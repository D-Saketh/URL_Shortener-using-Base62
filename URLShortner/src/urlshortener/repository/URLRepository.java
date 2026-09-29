package urlshortener.repository;

import urlshortener.model.URLMapping;
import java.util.List;

public interface URLRepository {

    void save(URLMapping url);
    List<URLMapping> findAll();
    URLMapping findByShortCode(String shortCode);
    List<URLMapping> findByUserId(int userId);
}