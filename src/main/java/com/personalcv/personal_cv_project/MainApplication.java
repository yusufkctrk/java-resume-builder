package com.personalcv.personal_cv_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ExecutionException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 902, 577);
        stage.setTitle("Cv Oluşturucu");
        stage.setScene(scene);
        stage.show();
        Firebase firebase = new Firebase();
        firebase.initialize();
        firebase.retrieveData();
    }

    public static void main(String[] args) {
        launch();
    }
}