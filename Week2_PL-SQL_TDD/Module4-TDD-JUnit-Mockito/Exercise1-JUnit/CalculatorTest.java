import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

// ============================================================
// Exercise 1: Setting Up JUnit
// Exercise 3: Assertions in JUnit
// Exercise 4: AAA Pattern, Test Fixtures, Setup & Teardown
// Module 4 - TDD using JUnit5 and Mockito
// DN 5.0 Deep Skilling - Java FSE React
// ============================================================

public class CalculatorTest {

    // --------------------------------------------------------
    // Exercise 4: Test Fixture - shared object for all tests
    // --------------------------------------------------------
    private Calculator calculator;

    // Exercise 4: @Before - runs before EACH test method (Setup)
    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("setUp() called - Calculator initialized");
    }

    // Exercise 4: @After - runs after EACH test method (Teardown)
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("tearDown() called - Calculator cleaned up");
    }

    // --------------------------------------------------------
    // Exercise 3: Assertions in JUnit
    // --------------------------------------------------------
    @Test
    public void testAssertions() {
        // assertEquals
        assertEquals(5, 2 + 3);

        // assertTrue
        assertTrue(5 > 3);

        // assertFalse
        assertFalse(5 < 3);

        // assertNull
        assertNull(null);

        // assertNotNull
        assertNotNull(new Object());

        System.out.println("testAssertions() passed");
    }

    // --------------------------------------------------------
    // Exercise 4: AAA Pattern (Arrange - Act - Assert)
    // --------------------------------------------------------

    @Test
    public void testAdd_AAAPattern() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals("10 + 5 should equal 15", 15, result);
    }

    @Test
    public void testSubtract_AAAPattern() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals("10 - 3 should equal 7", 7, result);
    }

    @Test
    public void testMultiply_AAAPattern() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals("4 * 5 should equal 20", 20, result);
    }

    @Test
    public void testDivide_AAAPattern() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        assertEquals("10 / 2 should equal 5.0", 5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero_ShouldThrowException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act + Assert (exception expected)
        calculator.divide(a, b);
    }

    @Test
    public void testAdd_NegativeNumbers() {
        // Arrange
        int a = -5;
        int b = -3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(-8, result);
    }
}
