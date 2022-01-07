package com.personalcv.personal_cv_project;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;


public class CreateResume {
    Skills skills;
    Education education;
    PersonalInformation personalInformation;
    Company company;
    Hobbies hobbies;
    JsonNode jsonNode = null;
    @FXML
    private Label sidebarNameLabel;

    public CreateResume() throws IOException, ExecutionException, InterruptedException {
        jsonNode = new Firebase().retrieveData();
        System.out.println(jsonNode);

        try {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //your Lable or TextField ID with .setText(“Text To update”)
                            System.out.println("çalışıyor");
                            sidebarNameLabel.setText((jsonNode.get(Params.personalInformations).get(Params.fullname).asText()));
                            fillTheResumeField(jsonNode);
                        }
                    });
                }
            }, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @FXML
    private Button addHobbyButton;

    @FXML
    private Button addSkillButton;

    @FXML
    private TextArea addressInput;

    @FXML
    private TextField birthdateInput;

    @FXML
    private TextField companyNameInput;

    @FXML
    private TextField experienceInput;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField fullNameInput;

    @FXML
    private ListView<String> hobbiesListView;

    @FXML
    private TextField hobbyInput;

    @FXML
    private TextField jobTitleInput;

    @FXML
    private TextField mailInput;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TextField phoneNumberInput;

    @FXML
    private Button removeHobbyButton;

    @FXML
    private Button removeSkillButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button updateResumeButton;

    @FXML
    private TextField elementarySchoolNameInput;

    @FXML
    private TextField highSchoolNameInput;

    @FXML
    private TextField licenseNameInput;

    @FXML
    private TextField elementarySchoolPeriodInput;

    @FXML
    private TextField highSchoolPeriodInput;

    @FXML
    private TextField licensePeriodInput;

    @FXML
    private TextField skillsInput;

    @FXML
    private ListView<String> skillsListView;

    @FXML
    private TextField zipCodeInput;

    @FXML
    void onAddHobby(ActionEvent event) {
        if (hobbyInput.getText() != "") {
            hobbiesListView.getItems().add(hobbyInput.getText());
        }

        hobbyInput.setText("");
        hobbyInput.requestFocus();
    }

    @FXML
    void onRemoveHobby(ActionEvent event) {
        try {
            int itemIndex = hobbiesListView.getSelectionModel().getSelectedIndex();
            hobbiesListView.getItems().remove(itemIndex);
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err);
        }
    }

    @FXML
    void onAddSkill(ActionEvent event) {
        if (skillsInput.getText() != "") {
            skillsListView.getItems().add(skillsInput.getText());
        }

        skillsInput.setText("");
        skillsInput.requestFocus();
    }

    @FXML
    void onRemoveSkill(ActionEvent event) {
        try {
            int itemIndex = skillsListView.getSelectionModel().getSelectedIndex();
            skillsListView.getItems().remove(itemIndex);
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err);
        }

    }

    @FXML
    void saveFunction(ActionEvent event) throws IOException {
        education = new Education(elementarySchoolNameInput.getText(),
                elementarySchoolPeriodInput.getText(),
                highSchoolNameInput.getText(),
                highSchoolPeriodInput.getText(),
                licenseNameInput.getText(),
                licensePeriodInput.getText());
        skills = new Skills();
        for (int i = 0; i < skillsListView.getItems().size(); i++) {
            skills.addSkill(skillsListView.getItems().get(i));
        }
        hobbies = new Hobbies();
        for (int i = 0; i < hobbiesListView.getItems().size(); i++) {
            hobbies.addHobby(hobbiesListView.getItems().get(i));
        }
        personalInformation = new PersonalInformation(fullNameInput.getText(),
                addressInput.getText(),
                zipCodeInput.getText(),
                birthdateInput.getText(),
                mailInput.getText(),
                phoneNumberInput.getText(),
                maleRadioButton.isSelected()
                        ? Params.male
                        : Params.female);
        company = new Company(companyNameInput.getText(), jobTitleInput.getText(), experienceInput.getText());
        Resume resume = new Resume();
        resume.createResume(personalInformation, education, company, skills, hobbies, Params.createNewResume);

    }

    @FXML
    void updateResume(ActionEvent event) throws IOException {
        education = new Education(elementarySchoolNameInput.getText(),
                elementarySchoolPeriodInput.getText(),
                highSchoolNameInput.getText(),
                highSchoolPeriodInput.getText(),
                licenseNameInput.getText(),
                licensePeriodInput.getText());
        skills = new Skills();
        for (int i = 0; i < skillsListView.getItems().size(); i++) {
            skills.addSkill(skillsListView.getItems().get(i));
        }
        hobbies = new Hobbies();
        for (int i = 0; i < hobbiesListView.getItems().size(); i++) {
            hobbies.addHobby(hobbiesListView.getItems().get(i));
        }
        personalInformation = new PersonalInformation(fullNameInput.getText(),
                addressInput.getText(),
                zipCodeInput.getText(),
                birthdateInput.getText(),
                mailInput.getText(),
                phoneNumberInput.getText(),
                maleRadioButton.isSelected()
                        ? Params.male
                        : Params.female);
        company = new Company(companyNameInput.getText(), jobTitleInput.getText(), experienceInput.getText());
        Resume resume = new Resume();
        resume.createResume(personalInformation, education, company, skills, hobbies, Params.updateResume);

    }

    @FXML
    void onFemaleRadioSelected(ActionEvent event) {
        if (maleRadioButton.isSelected()) {
            maleRadioButton.setSelected(false);
        }
    }

    @FXML
    void onMaleRadioSelected(ActionEvent event) {
        if (femaleRadioButton.isSelected()) {
            femaleRadioButton.setSelected(false);
        }
    }

    void fillTheResumeField(JsonNode json) {
        System.out.println("bizim " + json);
        fullNameInput.setText(json.get(Params.personalInformations).get(Params.fullname).asText());
        birthdateInput.setText(json.get(Params.personalInformations).get(Params.birthdate).asText());
        femaleRadioButton.setSelected(Objects.equals(json.get(Params.personalInformations).get(Params.gender).asText(), Params.female));
        maleRadioButton.setSelected(Objects.equals(json.get(Params.personalInformations).get(Params.gender).asText(), Params.male));
        mailInput.setText(json.get(Params.personalInformations).get(Params.mail).asText());
        phoneNumberInput.setText(json.get(Params.personalInformations).get(Params.phoneNumber).asText());
        zipCodeInput.setText(json.get(Params.personalInformations).get(Params.zipCode).asText());
        addressInput.setText(json.get(Params.personalInformations).get(Params.address).asText());
        companyNameInput.setText(json.get(Params.companyInformations).get(Params.companyName).asText());
        jobTitleInput.setText(json.get(Params.companyInformations).get(Params.jobTitle).asText());
        System.out.println(json.get(Params.companyInformations).get(Params.experience));
        experienceInput.setText(json.get(Params.companyInformations).get(Params.experience).asText());
        try {
            json.get(Params.skillsInformation).get(Params.skills).forEach((item) -> {
                skillsListView.getItems().add(item.asText());
            });
        } catch (NullPointerException e) {
            System.out.println("An error occured while retrieving Skills List. The error is :" + e);
        }
        try {
            json.get(Params.hobbiesInformation).get(Params.hobbies).forEach((item) -> {
                hobbiesListView.getItems().add(item.asText());
            });
        } catch (NullPointerException e) {
            System.out.println("An error occured while retrieving Hobbies List. The error is :" + e);
        }
        elementarySchoolNameInput.setText(json.get(Params.educationInformations).get(Params.elementary_school).get(Params.schoolName).asText());
        elementarySchoolPeriodInput.setText(json.get(Params.educationInformations).get(Params.elementary_school).get(Params.schoolPeriod).asText());
        highSchoolNameInput.setText(json.get(Params.educationInformations).get(Params.high_school).get(Params.schoolName).asText());
        highSchoolPeriodInput.setText(json.get(Params.educationInformations).get(Params.high_school).get(Params.schoolPeriod).asText());
        licenseNameInput.setText(json.get(Params.educationInformations).get(Params.license).get(Params.schoolName).asText());
        licensePeriodInput.setText(json.get(Params.educationInformations).get(Params.license).get(Params.schoolPeriod).asText());

    }
}


