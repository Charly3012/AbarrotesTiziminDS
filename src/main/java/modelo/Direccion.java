package modelo;

public class Direccion {

    private String calle;
    private int numero;
    private String colonia;
    private int cp;
    private String ciudad;
    private String estado;


   public Direccion(String calle, int numero, String colonia, int cp, String ciudad, String estado){
       this.calle = calle;
       this.numero = numero;
       this.colonia = colonia;
       this.cp = cp;
       this.ciudad = ciudad;
       this.estado = estado;
   }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCP() {
        return cp;
    }

    public void setCP(int CP) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "C. " + calle +", NO." + numero + ", " + colonia +", " + cp + ", " + ciudad + ", " + estado;
    }
}
