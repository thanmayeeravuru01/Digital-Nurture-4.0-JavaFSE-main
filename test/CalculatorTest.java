import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSquareUsingSpy() {
        // 1. Create real object
        Calculator realCalculator = new Calculator();

        // 2. Create spy from real object
        Calculator spyCalculator = spy(realCalculator);

        // 3. Stub multiply() only
        when(spyCalculator.multiply(2, 2)).thenReturn(10);

        // 4. Call square()
        int result = spyCalculator.square(2);

        // 5. Verify square used the stubbed multiply
        assertEquals(10, result);
    }
}
