https://github.com/localstack/localstack

install pip

curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py

python get-pip.py
python3 get-pip.py

--
https://github.com/localstack/localstack

pip install localstack
python3 -m pip install localstack

boto3

------
export to path
/Users/USER/Library/Python/3.8/bin


to Start
localstack start


---check service
aws --endpoint-url=http://localhost:4566 kinesis list-streams

aws --endpoint-url=http://localhost:4566 secretsmanager list-secrets

aws secretsmanager create-secret --name secretname --description "Basic Create Secret" --secret-string S3@tt13R0cks
aws secretsmanager create-secret --name production/MyAwesomeAppSecret --secret-string file://mycreds.json
–
--check secret
aws secretsmanager list-secrets --endpoint-url=http://localhost:4566
aws secretsmanager get-secret-value --secret-id MYSECRET --endpoint-url=http://localhost:4566

--create secret
aws --endpoint-url=http://localhost:4566 secretsmanager create-secret --name SECRET --secret-string file://mycredsqa.json

--delete secret
aws secretsmanager delete-secret --secret-id SECRET --endpoint-url=http://localhost:4566
    
