import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    public void testAdd() {
        int a = 10;
        int b = 5;
        int result = calculator.add(a, b);
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        int a = 10;
        int b = 3;
        int result = calculator.subtract(a, b);
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        int a = 4;
        int b = 5;
        int result = calculator.multiply(a, b);
        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        int a = 10;
        int b = 2;
        double result = calculator.divide(a, b);
        assertEquals(5.0, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }

    @Test
    public void testAddNegativeNumbers() {
        int result = calculator.add(-5, -3);
        assertEquals(-8, result);
    }
}
