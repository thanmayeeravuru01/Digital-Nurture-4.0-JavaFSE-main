import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    MathUtils math = new MathUtils();

    @Nested
    class AddTests {
        @Test
        void testAddPositive() {
            assertEquals(5, math.add(2, 3));
        }

        @Test
        void testAddNegative() {
            assertEquals(-5, math.add(-2, -3));
        }
    }

    @Nested
    class MultiplyTests {
        @Test
        void testMultiplyPositive() {
            assertEquals(6, math.multiply(2, 3));
        }

        @Test
        void testMultiplyByZero() {
            assertEquals(0, math.multiply(0, 5));
        }
    }

    @Nested
    class SubtractTests {
        @Test
        void testSubtractPositive() {
            assertEquals(2, math.subtract(5, 3));
        }

        @Test
        void testSubtractNegative() {
            assertEquals(-1, math.subtract(2, 3));
        }
    }
}
