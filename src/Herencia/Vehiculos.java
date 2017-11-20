/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.io.File;

/**
 *
 * @author Kevin
 */
public class Vehiculos {

    String Placa_vehiculo;
    Marca Codigo_marca;
    Estilo Codigo_estilo;
    Modelo Codigo_modelo;
    String Transmision_vehiculo;
    String Año;
    double Precio;
    File Foto;
    String Estado;

    public Vehiculos(String Placa_vehiculo, Marca Codigo_marca, Estilo Codigo_estilo, Modelo Codigo_modelo, String Transmision_vehiculo, String Año, double Precio, File Foto, String Estado) {
        this.Placa_vehiculo = Placa_vehiculo;
        this.Codigo_marca = Codigo_marca;
        this.Codigo_estilo = Codigo_estilo;
        this.Codigo_modelo = Codigo_modelo;
        this.Transmision_vehiculo = Transmision_vehiculo;
        this.Año = Año;
        this.Precio = Precio;
        this.Foto = Foto;
        this.Estado = Estado;
    }

    public String getPlaca_vehiculo() {
        return Placa_vehiculo;
    }

    public Marca getCodigo_marca() {
        return Codigo_marca;
    }

    public Estilo getCodigo_estilo() {
        return Codigo_estilo;
    }

    public Modelo getCodigo_modelo() {
        return Codigo_modelo;
    }

    public String getTransmision_vehiculo() {
        return Transmision_vehiculo;
    }

    public String getAño() {
        return Año;
    }

    public double getPrecio() {
        return Precio;
    }

    public File getFoto() {
        return Foto;
    }

    public String getEstado() {
        return Estado;
    }


}
