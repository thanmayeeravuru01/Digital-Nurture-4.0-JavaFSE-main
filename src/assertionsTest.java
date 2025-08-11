import org.junit.Test;
import static org.junit.Assert.*;

public class assertionsTest {

    @Test
    public void testAssertions() {
        // Equal values
        assertEquals(5, 2 + 3);

        // True condition
        assertTrue(5 > 3);

        // False condition
        assertFalse(5 < 3);

        // Null and not null
        assertNull(null);
        assertNotNull(new Object());
    }
}
