package ru.job4j.jdbc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private Properties config;
    private String dump;

    private Connection connection;

    public ImportDB(Properties config, String dump) throws Exception {
        this.config = config;
        this.dump = dump;
        init();
        create();
    }

    private void init() throws Exception {
        if (connection == null) {
            Class.forName(config.getProperty("jdbc.driver"));
            String url = config.getProperty("jdbc.url");
            String login = config.getProperty("jdbc.username");
            String password = config.getProperty("jdbc.password");
            connection = DriverManager.getConnection(url, login, password);
        }

    }

    private void create() throws Exception {
        String query = "CREATE table if not exists users("
                + "id serial primary key,"
                + "name varchar(64),"
                + "email varchar(64));";
        try (PreparedStatement statement =
                     connection.prepareStatement(query)) {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void save(List<User> users) throws Exception {
        String query = "INSERT INTO users(name, email)"
                + "values(?, ?)";
        for (User user : users) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.name);
                statement.setString(2, user.email);
                statement.execute();
            }
        }
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<User>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            reader.lines()
                    .forEach(line -> {
                        String[] temp = line.split(";", 3);
                        String name = temp[0];
                        String email = temp[1];
                        isValidLine(name, email);
                        users.add(new User(name, email));
                    });
        }
        return users;
    }

    private void isValidLine(String name, String email) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не найдено в строке");
        }

        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email не найдено в строке");
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app.properties")) {
                config.load(in);
            ImportDB db = new ImportDB(config, "data/dump.txt");
            db.save(db.load());
        }
    }
}