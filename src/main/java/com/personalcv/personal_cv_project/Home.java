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
    private TextField jobTitleInput;

    @FXML
    private TextField mailInput;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private TextField phoneNumberInput;

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
    private ListView<String> skillsListView;

    @FXML
    private TextField skilssInput;

    @FXML
    private TextField zipCodeInput;

    @FXML
    void onAddSkill(ActionEvent event) {
        if (skilssInput.getText() != "") {
            skillsListView.getItems().add(skilssInput.getText());
        }

        skilssInput.setText("");
        skilssInput.requestFocus();
    }

    @FXML
    void removeSkill(ActionEvent event) {
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
        personalInformation = new PersonalInformation(fullNameInput.getText(), addressInput.getText(), zipCodeInput.getText(), birthdateInput.getText(), mailInput.getText(), phoneNumberInput.getText(), maleRadioButton.isSelected() ? "erkek" : "kadın");
        company = new Company(companyNameInput.getText(), jobTitleInput.getText(), experienceInput.getText());

        Resume resume = new Resume();
        resume.createResume(personalInformation, education, company, skills);

        System.out.println(education);
        System.out.println(skills);
        System.out.println(personalInformation);
        System.out.println(company);


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


