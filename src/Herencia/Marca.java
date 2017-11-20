/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author Kevin
 */
public class Marca {
    
    int Codigo_marca;
    String Marca_vehiculo;

    public int getCodigo_marca() {
        return Codigo_marca;
    }

    public String getMarca_vehiculo() {
        return Marca_vehiculo;
    }

    public Marca(int Codigo_marca, String Marca_vehiculo) {
        this.Codigo_marca = Codigo_marca;
        this.Marca_vehiculo = Marca_vehiculo;
    }
}
