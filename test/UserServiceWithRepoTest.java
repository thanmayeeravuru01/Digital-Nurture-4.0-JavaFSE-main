import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceWithRepoTest {

    @Test
    public void testGetUserName() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1L)).thenReturn(new User(1L, "Alice"));

        UserServiceWithRepo service = new UserServiceWithRepo(mockRepo);
        String name = service.getUserName(1L);

        assertEquals("Alice", name);
    }
}
