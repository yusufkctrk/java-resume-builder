package com.personalcv.personal_cv_project.TestClasses;

import com.personalcv.personal_cv_project.Skills;

import java.io.IOException;
import java.util.ArrayList;

public class SkillsTest {
    Skills skills = Skills.getInstance();

    public SkillsTest() throws IOException {
        ArrayList<String> skillsList = new ArrayList<>();

        skillsList.add("Sorgulamak");

        skills.setSkills(skillsList);
        skills.addSkill("Merak Etmek");

        System.out.println(skills);
    }
}
