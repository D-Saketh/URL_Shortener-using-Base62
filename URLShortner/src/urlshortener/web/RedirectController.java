
package urlshortener.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import urlshortener.exception.ShortURLNotFoundException;
import urlshortener.repository.FileURLRepository;
import urlshortener.service.URLService;

import java.net.URI;

@RestController
public class RedirectController {

    private final URLService urlService = new URLService(new FileURLRepository());

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam String originalUrl) {

        String generatedUrl = urlService.shortenURL(originalUrl, 1);

        String shortCode = generatedUrl.substring(generatedUrl.lastIndexOf("/") + 1);

        String shortUrl = "http://localhost:8080/" + shortCode;

        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode) {

        try {
            String originalUrl = urlService.getOriginalURL(shortCode);
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();

        } catch (ShortURLNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
