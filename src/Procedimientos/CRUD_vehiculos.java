/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Estilo;
import Herencia.Marca;
import Herencia.Modelo;
import Herencia.Oficina;
import static Interfaces.Insertar_vehiculo.Estilo_vehiculo;
import static Interfaces.Insertar_vehiculo.Imagen;
import static Interfaces.Insertar_vehiculo.Marca_vehiculos;
import static Interfaces.Insertar_vehiculo.Modelo_vehiculo;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Kevin
 */
public class CRUD_vehiculos {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    private DefaultComboBoxModel<Marca> marca;
    private DefaultComboBoxModel<Modelo> modelo;
    private DefaultComboBoxModel<Estilo> estilo;
    Instancias instancias = new Instancias();

    public void Conexion_Base_datos() {
        if (connection != null) {
            return;
        }

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_de_vehiculos", "postgres", "kevin");
            if (connection != null) {

            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database");
        }
    }

    public ArrayList<Marca> obtenerMarca() {
        ArrayList<Marca> listamarca = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM marcas");

            while (rs.next()) {
                String id = rs.getString("id_marca");
                String nombre = rs.getString("nombre");
                Marca marca = new Marca(Integer.parseInt(id), nombre);

                listamarca.add(marca);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listamarca;
    }

    public void llenarMarca() {
        marca = new DefaultComboBoxModel<Marca>();
        ArrayList<Marca> listamarca = new ArrayList();
        listamarca = obtenerMarca();

        for (Marca marca2 : listamarca) {
            marca.addElement(marca2);
        }
        Marca_vehiculos.setModel(marca);

    }

    public ArrayList<Modelo> obtenerModelo() {
        ArrayList<Modelo> listamodelo = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM modelo");

            while (rs.next()) {
                String id = rs.getString("id_modelo");
                String nombre = rs.getString("nombre");
                Modelo modelo = new Modelo(Integer.parseInt(id), nombre);

                listamodelo.add(modelo);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listamodelo;
    }

    public void llenarModelo() {
        modelo = new DefaultComboBoxModel<Modelo>();
        ArrayList<Modelo> listamodelo = new ArrayList();
        listamodelo = obtenerModelo();

        for (Modelo modelo2 : listamodelo) {
            modelo.addElement(modelo2);
        }
        Modelo_vehiculo.setModel(modelo);

    }

    public ArrayList<Estilo> obtenerEstilo() {
        ArrayList<Estilo> listaestilo = new ArrayList();

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM estilo");

            while (rs.next()) {
                String id = rs.getString("id_estilo");
                String nombre = rs.getString("nombre");
                Estilo estilo = new Estilo(Integer.parseInt(id), nombre);

                listaestilo.add(estilo);

            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return listaestilo;
    }

    public void llenarEstilo() {
        estilo = new DefaultComboBoxModel<Estilo>();
        ArrayList<Estilo> listaestilo = new ArrayList();
        listaestilo = obtenerEstilo();

        for (Estilo estilo2 : listaestilo) {
            estilo.addElement(estilo2);
        }
        Estilo_vehiculo.setModel(estilo);

    }

    public void insertarVehiculo(){
    
        
    }
    
}
