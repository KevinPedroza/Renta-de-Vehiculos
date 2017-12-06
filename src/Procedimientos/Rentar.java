package Procedimientos;

/**
 *
 * @author Carol
 */
public class Rentar {

    private String placa, cedula, nombre_usuario;
    private double precio_total;

    public Rentar() {
    }

    public Rentar(String placa, String cedula, String nombre_usuario, double precio_total) {
        this.placa = placa;
        this.cedula = cedula;
        this.nombre_usuario = nombre_usuario;
        this.precio_total = precio_total;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }
    
}
