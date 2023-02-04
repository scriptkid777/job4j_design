package ru.job4j.io;

import org.junit.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AnalysisTest {

    @Test
 public void whenServerDown(@TempDir Path tmp) throws IOException {
        File source = tmp.resolve("server1.log").toFile();
        File target = tmp.resolve("unavailable1.csv").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("200 10:56:01\n" +
                    "500 10:57:01\n" +
                    "400 10:58:01\n" +
                    "500 10:59:01\n" +
                    "400 11:01:02\n" +
                    "200 11:02:02");
        }
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::append);
        }
         assertThat("10:57:01;11:02:02").isEqualTo(rsl.toString());
    }
}