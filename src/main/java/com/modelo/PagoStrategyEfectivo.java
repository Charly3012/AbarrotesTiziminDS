package com.modelo;

public class PagoStrategyEfectivo implements MetodoPagoStrategy {
    private Double recibido;

    public PagoStrategyEfectivo(Double recibido){
        this.recibido = recibido;
    }

    @Override
    public void pagar(double cantidad){
        //Logica de pago con efectivo para guardar datos o algo mas especifico
    }
}
