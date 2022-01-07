package com.personalcv.personal_cv_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class Home {
    Skills skills;
    Education education;
    PersonalInformation personalInformation;
    Company company;
    Hobbies hobbies;

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
    private TextField schoolNameInput1;

    @FXML
    private TextField schoolNameInput2;

    @FXML
    private TextField schoolNameInput3;

    @FXML
    private TextField schoolPeriodInput1;

    @FXML
    private TextField schoolPeriodInput2;

    @FXML
    private TextField schoolPeriodInput3;

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
        education = new Education(schoolNameInput1.getText(), schoolPeriodInput1.getText(), schoolNameInput2.getText(), schoolPeriodInput2.getText(), schoolNameInput3.getText(), schoolPeriodInput3.getText());
        skills = new Skills();
        for (int i = 0; i < skillsListView.getItems().size(); i++) {
            skills.addSkill(skillsListView.getItems().get(i));
        }
        hobbies = new Hobbies();
        for (int i = 0; i < hobbiesListView.getItems().size(); i++) {
            hobbies.addHobby(hobbiesListView.getItems().get(i));
        }
        personalInformation = new PersonalInformation(fullNameInput.getText(), addressInput.getText(), zipCodeInput.getText(), birthdateInput.getText(), mailInput.getText(), phoneNumberInput.getText(), maleRadioButton.isSelected() ? "erkek" : "kadın");
        company = new Company(companyNameInput.getText(), jobTitleInput.getText(), experienceInput.getText());
        Resume resume = new Resume();
        resume.createResume(personalInformation, education, company, skills,hobbies);
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


}


