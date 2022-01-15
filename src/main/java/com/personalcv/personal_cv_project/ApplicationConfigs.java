package com.personalcv.personal_cv_project;

import java.io.IOException;

public class ApplicationConfigs {
    Boolean isDarkThemeSelected = true;
    Boolean isResumeScreenSelected = true;

    public Boolean getDarkThemeSelected() {
        return isDarkThemeSelected;
    }

    public void setDarkThemeSelected(Boolean darkThemeSelected) {
        isDarkThemeSelected = darkThemeSelected;
    }

    public Boolean getResumeScreenSelected() {
        return isResumeScreenSelected;
    }

    public void setResumeScreenSelected(Boolean resumeScreenSelected) {
        isResumeScreenSelected = resumeScreenSelected;
    }

    private static ApplicationConfigs applicationConfigs;

    public static ApplicationConfigs getInstance() throws IOException {
        if (applicationConfigs == null) {
            applicationConfigs = new ApplicationConfigs();

        }
        return applicationConfigs;
    }

    @Override
    public String toString() {
        return "ApplicationConfigs{" +
                "isDarkThemeSelected=" + isDarkThemeSelected +
                ", isResumeScreenSelected=" + isResumeScreenSelected +
                '}';
    }
}
