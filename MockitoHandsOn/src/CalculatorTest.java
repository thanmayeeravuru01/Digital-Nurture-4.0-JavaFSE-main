import org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, calc.add(6, 4));
    }

    @Test
    public void testIsEven() {
        assertTrue(calc.isEven(8));
        assertFalse(calc.isEven(5));
    }
}


