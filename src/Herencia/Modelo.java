package Herencia;

/**
 *
 * @author Kevin
 */
public class Modelo {

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

}
