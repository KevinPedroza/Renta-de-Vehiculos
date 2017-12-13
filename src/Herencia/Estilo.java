/*
this class will have the getters and setters. for us to use them later to save the information 
 */
package Herencia;

/**
 *
 * @author Kevin
 */
public class Estilo {

    int Codigo_estilo;
    String Estilo_vehiculo;

    public Estilo(int Codigo_estilo, String Estilo_vehiculo) {
        this.Codigo_estilo = Codigo_estilo;
        this.Estilo_vehiculo = Estilo_vehiculo;
    }

    public void setCodigo_estilo(int Codigo_estilo) {
        this.Codigo_estilo = Codigo_estilo;
    }

    public void setEstilo_vehiculo(String Estilo_vehiculo) {
        this.Estilo_vehiculo = Estilo_vehiculo;
    }

    public int getCodigo_estilo() {
        return Codigo_estilo;
    }

    public String getEstilo_vehiculo() {
        return Estilo_vehiculo;
    }

    @Override
    public String toString() {
        return this.Estilo_vehiculo;

    }
}
