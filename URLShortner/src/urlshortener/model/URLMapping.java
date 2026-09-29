package urlshortener.model;

public class URLMapping {

    private int id;
    private String originalUrl;
    private String shortCode;
    private int userId;

    public URLMapping(int id, String originalUrl, String shortCode, int userId) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return id + " | " + originalUrl + " | " + "http://short.ly/" + shortCode;
    }
}