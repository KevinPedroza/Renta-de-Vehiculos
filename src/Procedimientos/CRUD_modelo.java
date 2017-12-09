/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Estilo;
import Herencia.Modelo;
import static Interfaces.Eliminar_modelo.Eliminar_modelo;
import static Interfaces.Insertar_modelo.Codigo_modelo;
import static Interfaces.Insertar_modelo.Modelos_registrados;
import static Interfaces.Insertar_modelo.Nombre_modelo;
import static Interfaces.Modificar_modelo.Modificar_modelo;
import static Interfaces.Modificar_modelo.codigomodelomodificar;
import static Interfaces.Modificar_modelo.nombremodelomodificar;
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
public class CRUD_modelo {
    
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
            
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_de_vehiculos", "postgres", "postgres123");
            if (connection != null) {
                
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database");
        }
    }
    
    public void Registramodelo() {
        
        Conexion_Base_datos();
        try {
            String idmodelo = Codigo_modelo.getText();
            String modelo = Nombre_modelo.getText();
            int parseo = Integer.parseInt(idmodelo);
            Modelo modelo2 = new Modelo(parseo, modelo);
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO modelo (id_modelo, nombre) VALUES ('" + modelo2.getCodigo_modelo() + "', '" + modelo2.getModelo_vehiculo() + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agregó el estilo de manera exitosa");
                Codigo_modelo.setText("");
                Nombre_modelo.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el Código, Ingrese Números en el Codigo!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la Marca, ya existe ese Código");
        }
        
    }
    
    public void Mostrarmodelos() {
        
        ArrayList<String> id_modelo = null;
        ArrayList<String> modelo = null;
        
        Conexion_Base_datos();
        try {
            id_modelo = new <String>ArrayList();
            modelo = new <String>ArrayList();
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_modelo, nombre FROM modelo ORDER BY nombre ASC");
            
            while (rs.next()) {
                id_modelo.add(rs.getString("id_modelo"));
                modelo.add(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        
        for (int i = 0; i < id_modelo.size(); i++) {
            Modelos_registrados.setValueAt(id_modelo.get(i), i, 0);
            Modelos_registrados.setValueAt(modelo.get(i), i, 1);
            
            if (id_modelo.size() >= Modelos_registrados.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Modelos_registrados.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
            
        }
        if (Modelos_registrados.getRowCount() > id_modelo.size()) {
            
            try {
                DefaultTableModel temp2 = (DefaultTableModel) Modelos_registrados.getModel();
                Modelos_registrados.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);
                
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }
    
    public void Cargarmodeloseliminar() {
        
        ArrayList<String> id_modelo = null;
        ArrayList<String> modelo = null;
        
        Conexion_Base_datos();
        try {
            id_modelo = new <String>ArrayList();
            modelo = new <String>ArrayList();
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_modelo, nombre FROM modelo ORDER BY nombre ASC");
            
            while (rs.next()) {
                id_modelo.add(rs.getString("id_modelo"));
                modelo.add(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        
        for (int i = 0; i < id_modelo.size(); i++) {
            Eliminar_modelo.setValueAt(id_modelo.get(i), i, 0);
            Eliminar_modelo.setValueAt(modelo.get(i), i, 1);
            
            if (id_modelo.size() >= Eliminar_modelo.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_modelo.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
            
        }
        if (Eliminar_modelo.getRowCount() > id_modelo.size()) {
            
            try {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_modelo.getModel();
                Eliminar_modelo.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);
                
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }
    
    public void Eliminar_modelo() {
        
        TableModel tablaModelo;
        tablaModelo = (TableModel) Eliminar_modelo.getModel();
        boolean avanzar = true;
        int registro = Eliminar_modelo.getSelectedRow();
        int columna = Eliminar_modelo.getSelectedColumn();
        
        if (registro == -1) {
            
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }
        
        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Eliminar_modelo.getSelectedRow(), 0).toString();
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Elmininar : " + strResultado);
                if (opcion == 0) {
                    Conexion_Base_datos();
                    try {
                        
                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM modelo WHERE id_modelo = '" + strResultado + "'");
                        if (z == 1) {
                            JOptionPane.showMessageDialog(null, "Se eliminó el registro de manera exitosa");
                            Cargarmodeloseliminar();
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
    
    public void Llenarlista_modificar() {
        modelo = new DefaultListModel<Modelo>();
        ArrayList<Modelo> listamodelo = new ArrayList();
        listamodelo = obtenerModelo();
        
        for (Modelo modelo2 : listamodelo) {
            modelo.addElement(modelo2);
        }
        Modificar_modelo.setModel(modelo);
        
    }
    
    public void cargarDatosListaModificar() {
        Modelo modelo = Modificar_modelo.getSelectedValue();
        Conexion_Base_datos();
        try {
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_modelo, nombre FROM modelo WHERE id_modelo = '" + modelo.getCodigo_modelo() + "'");
            
            while (rs.next()) {
                codigomodelomodificar.setText(rs.getString("id_modelo"));
                nombremodelomodificar.setText(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            
        }
        
    }
    
    public void Modificar_modelo() {
        Modelo modelo = Modificar_modelo.getSelectedValue();
        
        Conexion_Base_datos();
        
        try {
            String nombre = nombremodelomodificar.getText();
            String Codigo = codigomodelomodificar.getText();
            
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE modelo SET id_modelo = '" + Codigo + "', nombre = '" + nombre + "' WHERE id_modelo = '" + modelo.getCodigo_modelo() + "'");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se módificó el Estilo de manera exitosa");
                nombremodelomodificar.setText("");
                codigomodelomodificar.setText("");
                Llenarlista_modificar();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el Estilo");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        
    }
    
}
