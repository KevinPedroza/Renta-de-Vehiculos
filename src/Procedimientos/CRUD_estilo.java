/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Estilo;
import static Interfaces.Insertar_estilo.Codigo_estilo;
import static Interfaces.Insertar_estilo.Estilos_registrados;
import static Interfaces.Insertar_estilo.Nombre_estilo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class CRUD_estilo {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

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

    public void Registraestilo() {

        Conexion_Base_datos();
        try {
            String Idestilo = Codigo_estilo.getText();
            String estilo2 = Nombre_estilo.getText();
            int parseo = Integer.parseInt(Idestilo);
            Estilo estilo = new Estilo(parseo, estilo2);
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO estilo (id_estilo, nombre) VALUES ('" + estilo.getCodigo_estilo() + "', '" + estilo.getEstilo_vehiculo() + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agregó el estilo de manera exitosa");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el Código, Ingrese Números en el Codigo!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la Marca");
        }

    }

    public void Mostrarestilos() {

        ArrayList<String> id_estilo = null;
        ArrayList<String> estilo = null;

        Conexion_Base_datos();
        try {
            id_estilo = new <String>ArrayList();
            estilo = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_estilo, nombre FROM estilo ORDER BY nombre ASC");

            while (rs.next()) {
                id_estilo.add(rs.getString("id_estilo"));
                estilo.add(rs.getString("nombre"));

            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }

        for (int i = 0; i < id_estilo.size(); i++) {
            Estilos_registrados.setValueAt(id_estilo.get(i), i, 0);
            Estilos_registrados.setValueAt(estilo.get(i), i, 1);

            if (id_estilo.size() >= Estilos_registrados.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Estilos_registrados.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }

        }
        if (Estilos_registrados.getRowCount() > id_estilo.size()) {

            try {
                DefaultTableModel temp2 = (DefaultTableModel) Estilos_registrados.getModel();
                Estilos_registrados.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);

            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }

}
