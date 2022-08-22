

public OkHttpClient mockResponse200(){
        OkHttpClient client;
        client = mock(OkHttpClient.class);
        Call call = mock(Call.class);
        Request request = new Request.Builder().url("https://url.com").build();
        Response response = null;
        try {
        response = new Response.Builder()
        .protocol(Protocol.get(Protocol.HTTP_1_0.toString()))
        .request(request)
        .code(0)
        .message("")
        .body(
        ResponseBody.create(
        MediaType.parse("application/json"),
        UtilTestReadFile.readJsonFile("ResponseEncryptedKey-200.json"))).build();
        } catch (IOException e) {
        throw new RuntimeException(e);
        }

        try {
        when(call.execute()).thenReturn(response);
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
        when(client.newCall(any())).thenReturn(call);
        return client;
        }