package urlshortener.repository;

import urlshortener.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUserRepository implements UserRepository {

    private static final String FILE_PATH = "data/users.txt";

    @Override
    public void save(User user) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            writer.write(
                    user.getId() + "|" +
                            user.getName() + "|" +
                            user.getEmail() + "|" +
                            user.getPassword()
            );

            writer.newLine();

        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }

    @Override
    public List<User> findAll() {

        List<User> users = new ArrayList<>();

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return users;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                users.add(new User(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        parts[3]
                ));
            }

        } catch (IOException e) {
            System.out.println("Error reading users.");
        }

        return users;
    }
}