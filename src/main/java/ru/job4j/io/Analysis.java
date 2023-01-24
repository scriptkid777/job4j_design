package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        var flag = true;
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            BufferedReader reader = new BufferedReader(new FileReader(source));
for (String line = reader.readLine(); line != null; line = reader.readLine()) {
    if (flag && (line.contains("400") || line.contains("500"))) {
       flag = false;
       String[] array = line.split(" ", 2);
       out.print(array[1]);
       out.print(";");
    } else if (!flag && (line.contains("200") || line.contains("300"))) {
        flag = true;
        String[] array = line.split(" ", 2);
        out.print(array[1]);
        out.print(";");
        out.print(System.lineSeparator());
    }
}
        }   catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
       new Analysis().unavailable("server.log", "unavailable.csv");
    }
}
