package Procedimientos;

import static Interfaces.Login.Contraseña;
import static Interfaces.Login.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database");
        }
    }

    public void Ingresar_login() {
        String user = Usuario.getText();
        String pass = Contraseña.getText();
        String tipo = null;

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT tipo FROM usuario WHERE nombre = '" + user + "' AND contrasena = MD5('" + pass + "')");

            while (rs.next()) {
                tipo = rs.getString("tipo");
                
            }

        } catch (Exception e) {
            System.out.println("Error de conexión");

        }
        try {
            if (tipo.equals("v")) {
                JOptionPane.showMessageDialog(null, "Bienvenido Administrador!");
                instancias.MenuCRUD();
            }
            if (!tipo.equals("v")) {
                JOptionPane.showMessageDialog(null, "Bienvenido Cliente!");
            }
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No estas Registrado, Por favor Registrese!");
        }
    }

}
