package urlshortener.controller;

import urlshortener.model.User;
import urlshortener.service.UserService;

import java.util.Scanner;

public class UserController {

    private UserService service;
    private Scanner S;

    public UserController(UserService service, Scanner S) {
        this.service = service;
        this.S = S;
    }

    public User register() {

        System.out.print("Enter name: ");
        String name = S.nextLine();

        System.out.print("Enter email: ");
        String email = S.nextLine();

        System.out.print("Enter password: ");
        String password = S.nextLine();

        User user = service.register(name, email, password);

        if (user == null) {
            System.out.println("Email already registered.");
        } else {
            System.out.println("Registration successful.");
        }
        return user;
    }

    public User login() {

        System.out.print("Enter email: ");
        String email = S.nextLine();

        System.out.print("Enter password: ");
        String password = S.nextLine();

        User user = service.login(email, password);

        if (user == null) {
            System.out.println("Invalid email or password.");
        } else {
            System.out.println("Welcome, " + user.getName());
        }

        return user;
    }
}