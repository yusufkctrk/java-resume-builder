package com.personalcv.personal_cv_project;


import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Resume {
    public void createResume(PersonalInformation personalInformation, Education education, Company company, Skills skills, Hobbies hobbies) throws IOException {
        Firebase firebase = new Firebase();
        Map<String, Object> resumeMap = new HashMap<>();

        Map<String, Object> personalMap = new HashMap<>();
        Map<String, Object> educationMap = new HashMap<>();
        Map<String, Object> schoolInformationMap = new HashMap<>();
        Map<String, Object> schoolInformationMap2 = new HashMap<>();
        Map<String, Object> schoolInformationMap3 = new HashMap<>();
        Map<String, Object> companyMap = new HashMap<>();
        Map<String, Object> skillsMap = new HashMap<>();
        Map<String, Object> hobbiesMap = new HashMap<>();

        personalMap.put(Params.fullname, personalInformation.getFullname());
        personalMap.put(Params.birthdate, personalInformation.getBirthDate());
        personalMap.put(Params.address, personalInformation.getAddress());
        personalMap.put(Params.gender, personalInformation.getGender());
        personalMap.put(Params.mail, personalInformation.getMail());
        personalMap.put(Params.phoneNumber, personalInformation.getPhoneNumber());
        personalMap.put(Params.zipCode, personalInformation.getZipCode());

        schoolInformationMap.put(Params.schoolName, education.getSchoolName_1());
        schoolInformationMap.put(Params.schoolPeriod, education.getSchoolPeriod_1());
        schoolInformationMap2.put(Params.schoolName, education.getSchoolName_2());
        schoolInformationMap2.put(Params.schoolPeriod, education.getSchoolPeriod_2());
        schoolInformationMap3.put(Params.schoolName, education.getSchoolName_3());
        schoolInformationMap3.put(Params.schoolPeriod, education.getSchoolPeriod_3());
        educationMap.put(Params.elementary_school, schoolInformationMap);
        educationMap.put(Params.high_school, schoolInformationMap2);
        educationMap.put(Params.license, schoolInformationMap3);

        companyMap.put(Params.companyName, company.getCompanyName());
        companyMap.put(Params.jobTitle, company.getJobTitle());
        companyMap.put(Params.jobTitle, company.getExperience());

        skillsMap.put(Params.skills, skills.getSkills());
        hobbiesMap.put(Params.hobbies, hobbies.getHobbies());

        resumeMap.put(Params.personalInformations, personalMap);
        resumeMap.put(Params.personalInformations, educationMap);
        resumeMap.put(Params.companyInformations, companyMap);
        resumeMap.put(Params.skillsInformation, skillsMap);
        resumeMap.put(Params.hobbiesInformation, hobbiesMap);


        JsonNode jsonNode = new Utility().mapObjectToJson(resumeMap);
        jsonNode.get(Params.hobbiesInformation).get(Params.hobbies).forEach(System.out::println);
//        firebase.createData(resumeMap);
    }
}
