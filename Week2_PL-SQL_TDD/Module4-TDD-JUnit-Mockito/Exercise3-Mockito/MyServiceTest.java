import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

// ============================================================
// Exercise 1: Mocking and Stubbing
// Exercise 2: Verifying Interactions
// Module 4 - TDD using JUnit5 and Mockito
// DN 5.0 Deep Skilling - Java FSE React
// ============================================================

public class MyServiceTest {

    // --------------------------------------------------------
    // Exercise 1: Mocking and Stubbing
    // Scenario: Test a service that depends on an external API
    //           Mock the API and stub its method to return test data
    // --------------------------------------------------------
    @Test
    public void testExternalApi_MockingAndStubbing() {
        // Arrange - create mock object for external dependency
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Stub - define what the mock returns when called
        when(mockApi.getData()).thenReturn("Mock Data");

        // Inject mock into service
        MyService service = new MyService(mockApi);

        // Act
        String result = service.fetchData();

        // Assert - verify stub returned correct value
        assertEquals("Mock Data", result);
        System.out.println("Exercise 1 passed: Mocking & Stubbing works. Result: " + result);
    }

    // --------------------------------------------------------
    // Exercise 2: Verifying Interactions
    // Scenario: Verify that getData() was called exactly once
    // --------------------------------------------------------
    @Test
    public void testVerifyInteraction() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Test Data");

        MyService service = new MyService(mockApi);

        // Act
        service.fetchData();

        // Assert - verify the method was called exactly once
        verify(mockApi).getData();
        verify(mockApi, times(1)).getData();

        System.out.println("Exercise 2 passed: Interaction verified - getData() called once.");
    }

    @Test
    public void testVerifyInteraction_CalledMultipleTimes() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Data");

        MyService service = new MyService(mockApi);

        // Act - call twice
        service.fetchData();
        service.fetchData();

        // Assert - verify called exactly twice
        verify(mockApi, times(2)).getData();
        System.out.println("Exercise 2 passed: getData() called exactly 2 times - verified.");
    }

    @Test
    public void testVerify_SendDataCalledWithSpecificArgument() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act
        service.processData("Hello");

        // Assert - verify sendData was called with exact argument
        verify(mockApi).sendData("Hello");
        System.out.println("Exercise 2 passed: sendData('Hello') call verified.");
    }

    @Test
    public void testVerify_NoInteraction() {
        // Arrange
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Act - do NOT call any method

        // Assert - verify no interaction happened
        verifyNoInteractions(mockApi);
        System.out.println("Exercise 2 passed: No interactions verified.");
    }
}
