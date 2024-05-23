package com.controlador;

import javafx.stage.Stage;

public class ControladorPrincipalSingleton {

    private CategoriasControlador categoriasControlador;
    private ClientesControlador clientesControlador;
    private Stage menuStage;

    private ControladorPrincipalSingleton() {
        this.categoriasControlador = new CategoriasControlador();
        this.clientesControlador = new ClientesControlador();
    }

    private static final ControladorPrincipalSingleton instancia = new ControladorPrincipalSingleton();

    public static ControladorPrincipalSingleton getInstancia() {
        return instancia;
    }

    public CategoriasControlador getCategoriasControlador() {
        return categoriasControlador;
    }

    public ClientesControlador getClientesControlador(){
        return clientesControlador;
    }

    public void setMenuStage(Stage stage) {
        this.menuStage = stage;
    }

    public Stage getMenuStage() {
        return menuStage;
    }
}




