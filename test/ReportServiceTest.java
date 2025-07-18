import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportServiceTest {

    @Test
    public void testMultipleReturnValues() {
        // 1. Create mock
        DataSource mockDataSource = mock(DataSource.class);

        // 2. Stub multiple return values
        when(mockDataSource.getData())
                .thenReturn("Data One")
                .thenReturn("Data Two");

        // 3. Use the mock in service
        ReportService service = new ReportService(mockDataSource);

        // 4. Call twice
        String firstReport = service.generateReport();
        String secondReport = service.generateReport();

        // 5. Assert both results
        assertEquals("Report: Data One", firstReport);
        assertEquals("Report: Data Two", secondReport);
    }
}
