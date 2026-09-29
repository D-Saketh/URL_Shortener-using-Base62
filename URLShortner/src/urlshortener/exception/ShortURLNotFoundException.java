package urlshortener.exception;

public class ShortURLNotFoundException extends Exception {

    public ShortURLNotFoundException(String message) {
        super(message);
    }
}