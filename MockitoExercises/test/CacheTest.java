import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CacheTest {

    @Test
    public void testDynamicResponse() {
        // 1. Mock the fetcher
        DataFetcher mockFetcher = mock(DataFetcher.class);

        // 2. Use Answer to return dynamic response
        when(mockFetcher.fetchData(anyString())).thenAnswer((Answer<String>) invocation -> {
            String arg = invocation.getArgument(0);
            return "value_for_" + arg;
        });

        // 3. Inject into cache
        Cache cache = new Cache(mockFetcher);

        // 4. Call with dynamic input
        String result = cache.get("user42");

        assertEquals("value_for_user42", result);
    }
}
