package com.avramenko.java.multithreading.filesWork;

import java.io.*;

public class FileUtils {

    public static String readFromFile(File file) throws IOException {
        BufferedReader bufferedReader = null;
        StringBuilder result = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                result.append(str);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        return result.toString();
    }

    public static void writeToFile(String filePath, String text) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(filePath, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

    public static boolean createFileInDirectory(File directory, String fileName, String text) {
        if (!directory.isDirectory()) {
            return false;
        }
        try {
            writeToFile(directory.getAbsolutePath() + File.separator + fileName, text);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
