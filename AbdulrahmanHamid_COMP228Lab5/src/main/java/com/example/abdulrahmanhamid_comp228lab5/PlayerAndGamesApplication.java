package com.example.abdulrahmanhamid_comp228lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerAndGamesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PlayerAndGamesApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 350);

        Image icon = new Image("https://upload.wikimedia.org/wikipedia/en/c/cc/JavaFX_Logo.png");
        stage.getIcons().add(icon);

        stage.setTitle("Player And Games Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}