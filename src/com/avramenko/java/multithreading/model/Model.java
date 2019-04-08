package com.avramenko.java.multithreading.model;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Model {

    private ResultString[] resultStrings;
    private int length;
    private final int initialLength = 10;
    private int currentLength = 0;

    public Model(){
        length = initialLength;
        ResultString[] resultStrings = new ResultString[length];
    }

    public void startWork(String directoryPath, String matches) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        DirectoryTask task = new DirectoryTask(new File(directoryPath), matches);
        Future future = executorService.submit(task);
//        executorService.shutdown();
    }

    public boolean addResultString(ResultString...resultStrings){
        if (this.resultStrings != null && resultStrings != null) {
            if (resultStrings.length <= length - currentLength) {
                for (int i = 0; i < resultStrings.length; i++) {
                    this.resultStrings[currentLength] = resultStrings[i];
                    currentLength++;
                }
            } else {
                this.length += resultStrings.length;
                this.resultStrings = Arrays.copyOf(this.resultStrings, length);

                for (int i = 0; i < resultStrings.length; i++) {
                    this.resultStrings[currentLength] = resultStrings[i];
                    currentLength++;
                }
            }
            return true;
        } else {
            if (this.resultStrings == null && resultStrings != null) {
                this.resultStrings = resultStrings;
                this.length = resultStrings.length;
                this.currentLength = this.length;
            }
            return false;

        }
    }

    public ResultString[] getResultStrings(){
        return resultStrings;
    }
}
