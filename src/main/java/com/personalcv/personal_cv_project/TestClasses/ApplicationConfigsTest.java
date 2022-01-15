package com.personalcv.personal_cv_project.TestClasses;

import com.personalcv.personal_cv_project.ApplicationConfigs;

import java.io.IOException;

public class ApplicationConfigsTest {


    ApplicationConfigs applicationConfigs = ApplicationConfigs.getInstance();

    public ApplicationConfigsTest() throws IOException {
        applicationConfigs.setDarkThemeSelected(true);
        applicationConfigs.setResumeScreenSelected(true);
        System.out.println(applicationConfigs);

        applicationConfigs.setResumeScreenSelected(false);
        System.out.println(ApplicationConfigs.getInstance());
    }

}
