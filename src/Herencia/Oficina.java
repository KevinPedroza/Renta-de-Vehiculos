/*
this class will have the getters and setters. for us to use them later to save the information 
 */
package Herencia;

/**
 *
 * @author Kevin
 */
public class Oficina {

    int id_oficina;
    String Nombre_oficina;

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public String getNombre_oficina() {
        return Nombre_oficina;
    }

    public void setNombre_oficina(String Nombre_oficina) {
        this.Nombre_oficina = Nombre_oficina;
    }

    public Oficina(int id_oficina, String Nombre_oficina) {
        this.id_oficina = id_oficina;
        this.Nombre_oficina = Nombre_oficina;
    }

    @Override
    public String toString() {
        return this.Nombre_oficina;

    }

}
