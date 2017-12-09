/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Marca;
import static Interfaces.Eliminar_marca.Eliminar_marca;
import static Interfaces.Insertar_marca.Codigo_marca;
import static Interfaces.Insertar_marca.Marcas_registradas;
import static Interfaces.Insertar_marca.Nombre_marca;
import static Interfaces.Modificar_marca.Marca_codigo_modificar;
import static Interfaces.Modificar_marca.Marca_modificar;
import static Interfaces.Modificar_marca.Nombre_marca_modificar;
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
public class CRUD_marca {
    
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;
    
    Instancias instancias = new Instancias();
    private DefaultListModel<Marca> modelo;
    
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
    
    public void Registrarmarca() {
        
        Conexion_Base_datos();
        try {
            String Idmarca = Codigo_marca.getText();
            String marca = Nombre_marca.getText();
            int parseo = Integer.parseInt(Idmarca);
            Marca marca2 = new Marca(parseo, marca);
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO marcas (id_marca, nombre) VALUES ('" + marca2.getCodigo_marca() + "', '" + marca2.getMarca_vehiculo() + "')");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se agregó la Marca de manera exitosa");
                Codigo_marca.setText("");
                Nombre_marca.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error al insertar el Código, Ingrese Números en el Codigo!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la Marca, ya existe ese código");
        }
        
    }
    
    public void Mostrarmarcas() {
        
        ArrayList<String> id_marca = null;
        ArrayList<String> marca = null;
        
        Conexion_Base_datos();
        try {
            id_marca = new <String>ArrayList();
            marca = new <String>ArrayList();
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_marca, nombre FROM marcas ORDER BY nombre ASC");
            
            while (rs.next()) {
                id_marca.add(rs.getString("id_marca"));
                marca.add(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        
        for (int i = 0; i < id_marca.size(); i++) {
            Marcas_registradas.setValueAt(id_marca.get(i), i, 0);
            Marcas_registradas.setValueAt(marca.get(i), i, 1);
            
            if (id_marca.size() >= Marcas_registradas.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Marcas_registradas.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
            
        }
        if (Marcas_registradas.getRowCount() > id_marca.size()) {
            
            try {
                DefaultTableModel temp2 = (DefaultTableModel) Marcas_registradas.getModel();
                Marcas_registradas.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);
                
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }
    
    public void Cargar_tablaeliminar() {
        
        ArrayList<String> id_marca = null;
        ArrayList<String> marca = null;
        Conexion_Base_datos();
        
        try {
            id_marca = new <String>ArrayList();
            marca = new <String>ArrayList();
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_marca, nombre FROM marcas ORDER BY nombre ASC");
            
            while (rs.next()) {
                id_marca.add(rs.getString("id_marca"));
                marca.add(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        
        for (int i = 0; i < id_marca.size(); i++) {
            Eliminar_marca.setValueAt(id_marca.get(i), i, 0);
            Eliminar_marca.setValueAt(marca.get(i), i, 1);
            
            if (id_marca.size() >= Eliminar_marca.getRowCount()) {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_marca.getModel();
                Object nuevo[] = {temp2.getRowCount()};
                temp2.addRow(nuevo);
            }
            
        }
        if (Eliminar_marca.getRowCount() > id_marca.size()) {
            
            try {
                DefaultTableModel temp2 = (DefaultTableModel) Eliminar_marca.getModel();
                Eliminar_marca.getModel();
                temp2.removeRow(temp2.getRowCount() - 1);
                
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        
    }
    
    public void Eliminar_marca() {
        
        TableModel tablaModelo;
        tablaModelo = (TableModel) Eliminar_marca.getModel();
        boolean avanzar = true;
        int registro = Eliminar_marca.getSelectedRow();
        int columna = Eliminar_marca.getSelectedColumn();
        
        if (registro == -1) {
            
            avanzar = false;
        } else if (columna == -1) {
            avanzar = false;
        }
        
        if (avanzar) {
            try {
                String strResultado = tablaModelo.getValueAt(Eliminar_marca.getSelectedRow(), 0).toString();
                int opcion = JOptionPane.showConfirmDialog(null, "Desea Elmininar : " + strResultado);
                if (opcion == 0) {
                    Conexion_Base_datos();
                    try {
                        
                        s = connection.createStatement();
                        int z = s.executeUpdate("DELETE FROM marcas WHERE id_marca = '" + strResultado + "'");
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
    
    public ArrayList<Marca> obtenermarca() {
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
    
    public void Llenarlista_modificar() {
        modelo = new DefaultListModel<Marca>();
        ArrayList<Marca> listamarca = new ArrayList();
        listamarca = obtenermarca();
        
        for (Marca marca : listamarca) {
            modelo.addElement(marca);
        }
        Marca_modificar.setModel(modelo);
        
    }
    
    public void cargarDatosListaModificar() {
        Marca marca = Marca_modificar.getSelectedValue();
        Conexion_Base_datos();
        try {
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM marcas WHERE id_marca = '" + marca.getCodigo_marca() + "'");
            
            while (rs.next()) {
                Marca_codigo_modificar.setText(rs.getString("id_marca"));
                Nombre_marca_modificar.setText(rs.getString("nombre"));
                
            }
        } catch (Exception e) {
            
        }
        
    }
    
    public void Modificar_marca() {
        Marca marca = Marca_modificar.getSelectedValue();
        
        Conexion_Base_datos();
        
        try {
            String nombre = Nombre_marca_modificar.getText();
            String Codigo = Marca_codigo_modificar.getText();
            
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE marcas SET id_marca = '" + Codigo + "', nombre = '" + nombre + "' WHERE id_marca = '" + marca.getCodigo_marca() + "'");
            if (z == 1) {
                JOptionPane.showMessageDialog(null, "Se módificó la Marca de manera exitosa");
                Nombre_marca_modificar.setText("");
                Marca_codigo_modificar.setText("");
                Llenarlista_modificar();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar la Marca");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }
        
    }
    
}
