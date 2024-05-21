package com.controlador;

import Modelo.Producto;
import Modelo.PAgranel;
import Modelo.PUnidad;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class RegistroInvcontroller  {


    @FXML
    public TableView<Producto> tblProductos;
    @FXML
    public TableColumn<Producto, String> colIdenti;
    @FXML
    public TableColumn<Producto, String>  colNombre;
    @FXML
    public TableColumn <Producto, Double>colPreVent;
    @FXML
    public TableColumn <Producto, Double>colPrePro;
    @FXML
    public TableColumn <Producto, String>colCant;
    @FXML
    public Button btnGuardar;
    @FXML
    public TextField cantidadField;
    @FXML
    public TextField precioProveedorField;
    @FXML
    public TextField precioVentaField;
    @FXML
    public TextField identificadorField;
    @FXML
    public TextField nombreField;
    private ObservableList<Producto> productoData = FXCollections.observableArrayList();

    @FXML
    public ChoiceBox<String>tipoCantidadChoiceBox;
    //lo que esta debajo es parte del proceso


    public void guardar(ActionEvent actionEvent) {
        String identificador = identificadorField.getText();
        double precioVenta = Double.parseDouble(precioVentaField.getText());
        String nombre = nombreField.getText();
        double precioProveedor = Double.parseDouble(precioProveedorField.getText());
        String cantidad = cantidadField.getText();
        String tipoCantidad = tipoCantidadChoiceBox.getValue();

        Producto producto;
        if (tipoCantidad.equals("Agranel")) {
            producto = new PAgranel();
        } else {
            producto = new PUnidad();
        }

        producto.setIdentificador(identificador);
        producto.setPrecioVenta(precioVenta);
        producto.setNombre(nombre);
        producto.setPrecioProveedor(precioProveedor);
        producto.setCantidad(cantidad);

        productoData.add(producto);
    }


    @FXML
    private void initialize() {
        /*productoData = FXCollections.observableArrayList();

        this.colIdenti.setCellValueFactory(new PropetyValueFactory("Identificador"));
        this.colNombre.setCellValueFactory(new PropetyValueFactory("Nombre"));
        this.colPreVent.setCellValueFactory(new PropetyValueFactory("Precio Venta"));
        this.colPrePro.setCellValueFactory(new PropetyValueFactory("Precio proveedor"));*/

        //Initialize the table columns.
        colIdenti.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificador()));
        colPreVent.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecioVenta()).asObject());
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colPrePro.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecioproveedor()).asObject());
        colCant.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidad()));


        tipoCantidadChoiceBox.setItems(FXCollections.observableArrayList("Agranel", "Por Unidad"));
        tipoCantidadChoiceBox.setValue("Agranel"); // Default value


        tblProductos.setItems(productoData);
    }

    public void cerrarVentana() {



    }
}
