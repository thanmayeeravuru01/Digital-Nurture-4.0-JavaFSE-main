import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testGetUserById_returnsUser() {
        UserRepository mockRepo = mock(UserRepository.class);

        User user = new User(1L, "Thanmayee");

        when(mockRepo.findById(1L)).thenReturn(Optional.of(user));

        UserService service = new UserService(mockRepo);

        User result = service.getUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Thanmayee", result.getName());
    }

    @Test
    public void testGetUserById_returnsNullWhenNotFound() {
        UserRepository mockRepo = mock(UserRepository.class);

        when(mockRepo.findById(2L)).thenReturn(Optional.empty());

        UserService service = new UserService(mockRepo);

        User result = service.getUserById(2L);

        assertNull(result);
    }
}
