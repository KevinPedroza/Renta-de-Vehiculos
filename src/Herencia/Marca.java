/*
this class will have the getters and setters. for us to use them later to save the information 
 */
package Herencia;

/**
 *
 * @author Kevin
 */
public class Marca {

    int Codigo_marca;
    String Marca_vehiculo;

    public Marca(int Codigo_marca, String Marca_vehiculo) {
        this.Codigo_marca = Codigo_marca;
        this.Marca_vehiculo = Marca_vehiculo;
    }

    public void setCodigo_marca(int Codigo_marca) {
        this.Codigo_marca = Codigo_marca;
    }

    public void setMarca_vehiculo(String Marca_vehiculo) {
        this.Marca_vehiculo = Marca_vehiculo;
    }

    public int getCodigo_marca() {
        return Codigo_marca;
    }

    public String getMarca_vehiculo() {
        return Marca_vehiculo;
    }

    @Override
    public String toString() {
        return this.Marca_vehiculo;

    }

}
