package com.modelo;

import java.io.Serializable;

public interface Producto extends Serializable {

    void setIdentificador(String identificador);
    String getIdentificador();
    void setNombre(String nombre);
    String getNombre();
    void setPrecioVenta(double precioventa);
    double getPrecioVenta();
    void setPrecioProveedor(double precioProveedor);
    double getPrecioproveedor();
    void setCantidad(String cantidad);
    String getCantidad();
    void setCategoria(String categoria);
    String getCategoria();
    String getCantidadNeta();
    void setCantidadNeta();
    void setCantidadNeta(double cantidadNeta);
    public void actualizarInventario();
}
