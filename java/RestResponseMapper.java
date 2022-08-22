

switch (response.getStatus()) {
        case 200:
        logger.info("Respuesta exitosa :::" + response.getStatus());
        String jsonData1 = response.getEntity(String.class);
        logger.debug("response :::" + jsonData1);
        successResponseDTO = new Gson().fromJson(jsonData1, SuccessResponseDTO.class);
        break;
        case 401:
        logger.info("Respuesta unauthorized :::" + response.getStatus());
        String jsonData2 = response.getEntity(String.class);
        logger.info("response:::" + jsonData2);
        responseUnauthorizedDTO = new Gson().fromJson(jsonData2, ResponseUnauthorizedDTO.class);
        throw new RespuestaServicio(responseUnauthorizedDTO.httpCode, responseUnauthorizedDTO.httpMessage);
default:
        logger.info("Respuesta fallida " + response.getStatus());
        String jsonData3 = response.getEntity(String.class);
        logger.info("response:::" + jsonData3);
        errorDTO = new Gson().fromJson(jsonData3, ResponseErrorDTO.class);
        throw new RespuestaServicio(errorDTO.getErrors().get(0).getCode(), errorDTO.getErrors().get(0).getDetail());
        }