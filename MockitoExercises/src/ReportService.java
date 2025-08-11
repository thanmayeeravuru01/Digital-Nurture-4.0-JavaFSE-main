public class ReportService {
    private DataSource dataSource;

    public ReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String generateReport() {
        String data = dataSource.getData();
        return "Report: " + data;
    }
}
