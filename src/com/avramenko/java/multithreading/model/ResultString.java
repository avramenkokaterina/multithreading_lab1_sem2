package com.avramenko.java.multithreading.model;

public class ResultString {

    private String fileName;
    private int amount;

    public ResultString(String fileName, int amount){

        this.fileName = fileName;
        this.amount = amount;
    }

    public ResultString(){}

    public String getFileName() {
        return fileName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return fileName + ": " + amount + " words.";
    }
}

