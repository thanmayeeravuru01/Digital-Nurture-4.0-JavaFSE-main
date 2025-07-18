import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotifierTest {

    @Test
    public void testMessageSentCorrectly() {
        // 1. Mock the sender
        MessageSender mockSender = mock(MessageSender.class);

        // 2. Inject into Notifier
        Notifier notifier = new Notifier(mockSender);

        // 3. Call the method
        notifier.notifyUser("user123");

        // 4. Capture arguments
        ArgumentCaptor<String> recipientCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

        // 5. Verify and capture
        verify(mockSender).send(recipientCaptor.capture(), messageCaptor.capture());

        // 6. Assert the captured values
        assertEquals("user123", recipientCaptor.getValue());
        assertEquals("You have a new notification.", messageCaptor.getValue());
    }
}
