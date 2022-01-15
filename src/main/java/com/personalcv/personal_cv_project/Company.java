package com.personalcv.personal_cv_project;

import java.io.IOException;

public class Company {
    private static Company companyInstance;

    public static Company getInstance() throws IOException {
        if (companyInstance == null) {
            companyInstance = new Company();

        }
        return companyInstance;
    }

    private String companyName = "";
    private String jobTitle = "";
    private String experience = "";

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }


}
