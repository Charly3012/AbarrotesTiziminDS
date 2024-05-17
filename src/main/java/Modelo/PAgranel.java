package Modelo;

public class PAgranel implements Producto{
    private String identificador;
    private double precioVenta;
    private String nombre;
    private double precioProveedor;
    private double cantidadAgranel;


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
        this.precioVenta = precioVenta;
    }

    @Override
    public double getPrecioVenta() {
        return precioVenta;
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
}
