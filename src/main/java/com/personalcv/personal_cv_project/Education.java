package com.personalcv.personal_cv_project;

public class Education {
    private String schoolName_1 = "";
    private String schoolPeriod_1 = "";
    private String schoolName_2 = "";
    private String schoolPeriod_2 = "";
    private String schoolName_3 = "";
    private String schoolPeriod_3 = "";

    public String getSchoolName_1() {
        return schoolName_1;
    }

    public void setSchoolName_1(String schoolName_1) {
        this.schoolName_1 = schoolName_1;
    }

    public String getSchoolPeriod_1() {
        return schoolPeriod_1;
    }

    public void setSchoolPeriod_1(String schoolPeriod_1) {
        this.schoolPeriod_1 = schoolPeriod_1;
    }

    public String getSchoolName_2() {
        return schoolName_2;
    }

    public void setSchoolName_2(String schoolName_2) {
        this.schoolName_2 = schoolName_2;
    }

    public String getSchoolPeriod_2() {
        return schoolPeriod_2;
    }

    public void setSchoolPeriod_2(String schoolPeriod_2) {
        this.schoolPeriod_2 = schoolPeriod_2;
    }

    public String getSchoolName_3() {
        return schoolName_3;
    }

    public void setSchoolName_3(String schoolName_3) {
        this.schoolName_3 = schoolName_3;
    }

    public String getSchoolPeriod_3() {
        return schoolPeriod_3;
    }

    @Override
    public String toString() {
        return "Education{" +
                "schoolName_1='" + schoolName_1 + '\'' +
                ", schoolPeriod_1='" + schoolPeriod_1 + '\'' +
                ", schoolName_2='" + schoolName_2 + '\'' +
                ", schoolPeriod_2='" + schoolPeriod_2 + '\'' +
                ", schoolName_3='" + schoolName_3 + '\'' +
                ", schoolPeriod_3='" + schoolPeriod_3 + '\'' +
                '}';
    }

    public void setSchoolPeriod_3(String schoolPeriod_3) {
        this.schoolPeriod_3 = schoolPeriod_3;
    }

    public Education(String schoolName_1, String schoolPeriod_1, String schoolName_2, String schoolPeriod_2, String schoolName_3, String schoolPeriod_3) {
        this.schoolName_1 = schoolName_1;
        this.schoolPeriod_1 = schoolPeriod_1;
        this.schoolName_2 = schoolName_2;
        this.schoolPeriod_2 = schoolPeriod_2;
        this.schoolName_3 = schoolName_3;
        this.schoolPeriod_3 = schoolPeriod_3;
    }

    public Education(String schoolName_1, String schoolPeriod_1, String schoolName_2, String schoolPeriod_2) {
        this.schoolName_1 = schoolName_1;
        this.schoolPeriod_1 = schoolPeriod_1;
        this.schoolName_2 = schoolName_2;
        this.schoolPeriod_2 = schoolPeriod_2;
    }

    public Education(String schoolName_1, String schoolPeriod_1) {
        this.schoolName_1 = schoolName_1;
        this.schoolPeriod_1 = schoolPeriod_1;
    }
}
