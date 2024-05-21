package Modelo;

public class Cliente {

    private String nombre;
    private long telefono;
    private int ID;
    private Direccion direccion;



    public Cliente(String nombre, long telefono, int ID, Direccion direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ID = ID;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}


