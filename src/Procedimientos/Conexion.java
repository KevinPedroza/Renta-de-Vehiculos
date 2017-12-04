package Procedimientos;

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
public class Conexion {
    
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
            System.out.println(sql);
            s = conexion.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                v = new Vehiculos();
                v.setPlaca_vehiculo(rs.getString(1));
                v.setAño(rs.getString(6));
//                v.setCodigo_marca(rs.getInt("ma.nombre"));
//                v.setCodigo_estilo(rs.getInt("es.nombre"));
//                v.setCodigo_modelo(rs.getInt("mo.nombre"));
                v.setPrecio(rs.getDouble(7));
                v.setTransmision_vehiculo(rs.getString(5));
                try {
                    InputStream is = rs.getBinaryStream(8);
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
}
