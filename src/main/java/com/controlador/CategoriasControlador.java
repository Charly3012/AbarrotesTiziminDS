package com.controlador;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import com.modelo.Alerta;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.modelo.Categoria;



public class CategoriasControlador implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private TableColumn<?, ?> colDescripcion;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableView<Categoria> tabCategorias;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private ObservableList<Categoria> obsCategorias;

    @FXML
    private ObservableList<Categoria> obsBusqueda;

    private Categoria categoriaSelec;

    @FXML
    void clickEliminar(ActionEvent event) {


        //Para seleccionar un objeto
        categoriaSelec = this.tabCategorias.getSelectionModel().getSelectedItem();

        if(categoriaSelec == null){
            Alerta alertaNoSeleccionado = new Alerta("Error", "Debes seleccionar una categoria");
            alertaNoSeleccionado.mostrarAlertaError();
        }else{
            if(true){
                this.obsCategorias.remove(categoriaSelec);
                this.obsBusqueda.remove(categoriaSelec);
                this.tabCategorias.refresh();

                Alerta alertaCategoriaEliminado = new Alerta("Categoria eliminado", "La categoria seleccionada se ha eliminado con exito");
                alertaCategoriaEliminado.mostrarAlertaInformation();

                this.tabCategorias.getSelectionModel().clearSelection();
            }
            else {
                Alerta categoriaEnUso = new Alerta("Error al eliminar", "No es posible eliminar la categoria ya que existen productos en esta categoría");
                categoriaEnUso.mostrarAlertaError();
            }

        }

        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtDescripcion.setText("");

        persistenciaEscribir();

    }

    /*
    public boolean comprobacionEliminar(){

        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/persistencia/gestionInventarios.cja"));
            ArrayList<Producto> productosComprobacion = (ArrayList<Producto>) ois.readObject();

            for (int i = 0; i < productosComprobacion.size(); i++) {
                if(productosComprobacion.get(i).getNombre().equals(categoriaSeleccionado.getNombreCategoria())){
                    return false;
                }

            }
            return true;

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }
     */

    @FXML
    void clickGuardar(ActionEvent event) {
        try{
            int id = Integer.parseInt(this.txtId.getText());
            String nombre = this.txtNombre.getText();
            String descripcion = this.txtDescripcion.getText();

            Categoria categoriaNueva = new Categoria(id, nombre, descripcion);
            categoriaSelec = this.tabCategorias.getSelectionModel().getSelectedItem();


            if(!(obsCategorias.contains(categoriaNueva))){


                //Editar
                if (obsCategorias.contains(categoriaSelec)){
                    categoriaSelec.setId(id);
                    categoriaSelec.setNombre(nombre);
                    categoriaSelec.setDescripcion(descripcion);
                    this.tabCategorias.refresh();

                    Alerta categoriaModificada = new Alerta("Categoría modificada", "La categoría ha sido modificada con éxito");
                    categoriaModificada.mostrarAlertaInformation();

                    this.txtId.setText("");
                    this.txtNombre.setText("");
                    this.txtDescripcion.setText("");

                }



                //Nuevo
                else{
                    this.obsCategorias.add(categoriaNueva);

                    Alerta agregadoCorrecto = new Alerta("Agregado correctamente", "La categoría " + this.txtNombre.getText() +" fue agregado correctamente");
                    agregadoCorrecto.mostrarAlertaInformation();

                    this.txtId.setText("");
                    this.txtNombre.setText("");
                    this.txtDescripcion.setText("");

                    //Para evitar conflictos cuando se está buscando
                    if (categoriaNueva.getNombre().toLowerCase().contains(this.txtBuscar.getText().toLowerCase())){
                        this.obsBusqueda.add(categoriaNueva);

                    }
                    this.tabCategorias.refresh();

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
            this.tabCategorias.getSelectionModel().clearSelection();
        }

        persistenciaEscribir();
    }

    @FXML
    void clickLimpiar(ActionEvent event) {
        this.txtId.setText("");
        this.txtDescripcion.setText("");
        this.txtNombre.setText("");
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert btnGuardar != null : "fx:id=\"btnGuardar\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert colDescripcion != null : "fx:id=\"colDescripcion\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert tabCategorias != null : "fx:id=\"tabCategorias\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert txtBuscar != null : "fx:id=\"txtBuscar\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert txtDescripcion != null : "fx:id=\"txtDescripcion\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'FXMLCategorias.fxml'.";
        iniciarDatos();
        persistenciaLeer();
    }

    public void iniciarDatos(){
        obsCategorias = FXCollections.observableArrayList();
        tabCategorias.setItems(obsCategorias);

        obsBusqueda = FXCollections.observableArrayList();

        this.colId.setCellValueFactory((new PropertyValueFactory<>("id")));
        this.colDescripcion.setCellValueFactory((new PropertyValueFactory<>("descripcion")));
        this.colNombre.setCellValueFactory((new PropertyValueFactory<>("nombre")));
    }

    public void persistenciaEscribir(){
        //Persistencia - Guardar los datos en un archivo
        ArrayList<Categoria> categoriasGuardar= new ArrayList<>(obsCategorias);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/persistencia/categorias.cja"));
            oos.writeObject(categoriasGuardar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void persistenciaLeer(){
        File comprobracionExist = new File("src/main/resources/persistencia/categorias.cja");

        if(comprobracionExist.exists()){
            //Persistencia - Leer el archivo de datos
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/persistencia/categorias.cja"));
                ArrayList<Categoria> categoriasGuardar = (ArrayList<Categoria>) ois.readObject();
                obsCategorias.addAll(categoriasGuardar);

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println(" ");
        }

    }

    public void cerrarVentana() {

        // Obtener la instancia del stage principal desde la ventana oculta
        if (this.txtId != null && this.txtId.getScene() != null) {
            Stage myStage = (Stage) this.txtId.getScene().getWindow();
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
    public void clickSeleccionar(MouseEvent mouseEvent) {
        categoriaSelec = this.tabCategorias.getSelectionModel().getSelectedItem();
        if(categoriaSelec != null){
            this.txtId.setText(categoriaSelec.getId() +" ");
            this.txtNombre.setText(categoriaSelec.getNombre());
            this.txtDescripcion.setText(categoriaSelec.getDescripcion());
        }
    }

    public void escribirBuscar(KeyEvent keyEvent) {

        String busqueda = this.txtBuscar.getText();

        if(busqueda.isEmpty()){
            this.tabCategorias.setItems(obsCategorias);
        }
        else{
            this.obsBusqueda.clear();
            for (Categoria categoria : this.obsCategorias){
                if(categoria.getNombre().toLowerCase().contains(busqueda.toLowerCase())){
                    this.obsBusqueda.add(categoria);
                }
            }
            this.tabCategorias.setItems(obsBusqueda);
        }

    }
}
