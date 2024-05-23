package modelo;

public class ProductoFactory {
    public static Producto crearProducto(String tipoCantidad) {
        if (tipoCantidad.equals("Agranel")) {
            return new PAgranel();
        } else if (tipoCantidad.equals("Por Unidad")) {
            return new PUnidad();
        }
        return null; // O lanzar una excepción dependiendo del caso
    }
}
