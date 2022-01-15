package com.personalcv.personal_cv_project.TestClasses;

import com.personalcv.personal_cv_project.Hobbies;

import java.io.IOException;
import java.util.ArrayList;

public class HobbiesTest {
    Hobbies hobbies = Hobbies.getInstance();

    public HobbiesTest() throws IOException {
        ArrayList<String> hobbiesList = new ArrayList<>();
        hobbiesList.add("Sorgulamak");
        hobbies.setHobbies(hobbiesList);
        System.out.println(hobbies);
    }
}
