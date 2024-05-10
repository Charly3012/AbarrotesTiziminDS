package com.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane btnVentas;

    @FXML
    private Label labCambiar;



    @FXML
    void initialize() {
        assert btnVentas != null : "fx:id=\"btnVentas\" was not injected: check your FXML file 'FXMLVista.fxml'.";
        assert labCambiar != null : "fx:id=\"labCambiar\" was not injected: check your FXML file 'FXMLVista.fxml'.";

    }

    @FXML
    void clickVentas(MouseEvent event) {
        this.labCambiar.setText("Waaaaaaa si funciona");
    }



}
