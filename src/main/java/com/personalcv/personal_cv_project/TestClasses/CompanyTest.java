package com.personalcv.personal_cv_project.TestClasses;

import com.personalcv.personal_cv_project.Company;

import java.io.IOException;

public class CompanyTest {
    Company company = Company.getInstance();

    public CompanyTest() throws IOException {
        company.setJobTitle("CEO-Founder");
        company.setCompanyName("swexcode");
        company.setExperience("5");

        System.out.println(company);
    }
}
