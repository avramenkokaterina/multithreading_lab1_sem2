package com.avramenko.java.multithreading.view;

import java.util.Scanner;

public class View {

    private Scanner sc;

    public void printMessage(Messages messages) {
        switch (messages) {
            case SHOW_FIRST_MESSAGE:
                System.out.println("Hello and welcome! I'm gonna show you how multithreading works.");
                break;
            case ENTER_DIR:
                System.out.println("Please, enter absolute path to directory: ");
                break;
            case ENTER_LETTER:
                System.out.println("Please, enter letter: ");
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
}
