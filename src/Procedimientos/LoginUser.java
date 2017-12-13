package Procedimientos;
//here we have all methods needed to make the login
import Herencia.Usuario;
import static Interfaces.Login.Contraseña;
import static Interfaces.Login.Foto_user;
import static Interfaces.Login.Usuario;
import static Interfaces.Registro.Administrador_check;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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

            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/renta_de_vehiculos", "postgres", "postgres123");
            if (connection != null) {

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problem when connecting to the database");
        }
    }

    public void Ingresar_login() {
        Usuario usuario = new Usuario();
        String user = Usuario.getText();
        String pass = Contraseña.getText();
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
            } else if ("c".equals(usuario.getTipo())) {
                JOptionPane.showMessageDialog(null, "Bienvenido Cliente!");
                instancias.buscarVehiculo(usuario);

            } else {
                JOptionPane.showMessageDialog(null, "Contraseña o Usuario Incorrecto!");
                instancias.Login();
            }
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "No estas Registrado, Por favor Registrese!");
            instancias.Login();
        }
    }

    public InputStream buscarFoto() {
        InputStream foto = null;

        Conexion_Base_datos();
        try {
            String user = Usuario.getText();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT foto FROM usuario WHERE nombre LIKE '%" + user + "%'");

            while (rs.next()) {
                foto = rs.getBinaryStream("foto");
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        return foto;
    }

    public void enseñarFoto(InputStream buscar) {
        ImageIcon imagen = null;
        int anchoimagen = Foto_user.getWidth();
        int altoimagen = Foto_user.getHeight();
        try {
            InputStream us = buscar;
            BufferedImage bi = ImageIO.read(us);
            imagen = new ImageIcon(bi);
            Image image = imagen.getImage();
            image.getScaledInstance(anchoimagen, altoimagen, Image.SCALE_DEFAULT);
            ImageIcon icononuevo = new ImageIcon(image);

            Foto_user.setIcon(icononuevo);
        } catch (Exception e) {
        }

    }

    public void verificarAdmi() {
        boolean verify = false;
        ArrayList<String> tipo = new ArrayList();
        Conexion_Base_datos();
        try {
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT tipo FROM usuario");

            while (rs.next()) {
                tipo.add(rs.getString("tipo"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión");
        }

        for (int i = 0; i < tipo.size(); i++) {
            System.out.println(tipo.get(i));
            if ("v".equals(tipo.get(i))) {
                verify = true;
                break;
            } else {
                verify = false;
            }
            System.out.println(verify);
        }

        if (verify == true) {
            Administrador_check.setEnabled(false);
        } else {
            Administrador_check.setEnabled(true);
        }
    }

}
