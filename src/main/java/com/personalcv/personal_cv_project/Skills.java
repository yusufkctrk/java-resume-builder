package com.personalcv.personal_cv_project;


import java.io.IOException;
import java.util.ArrayList;

public class Skills {
    private static Skills skillsInstance;

    public static Skills getInstance() throws IOException {
        if (skillsInstance == null) {
            skillsInstance = new Skills();

        }
        return skillsInstance;
    }



    private ArrayList<String> skills = new ArrayList<>();

    public ArrayList<String> getSkills() {
        return skills;
    }


    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    @Override
    public String toString() {
        System.out.println("Skills:");
        skills.forEach(System.out::println);
        return "";
    }

    Skills() {
    }

    public Skills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
