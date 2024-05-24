package com.modelo;

public class PagoStrategyPaypal implements MetodoPagoStrategy {
    private String correo;
    private String contraseña;

    public PagoStrategyPaypal(String correo, String contraseña){
        this.contraseña = contraseña;
        this.correo = correo;

    }

    @Override
    public void pagar(double cantidad){
        //Cuando se hace el pago en paypal
    }
}
