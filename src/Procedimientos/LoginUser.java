package Procedimientos;

import Herencia.Usuario;
import static Interfaces.Login.Contraseña;
import static Interfaces.Login.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class LoginUser {

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
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problem when connecting to the database");
        }
    }

    public void Ingresar_login() {
        Usuario usuario = new Usuario();
        String user = Usuario.getText();
        String pass = new String (Contraseña.getPassword());
        Conexion_Base_datos();
        try {
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT cedula, nombre, telefono, direccion, foto, contrasena, tipo"
                    + " FROM usuario WHERE nombre = '" + user + "' AND contrasena = MD5('" + pass + "')");
            
            while (rs.next()) {
                usuario.setCedula(rs.getString("cedula"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setFoto(null);
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setTipo(rs.getString("tipo"));
            }
        
        } catch (SQLException e) {
            System.out.println("Error de conexión");
        
        }
        try {
            if ("v".equals(usuario.getTipo())) {
                JOptionPane.showMessageDialog(null, "Bienvenido Administrador!");
                instancias.MenuCRUD();
            } else {
                JOptionPane.showMessageDialog(null, "Bienvenido Cliente!");
                instancias.buscarVehiculo(usuario);
            }
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No estas Registrado, Por favor Registrese!");
            instancias.Login();
        }
    }

}
