package Herencia;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carol
 */
public class Usuario {

    private String cedula, nombre, telefono, direccion, contrasena, tipo;
    private FileInputStream foto;

    public Usuario(String cedula, String nombre, String telefono, String direccion, String contrasena, String tipo, FileInputStream foto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.foto = foto;
    }

    public Usuario() {
    }

    private Connection conexion = null;
    private ResultSet rs = null;

    public void conectar() {
        if (conexion != null) {
            return;
        }
        String url = "jdbc:postgresql://localhost:5432/renta_de_vehiculos";
        String password = "postgres123";
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, "postgres", password);
            if (conexion != null) System.out.println("Se conectó a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public boolean registrar() {
        conectar();
        try {
            String sql = "INSERT INTO usuario(cedula, nombre, telefono, direccion, foto, contrasena, tipo) VALUES (?, ?, ?, ?, ?, MD5(?), ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, telefono);
            ps.setString(4, direccion);
            ps.setBinaryStream(5, foto);
            ps.setString(6, contrasena);
            ps.setString(7, tipo);
            int res = ps.executeUpdate();
            System.out.println(res);
            return res == 1;
        } catch (SQLException e) {
            System.out.println("error" + e);
            return false;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FileInputStream getFoto() {
        return foto;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }

}
