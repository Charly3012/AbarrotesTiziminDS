package com.controlador;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.modelo.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;


public class ControladorRegistroVentas implements Initializable {
    @FXML
    public Button btnAñadir;

    @FXML
    public Label labTotalMostrar;

    @FXML
    public TextField txtCliente;

    @FXML
    public Button btnSeleccionarCliente;

    @FXML
    public Label labClienteSeleccionado;

    @FXML
    public Label labHoraMostrar;

    @FXML
    public ComboBox cmbPago;

    @FXML
    public ObservableList<String> obsPago;

    @FXML
    private AnchorPane anchorDetalleVenta;

    @FXML
    private Button btnBuscar;

    @FXML
    private MenuButton btnMenu;

    @FXML
    private Button btnPagar;

    @FXML
    private TableColumn<DatosVenta, String> colCantidadDv;

    @FXML
    private TableColumn<?, ?> colCategoriaDisp;

    @FXML
    private TableColumn<?, ?> colInventarioDisp;

    @FXML
    private TableColumn<?, ?> colPrecioUnitarioDisp;

    @FXML
    private TableColumn<DatosVenta, Integer> colProductoDv;

    @FXML
    private TableColumn<?, ?> colProuctoDisp;

    @FXML
    private TableColumn<DatosVenta, Integer> colTotalDv;

    @FXML
    private TableView<DatosVenta> tblDetalleVenta;

    @FXML
    private TableView<Producto> tblProductosDisponibles;

    @FXML
    private TextField txtBuscarProducto;

    @FXML
    private TextField txtTotal;
    @FXML
    protected ObservableList<DatosVenta> obsProducDetalle;

    @FXML //Lista que se muestra de productos
    private ObservableList<Producto> obsProductos;

    @FXML //Lista que se muestra cuando se esta buscando entre los productos
    private ObservableList<Producto> obsBusqueda;

    private Cliente clienteCompra;

    private String fecha;

    private ArrayList<Venta> ventas = new ArrayList<>();


    public void initialize(URL url, ResourceBundle rb) {

        assert colPrecioUnitarioDisp != null : "fx:id=\"colPrecioUnitarioDisp \" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert colInventarioDisp != null : "fx:id=\"colInventarioDisp\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert colCategoriaDisp != null : "fx:id=\"colCategoriaDisp\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert colProuctoDisp!= null : "fx:id=\"colProuctoDisp\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert tblProductosDisponibles != null : "fx:id=\"tblProductosDisponibles\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert txtBuscarProducto != null : "fx:id=\"tblProductosDisponibles\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert btnBuscar != null : "fx:id=\"tblProductosDisponibles\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        assert tblDetalleVenta != null : "fx:id=\"tblDetalleVenta\" was not injected: check your FXML file 'VistaRegistroComprasVentas.fxml'.";
        iniciarDatosObservables();
        persistenciaLeer();
    }

