package com.avramenko.java.multithreading.model;

import com.avramenko.java.multithreading.filesWork.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DirectoryTask implements Callable<Boolean> {
    private File directory;
    private String matches;

    private final String RESULT_FILE_NAME = "matches-data.txt";

    DirectoryTask(File directory, String matches) {
        this.directory = directory;
        this.matches = matches;
    }

    @Override
    public Boolean call() {
        List<File> directories = new ArrayList<>();
        List<File> textFiles = new ArrayList<>();

        if (this.directory.canRead()) {
            for (File temp : Objects.requireNonNull(this.directory.listFiles())) {
                if (temp.isDirectory() && temp.canRead()) {
                    directories.add(temp);
                } else if (temp.getName().contains(".txt")) {
                    textFiles.add(temp);
                }
            }
        }

        for (File directory : directories) {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future future = executorService.submit(new DirectoryTask(directory, matches));
//            executorService.shutdown();
        }

        String filesMatches = this.getFilesMatches(textFiles, this.matches);
        boolean isSuccess = false;
        if (filesMatches != null || filesMatches.length() > 0) {
            isSuccess = FileUtils.createFileInDirectory(this.directory, this.RESULT_FILE_NAME, filesMatches);
            if (isSuccess) {
                System.out.println("Output " + this.directory + File.separator + this.RESULT_FILE_NAME + ":\n" + filesMatches);
            }
        }
        return isSuccess;
    }

    private String getFilesMatches(List<File> files, String matches) {
        if (files.size() == 0) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (File file : files) {
            int countMatches = calculateMatchesInFile(file, matches);
            if (countMatches > 0) {
                result.append(file.getName());
                result.append(" - ");
                result.append(countMatches);
                result.append("\r\n");
            }
        }
        return result.toString();
    }

    private int calculateMatchesInFile(File textFile, String matches) {
        if (textFile == null) {
            return 0;
        }
        String fileText = null;
        try {
            fileText = FileUtils.readFromFile(textFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.calculateMatches(fileText, matches);
    }

    private int calculateMatches(String text, String matches) {
        if (text == null) {
            return 0;
        }
        int count = 0;
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.startsWith(matches) || word.startsWith("\"" + matches) || word.startsWith("\\(" + matches)) {
                count++;
            }
        }
        return count;
    }
}
