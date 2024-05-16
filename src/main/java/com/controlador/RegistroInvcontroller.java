package com.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegistroInvcontroller {


    @FXML
    public TableView tblProductos;
    @FXML
    public TableColumn colIdenti;
    @FXML
    public TableColumn colNombre;
    @FXML
    public TableColumn colPreVent;
    @FXML
    public TableColumn colPrePro;
    @FXML
    public TableColumn colCant;
    @FXML
    public Button btnGuardar;

    public void guardar(ActionEvent actionEvent) {

    }
}
