package ru.job4j.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        String text;
        String answerLine;
        List<String> stringLog = new ArrayList<>();
        List<String> answerList = readPhrases();
        Scanner scanner = new Scanner(System.in);
        boolean quiet = false;
        do {
         text = scanner.nextLine();
         if (text != null && !text.isEmpty()) {
             if (STOP.equals(text)) {
                 quiet = true;
             }
             if (CONTINUE.equals(text)) {
                 quiet = false;
             }
             if (!quiet) {
                 Random random  = new Random();
                 answerLine = answerList.get(random.nextInt(answerList.size()));
                 System.out.println(answerLine);
                 stringLog.add(text);
                 stringLog.add(answerLine);
             } else {
                 stringLog.add(text);
             }
         }
        } while (!OUT.equals(text));
        saveLog(stringLog);
    }

    private List<String> readPhrases() throws IOException {
        return Files.readAllLines(Paths.get(botAnswers), StandardCharsets.UTF_8);
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./data/path.txt", "./data/botAnswers.txt");
        cc.run();
    }
}
