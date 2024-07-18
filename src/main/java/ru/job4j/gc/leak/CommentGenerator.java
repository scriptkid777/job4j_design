package ru.job4j.gc.leak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.IOException;

public class CommentGenerator implements Generate {
    public static final String PATH_PHRASES = "src/main/java/ru/job4j/gc/leak/files/phrases.txt";

    private static List<Comment> comments = new ArrayList<>();
    private static List<String> phrases;
    private UserGenerator userGenerator;
    private Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        try {
            phrases = read(PATH_PHRASES);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static List<Comment> getComments() {
        return comments;
    }

    @Override
    public void generate() {
        comments.clear();
        String separator = System.lineSeparator();
        for (int i = 0; i < 50; i++) {
            String comment = String.format("%s%s%s%s%s",
                    phrases.get(random.nextInt(phrases.size())), separator,
                    phrases.get(random.nextInt(phrases.size())), separator,
                    phrases.get(random.nextInt(phrases.size())));
            comments.add(new Comment(comment,
                    userGenerator.randomUser()));
        }
    }
}
