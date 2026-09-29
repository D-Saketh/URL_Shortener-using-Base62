package urlshortener.service;

import urlshortener.exception.ShortURLNotFoundException;
import urlshortener.model.URLMapping;
import urlshortener.repository.URLRepository;
import urlshortener.util.Base62Util;

import java.util.List;

public class URLService {

    private URLRepository repository;
    public URLService(URLRepository repository) {
        this.repository = repository;
    }

    public String shortenURL(String originalUrl, int userId) {

        List<URLMapping> urls = repository.findAll();
        int id = urls.size() + 1;
        String shortCode = Base62Util.encode(id);

        URLMapping url = new URLMapping(id, originalUrl, shortCode, userId);

        repository.save(url);
        return "http://short.ly/" + shortCode;
    }

    public List<URLMapping> getUserURLs(int userId) {
        return repository.findByUserId(userId);
    }

    public String getOriginalURL(String shortCode)
            throws ShortURLNotFoundException {

        URLMapping url = repository.findByShortCode(shortCode);

        if (url == null) {
            throw new ShortURLNotFoundException("Short URL not found.");
        }
        return url.getOriginalUrl();
    }
}