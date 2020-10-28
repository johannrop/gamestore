
package Modelo;

public class Juego {
    int id;
    String nombre,anho,protagonista,director,productor,
            tecnologia,cantidad,preciVenta,precioAlquiler;

    public Juego() {
    }

    public Juego(String nombre, String anho, String protagonista, String director, String productor, String tecnologia, String cantidad, String preciVenta, String precioAlquiler) {
        this.nombre = nombre;
        this.anho = anho;
        this.protagonista = protagonista;
        this.director = director;
        this.productor = productor;
        this.tecnologia = tecnologia;
        this.cantidad = cantidad;
        this.preciVenta = preciVenta;
        this.precioAlquiler = precioAlquiler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPreciVenta() {
        return preciVenta;
    }

    public void setPreciVenta(String preciVenta) {
        this.preciVenta = preciVenta;
    }

    public String getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(String precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

   
    
}
