// MyService.java
// Service that depends on ExternalApi — we will mock ExternalApi in tests

public class MyService {

    private final ExternalApi externalApi;

    // Constructor injection - makes mocking easy
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void processData(String data) {
        externalApi.sendData(data);
    }
}
