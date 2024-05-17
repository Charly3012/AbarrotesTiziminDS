package com.controlador;

import Modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RegistroInvcontroller  {


    @FXML
    public TableView<Producto> tblProductos;
    @FXML
    public TableColumn<Producto, String> colIdenti;
    @FXML
    public TableColumn<Producto, String> colNombre;
    @FXML
    public TableColumn<Producto, Double> colPreVent;
    @FXML
    public TableColumn<Producto, Double> colPrePro;
    @FXML
    public TableColumn<Producto, String> colCant;
    @FXML
    public Button btnGuardar;
    @FXML
    public ChoiceBox<String>tipoCantidad;
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
            producto = new ProductoAgranel();
        } else {
            producto = new ProductoUnidad();
        }

        producto.setIdentificador(identificador);
        producto.setPrecioVenta(precioVenta);
        producto.setNombre(nombre);
        producto.setPrecioProveedor(precioProveedor);
        producto.setCantidad(cantidad);

        productoData.add(producto);
    }
    private final ObservableList<Producto> productoData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Initialize the table columns.
        colIdenti.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificador()));
        precioVentaColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecioVenta()).asObject());
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        precioProveedorColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecioProveedor()).asObject());
        cantidadColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidad()));

        // Add options to the choice box.
        tipoCantidadChoiceBox.setItems(FXCollections.observableArrayList("Agranel", "Por Unidad"));
        tipoCantidadChoiceBox.setValue("Agranel"); // Default value

        // Set the data to the table.
        tblProductos.setItems(productoData);
    }
}
