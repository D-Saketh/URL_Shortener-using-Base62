package urlshortener.repository;

import urlshortener.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);
    List<User> findAll();
}