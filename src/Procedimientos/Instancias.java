/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Herencia.Usuario;
import Interfaces.BuscarVehiculo;
import Interfaces.Eliminar_estilo;
import Interfaces.Eliminar_modelo;
import Interfaces.Eliminar_oficina;
import Interfaces.Eliminar_vehiculo;
import Interfaces.Estilo_CRUD;
import Interfaces.Insertar_estilo;
import Interfaces.Insertar_marca;
import Interfaces.Insertar_modelo;
import Interfaces.Insertar_oficina;
import Interfaces.Insertar_vehiculo;
import Interfaces.Login;
import Interfaces.Marca_CRUD;
import Interfaces.MenúAdmi;
import Interfaces.Modelo_CRUD;
import Interfaces.Modifica_oficina;
import Interfaces.Modificar_Estilo;
import static Interfaces.Modificar_Estilo.Modificar_estilo;
import Interfaces.Modificar_marca;
import Interfaces.Modificar_modelo;
import Interfaces.Modificar_vehiculo;
import Interfaces.Oficina_CRUD;
import Interfaces.Vehiculo_CRUD;
import javax.swing.JFrame;

/**
 *
 * @author Kevin
 */
public class Instancias extends JFrame {
    
    public void MarcaCRUD() {
        Marca_CRUD marca = new Marca_CRUD(this, true);
        marca.pack();
        marca.setVisible(true);
    }
    
    public void MenuCRUD() {
        MenúAdmi menu = new MenúAdmi(this, true);
        menu.pack();
        menu.setVisible(true);
    }
    
    public void Login() {
        Login login = new Login(this, true);
        login.pack();
        login.setVisible(true);
    }
    
    public void buscarVehiculo(Usuario usuario) {
        BuscarVehiculo b = new BuscarVehiculo(usuario);
        b.setVisible(true);
    }
    
    public void Insertarmarca() {
        Insertar_marca marca = new Insertar_marca(this, true);
        marca.pack();
        marca.setVisible(true);
        
    }
    
    public void modificarMarca() {
        Modificar_marca marca = new Modificar_marca(this, true);
        marca.pack();
        marca.setVisible(true);
    }
    
    public void menuEstilos() {
        Estilo_CRUD estilo = new Estilo_CRUD(this, true);
        estilo.pack();
        estilo.setVisible(true);
        
    }
    
    public void insertarEstilo() {
        Insertar_estilo estilo = new Insertar_estilo(this, true);
        estilo.pack();
        estilo.setVisible(true);
        
    }
    
    public void eliminarEstilo() {
        Eliminar_estilo estilo = new Eliminar_estilo(this, true);
        estilo.pack();
        estilo.setVisible(true);
        
    }
    
    public void modificarEstilo() {
        Modificar_Estilo estilo = new Modificar_Estilo(this, true);
        estilo.pack();
        estilo.setVisible(true);
        
    }
    
    public void menuModelo() {
        Modelo_CRUD menu = new Modelo_CRUD(this, true);
        menu.pack();
        menu.setVisible(true);
    }
    
    public void insertarModelo() {
        Insertar_modelo modelo = new Insertar_modelo(this, true);
        modelo.pack();
        modelo.setVisible(true);
    }
    
    public void eliminarModelo() {
        Eliminar_modelo modelo = new Eliminar_modelo(this, true);
        modelo.pack();
        modelo.setVisible(true);
        
    }
    
    public void modificarModelo() {
        Modificar_modelo modelo = new Modificar_modelo(this, true);
        modelo.pack();
        modelo.setVisible(true);
    }
    
    public void menuOficina() {
        Oficina_CRUD oficina = new Oficina_CRUD(this, true);
        oficina.pack();
        oficina.setVisible(true);
        
    }
    
    public void insertarOficina() {
        Insertar_oficina oficina = new Insertar_oficina(this, true);
        oficina.pack();
        oficina.setVisible(true);
    }
    
    public void eliminarOficina() {
        Eliminar_oficina oficina = new Eliminar_oficina(this, true);
        oficina.pack();
        oficina.setVisible(true);
    }
    
    public void moficiarOficina() {
        Modifica_oficina oficina = new Modifica_oficina(this, true);
        oficina.pack();
        oficina.setVisible(true);
    }
    
    public void menuVehiculos() {
        Vehiculo_CRUD vehiculo = new Vehiculo_CRUD(this, true);
        vehiculo.pack();
        vehiculo.setVisible(true);
    }
    
    public void insertarVehiculo() {
        Insertar_vehiculo vehiculo = new Insertar_vehiculo(this, true);
        vehiculo.pack();
        vehiculo.setVisible(true);
    }
    
    public void eliminarVehiculo() {
        Eliminar_vehiculo vehi = new Eliminar_vehiculo(this, true);
        vehi.pack();
        vehi.setVisible(true);
    }
    
    public void modificarVehiculo() {
        Modificar_vehiculo vehi = new Modificar_vehiculo(this, true);
        vehi.pack();
        vehi.setVisible(true);
    }
}
