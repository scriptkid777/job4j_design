package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        var flag = true;
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            BufferedReader reader = new BufferedReader(new FileReader(source));
for (String line = reader.readLine(); line != null; line = reader.readLine()) {
    String[] array = line.split(" ");
    if (flag && (line.contains("400") || line.contains("500"))) {
       flag = false;
       out.append(array[1]).append(";");
    } else if (!flag && (line.contains("200") || line.contains("300"))) {
        flag = true;
        out.append(array[1]).append(";").append(System.lineSeparator());
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
