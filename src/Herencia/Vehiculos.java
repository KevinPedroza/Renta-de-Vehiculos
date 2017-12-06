/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import Procedimientos.Conexion_busqueda;
import java.io.File;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin
 */
public class Vehiculos {

    String Placa_vehiculo;
    int Codigo_marca;
    int Codigo_estilo;
    int Codigo_modelo;
    String Transmision_vehiculo;
    String Año;
    double Precio;
    File Foto;
    String Estado;

    public Vehiculos(String Placa_vehiculo, int Codigo_marca, int Codigo_estilo, int Codigo_modelo, String Transmision_vehiculo, String Año, double Precio, File Foto, String Estado) {
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

    public Vehiculos() {
    }

    public String getPlaca_vehiculo() {
        return Placa_vehiculo;
    }

    public int getCodigo_marca() {
        return Codigo_marca;
    }

    public int getCodigo_estilo() {
        return Codigo_estilo;
    }

    public int getCodigo_modelo() {
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

    public void setPlaca_vehiculo(String Placa_vehiculo) {
        this.Placa_vehiculo = Placa_vehiculo;
    }

    public void setCodigo_marca(int Codigo_marca) {
        this.Codigo_marca = Codigo_marca;
    }

    public void setCodigo_estilo(int Codigo_estilo) {
        this.Codigo_estilo = Codigo_estilo;
    }

    public void setCodigo_modelo(int Codigo_modelo) {
        this.Codigo_modelo = Codigo_modelo;
    }

    public void setTransmision_vehiculo(String Transmision_vehiculo) {
        this.Transmision_vehiculo = Transmision_vehiculo;
    }

    public void setAño(String Año) {
        this.Año = Año;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setFoto(File Foto) {
        this.Foto = Foto;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    ImageIcon imagen = new ImageIcon();

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Número de Placa: " + this.Placa_vehiculo;

    }

    public LinkedList<Vehiculos> buscar(boolean[] filtros) {
        Conexion_busqueda c = new Conexion_busqueda();
        c.conectar();
        String sql = "SELECT placa, ma.nombre, mo.nombre, es.nombre, transmision, ano, precio, foto "
                + "FROM public.vehiculo AS ve "
                + "JOIN marcas AS ma ON ve.id_marca = ma.id_marca "
                + "JOIN modelo AS mo ON ve.id_modelo = mo.id_modelo "
                + "JOIN estilo AS es ON ve.id_estilo = es.id_estilo "
                + "WHERE ve.estado = 'Disponible'";
        String consulta = "";
        if (filtros[0]) {
            consulta += " AND ano >= '" + Año + "'";
        }
        if (filtros[1]) {
            consulta += " AND ve.id_estilo = '" + Codigo_estilo + "'";
        }
        if (filtros[2]) {
            consulta += " AND ve.id_marca = '" + Codigo_marca + "'";
        }
        if (filtros[3]) {
            consulta += " AND ve.id_modelo = '" + Codigo_modelo + "'";
        }
        if (filtros[4]) {
            consulta += " AND precio <= '" + Precio + "'";
        }
        if (filtros[5]) {
            consulta += " AND transmision = '" + Transmision_vehiculo + "'";
        }
        if (!"".equals(consulta)) {
            sql += consulta;
        }
        LinkedList<Vehiculos> lista = c.buscarVehiculos(sql);
        return lista;
    }

}
