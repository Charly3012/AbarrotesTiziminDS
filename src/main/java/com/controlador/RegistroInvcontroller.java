package com.controlador;

import javafx.stage.Stage;
import com.modelo.Producto;
import com.modelo.ProductoFactory;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.io.*;
import java.util.ArrayList;

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
    @FXML
    public TextField BuscarF;
    @FXML
    public Button btnBuscar;
    @FXML
    public Button btnEliminar;
    private ObservableList<Producto> productoData = FXCollections.observableArrayList();

    @FXML
    public ChoiceBox<String>tipoCantidadChoiceBox;
    //lo que esta debajo es parte del proceso


    public void guardar(ActionEvent actionEvent) {
       try {
           String identificador = identificadorField.getText();
           double precioVenta = Double.parseDouble(precioVentaField.getText());
           String nombre = nombreField.getText();
           double precioProveedor = Double.parseDouble(precioProveedorField.getText());
           String cantidad = cantidadField.getText();
           String tipoCantidad = tipoCantidadChoiceBox.getValue();

       /* Producto producto;
        if (tipoCantidad.equals("Agranel")) {
            producto = new PAgranel();
        } else {
            producto = new PUnidad();
        }*/
           Producto producto = ProductoFactory.crearProducto(tipoCantidad);
           if (producto != null) {

               producto.setIdentificador(identificador);
               producto.setPrecioVenta(precioVenta);
               producto.setNombre(nombre);
               producto.setPrecioProveedor(precioProveedor);
               producto.setCantidad(cantidad);

               productoData.add(producto);
           }
       }catch(NumberFormatException e) {

           e.printStackTrace();
       }

       persistenciaEscribir();
    }


    @FXML
    private void initialize() {
        try {

            //Initialize the table columns.
            colIdenti.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificador()));
            colPreVent.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecioVenta()).asObject());
            colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            colPrePro.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecioproveedor()).asObject());
            colCant.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCantidad()));


            tipoCantidadChoiceBox.setItems(FXCollections.observableArrayList("Agranel", "Por Unidad"));
            tipoCantidadChoiceBox.setValue("Agranel"); // Default value


            tblProductos.setItems(productoData);
        }catch (Exception e){
            mostrarAlerta("Error en la inicialización", "Hubo un error al inicializar la tabla.", e);
        }

        persistenciaLeer();
    }

    private void mostrarAlerta(String titulo, String contenido, Exception e) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        if (e != null) {
            alerta.setContentText(contenido + "\nDetalles: " + e.getMessage());
        }
        alerta.showAndWait();
    }

    public void cerrarVentana() {


        if (this.tblProductos != null && this.tblProductos.getScene() != null) {
            Stage myStage = (Stage) this.tblProductos.getScene().getWindow();
            myStage.close();
        } else {
            System.err.println("Error: TableView o su escena es null.");
        }

        // Mostrar la ventana principal de nuevo
        Stage menuStage = ControladorPrincipalSingleton.getInstancia().getMenuStage();
        if (menuStage != null) {
            menuStage.show();
        }



    }

    @FXML
    public void BuscarProduct(ActionEvent actionEvent) {
        try {
            FilteredList<Producto> filteredData = new FilteredList<>(productoData, p -> true);

            BuscarF.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(producto -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if (producto.getIdentificador().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (producto.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else if (producto.getCantidad().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    }

                    return false;
                });
            });

            SortedList<Producto> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tblProductos.comparatorProperty());

            tblProductos.setItems(sortedData);
        } catch (Exception e) {
            mostrarAlerta("Error en la búsqueda", "Hubo un error al configurar la funcionalidad de búsqueda.", e);
        }
    }
    @FXML
    void clickEliminar(ActionEvent event) {
        // Obtener el producto seleccionado
        Producto productoSelecc = tblProductos.getSelectionModel().getSelectedItem();

        if (productoSelecc == null) {
            // Mostrar alerta si no se ha seleccionado ningún producto
            Alert alertaNoSeleccionado = new Alert(Alert.AlertType.ERROR);
            alertaNoSeleccionado.setTitle("Error");
            alertaNoSeleccionado.setContentText("Debes seleccionar un producto");
            alertaNoSeleccionado.showAndWait();
        } else {
            // Eliminar el producto de la lista
            productoData.remove(productoSelecc);

            // Limpiar selección en la tabla
            tblProductos.getSelectionModel().clearSelection();

            // Mostrar alerta de éxito
            Alert alertaProductoEliminado = new Alert(Alert.AlertType.INFORMATION);
            alertaProductoEliminado.setTitle("Producto eliminado");
            alertaProductoEliminado.setContentText("El producto seleccionado se ha eliminado con éxito");
            alertaProductoEliminado.showAndWait();
        }

        persistenciaEscribir();
    }

    public void persistenciaLeer(){
        File comprobracionExist = new File("src/main/resources/persistencia/productos.cja");

        if(comprobracionExist.exists()){
            //Persistencia - Leer el archivo de datos
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/persistencia/productos.cja"));
                ArrayList<Producto> productosGuardar = (ArrayList<Producto>) ois.readObject();
                productoData.addAll(productosGuardar);

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public void persistenciaEscribir(){
        //Persistencia - Guardar los datos en un archivo
        ArrayList<Producto> productosGuardar = new ArrayList<Producto>(productoData);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/persistencia/productos.cja"));
            oos.writeObject(productosGuardar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
