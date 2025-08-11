import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class PrintServiceTest {

    @Test
    public void testResetMock() {
        // 1. Create mock
        Printer mockPrinter = mock(Printer.class);

        // 2. Inject into service
        PrintService service = new PrintService(mockPrinter);

        // 3. Call first method
        service.printWelcome();

        // 4. Verify it worked
        verify(mockPrinter).print("Welcome!");

        // 5. Reset the mock
        reset(mockPrinter);

        // 6. Call second method
        service.printGoodbye();

        // 7. Verify only second call is known now
        verify(mockPrinter).print("Goodbye!");

    }
}
