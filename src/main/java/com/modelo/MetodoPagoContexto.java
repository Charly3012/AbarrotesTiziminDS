package com.modelo;

public class MetodoPagoContexto {
    private MetodoPagoStrategy strategy;

    public void setMetodoPagoStrategy(MetodoPagoStrategy strategy){
        this.strategy = strategy;
    }

    public void ejecutarPago(double cantidad){
        if(strategy != null){
            strategy.pagar(cantidad);
        }
        else{
            throw new IllegalStateException("El pago no ha sido configurado");
        }
    }
}
