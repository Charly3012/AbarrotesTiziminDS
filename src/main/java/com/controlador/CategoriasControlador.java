package com.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CategoriasControlador {

    @FXML
    public BorderPane borderPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }

    public void cerrarVentana() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLMenu.fxml"));
            Parent root = loader.load();
            MenuControlador controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Abarrotes Tizimin");
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.borderPane.getScene().getWindow();
            myStage.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
