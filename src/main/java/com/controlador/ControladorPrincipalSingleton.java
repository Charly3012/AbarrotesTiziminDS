package com.controlador;

public class ControladorPrincipalSingleton {

    //En esta parte van a poner la instancia de cada controlador, tiene que ser protected, el unico privado es la instancia principal
    private ControladorPrincipalSingleton controladorPrincipal;
    private CategoriasControlador categoriasControlador;



    private ControladorPrincipalSingleton(){
        //Aquí dentro ponen la instancia de cada controlador
        //Ejemplo this.controladorInventarios = new ControladorInventarios()
        //Obviamente tienen que primero hacer el constructor de su clase controladora respectiva
        this.categoriasControlador = new CategoriasControlador();

    }

    //Esta madre no me la toquen
    private static final ControladorPrincipalSingleton instancia = new ControladorPrincipalSingleton();


    //esta madre tampoco me la toquen
    public static ControladorPrincipalSingleton getInstanciaCP(){
        return instancia;
    }

    //Van a hacer sus geters como normalemente pero con sus controladores respectivos

    public CategoriasControlador getCategoriasControlador() {
        return categoriasControlador;
    }
}
