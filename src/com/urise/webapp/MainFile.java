package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------------------------------------------------");
        printFiles("./");

    }

    public static void printFiles(File dir) {

        StringBuilder sb = new StringBuilder();

        printFilesRec(dir, "", sb);

        System.out.print(sb.toString());

    }

    public static void printFiles(String path) {
        File dir = new File(path);
        printFiles(dir);
    }

    private static void printFilesRec(File dir, String prefix, StringBuilder sb) {
        if (!dir.isDirectory()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        String newPrefix = prefix + "   ";
        for (File file : files) {
            sb.append(prefix);
            sb.append(file.getName());
            sb.append("\n");
            printFilesRec(file, newPrefix, sb);
        }
    }

}