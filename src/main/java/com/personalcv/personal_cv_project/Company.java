package com.personalcv.personal_cv_project;

public class Company {
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

    public Company(String companyName, String jobTitle, String experience) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.experience = experience;
    }
}
