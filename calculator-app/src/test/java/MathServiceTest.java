import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MathServiceTest {
    @Test
    void testDoubleAdditionThrowsException() {
        Calculator mockCalc = mock(Calculator.class);
        when(mockCalc.add(anyInt(), anyInt())).thenThrow(new ArithmeticException("Boom"));

        MathService service = new MathService(mockCalc);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.doubleAddition(1, 2);
        });

        assertTrue(exception.getMessage().contains("Failed to compute double addition"));
        assertTrue(exception.getCause() instanceof ArithmeticException);
    }
}