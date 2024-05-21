package modelo;

public class Cliente {

    private String nombre;
    private long telefono;
    private int id;
    private String genero;
    private String direccionCadena;
    private Direccion direccion;

    public Cliente(String nombre, long telefono, int ID, String genero, Direccion direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = ID;
        this.genero = genero;
        this.direccionCadena = direccion.toString();
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccionCadena() {
        return direccionCadena;
    }

    public void setDireccionCadena(String direccionCadena) {
        this.direccionCadena = direccionCadena;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}


