package com.personalcv.personal_cv_project;

public class PersonalInformation {
    private String fullname = "";
    private String address = "";
    private String zipCode = "";
    private String birthDate = "";
    private String mail = "";
    private String phoneNumber = "";
    private String gender = "";

    public PersonalInformation(String fullname, String address, String zipCode, String birthDate, String mail, String phoneNumber, String gender) {
        this.fullname = fullname;
        this.address = address;
        this.zipCode = zipCode;
        this.birthDate = birthDate;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", mail='" + mail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }


}
