/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procedimientos;

import Interfaces.Estilo_CRUD;
import Interfaces.Insertar_estilo;
import Interfaces.Insertar_marca;
import Interfaces.Login;
import Interfaces.Marca_CRUD;
import Interfaces.MenúAdmi;
import Interfaces.Modificar_marca;
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
}
