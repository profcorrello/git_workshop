import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testIntegerOverflow() {
        int a = Integer.MAX_VALUE;
        int b = 1;
        int result = calculator.add(a, b);
        assertTrue(result < 0);
    }

    @Test
    void testIntegerUnderflow() {
        int a = Integer.MIN_VALUE;
        int b = -1;
        int result = calculator.subtract(a, b);
        assertTrue(result > 0);
    }

    @ParameterizedTest
    @CsvSource({ "-5, -3, -8", "-5, 3, -2", "5, -3, 2" })
    void testAddWithNegativeNumbers(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
}