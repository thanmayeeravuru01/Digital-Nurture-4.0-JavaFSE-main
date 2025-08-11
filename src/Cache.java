public class Cache {
    private DataFetcher fetcher;

    public Cache(DataFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public String get(String key) {
        return fetcher.fetchData(key);
    }
}
