package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppAT extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppAT.class.getResource("/vista/FXMLMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 854, 480);
        stage.setTitle("Abarrotes Tizimin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}