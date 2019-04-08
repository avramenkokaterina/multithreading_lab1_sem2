package com.avramenko.java.multithreading.controller;

import com.avramenko.java.multithreading.model.Model;
import com.avramenko.java.multithreading.validators.InvalidInputException;
import com.avramenko.java.multithreading.validators.Validator;
import com.avramenko.java.multithreading.view.Activities;
import com.avramenko.java.multithreading.view.Messages;
import com.avramenko.java.multithreading.view.View;

public class Controller {

    private String dirName;
    private String letter;
    private Validator validator = new Validator();

    public void startWorking() {
        View view = new View();
        Model model = new Model();
        Activities activities;

        activities = Activities.SHOW_START_MESSAGE;
        while (true) {
            switch (activities) {
                case SHOW_START_MESSAGE:
                    activities = showMessage(view);
                    break;
                case ENTER_DATA:
                    activities = getData(view);
                    model.startWork(this.dirName, this.letter);
                    break;
            }
        }
    }

    private Activities showMessage(View view) {
        view.printMessage(Messages.SHOW_FIRST_MESSAGE);
        return Activities.ENTER_DATA;
    }

    private Activities getData(View view){
        dirName = checkDirName(view);
        letter = checkLetter(view);
        return Activities.SEARCH_TXT;
    }

    private String checkDirName(View view){
        view.printMessage(Messages.ENTER_DIR);
        dirName = view.readString();

        return dirName;
    }

    private String checkLetter(View view){
        view.printMessage(Messages.ENTER_LETTER);
        letter = view.readString();
        do {
            try {
                if (!validator.checkLetter(letter).isEmpty()) {
                    throw new InvalidInputException(validator.checkLetter(letter));
                }
            } catch (InvalidInputException iie) {
                System.out.println(iie.getMessage());
                letter = view.readString();
            }
        } while (!validator.checkLetter(letter).isEmpty());
        return letter;
    }
}
