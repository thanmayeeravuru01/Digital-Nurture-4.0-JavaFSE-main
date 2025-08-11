import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {

    @Test
    public void testAdd() {
        MathService mathService = new MathService();
        int result = mathService.add(10, 5);
        assertEquals(15, result);
    }
}