    public void cerrarVentana() {

        // Obtener la instancia del stage principal desde la ventana oculta
        if (this.txtCliente != null && this.txtCliente.getScene() != null) {
            Stage myStage = (Stage) this.txtCliente.getScene().getWindow();
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


    public void persistenciaLeer(){
        File comprobracionExist = new File("src/main/resources/persistencia/productos.cja");
        if(comprobracionExist.exists()){
            //Persistencia - Leer el archivo de datos
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/persistencia/productos.cja"));
                ArrayList<Producto> productosGuardar = (ArrayList<Producto>) ois.readObject();
                obsProductos.addAll(productosGuardar);
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void iniciarDatosObservables(){
        //Iniciar la visualización de objetos en la tabla
        obsProductos = FXCollections.observableArrayList();
        obsBusqueda = FXCollections.observableArrayList();
        this.tblProductosDisponibles.setItems(obsProductos);
        //Para setear los elementos de nuestro array original al que se muestra en pantalla


        //Mapeo de las columnas de la tabla con los atributos de los objetos persona

        this.colProuctoDisp.setCellValueFactory((new PropertyValueFactory<>("nombre")));
        this.colCategoriaDisp.setCellValueFactory((new PropertyValueFactory<>("categoria")));
        this.colInventarioDisp.setCellValueFactory((new PropertyValueFactory<>("cantidadNeta")));
        this.colPrecioUnitarioDisp.setCellValueFactory((new PropertyValueFactory<>("precioVenta")));

        //Iniciar datos de detalle venta
        obsProducDetalle = FXCollections.observableArrayList();


        this.colProductoDv.setCellValueFactory((new PropertyValueFactory<>("nombreVista")));
        this.colCantidadDv.setCellValueFactory(new PropertyValueFactory<DatosVenta, String>("cantidad"));
        this.colTotalDv.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        //Para poder editar la tabla de detalle venta
        this.tblDetalleVenta.setEditable(true);
        this.colCantidadDv.setCellFactory(TextFieldTableCell.forTableColumn());

        this.tblDetalleVenta.setItems(obsProducDetalle);

        //Método de pago
        obsPago = FXCollections.observableArrayList("Paypal", "Efectivo");
        this.cmbPago.setItems(obsPago);
        this.cmbPago.setValue("Efectivo");

    }

    @FXML
    public void escribirBuscar(KeyEvent keyEvent) {

        String busqueda = this.txtBuscarProducto.getText();

        if(busqueda.isEmpty()){
            this.tblProductosDisponibles.setItems(obsProductos);
        }
        else{
            this.obsBusqueda.clear();
            for (Producto productoVista : this.obsProductos){
                if(productoVista.getNombre().toLowerCase().contains(busqueda.toLowerCase())){
                    this.obsBusqueda.add(productoVista);
                }
            }
            this.tblProductosDisponibles.setItems(obsBusqueda);
        }
    }

    @FXML
    private void seleccionar(MouseEvent event){
        Producto p = this.tblProductosDisponibles.getSelectionModel().getSelectedItem();

        if(p !=null){

        }
    }

    @FXML
    public void carrito(ActionEvent actionEvent) {

        Producto p = this.tblProductosDisponibles.getSelectionModel().getSelectedItem();

        String nombreProducto = p.getNombre();
        int cantidadExistencia = Integer.parseInt(p.getCantidadNeta());
        String cantidad = "1";
        double subtotal = p.getPrecioVenta() * (Integer.parseInt(cantidad));

        DatosVenta pVenta = new DatosVenta(nombreProducto, cantidad, subtotal, p.getPrecioVenta(), cantidadExistencia);

        if (p != null) {
            // Añadir el producto seleccionado a tblDetalleVenta
            this.tblDetalleVenta.getItems().add(pVenta);
            // Opcional: Limpiar la selección en tblProductosDisponibles
            this.tblProductosDisponibles.getSelectionModel().clearSelection();
        }


        actualizarTotal();


    }



    @FXML
    public void clickEditarCantidad(TableColumn.CellEditEvent<?,?> cellEditEvent) {

        try {
            DatosVenta pVenta = this.tblDetalleVenta.getSelectionModel().getSelectedItem();
            pVenta.setCantidad((String) cellEditEvent.getNewValue());
            double aux = Double.parseDouble(((String) cellEditEvent.getNewValue()));
            pVenta.setSubtotal(pVenta.getPrecioUnitario() * aux);


            if (aux > Double.parseDouble(pVenta.getCantidadNetalocal())){
                Alerta alerta = new Alerta("Error", "Sin suficiente estock");
                alerta.mostrarAlertaError();
                pVenta.setCantidad("1");
                pVenta.setSubtotal(pVenta.getPrecioUnitario() * aux);
                tblDetalleVenta.refresh();
            }



            tblDetalleVenta.refresh();
        } catch (NumberFormatException e) {
            Alerta alerta = new Alerta("Error", "El valor tiene que ser de tipo entero");
            alerta.mostrarAlertaError();
            DatosVenta pVenta = this.tblDetalleVenta.getSelectionModel().getSelectedItem();

            pVenta.setCantidad("1");
            double aux = Double.parseDouble("1");
            pVenta.setSubtotal(pVenta.getPrecioUnitario() * aux);
            tblDetalleVenta.refresh();
        }

        actualizarTotal();
    }

    public double suma = 0;

   public double getSuma() {
        return suma;


   }




    public void actualizarTotal(){
        ArrayList<DatosVenta> auxDetalleVenta = new ArrayList<>();
        auxDetalleVenta.addAll(obsProducDetalle);
        if(auxDetalleVenta.isEmpty()){
            this.labTotalMostrar.setText("----");
        }else{

            double suma = 0;
            for (int i = 0; i < obsProducDetalle.size(); i++){
                suma = suma + obsProducDetalle.get(i).getSubtotal();
            }

            this.labTotalMostrar.setText(suma + "");
        }

    }





    @FXML
    public void clickSeleccionarCliente(ActionEvent actionEvent) {

        //Persistencia - Leer el archivo de datos
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/persistencia/clientes.cja"));
            ArrayList<Cliente> clientesGuardar = (ArrayList<Cliente>) ois.readObject();

            for(int j = 0; j < clientesGuardar.size(); j++){
                if (clientesGuardar.get(j).getTelefono() == Long.parseLong(this.txtCliente.getText())){
                    clienteCompra = clientesGuardar.get(j);
                    break;
                }
            }
            if(clienteCompra == null){
                Alerta clienteNoExiste = new Alerta("Error", "El cliente no existe");
                clienteNoExiste.mostrarAlertaError();
            }else{
                this.labClienteSeleccionado.setText(clienteCompra.getNombre());
            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (NumberFormatException f){
            Alerta formatoIncorrecto = new Alerta("Error", "Ingrese un número de celular valido");
            formatoIncorrecto.mostrarAlertaError();

        }

        this.txtCliente.setText("");


    }



    @FXML
    void clickPagar(ActionEvent event) throws IOException {

       //aquí es donde se usa el patron de diseño Strategy

        try{
            if(clienteCompra != null){
                if(cmbPago.getSelectionModel().getSelectedItem().equals("Efectivo")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLPagoEfectivo.fxml"));
                    Parent root = loader.load();
                    ControladorPagarEfectivo controlador = loader.getController();
                    controlador.setProduc(obsProducDetalle);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.showAndWait();


                }else{

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FXMLPagoPaypal.fxml"));
                    Parent root = loader.load();
                    ControladorPagarPaypal controlador = loader.getController();
                    controlador.setProduc(obsProducDetalle);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.showAndWait();

                }


                //Genera el objeto venta
                ArrayList<DatosVenta> aux = new ArrayList<>(obsProducDetalle);

                double precioCompraTotal = Double.parseDouble(labTotalMostrar.getText());
                Venta nuevaVenta = new Venta(clienteCompra.getTelefono(), precioCompraTotal, fecha, aux);
                ventas.add(nuevaVenta);


                //Generar archivo pdf
                try {
                    ArrayList<Producto> productos = new ArrayList<>(obsProducDetalle);
                    Cliente clientenota = ControladorPrincipalSingleton.getInstancia().getClientesControlador().buscarCliente(clienteCompra.getTelefono());

                    LocalDateTime fechaHoraActual = LocalDateTime.now();

                    // Define el formato de la fecha y hora
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                    // Formatea la fecha y hora actual y guárdalas en un String
                    String fechaHoraActualString = fechaHoraActual.format(formato);

                    PDDocument documento = new PDDocument();
                    PDPage pagina = new PDPage(PDRectangle.A6);
                    documento.addPage(pagina);
                    PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                    contenido.beginText();
                    contenido.setFont(PDType1Font.TIMES_BOLD, 12); //Caracteristicas de la letra

                    contenido.newLineAtOffset(80, 400);
                    contenido.showText("=ABARROTES TIZIMÍN=");
                    contenido.newLineAtOffset(0, -20);
                    contenido.showText("    Fecha: " + String.format(String.valueOf(fechaHoraActualString)));
                    contenido.newLineAtOffset(-60, -20);
                    contenido.showText("Nombre del cliente: " + clientenota.getNombre());
                    contenido.newLineAtOffset(0, -13);
                    contenido.showText("ID del cliente: " + clientenota.getId());
                    contenido.newLineAtOffset(0, -20);
                    contenido.showText(".:| Artículos |:.");

                    for (int i = 0; i < aux.size(); i++) {
                        contenido.newLineAtOffset(0, -20);
                        contenido.showText("Producto: " + aux.get(i).getNombreVista());
                        contenido.newLineAtOffset(0, -13);
                        contenido.showText("Cantidad: " + aux.get(i).getCantidad());
                        contenido.newLineAtOffset(0, -13);
                        contenido.showText("Precio: $" + aux.get(i).getPrecioUnitario());
                    }

                    contenido.newLineAtOffset(0, -25);
                    contenido.showText("Subtotal: $" + precioCompraTotal);

                    contenido.newLineAtOffset(0, -13);
                    contenido.showText("Total: $" + (precioCompraTotal));
                    contenido.endText();

                    contenido.close();
                    documento.save("src/main/resources/Ticket/ticket.pdf");
                    //File path = new File("src/resources/Ticket/ticket.pdf");
                    //Desktop.getDesktop().open(path);



                //Para disminuir el inventario
                ArrayList<Producto> nuevoInventario = new ArrayList<>(obsProductos);
                ArrayList<Producto> inventarioGuardar = new ArrayList<>();
                for(int i = 0; i < aux.size(); i++ ){
                    for(int j = 0; j < nuevoInventario.size(); j ++){
                        if (nuevoInventario.get(j).getNombre().equals(aux.get(i).getNombre())){
                            double inventario;
                            inventario = Double.parseDouble(nuevoInventario.get(j).getCantidadNeta()) - (Double.parseDouble(aux.get(i).getCantidad()));
                            Producto productoAct = nuevoInventario.get(j);
                            productoAct.setCantidadNeta(inventario);
                            productoAct.actualizarInventario();
                            System.out.println(productoAct.getCantidadNeta());
                            //System.out.println("ola");
                        }

                    }
                }

                obsProductos.removeAll(obsProductos);
                obsProductos.addAll(nuevoInventario);

                tblDetalleVenta.refresh();

                obsProducDetalle.removeAll(obsProducDetalle);
                tblDetalleVenta.refresh();




                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Error: " + e.getMessage());
                    alert.showAndWait();
                }

            }

            else{
                Alerta alerta = new Alerta("Error", "Debe ingresar un cliente valido");
                alerta.mostrarAlertaError();
            }


        }catch (IOException e) {
            Alerta alerta = new Alerta("Error", e.getMessage()+e.getCause());
            alerta.mostrarAlertaError();
        }



    }



}

