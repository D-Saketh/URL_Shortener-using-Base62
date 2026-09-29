package urlshortener;

import urlshortener.controller.URLController;
import urlshortener.controller.UserController;
import urlshortener.model.User;
import urlshortener.repository.FileURLRepository;
import urlshortener.repository.FileUserRepository;
import urlshortener.repository.URLRepository;
import urlshortener.repository.UserRepository;
import urlshortener.service.URLService;
import urlshortener.service.UserService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

        UserRepository userRepository = new FileUserRepository();
        URLRepository urlRepository = new FileURLRepository();
        UserService userService = new UserService(userRepository);
        URLService urlService = new URLService(urlRepository);
        UserController userController = new UserController(userService, S);
        URLController urlController = new URLController(urlService, S);

        while (true) {
            System.out.println("\n===== URL SHORTENER =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(S.nextLine());

            if (choice == 1) {
                userController.register();

            } else if (choice == 2) {
                User user = userController.login();

                if (user != null) {
                    urlController.showMenu(user);
                }

            } else if (choice == 3) {
                System.out.println("Goodbye.");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
        S.close();
    }
}