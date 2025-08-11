import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisabledTest {

    @Test
    void testActiveMethod() {
        assertEquals(2, 1 + 1);
    }

    @Disabled("Work in progress")
    @Test
    void testDisabledMethod() {
        fail("This test is disabled and should not run.");
    }
}
