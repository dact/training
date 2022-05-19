

    @BeforeEach
    public void initialice(){
        try {
            InjectEnvironmentTest.injectEnvironmentVariable("PATH_",pathFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }