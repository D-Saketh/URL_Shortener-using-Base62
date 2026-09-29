package urlshortener.repository;

import urlshortener.model.URLMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileURLRepository implements URLRepository {

    private static final String FILE_PATH = "data/urls.txt";

    @Override
    public void save(URLMapping url) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            writer.write(url.getId() + "|" + url.getOriginalUrl() + "|" + url.getShortCode() + "|" +
                            url.getUserId());

            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving URL.");
        }
    }

    @Override
    public List<URLMapping> findAll() {

        List<URLMapping> urls = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return urls;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                urls.add(new URLMapping(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3])
                ));
            }

        } catch (IOException e) {
            System.out.println("Error reading URLs.");
        }

        return urls;
    }

    @Override
    public URLMapping findByShortCode(String shortCode) {

        for (URLMapping url : findAll()) {

            if (url.getShortCode().equals(shortCode)) {
                return url;
            }
        }

        return null;
    }

    @Override
    public List<URLMapping> findByUserId(int userId) {

        List<URLMapping> result = new ArrayList<>();

        for (URLMapping url : findAll()) {

            if (url.getUserId() == userId) {
                result.add(url);
            }
        }

        return result;
    }
}