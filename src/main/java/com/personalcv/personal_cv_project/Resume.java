package com.personalcv.personal_cv_project;


import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Resume {

    private static Resume resume;

    public static Resume getInstance() {
        if (resume == null) {
            resume = new Resume();
        }
        return resume;
    }

    public void createResume(PersonalInformation personalInformation, Education education, Company company, Skills skills, Hobbies hobbies, String processType) throws IOException {
        Firebase firebase = Firebase.getInstance();
        Map<String, Object> resumeMap = new HashMap<>();



        Map<String, Object> personalMap = new HashMap<>();
        Map<String, Object> educationMap = new HashMap<>();
        Map<String, Object> elementarySchoolMap = new HashMap<>();
        Map<String, Object> highSchoolMap = new HashMap<>();
        Map<String, Object> licenseMap = new HashMap<>();
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

        elementarySchoolMap.put(Params.schoolName, education.getSchoolName_1());
        elementarySchoolMap.put(Params.schoolPeriod, education.getSchoolPeriod_1());
        highSchoolMap.put(Params.schoolName, education.getSchoolName_2());
        highSchoolMap.put(Params.schoolPeriod, education.getSchoolPeriod_2());
        licenseMap.put(Params.schoolName, education.getSchoolName_3());
        licenseMap.put(Params.schoolPeriod, education.getSchoolPeriod_3());
        educationMap.put(Params.elementary_school, elementarySchoolMap);
        educationMap.put(Params.high_school, highSchoolMap);
        educationMap.put(Params.license, licenseMap);

        companyMap.put(Params.companyName, company.getCompanyName());
        companyMap.put(Params.jobTitle, company.getJobTitle());
        companyMap.put(Params.experience, company.getExperience());

        skillsMap.put(Params.skills, skills.getSkills());
        hobbiesMap.put(Params.hobbies, hobbies.getHobbies());

        resumeMap.put(Params.personalInformations, personalMap);
        resumeMap.put(Params.educationInformations, educationMap);
        resumeMap.put(Params.companyInformations, companyMap);
        resumeMap.put(Params.skillsInformation, skillsMap);
        resumeMap.put(Params.hobbiesInformation, hobbiesMap);

        JsonNode jsonNode = new Utility().mapObjectToJson(resumeMap);


        if (Objects.equals(processType, Params.createNewResume))
            firebase.createResume(resumeMap);
        else if (Objects.equals(processType, Params.updateResume)) {
            firebase.updateData(resumeMap, Params.currentPersonID);
            System.out.println("çalıştı " + resumeMap);
        }
    }
}
