package com.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ClientesControlador implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<?, ?> colDireccion;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colTelefono;

    @FXML
    private TableView<?> tabClientes;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtCalle;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtCodigoPostal;

    @FXML
    private TextField txtColonia;

    @FXML
    private TextField txtEstado;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNumeroDeCasa;

    @FXML
    private TextField txtTelefono;

    @FXML
    void clickEliminar(ActionEvent event) {

    }

    @FXML
    void clickGuardar(ActionEvent event) {

    }

    @FXML
    void clickLimpiar(ActionEvent event) {

    }

    @FXML
    void escribirBuscar(KeyEvent event) {

    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert btnGuardar != null : "fx:id=\"btnGuardar\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert colDireccion != null : "fx:id=\"colDireccion\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert colTelefono != null : "fx:id=\"colTelefono\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert tabClientes != null : "fx:id=\"tabClientes\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtBuscar != null : "fx:id=\"txtBuscar\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtCalle != null : "fx:id=\"txtCalle\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtCiudad != null : "fx:id=\"txtCiudad\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtCodigoPostal != null : "fx:id=\"txtCodigoPostal\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtColonia != null : "fx:id=\"txtColonia\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtEstado != null : "fx:id=\"txtEstado\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtNumeroDeCasa != null : "fx:id=\"txtNumeroDeCasa\" was not injected: check your FXML file 'FXMLClientes.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'FXMLClientes.fxml'.";



    }


    public void iniciarDatos(){

    }



    public void cerrarVentana(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLMenu.fxml"));
            Parent root = loader.load();
            MenuControlador controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Abarrotes Tizimin");
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnEliminar.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
