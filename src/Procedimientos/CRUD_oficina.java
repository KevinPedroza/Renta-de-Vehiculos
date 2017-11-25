/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Modelo;
import Herencia.Oficina;
import static Interfaces.Eliminar_oficina.Tabla_eliminar_oficina;
import static Interfaces.Insertar_oficina.Codigo_oficina;
import static Interfaces.Insertar_oficina.Nombre_oficina;
import static Interfaces.Insertar_oficina.Oficina_registradas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kevin
 */
public class CRUD_oficina {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    private DefaultListModel<Modelo> modelo;
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

    public void Registraoficina() {

        Conexion_Base_datos();
        try {
            String idoficina = Codigo_oficina.getText();
            String oficina = Nombre_oficina.getText();
            int parseo = Integer.parseInt(idoficina);
            Oficina modelo2 = new Oficina(parseo, oficina);
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO oficina (id_oficina, nombre) VALUES ('" + modelo2.getId_oficina() + "', '" + modelo2.getNombre_oficina() + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agregó la Oficina de manera exitosa");
                Codigo_oficina.setText("");
                Nombre_oficina.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el Código, Ingrese Números en el Codigo!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la Oficina, ya existe ese código");
        }

    }

    public void Mostraroficina() {

        ArrayList<String> id_oficina = null;
        ArrayList<String> oficina = null;

        Conexion_Base_datos();
        try {
            id_oficina = new <String>ArrayList();
            oficina = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_oficina, nombre FROM oficina ORDER BY nombre ASC");

            while (rs.next()) {
                id_oficina.add(rs.getString("id_oficina"));
                oficina.add(rs.getString("nombre"));

            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }

        for (int i = 0; i < id_oficina.size(); i++) {
            Oficina_registradas.setValueAt(id_oficina.get(i), i, 0);
            Oficina_registradas.setValueAt(oficina.get(i), i, 1);

            if (id_oficina.size() >= Oficina_registradas.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Oficina_registradas.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Oficina_registradas.getRowCount() > id_oficina.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Oficina_registradas.getModel();
                Oficina_registradas.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public void Mostraroficinas() {

        ArrayList<String> id_oficina = null;
        ArrayList<String> oficina = null;

        Conexion_Base_datos();
        try {
            id_oficina = new <String>ArrayList();
            oficina = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_oficina, nombre FROM oficina ORDER BY nombre ASC");

            while (rs.next()) {
                id_oficina.add(rs.getString("id_oficina"));
                oficina.add(rs.getString("nombre"));

            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }

        for (int i = 0; i < id_oficina.size(); i++) {
            Tabla_eliminar_oficina.setValueAt(id_oficina.get(i), i, 0);
            Tabla_eliminar_oficina.setValueAt(oficina.get(i), i, 1);

            if (id_oficina.size() >= Tabla_eliminar_oficina.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Tabla_eliminar_oficina.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Tabla_eliminar_oficina.getRowCount() > id_oficina.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Tabla_eliminar_oficina.getModel();
                Tabla_eliminar_oficina.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

    public void Eliminar_oficina() {

        TableModel tablaModelo;
        tablaModelo = (TableModel) Tabla_eliminar_oficina.getModel();
        boolean avanzar = true;
        int registro = Tabla_eliminar_oficina.getSelectedRow();
        int columna = Tabla_eliminar_oficina.getSelectedColumn();

        if (registro == -1) {

            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }

        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Tabla_eliminar_oficina.getSelectedRow(), 0).toString();
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Elmininar : " + strResultado);
                if (opcion == 0) {
                    Conexion_Base_datos();
                    try {

                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM oficina WHERE id_oficina = '" + strResultado + "'");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa");
                            Mostraroficinas();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                        }
                    } catch (Exception e) {
                        System.out.println("Error de conexión");
                    }
                }
            } catch (java.lang.NullPointerException e) {
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un registro");

        }

    }
}
