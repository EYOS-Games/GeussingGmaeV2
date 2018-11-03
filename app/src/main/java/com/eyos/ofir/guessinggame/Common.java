package com.eyos.ofir.guessinggame;

public class Common {

    public static final int MAIN_SCREEN = 0;
    public static final int SUB_CATEGORY_SCREEN = 1;
    public static final int DIFFICULTY_SCREEN  = 2;
    public static final int SELECTED_QUESTION_SCREEN  = 3;

    public static final String SELECTED_CATEGORY_KEY  = "SELECTED_CATEGORY";
    public static final String SELECTED_SUB_CATEGORY_KEY = "SELECTED_SUB_CATEGORY";
    public static final String SELECTED_DIFFICULTY_KEY =  "SELECTED_DIFFIUCLTY";
    public static final String SELECTED_SELECTED_QUESTION_KEY =  "SELECTED_SELECTED_QUESTION";

    ///
    public static char[] user_submit_answer;
    public static int count=1;
    public static String[] alphabet_character={
            "a","b","c","d","e","f","g","h","i","j","k","l",
            "m","n","o","p","q","r","s","t","u","v","w","x",
            "y","z"
    };
}
