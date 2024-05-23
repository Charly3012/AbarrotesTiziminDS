package com.modelo;

public class PUnidad implements Producto{
    private String identificador;
    private double precioventa;
    private String nombre;
    private String categoria;
    private double precioProveedor;
    private int cantidadUnidad;

    private String cantidadNeta;


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
        this.cantidadUnidad = Integer.parseInt(cantidad);
    }

    @Override
    public String getCantidad() {
        return String.valueOf(cantidadUnidad);
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    public void setCantidadNeta(){
        this.cantidadNeta = String.valueOf(cantidadUnidad);
    }

    public String getCantidadNeta(){
        return cantidadNeta;
    }

    public void setCantidadNeta(double cantidadNeta) {
        this.cantidadNeta = String.valueOf(cantidadNeta);
    }

    public void actualizarInventario(){
        this.cantidadUnidad = Integer.parseInt(cantidadNeta);
    }
}
