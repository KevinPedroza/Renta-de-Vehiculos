package Procedimientos;
//this will some conections to the data base 
import Herencia.Vehiculos;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Carol
 */
public class Conexion_busqueda {
    
    private Connection conexion = null;
    private Statement s = null;
    private PreparedStatement ps = null;
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
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    
    public LinkedList<Vehiculos> buscarVehiculos(String sql) {
        conectar();
        LinkedList<Vehiculos> list = new LinkedList();
        Vehiculos v;
        try {
            
            s = conexion.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                v = new Vehiculos();
                v.setPlaca_vehiculo(rs.getString("placa"));
                v.setAño(rs.getString("ano"));
                v.setCodigo_marca(rs.getInt("id_marca"));
                v.setCodigo_estilo(rs.getInt("id_estilo"));
                v.setCodigo_modelo(rs.getInt("id_modelo"));
                v.setPrecio(rs.getDouble("precio"));
                v.setTransmision_vehiculo(rs.getString("transmision"));
                try {
                    InputStream is = rs.getBinaryStream("foto");
                    BufferedImage im = ImageIO.read(is);
                    v.setImagen(new ImageIcon(im));
                } catch (SQLException | IOException ex) {
                    System.out.println("error de imagen");
                }
                list.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return list;
    }
    
    public String buscar(String sql) {
        conectar();
        String res = "";
        try {
            s = conexion.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                res = rs.getString(1);
            }
        } catch (SQLException e) {
            return null;
        }
        return res;
    }
    
    public boolean insertar(String sql) {
        conectar();
        try {
            s = conexion.createStatement();
            int res = s.executeUpdate(sql);
            return res == 1;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean update(String sql) {
        conectar();
        try {
            s = conexion.createStatement();
            int res = s.executeUpdate(sql);
            return res == 1;
        } catch (SQLException e) {
            return false;
        }
    }
}
