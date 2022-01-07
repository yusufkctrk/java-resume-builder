module com.personalcv.personal_cv_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires java.annotation;
    requires com.google.auth;
    requires com.google.api.apicommon;
    requires google.cloud.firestore;
    requires google.cloud.core;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.personalcv.personal_cv_project to javafx.fxml;
    exports com.personalcv.personal_cv_project;
}