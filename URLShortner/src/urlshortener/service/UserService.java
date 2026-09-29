package urlshortener.service;

import urlshortener.model.User;
import urlshortener.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(String name, String email, String password) {

        List<User> users = repository.findAll();

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {
                return null;
            }
        }

        int id = users.size() + 1;
        User user = new User(id, name, email, password);

        repository.save(user);
        return user;
    }

    public User login(String email, String password) {

        for (User user : repository.findAll()) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}