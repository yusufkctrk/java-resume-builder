package com.personalcv.personal_cv_project;

public class User {

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