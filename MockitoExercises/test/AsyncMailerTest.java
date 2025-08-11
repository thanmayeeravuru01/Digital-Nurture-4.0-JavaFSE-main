import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class AsyncMailerTest {

    @Test
    public void testEmailSentWithinTimeout() {
        EmailClient mockClient = mock(EmailClient.class);
        AsyncMailer mailer = new AsyncMailer(mockClient);

        mailer.send("user@email.com", "Hello from async");

        // verify with timeout (wait up to 500ms for method to be called)
        verify(mockClient, timeout(500)).sendEmail("user@email.com", "Hello from async");
    }
}
