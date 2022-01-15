package com.personalcv.personal_cv_project;

import java.io.IOException;

public class User {
    private static User userInstance;

    public static User getInstance() throws IOException {
        if (userInstance == null) {
            userInstance = new User();

        }
        return userInstance;
    }

    public String date_of_birth;
    public String full_name;
    public String nickname;

    public User() {
    }

    public User(String date_of_birth, String full_name) {
        this.date_of_birth = date_of_birth;
        this.full_name = full_name;
    }

    public User(String dateOfBirth, String fullName, String nickname) {
        // ...
    }

}