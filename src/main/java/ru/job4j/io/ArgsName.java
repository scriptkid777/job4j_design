package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        keyValid(key);
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg : args) {
            String[] keyAndValue = arg.split("=", 2);
            values.put(keyAndValue[0].substring(1), keyAndValue[1]);
        }
    }

    public static ArgsName of(String[] args) {
        argsValid(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    private void keyValid(String key) {
        if (key.isEmpty()) {
            throw new IllegalArgumentException("Error: This key is empty");
        }
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
    }

    private static void argsValid(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String arg : args) {
            if (!arg.contains("=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", arg));
            }
            String[] argSplited = arg.split("=", 2);
            if (!argSplited[0].startsWith("-")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", arg));
            }
            if ("-".equals(argSplited[0])) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", arg));
            }

            if (argSplited[1].isEmpty()) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", arg));
            }
        }
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }


}
