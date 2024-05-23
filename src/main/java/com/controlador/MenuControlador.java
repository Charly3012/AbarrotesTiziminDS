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

            // Obtener el controlador del Singleton
            CategoriasControlador controladorCategorias = ControladorPrincipalSingleton.getInstancia().getCategoriasControlador();

            // Configurar la escena y el stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Categorias");
            stage.setScene(scene);
            stage.show();

            // Manejar el evento de cierre de la ventana
            stage.setOnCloseRequest(e -> controladorCategorias.cerrarVentana());

            // Obtener y guardar el stage del menú principal
            Stage menuStage = (Stage) btnCategorias.getScene().getWindow();
            menuStage.hide();

            // Guardar referencia al stage en el Singleton
            ControladorPrincipalSingleton.getInstancia().setMenuStage(menuStage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickClientes(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLClientes.fxml"));
            Parent root = loader.load();
            ClientesControlador clientesControlador = ControladorPrincipalSingleton.getInstancia().getClientesControlador();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Clientes");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> clientesControlador.cerrarVentana());
            Stage menuStage = (Stage) this.btnCategorias.getScene().getWindow();
            menuStage.hide();
            ControladorPrincipalSingleton.getInstancia().setMenuStage(menuStage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void clickInventario(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VistaRegistroInv.fxml"));
            Parent root = loader.load();
            RegistroInvcontroller registroInvcontroller = ControladorPrincipalSingleton.getInstancia().getRegistroInvcontroller();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Inventario");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> registroInvcontroller.cerrarVentana());
            Stage menuStage = (Stage) this.btnCategorias.getScene().getWindow();
            menuStage.hide();

            ControladorPrincipalSingleton.getInstancia().setMenuStage(menuStage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
