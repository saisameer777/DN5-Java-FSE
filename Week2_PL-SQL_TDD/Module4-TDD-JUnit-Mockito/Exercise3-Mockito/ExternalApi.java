// ExternalApi.java
// Interface representing an external dependency to be mocked

public interface ExternalApi {
    String getData();
    void sendData(String data);
}
