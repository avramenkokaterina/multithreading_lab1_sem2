package com.avramenko.java.multithreading.model;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Model {

    public void startWork(String directoryPath, String matches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        DirectoryTask task = new DirectoryTask(new File(directoryPath), matches);
        Future future = executorService.submit(task);
//      executorService.shutdown();
    }
}
