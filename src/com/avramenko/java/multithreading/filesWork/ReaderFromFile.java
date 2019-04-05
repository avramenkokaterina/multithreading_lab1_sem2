package com.avramenko.java.multithreading.filesWork;

import com.avramenko.java.multithreading.model.Model;
import com.avramenko.java.multithreading.model.ResultString;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {
    public boolean readFromFile(Model model) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader("");
            bufferedReader = new BufferedReader(fileReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                model.addResultString(parser(str));
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    private ResultString parser(String str){
        ResultString resultString = new ResultString();
        String[] strings = str.split("");


        return resultString;
    }

}
