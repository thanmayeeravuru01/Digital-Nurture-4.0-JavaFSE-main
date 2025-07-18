import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    public void testSendEmailThrowsException() {
        // 1. Create mock
        EmailService mockEmailService = mock(EmailService.class);

        // 2. Tell it to throw exception
        doThrow(new RuntimeException("Email failed"))
                .when(mockEmailService).sendEmail(anyString(), anyString());

        // 3. Use mock in registration class
        UserRegistration registration = new UserRegistration(mockEmailService);

        // 4. Call and assert
        boolean result = registration.registerUser("test@example.com");

        assertFalse(result);
    }
}
