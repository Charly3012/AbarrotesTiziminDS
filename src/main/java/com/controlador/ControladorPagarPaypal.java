package com.controlador;

import com.modelo.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControladorPagarPaypal {

    @FXML
    public TextField txtCorreo;

    @FXML
    public TextField txtcontraseña;

    public void setProduc(ObservableList<DatosVenta> produc) {
        this.producEnPagar = produc;
        actualizarTotal();
    }

    @FXML
    public Label labCambio;

    @FXML
    protected ObservableList<DatosVenta> producEnPagar;

    @FXML
    public Button btnCobrar;

    @FXML
    public TextField txtPago;
    @FXML
    public TextField txtCambio;
    @FXML
    public Label labTotal;


    @FXML
    public void CobraryGenerar(ActionEvent actionEvent) {
        MetodoPagoContexto contexto = new MetodoPagoContexto();
        contexto.setMetodoPagoStrategy(new PagoStrategyPaypal(txtCorreo.getText(), txtcontraseña.getText()));

        Alerta alerta = new Alerta("Pago confirmado", "Su pago con Paypal se ha realizado correctamente");
        alerta.mostrarAlertaInformation();

        Stage stage = (Stage) btnCobrar.getScene().getWindow();
        stage.close();

    }
    public void actualizarTotal() {

    }

    public void escribirPago(KeyEvent keyEvent) {


    }
}





