/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Estilo;
import static Interfaces.Eliminar_estilo.Estilos_eliminar;
import static Interfaces.Insertar_estilo.Codigo_estilo;
import static Interfaces.Insertar_estilo.Estilos_registrados;
import static Interfaces.Insertar_estilo.Nombre_estilo;
import static Interfaces.Modificar_Estilo.Codigo_Estilo;
import static Interfaces.Modificar_Estilo.Modificar_estilo;
import static Interfaces.Modificar_Estilo.Nombre_estilo2;
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
public class CRUD_estilo {
    
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    private DefaultListModel<Estilo> modelo;
    Instancias instancias = new Instancias();
    
    public void Conexion_Base_datos() {
        if (connection != null) {
            return;
        }
        
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_de_vehiculos", "postgres", "postgres123");
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
                Codigo_estilo.setText("");
                Nombre_estilo.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el Código, Ingrese Números en el Codigo!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el Estilo, ya existe ese código" + e);
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
    
    public void Cargar_tablaeliminar() {
        
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
            Estilos_eliminar.setValueAt(id_estilo.get(i), i, 0);
            Estilos_eliminar.setValueAt(estilo.get(i), i, 1);
            
            if (id_estilo.size() >= Estilos_eliminar.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Estilos_eliminar.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
            
        }
        if (Estilos_eliminar.getRowCount() > id_estilo.size()) {
            
            try {
                DefaultTableModel temp2 = (DefaultTableModel) Estilos_eliminar.getModel();
                Estilos_eliminar.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);
                
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        
    }
    
    public void Eliminar_estilo() {
        
        TableModel tablaModelo;
        tablaModelo = (TableModel) Estilos_eliminar.getModel();
        boolean avanzar = true;
        int registro = Estilos_eliminar.getSelectedRow();
        int columna = Estilos_eliminar.getSelectedColumn();
        
        if (registro == -1) {
            
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }
        
        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Estilos_eliminar.getSelectedRow(), 0).toString();
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Elmininar : " + strResultado);
                if (opcion == 0) {
                    Conexion_Base_datos();
                    try {
                        
                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM estilo WHERE id_estilo = '" + strResultado + "'");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa");
                            Cargar_tablaeliminar();
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
    
    public ArrayList<Estilo> obtenerestilo() {
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
    
    public void Llenarlista_modificar() {
        modelo = new DefaultListModel<Estilo>();
        ArrayList<Estilo> listaestilo = new ArrayList();
        listaestilo = obtenerestilo();
        
        for (Estilo estilo : listaestilo) {
            modelo.addElement(estilo);
        }
        Modificar_estilo.setModel(modelo);
        
    }
    
    public void cargarDatosListaModificar() {
        Estilo estilo = Modificar_estilo.getSelectedValue();
        Conexion_Base_datos();
        try {
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_estilo, nombre FROM estilo WHERE id_estilo = '" + estilo.getCodigo_estilo() + "'");
            
            while (rs.next()) {
                Codigo_Estilo.setText(rs.getString("id_estilo"));
                Nombre_estilo2.setText(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            
        }
        
    }
    
    public void Modificar_estilo() {
        Estilo estilo = Modificar_estilo.getSelectedValue();
        
        Conexion_Base_datos();
        
        try {
            String nombre = Nombre_estilo.getText();
            String Codigo = Codigo_Estilo.getText();
            
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE estilo SET id_estilo = '" + Codigo + "', nombre = '" + nombre + "' WHERE id_estilo = '" + estilo.getCodigo_estilo() + "'");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se módificó el Estilo de manera exitosa");
                Nombre_estilo.setText("");
                Codigo_Estilo.setText("");
                Llenarlista_modificar();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el Estilo");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        
    }
    
}
