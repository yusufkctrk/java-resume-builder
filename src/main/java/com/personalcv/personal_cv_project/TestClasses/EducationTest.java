package com.personalcv.personal_cv_project.TestClasses;

import com.personalcv.personal_cv_project.Education;

public class EducationTest {
    Education education = Education.getInstance();

    public EducationTest() {
        education.setSchoolName_1("Bahçelievler İlköğretim");
        education.setSchoolPeriod_1("2008-2016");

        education.setSchoolName_2("Erzincan Fen Lisesi");
        education.setSchoolPeriod_2("2016-2020");

        education.setSchoolName_3("Marmara Üniversitesi");
        education.setSchoolPeriod_3("2020-2024");

        System.out.println(education);

    }
}
