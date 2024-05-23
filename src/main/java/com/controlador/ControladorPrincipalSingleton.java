package com.controlador;

import javafx.stage.Stage;

public class ControladorPrincipalSingleton {

    private CategoriasControlador categoriasControlador;
    private RegistroInvcontroller registroInvcontroller;

    private Stage menuStage;

    private ControladorPrincipalSingleton() {
        this.categoriasControlador = new CategoriasControlador();
        this.registroInvcontroller = new RegistroInvcontroller();
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


    public void setMenuStage(Stage stage) {
        this.menuStage = stage;
    }

    public Stage getMenuStage() {
        return menuStage;
    }

}



