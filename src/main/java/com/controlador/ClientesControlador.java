package com.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Alerta;

public class ClientesControlador implements Initializable {


    @FXML
    private ComboBox<String> cmbGenero;

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
    private TableColumn<?, ?> colGenero;

    @FXML
    private TableColumn<?, ?> colDireccion;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colTelefono;

    @FXML
    private TableView<Cliente> tabClientes;

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
    private ObservableList<Cliente> obsClientes;

    @FXML
    private ObservableList<Cliente> obsBusqueda;

    @FXML
    private ObservableList<String> obsGeneros;

    private Cliente clienteSelecc;


    @FXML
    void clickEliminar(ActionEvent event) {

    }

    @FXML
    void clickGuardar(ActionEvent event) {

        try {

            //Datos del cliente
            String nombre = this.txtNombre.getText();
            long telefono = Long.parseLong(this.txtTelefono.getText());
            int id = Integer.parseInt(this.txtId.getText());
            String genero = this.cmbGenero.getSelectionModel().getSelectedItem() + "";

            //Datos de la direccion del cliente
            String calle = this.txtCalle.getText();
            int numero = Integer.parseInt(this.txtNumeroDeCasa.getText());
            String colonia = this.txtColonia.getText();
            int cp = Integer.parseInt(this.txtCodigoPostal.getText());
            String ciudad = this.txtCiudad.getText();
            String estado = this.txtEstado.getText();

            Direccion direccion = new Direccion(calle, numero, colonia, cp, ciudad, estado);
            Cliente clienteNuevo = new Cliente(nombre, telefono, id, genero, direccion );
            clienteSelecc = tabClientes.getSelectionModel().getSelectedItem();


            //Comprobación de si existe
            if(!(obsClientes.contains(clienteNuevo))){

                //Editar
                if (obsClientes.contains(clienteSelecc)){
                    clienteSelecc.setNombre(nombre);
                    clienteSelecc.setId(id);
                    clienteSelecc.setTelefono(telefono);
                    clienteSelecc.setGenero(genero);
                    clienteSelecc.setDireccion(direccion);
                    this.tabClientes.refresh();

                    Alerta categoriaModificada = new Alerta("Categoría modificada", "La categoría ha sido modificada con éxito");
                    categoriaModificada.mostrarAlertaInformation();

                    limpiarCampos();

                }



                //Nuevo
                else{
                    this.obsClientes.add(clienteNuevo);

                    Alerta agregadoCorrecto = new Alerta("Agregado correctamente", "El cliente " + this.txtNombre.getText() +" fue agregado correctamente");
                    agregadoCorrecto.mostrarAlertaInformation();

                    limpiarCampos();

                    //Para evitar conflictos cuando se está buscando
                    if (clienteNuevo.getNombre().toLowerCase().contains(this.txtBuscar.getText().toLowerCase())){
                        this.obsBusqueda.add(clienteNuevo);
                    }
                    this.tabClientes.refresh();

                }


            }
            else {
                Alerta categoriaExiste = new Alerta("Producto ya existe", "¡Error! el producto ya existe");
                categoriaExiste.mostrarAlertaInformation();
            }


        } catch (NumberFormatException | ArithmeticException e) {

            Alerta alertacategoria = new Alerta("Error", "Compruebe los datos e intente nuevamente\n" + "Detalles del error: " + e.getMessage());
            alertacategoria.mostrarAlertaError();

        }finally{
            this.tabClientes.getSelectionModel().clearSelection();
        }

    }



    @FXML
    void clickLimpiar(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos(){
        this.txtNombre.setText("");
        this.txtId.setText("");
        this.txtTelefono.setText("");
        this.cmbGenero.setValue(null);
        this.txtCalle.setText("");
        this.txtNumeroDeCasa.setText("");
        this.txtColonia.setText("");
        this.txtCodigoPostal.setText("");
        this.txtEstado.setText("");
        this.txtCiudad.setText("");

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

        iniciarDatos();

    }


    public void iniciarDatos(){
        obsGeneros = FXCollections.observableArrayList("Hombre", "Mujer", "Prefiero no decir");
        cmbGenero.setItems(obsGeneros);

        obsClientes = FXCollections.observableArrayList();
        tabClientes.setItems(obsClientes);

        obsBusqueda = FXCollections.observableArrayList();

        this.colNombre.setCellValueFactory((new PropertyValueFactory<>("nombre")));
        this.colTelefono.setCellValueFactory((new PropertyValueFactory<>("telefono")));
        this.colId.setCellValueFactory((new PropertyValueFactory<>("id")));
        this.colGenero.setCellValueFactory((new PropertyValueFactory<>("genero")));
        this.colDireccion.setCellValueFactory((new PropertyValueFactory<>("direccionCadena")));

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
