package com.personalcv.personal_cv_project.TestClasses;

import com.personalcv.personal_cv_project.PersonalInformation;

public class PersonalInformationsTest {
    PersonalInformation personalInformation = PersonalInformation.getInstance();

    public PersonalInformationsTest() {
        personalInformation.setFullname("Yusuf Kocatürk");
        personalInformation.setPhoneNumber("5555555555");
        personalInformation.setMail("example@xc.com");
        personalInformation.setBirthDate("28.08.2016");
        personalInformation.setZipCode("34119");
        personalInformation.setAddress("Sirekci/İstnabul");
        personalInformation.setGender("male");
        System.out.println(personalInformation);
    }
}
