import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BeforeAllAfterAllTest {

    static int sharedValue;

    @BeforeAll
    static void setupAll() {
        sharedValue = 10;
        System.out.println("Setup before all tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Teardown after all tests");
    }

    @Test
    void testAdd() {
        int result = sharedValue + 5;
        assertEquals(15, result);
    }

    @Test
    void testMultiply() {
        int result = sharedValue * 2;
        assertEquals(20, result);
    }
}
