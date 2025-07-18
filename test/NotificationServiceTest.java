import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class NotificationServiceTest {

    @Test
    public void testSendMessageCalledWithArgument() {
        // 1. Create mock
        Messenger mockMessenger = mock(Messenger.class);

        // 2. Inject into service
        NotificationService service = new NotificationService(mockMessenger);

        // 3. Call method
        service.alertUser();

        // 4. Verify it was called with specific string
        verify(mockMessenger).sendMessage(anyString());
    }
}
