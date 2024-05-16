package com.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuControlador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane btnCategorias;

    @FXML
    private AnchorPane btnClientes;

    @FXML
    private AnchorPane btnInventario;

    @FXML
    private AnchorPane btnVentas;

    @FXML
    void clickCategorias(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLCategorias.fxml"));
            Parent root = loader.load();
            CategoriasControlador controladorCategorias = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Categorias");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controladorCategorias.cerrarVentana());
            Stage myStage = (Stage) this.btnInventario.getScene().getWindow();
            myStage.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickClientes(MouseEvent event) {

    }

    @FXML
    void clickInventario(MouseEvent event) {

    }

    @FXML
    void clickVentas(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCategorias != null : "fx:id=\"btnCategorias\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert btnClientes != null : "fx:id=\"btnClientes\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert btnInventario != null : "fx:id=\"btnInventario\" was not injected: check your FXML file 'FXMLMenu.fxml'.";
        assert btnVentas != null : "fx:id=\"btnVentas\" was not injected: check your FXML file 'FXMLMenu.fxml'.";

    }

}
