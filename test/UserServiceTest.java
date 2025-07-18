import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testVoidMethodCalled() {
        // 1. Create mock
        Logger mockLogger = mock(Logger.class);

        // 2. Inject into service
        UserService service = new UserService(mockLogger);

        // 3. Call method
        service.createUser("thanmayee");

        // 4. Verify the void method was called with the correct message
        verify(mockLogger).log("User created: thanmayee");
    }
}
