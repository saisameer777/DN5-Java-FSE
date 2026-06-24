import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testFetchData_MockingAndStubbing() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testFetchData_VerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Test Data");

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testFetchData_CalledTwice() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Data");

        MyService service = new MyService(mockApi);
        service.fetchData();
        service.fetchData();

        verify(mockApi, times(2)).getData();
    }

    @Test
    public void testProcessData_VerifyArgument() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.processData("Hello");

        verify(mockApi).sendData("Hello");
    }

    @Test
    public void testNoInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        new MyService(mockApi);

        verifyNoInteractions(mockApi);
    }
}
