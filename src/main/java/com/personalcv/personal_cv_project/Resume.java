package com.personalcv.personal_cv_project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Resume {
    public void createResume(PersonalInformation personalInformation, Education education, Company company, Skills skills) throws IOException {
        Firebase firebase = new Firebase();
        Map<String, Object> resumeMap = new HashMap<>();

        Map<String, Object> personalMap = new HashMap<>();
        Map<String, Object> educationMap = new HashMap<>();
        Map<String, Object> schoolInformationMap = new HashMap<>();
        Map<String, Object> schoolInformationMap2 = new HashMap<>();
        Map<String, Object> schoolInformationMap3 = new HashMap<>();
        Map<String, Object> companyMap = new HashMap<>();
        Map<String, Object> skillsMap = new HashMap<>();

        personalMap.put("fullname", personalInformation.getFullname());
        personalMap.put("birthdate", personalInformation.getBirthDate());
        personalMap.put("address", personalInformation.getAddress());
        personalMap.put("gender", personalInformation.getGender());
        personalMap.put("mail", personalInformation.getMail());
        personalMap.put("phoneNumber", personalInformation.getPhoneNumber());
        personalMap.put("zipCode", personalInformation.getZipCode());

        schoolInformationMap.put("name", education.getSchoolName_1());
        schoolInformationMap.put("period", education.getSchoolPeriod_1());
        schoolInformationMap2.put("name", education.getSchoolName_2());
        schoolInformationMap2.put("period", education.getSchoolPeriod_2());
        schoolInformationMap3.put("name", education.getSchoolName_3());
        schoolInformationMap3.put("period", education.getSchoolPeriod_3());
        educationMap.put("school1", schoolInformationMap);
        educationMap.put("school2", schoolInformationMap2);
        educationMap.put("school3", schoolInformationMap3);

        companyMap.put("companyName", company.getCompanyName());
        companyMap.put("jobTitle", company.getJobTitle());
        companyMap.put("experience", company.getExperience());

        skillsMap.put("skills", skills.getSkills());

        resumeMap.put("personalInformations", personalMap);
        resumeMap.put("educationInformations", educationMap);
        resumeMap.put("companyInformations", companyMap);
        resumeMap.put("skillsInformation", skillsMap);

        firebase.createData(resumeMap);
    }
}
