package Herencia;

/**
 *
 * @author Kevin
 */
public class Modelo {

    public void setCodigo_modelo(int Codigo_modelo) {
        this.Codigo_modelo = Codigo_modelo;
    }

    public void setModelo_vehiculo(String Modelo_vehiculo) {
        this.Modelo_vehiculo = Modelo_vehiculo;
    }

    int Codigo_modelo;
    String Modelo_vehiculo;

    public Modelo(int Codigo_marca, String Marca_vehiculo) {
        this.Codigo_modelo = Codigo_marca;
        this.Modelo_vehiculo = Marca_vehiculo;
    }

    public int getCodigo_modelo() {
        return Codigo_modelo;
    }

    public String getModelo_vehiculo() {
        return Modelo_vehiculo;
    }

    @Override
    public String toString() {
        return this.Modelo_vehiculo;

    }

}
