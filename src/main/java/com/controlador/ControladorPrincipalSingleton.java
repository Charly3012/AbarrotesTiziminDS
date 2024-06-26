package com.controlador;

import javafx.stage.Stage;

public class ControladorPrincipalSingleton {

    private CategoriasControlador categoriasControlador;
    private RegistroInvcontroller registroInvcontroller;
    private ClientesControlador clientesControlador;
    private ControladorRegistroVentas controladorRegistroVentas;
    private ControladorPagarEfectivo controladorPagarEfectivo;

    private Stage menuStage;
  
   private ControladorPrincipalSingleton() {
        this.categoriasControlador = new CategoriasControlador();
        this.clientesControlador = new ClientesControlador();
        this.registroInvcontroller = new RegistroInvcontroller();
        this.controladorRegistroVentas = new ControladorRegistroVentas();
        this.controladorPagarEfectivo = new ControladorPagarEfectivo();
    }

    private static final ControladorPrincipalSingleton instancia = new ControladorPrincipalSingleton();

    public static ControladorPrincipalSingleton getInstancia() {
        return instancia;
    }

    public CategoriasControlador getCategoriasControlador() {
        return categoriasControlador;
    }


    public RegistroInvcontroller getRegistroInvcontroller(){
        return registroInvcontroller;
    }

    public ClientesControlador getClientesControlador(){
      return clientesControlador;
    }

    public ControladorRegistroVentas getControladorRegistroVentas(){
        return controladorRegistroVentas;
    }

    public ControladorPagarEfectivo getControladorPagar(){
        return controladorPagarEfectivo;
    }

    public void setMenuStage(Stage stage) {
        this.menuStage = stage;
    }

    public Stage getMenuStage() {
        return menuStage;
    }





}


