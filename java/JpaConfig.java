package co.com.service.config;

import co.com.commons.secretsmanager.connector.AbstractConnector;
import co.com.commons.secretsmanager.connector.clients.AWSSecretManagerConnector;
import co.com.commons.secretsmanager.connector.model.AWSSecretDBModel;
import co.com.commons.secretsmanager.manager.GenericManager;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class JpaConfig {

    private static final Logger LOGGER = LogManager.getLogger(JpaConfig.class);
    private static final String STRDRIVER = "org.postgresql.Driver";
    private static final String strFormatConnection = "jdbc:postgresql://%s:%s/%s";

    @Bean
    public BasicDataSource getDataSource() {
        AWSSecretDBModel secret = getSecretManager();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(STRDRIVER);
        dataSource.setUrl(String.format(strFormatConnection,secret.getHost(),secret.getPort(),secret.getDbname()));
        dataSource.setUsername(secret.getUsername());
        dataSource.setPassword(secret.getPassword());
        return dataSource;
    }



    public AWSSecretDBModel getSecretManager() {
        AWSSecretDBModel model = null;
        if(System.getenv().get("ENV_TYPE") != null){
            String envType = System.getenv().get("ENV_TYPE");
            model = new AWSSecretDBModel();
            model.setHost(System.getenv().get("DB_HOST_".concat(envType)));
            model.setPort(System.getenv().get("DB_PORT_".concat(envType)));
            model.setDbname(System.getenv().get("DB_NAME_".concat(envType)));
            model.setUsername(System.getenv().get("DB_USER_".concat(envType)));
            model.setPassword(System.getenv().get("DB_PASS_".concat(envType)));
        }else{
            LOGGER.info("Reading secret manager");
            String SECRET_REGION = System.getenv("SECRETREGION");
            String SECRET_NAME = System.getenv("SECRETNAME");
            LOGGER.trace("Secrets->Region:"+SECRET_REGION+" Name:"+SECRET_NAME);
            AbstractConnector connector = new AWSSecretManagerConnector(SECRET_REGION);
            GenericManager manager = new GenericManager(connector);
            String result = "";
            try {
                model = manager.getSecretModel(SECRET_NAME, AWSSecretDBModel.class);
                result = model.getHost()+ " " +
                        model.getUsername()+" " +
                        model.getDbname();
                LOGGER.info(result);
                LOGGER.trace(result);
            } catch(Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        LOGGER.info(model.getHost());
        return model;
    }

}
