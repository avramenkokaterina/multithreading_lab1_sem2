package com.avramenko.java.multithreading.validators;

public class Validator {

    private final static String DIR_REGEXP = "\\w{30}";
    private final static String LETTER_REGEXP = "[a-zA-Z]{1}";

    private final static String DIR_EXCEPTION = "Wrong directory name";
    private final static String LETTER_EXCEPTION = "Wrong letter. Enter latin letter. Enter only one letter.";
    private final static String LETTERS_AMOUNT_EXCEPTION = "";


    public String checkDirectoryName (String dirName) {
        if (!dirName.matches(DIR_REGEXP)) {
            return DIR_EXCEPTION;
        }
        return "";
    }

    public String checkLetter (String letter){
        if (!letter.matches(LETTER_REGEXP)) {
            return LETTER_EXCEPTION;
        }
        return "";
    }
}
