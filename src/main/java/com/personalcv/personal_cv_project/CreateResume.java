package com.personalcv.personal_cv_project;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    JsonNode documentsJsonNode = null;
    Boolean isDarkThemeSelected = ApplicationConfigs.getInstance().getDarkThemeSelected();
    Boolean isResumeScreenSelected = ApplicationConfigs.getInstance().getResumeScreenSelected();

    @FXML
    private Label sidebarNameLabel;


    public CreateResume() throws IOException, ExecutionException, InterruptedException {
        jsonNode = new Firebase().retrieveData();
        documentsJsonNode = new Firebase().retrieveDocuments();
        try {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("çalışıyor");
                            System.out.println(jsonNode);
                            sidebarNameLabel.setText((jsonNode.get(Params.personalInformations).get(Params.fullname).asText()));
                            try {
                                if (ApplicationConfigs.getInstance().getResumeScreenSelected()) {
                                    fillTheResumeField(jsonNode);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                if (!ApplicationConfigs.getInstance().getResumeScreenSelected()) {
                                    fillTheUsersField(documentsJsonNode);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private Button showUserCVButton;

    @FXML
    private Button myUsersButton;

    @FXML
    private Button createResumeButton;
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
    private ListView<String> usersListView;

    @FXML
    private TextField zipCodeInput;

    @FXML
    private Button darkThemeButton;

    @FXML
    private Button lightThemeButton;
    @FXML
    private Button deleteResumeButton;

    @FXML
    void onShowUserCV(ActionEvent event) throws IOException, ExecutionException, InterruptedException {
        try {
            int itemIndex = usersListView.getSelectionModel().getSelectedIndex();
            System.out.println(itemIndex);
            Params.currentPersonID = Params.documentsID.get(itemIndex);
            Stage stage;
            Parent root;
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (ApplicationConfigs.getInstance().getDarkThemeSelected()) {
                root = FXMLLoader.load(getClass().getResource("createResumeDarkTheme.fxml"));
            } else {
                root = FXMLLoader.load(getClass().getResource("createResume.fxml"));
            }

            ApplicationConfigs.getInstance().setResumeScreenSelected(true);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err);
        }
    }

    @FXML
    void onChangeToResume(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (ApplicationConfigs.getInstance().getDarkThemeSelected()) {
            root = FXMLLoader.load(getClass().getResource("createResumeDarkTheme.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("createResume.fxml"));
        }

        ApplicationConfigs.getInstance().setResumeScreenSelected(true);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onChangeToUsers(ActionEvent event) throws IOException, ExecutionException, InterruptedException {

        Stage stage;
        Parent root;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (ApplicationConfigs.getInstance().getDarkThemeSelected()) {
            root = FXMLLoader.load(getClass().getResource("myUsersDark.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("myUsers.fxml"));

        }
        Scene scene = new Scene(root);
        ApplicationConfigs.getInstance().setResumeScreenSelected(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteResume(ActionEvent event) throws IOException, ExecutionException, InterruptedException {
        Resume resume = Resume.getInstance();
        resume.deleteResume();
        Stage stage;
        Parent root;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (ApplicationConfigs.getInstance().getDarkThemeSelected()) {
            root = FXMLLoader.load(getClass().getResource("createResumeDarkTheme.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("createResume.fxml"));
        }
        Scene scene = new Scene(root);
        ApplicationConfigs.getInstance().setDarkThemeSelected(true);
        stage.setScene(scene);
        stage.show();
        clearFields();
    }

    @FXML
    void onDarkThemeSelected(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (ApplicationConfigs.getInstance().getResumeScreenSelected()) {
            root = FXMLLoader.load(getClass().getResource("createResumeDarkTheme.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("myUsersDark.fxml"));
        }
        Scene scene = new Scene(root);
        ApplicationConfigs.getInstance().setDarkThemeSelected(true);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onLightThemeSelected(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (ApplicationConfigs.getInstance().getResumeScreenSelected()) {

            root = FXMLLoader.load(getClass().getResource("createResume.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("myUsers.fxml"));
        }
        Scene scene = new Scene(root);
        ApplicationConfigs.getInstance().setDarkThemeSelected(false);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void onAddHobby(ActionEvent event) {
        if (!Objects.equals(hobbyInput.getText(), "")) {
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
        if (!Objects.equals(skillsInput.getText(), "")) {
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
        education = Education.getInstance();
        education.setSchoolName_1(elementarySchoolNameInput.getText());
        education.setSchoolPeriod_1(elementarySchoolPeriodInput.getText());
        education.setSchoolName_2(highSchoolNameInput.getText());
        education.setSchoolPeriod_2(highSchoolPeriodInput.getText());
        education.setSchoolName_3(licenseNameInput.getText());
        education.setSchoolPeriod_3(licensePeriodInput.getText());
        skills = new Skills();
        for (int i = 0; i < skillsListView.getItems().size(); i++) {
            skills.addSkill(skillsListView.getItems().get(i));
        }
        hobbies = new Hobbies();
        for (int i = 0; i < hobbiesListView.getItems().size(); i++) {
            hobbies.addHobby(hobbiesListView.getItems().get(i));
        }
        personalInformation = PersonalInformation.getInstance();
        personalInformation.setFullname(fullNameInput.getText());
        personalInformation.setAddress(addressInput.getText());
        personalInformation.setZipCode(zipCodeInput.getText());
        personalInformation.setBirthDate(birthdateInput.getText());
        personalInformation.setMail(mailInput.getText());
        personalInformation.setPhoneNumber(phoneNumberInput.getText());
        personalInformation.setGender(maleRadioButton.isSelected()
                ? Params.male
                : Params.female);

        company = Company.getInstance();
        company.setCompanyName(companyNameInput.getText());
        company.setJobTitle(jobTitleInput.getText());
        company.setExperience(experienceInput.getText());
        Resume resume = Resume.getInstance();
        resume.resumeProcess(personalInformation, education, company, skills, hobbies, Params.createNewResume);

    }

    @FXML
    void updateResume(ActionEvent event) throws IOException {
        education = Education.getInstance();
        education.setSchoolName_1(elementarySchoolNameInput.getText());
        education.setSchoolPeriod_1(elementarySchoolPeriodInput.getText());
        education.setSchoolName_2(highSchoolNameInput.getText());
        education.setSchoolPeriod_2(highSchoolPeriodInput.getText());
        education.setSchoolName_3(licenseNameInput.getText());
        education.setSchoolPeriod_3(licensePeriodInput.getText());

        skills = Skills.getInstance();
        for (int i = 0; i < skillsListView.getItems().size(); i++) {
            skills.addSkill(skillsListView.getItems().get(i));
        }
        hobbies = new Hobbies();
        for (int i = 0; i < hobbiesListView.getItems().size(); i++) {
            hobbies.addHobby(hobbiesListView.getItems().get(i));
        }
        personalInformation = PersonalInformation.getInstance();
        personalInformation.setFullname(fullNameInput.getText());
        personalInformation.setAddress(addressInput.getText());
        personalInformation.setZipCode(zipCodeInput.getText());
        personalInformation.setBirthDate(birthdateInput.getText());
        personalInformation.setMail(mailInput.getText());
        personalInformation.setPhoneNumber(phoneNumberInput.getText());
        personalInformation.setGender(maleRadioButton.isSelected()
                ? Params.male
                : Params.female);
        company = Company.getInstance();
        company.setCompanyName(companyNameInput.getText());
        company.setExperience(experienceInput.getText());
        company.setJobTitle(jobTitleInput.getText());
        Resume resume = Resume.getInstance();
        resume.resumeProcess(personalInformation, education, company, skills, hobbies, Params.updateResume);

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
        experienceInput.setText(json.get(Params.companyInformations).get(Params.experience).asText());
        try {
            skillsListView.getItems().clear();
            json.get(Params.skillsInformation).get(Params.skills).forEach((item) -> {
                skillsListView.getItems().add(item.asText());
            });
        } catch (NullPointerException e) {
            System.out.println("An error occured while retrieving Skills List. The error is :" + e);
        }
        try {
            hobbiesListView.getItems().clear();
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

    void fillTheUsersField(JsonNode jsonNode) {
        String fullname = "";
        String phoneNumber = "";
        String companyName = "";
        if (usersListView != null) {
            try {
                usersListView.getItems().clear();
                for (int i = 0; i < Params.documentsID.size(); i++) {
                    fullname = jsonNode.get(Params.documentsID.get(i)).get(Params.personalInformations).get(Params.fullname).asText();
                    phoneNumber = jsonNode.get(Params.documentsID.get(i)).get(Params.personalInformations).get(Params.phoneNumber).asText();
                    companyName = jsonNode.get(Params.documentsID.get(i)).get(Params.companyInformations).get(Params.companyName).asText();
                    usersListView.getItems().add(fullname + "                 " + companyName + "                       " + phoneNumber);
                }
            } catch (NullPointerException e) {
                System.out.println("An error occured while retrieving Users List. The error is :" + e);
            }
        }
    }

    void clearFields() {
        fullNameInput.clear();
        birthdateInput.clear();
        femaleRadioButton.setSelected(false);
        maleRadioButton.setSelected(false);
        mailInput.clear();
        phoneNumberInput.clear();
        zipCodeInput.clear();
        addressInput.clear();
        companyNameInput.clear();
        jobTitleInput.clear();
        experienceInput.clear();
        skillsListView.getItems().clear();
        hobbiesListView.getItems().clear();
        elementarySchoolNameInput.clear();
        elementarySchoolPeriodInput.clear();
        highSchoolNameInput.clear();
        highSchoolPeriodInput.clear();
        licenseNameInput.clear();
        licensePeriodInput.clear();

    }
}


