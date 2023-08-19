package ru.job4j.io;

/*
-d - directory - которую мы хотим архивировать.
-e - exclude - исключить файлы с расширением class.
-o - output - во что мы архивируем.
args[]=new String[]{"-d=C:\\projects\\job4j_design\\src\\main/java/ru/job4j/io/", "-e=.class", "-o=project.zip"}
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream((new BufferedOutputStream(new FileOutputStream(target))))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getName()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validate(ArgsName args) {
        if (!Files.isDirectory(Path.of(args.get("d")))) {
            throw new IllegalArgumentException(String.format("Path to the directory is incorrect : %s", args.get("d")));
        }
        if (!args.get("e").startsWith(".")) {
            throw new IllegalArgumentException(String.format("Incorrect extension : %s", args.get("e")));
        }
        if (!args.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Output path must have a \".zip\" extension : %s", args.get("o")));
        }
    }

    public static void main(String[] args)  throws IOException {
        if (args.length < 3) {
            throw new IllegalArgumentException("There must be 3 arguments passed.");
        }
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
       Path source = Path.of(argsName.get("d"));
       List<Path> list = Search.search(source, path -> !path.toString().endsWith(argsName.get("e")));
        zip.packFiles(list, new File("o"));
    }
}
