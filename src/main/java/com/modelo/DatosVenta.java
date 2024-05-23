package com.modelo;

import java.io.Serializable;

public class DatosVenta implements Serializable, Producto {

    private String nombreVista;
    private String cantidad;
    private double subtotal;
    private String cantidadNetalocal;
    private double precioUnitario;

    public DatosVenta(String nombreProducto, String cantidad, double subtotal, double precioVenta, int cantidadExistencia) {
        this.setNombre(nombreProducto);
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.setPrecioVenta(precioVenta);
        this.setCantidadNeta(cantidadExistencia);
        nombreVista = nombreProducto;
        this.precioUnitario = precioVenta;
        this.cantidadNetalocal = String.valueOf(cantidadExistencia);
    }


    public String getCantidad() {
        return cantidad;
    }

    @Override
    public void setCategoria(String categoria) {
        this.setCategoria(categoria);
    }

    @Override
    public String getCategoria() {
        return "";
    }

    @Override
    public String getCantidadNeta() {
        return "";
    }

    @Override
    public void setCantidadNeta() {

    }

    @Override
    public void setCantidadNeta(double cantidadNeta) {
        setCantidadNeta();
    }

    @Override
    public void actualizarInventario() {

    }

    @Override
    public void setIdentificador(String identificador) {

    }

    @Override
    public String getIdentificador() {
        return "";
    }

    @Override
    public void setNombre(String nombre) {

    }

    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public void setPrecioVenta(double precioventa) {

    }

    @Override
    public double getPrecioVenta() {
        return 0;
    }

    @Override
    public void setPrecioProveedor(double precioProveedor) {

    }

    @Override
    public double getPrecioproveedor() {
        return 0;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getNombreVista() {
        return nombreVista;
    }

    public void setNombreVista(String nombreVista) {
        this.nombreVista = nombreVista;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCantidadNetalocal() {
        return cantidadNetalocal;
    }

    public void setCantidadNetalocal(String cantidadNetalocal) {
        this.cantidadNetalocal = cantidadNetalocal;
    }


}
