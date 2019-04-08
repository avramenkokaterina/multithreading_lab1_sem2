package com.avramenko.java.multithreading.validators;

public class Validator {

    private final static String LETTER_REGEXP = "[a-zA-Z]";

    private final static String LETTER_EXCEPTION = "Wrong letter. Enter latin letter. Enter only one letter.";

    public String checkLetter (String letter){
        if (!letter.matches(LETTER_REGEXP)) {
            return LETTER_EXCEPTION;
        }
        return "";
    }
}
