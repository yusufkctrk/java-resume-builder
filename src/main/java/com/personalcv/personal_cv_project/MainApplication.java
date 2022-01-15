package com.personalcv.personal_cv_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    Firebase firebase = null;
    Stage stage = null;
    Scene scene = null;
    ScreenController controller = null;

    public MainApplication() throws IOException {
        firebase = new Firebase();
        firebase.initialize();
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            this.stage = stage;
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("createResumeDarkTheme.fxml"));
            this.scene = new Scene(fxmlLoader.load(), 1200, 768);
            this.stage.setTitle("Cv Oluşturucu");
            this.stage.setScene(this.scene);

            this.stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}