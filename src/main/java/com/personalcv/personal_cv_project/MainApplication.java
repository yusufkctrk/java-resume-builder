package com.personalcv.personal_cv_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainApplication extends Application {
    Firebase firebase = null;


    public MainApplication() throws IOException, ExecutionException, InterruptedException {
        firebase = new Firebase();
        firebase.initialize();


    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("createResume.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 768);
        scene.getStylesheets().add("application.css");
        stage.setTitle("Cv Oluşturucu");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }
}