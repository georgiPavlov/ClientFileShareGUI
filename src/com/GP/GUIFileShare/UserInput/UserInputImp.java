package com.GP.GUIFileShare.UserInput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 10/29/16.
 */
public class UserInputImp implements IUserInputImp {



    private Pattern pattern;

    private Matcher matcher;

    private static final String USERNAME_PATTERN =  "^[a-z0-9_-]{3,15}$";


    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    @Override
    public boolean validateUsername(String username) {
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        return matcher.matches();
    }

    @Override
    public boolean validatePassword(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
