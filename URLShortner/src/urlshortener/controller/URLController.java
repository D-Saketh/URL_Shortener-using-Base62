package urlshortener.controller;

import urlshortener.exception.ShortURLNotFoundException;
import urlshortener.model.URLMapping;
import urlshortener.model.User;
import urlshortener.service.URLService;

import java.util.List;
import java.util.Scanner;

public class URLController {

    private URLService service;
    private Scanner S;

    public URLController(URLService service, Scanner S) {
        this.service = service;
        this.S = S;
    }

    public void showMenu(User user) {

        while (true) {

            System.out.println("\n===== URL MENU =====");
            System.out.println("1. Shorten URL");
            System.out.println("2. View My URLs");
            System.out.println("3. Open Short URL");
            System.out.println("4. Logout");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(S.nextLine());

            if (choice == 1) {
                shortenURL(user);

            } else if (choice == 2) {
                viewURLs(user);

            } else if (choice == 3) {
                openURL();

            } else if (choice == 4) {
                System.out.println("Logged out.");
                return;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void shortenURL(User user) {

        System.out.print("Enter original URL: ");
        String originalUrl = S.nextLine();

        String shortUrl = service.shortenURL(originalUrl, user.getId());

        System.out.println("Short URL: " + shortUrl);
    }

    private void viewURLs(User user) {

        List<URLMapping> urls = service.getUserURLs(user.getId());

        if (urls.isEmpty()) {
            System.out.println("No URLs found.");
            return;
        }

        for (URLMapping url : urls) {
            System.out.println(url);
        }
    }

    private void openURL() {

        System.out.print("Enter short URL: ");
        String shortUrl = S.nextLine();

        String shortCode = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);

        try {
            String originalUrl = service.getOriginalURL(shortCode);
            System.out.println("Original URL: " + originalUrl);
            java.awt.Desktop.getDesktop().browse(new java.net.URI(originalUrl));

        } catch (ShortURLNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Unable to open URL: " + e.getMessage());
        }
    }
}