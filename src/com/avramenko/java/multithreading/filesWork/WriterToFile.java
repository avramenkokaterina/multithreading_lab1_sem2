package com.avramenko.java.multithreading.filesWork;

import com.avramenko.java.multithreading.model.Model;
import com.avramenko.java.multithreading.model.ResultString;

import java.io.*;

public class WriterToFile {

    public static final String FILE_NAME = "D:\\My Documents\\универ\\3 курс\\Java\\2 sem\\labs\\src\\com\\avramenko\\java\\multithreading\\data\\Results.txt";

    public boolean writeToFile(Model model) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            ResultString[] resultStrings = model.getResultStrings();

            for (ResultString resultString : resultStrings){
                bufferedWriter.write(resultString.toString());
                bufferedWriter.newLine();
            }

            return true;
        }catch (FileNotFoundException ex){
            System.out.println("File not found.");
            return false;
        }
        finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }

}
