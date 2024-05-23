package com.modelo;

public class PAgranel implements Producto{
    private String identificador;
    private double precioventa;
    private String nombre;
    private String categoria;
    private double precioProveedor;
    private double cantidadAgranel;
    private String cantidadNeta = String.valueOf(cantidadAgranel);

    @Override
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setPrecioVenta(double precioventa) {
        this.precioventa = precioventa;
    }

    @Override
    public double getPrecioVenta() {
        return precioventa;
    }

    @Override
    public void setPrecioProveedor(double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    @Override
    public double getPrecioproveedor() {
        return precioProveedor;
    }

    @Override
    public void setCantidad(String cantidad) {
        this.cantidadAgranel = Double.parseDouble(cantidad);
    }

    @Override
    public String getCantidad() {
        return String.valueOf(cantidadAgranel);
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCantidadNeta(){
        this.cantidadNeta = String.valueOf(cantidadAgranel);
    }

    public String getCantidadNeta(){
        return cantidadNeta;
    }

    public void setCantidadNeta(double cantidadNeta){
        this.cantidadNeta = String.valueOf(cantidadNeta);
    }

    public void actualizarInventario(){
        this.cantidadAgranel = Double.parseDouble(cantidadNeta);
    }
}
