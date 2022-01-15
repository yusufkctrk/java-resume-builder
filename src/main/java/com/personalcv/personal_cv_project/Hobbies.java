package com.personalcv.personal_cv_project;

import java.io.IOException;
import java.util.ArrayList;

public class Hobbies {
    private static Hobbies hobbiesInstance;

    public static Hobbies getInstance() throws IOException {
        if (hobbiesInstance == null) {
            hobbiesInstance = new Hobbies();
        }
        return hobbiesInstance;
    }

    private ArrayList<String> hobbies = new ArrayList<>();

    public void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    @Override
    public String toString() {
        System.out.println("Hobbies:");
        hobbies.forEach(System.out::println);
        return "";
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    Hobbies() {

    }

    public Hobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }
}
