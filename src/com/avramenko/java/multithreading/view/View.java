package com.avramenko.java.multithreading.view;

import com.avramenko.java.multithreading.model.ResultString;

import java.util.Scanner;

public class View {

    private Scanner sc;

    public void printMessage(Messages messages) {
        switch (messages) {
            case SHOW_FIRST_MESSAGE:
                System.out.println("Hello and welcome! I'm gonna show you how multithreading works./n");
                break;
            case ENTER_DIR:
                System.out.println("Please, enter name of a directory: ");
                break;
            case ENTER_LETTER:
                System.out.println("Please, enter letter: ");
                break;
            case NO_RESULTS:
                System.out.println("No results.");
                break;
            case SOMETHING_WRONG:
                System.out.println("Sorry, something goes wrong...");
                break;
            case SUCCESSFUL:
                System.out.println("Successful!");
                break;
            default:
                break;
        }
    }

    public String readString() {
        Scanner scan = new Scanner(System.in);
        String string = new String(scan.nextLine());
        return string;
    }

    public void printResult(ResultString[] resultStrings){
        for (ResultString resultString: resultStrings){
            System.out.println(resultString);
        }
    }
}