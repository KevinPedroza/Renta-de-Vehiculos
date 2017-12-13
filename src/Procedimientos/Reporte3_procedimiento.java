/*
this class will have the method needed to make the third report
 */
package Procedimientos;

import static Interfaces.Reporte_2.Estado;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Kevin
 */
public class Reporte3_procedimiento {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    private Font fuentebold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuentenormal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private Font fuentenormal2 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
    private Font fuenteitalic = new Font(Font.FontFamily.COURIER, 10, Font.ITALIC);

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

    public ArrayList<String> foto_car() {

        ArrayList<String> foto_carro = null;

        Conexion_Base_datos();
        try {
            foto_carro = new <InputStream>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT  us.foto as foto_user, vehiculo.foto as foto_vehi, vehiculo.url_foto_vehi as foto FROM usuario as us\n"
                    + "INNER JOIN alquiler on alquiler.cedula = us.cedula\n"
                    + "INNER JOIN vehiculo on vehiculo.placa = alquiler.placa\n"
                    + "INNER JOIN marcas on marcas.id_marca = vehiculo.id_marca \n"
                    + "INNER JOIN modelo on modelo.id_modelo = vehiculo.id_modelo \n"
                    + "INNER JOIN estilo on estilo.id_estilo = vehiculo.id_estilo\n"
                    + "WHERE vehiculo.estado = 'Ocupado';");

            while (rs.next()) {

                foto_carro.add(rs.getString("foto"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        return foto_carro;
    }

    public ArrayList<String> obtenerPlaca() {

        ArrayList<String> foto_carro = null;

        Conexion_Base_datos();
        try {
            foto_carro = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT  us.foto as foto_user, vehiculo.foto as foto_vehi, vehiculo.placa FROM usuario as us\n"
                    + "INNER JOIN alquiler on alquiler.cedula = us.cedula\n"
                    + "INNER JOIN vehiculo on vehiculo.placa = alquiler.placa\n"
                    + "INNER JOIN marcas on marcas.id_marca = vehiculo.id_marca \n"
                    + "INNER JOIN modelo on modelo.id_modelo = vehiculo.id_modelo \n"
                    + "INNER JOIN estilo on estilo.id_estilo = vehiculo.id_estilo\n"
                    + "WHERE vehiculo.estado = 'Ocupado';");

            while (rs.next()) {

                foto_carro.add(rs.getString("placa"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        return foto_carro;
    }

    public ArrayList<String> foto_user() {

        ArrayList<String> foto_carro = null;

        Conexion_Base_datos();
        try {
            foto_carro = new <InputStream>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT  us.url_foto_user as foto_user, vehiculo.foto as foto_vehi, vehiculo.url_foto_vehi  FROM usuario as us\n"
                    + "INNER JOIN alquiler on alquiler.cedula = us.cedula\n"
                    + "INNER JOIN vehiculo on vehiculo.placa = alquiler.placa\n"
                    + "INNER JOIN marcas on marcas.id_marca = vehiculo.id_marca \n"
                    + "INNER JOIN modelo on modelo.id_modelo = vehiculo.id_modelo \n"
                    + "INNER JOIN estilo on estilo.id_estilo = vehiculo.id_estilo\n"
                    + "WHERE vehiculo.estado = 'Ocupado';");

            while (rs.next()) {

                foto_carro.add(rs.getString("foto_user"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        return foto_carro;
    }

    public ArrayList<String> obtenerUser() {

        ArrayList<String> foto_carro = null;

        Conexion_Base_datos();
        try {
            foto_carro = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT us.nombre FROM usuario as us\n"
                    + "INNER JOIN alquiler on alquiler.cedula = us.cedula\n"
                    + "INNER JOIN vehiculo on vehiculo.placa = alquiler.placa\n"
                    + "INNER JOIN marcas on marcas.id_marca = vehiculo.id_marca \n"
                    + "INNER JOIN modelo on modelo.id_modelo = vehiculo.id_modelo \n"
                    + "INNER JOIN estilo on estilo.id_estilo = vehiculo.id_estilo\n"
                    + "WHERE vehiculo.estado = 'Ocupado';");

            while (rs.next()) {

                foto_carro.add(rs.getString("nombre"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        return foto_carro;
    }

    public String Info() {

        ArrayList Info = new ArrayList();
        ArrayList<String> placa = null;
        ArrayList<String> marca = null;
        ArrayList<String> modelo = null;
        ArrayList<String> estilo = null;
        ArrayList<String> trans = null;
        ArrayList<String> año = null;
        ArrayList<String> precio = null;
        ArrayList<String> estado = null;

        ArrayList<String> cedula = null;
        ArrayList<String> nombre = null;
        ArrayList<String> telefono = null;
        ArrayList<String> dire = null;
        ArrayList<String> tipo = null;

        String info2 = "";

        Conexion_Base_datos();
        try {
            placa = new <String>ArrayList();
            marca = new <String>ArrayList();
            modelo = new <String>ArrayList();
            estilo = new <String>ArrayList();
            trans = new <String>ArrayList();
            año = new <String>ArrayList();
            precio = new <String>ArrayList();
            estado = new <String>ArrayList();

            cedula = new <String>ArrayList();
            nombre = new <String>ArrayList();
            telefono = new <String>ArrayList();
            dire = new <String>ArrayList();
            tipo = new <String>ArrayList();

            s = connection.createStatement();
            rs = s.executeQuery("SELECT us.cedula, us.nombre, us.telefono ,us.direccion, us.tipo, vehiculo.placa, us.foto as foto_user, marcas.nombre AS marca,modelo.nombre AS modelo,estilo.nombre AS estilo,vehiculo.transmision,\n"
                    + "vehiculo.ano, vehiculo.precio, vehiculo.estado, vehiculo.foto as foto_vehi FROM usuario as us\n"
                    + "INNER JOIN alquiler on alquiler.cedula = us.cedula\n"
                    + "INNER JOIN vehiculo on vehiculo.placa = alquiler.placa\n"
                    + "INNER JOIN marcas on marcas.id_marca = vehiculo.id_marca \n"
                    + "INNER JOIN modelo on modelo.id_modelo = vehiculo.id_modelo \n"
                    + "INNER JOIN estilo on estilo.id_estilo = vehiculo.id_estilo\n"
                    + "WHERE vehiculo.estado = 'Ocupado' GROUP BY us.cedula, vehiculo.placa, marcas.nombre,modelo.nombre,estilo.nombre;");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));
                trans.add(rs.getString("transmision"));
                año.add(rs.getString("ano"));
                precio.add(rs.getString("precio"));
                estado.add(rs.getString("estado"));
                cedula.add(rs.getString("cedula"));
                nombre.add(rs.getString("nombre"));
                telefono.add(rs.getString("telefono"));
                tipo.add(rs.getString("tipo"));
                dire.add(rs.getString("direccion"));

            }

        } catch (SQLException e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {

            Info.add("Placa Vehiculo: " + placa.get(i) + ", Marca Vehiculo: " + marca.get(i) + ", Modelo Vehiculo: " + modelo.get(i) + "\nEstilo Vehiculo: " + estilo.get(i)
                    + ", Transmisión: " + trans.get(i) + ", Año: " + año.get(i) + ", Precio: " + precio.get(i) + ", Estado: " + estado.get(i) + "\n"
                    + "Cédula: " + cedula.get(i) + ", Nombre: " + nombre.get(i) + ", Teléfono: " + telefono.get(i) + " Dirección: " + dire.get(i)
                    + ", Tipo: " + tipo.get(i) + ".\n \n");
            info2 += Info.get(i);
        }

        return info2;
    }

    public void generar_PDF_Reporte3(String header, String info, String footer,
            String salida) {

        ArrayList<Image> ima = new ArrayList<Image>();
        ArrayList<Image> imauser = new ArrayList<Image>();
        for (int i = 0; i < foto_car().size(); i++) {

            try {
                ima.add(Image.getInstance(foto_car().get(i)));

            } catch (BadElementException | IOException ex) {
                Logger.getLogger(Reporte3_procedimiento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        for (int i = 0; i < foto_user().size(); i++) {

            try {
                imauser.add(Image.getInstance(foto_user().get(i)));

            } catch (BadElementException | IOException ex) {
                Logger.getLogger(Reporte3_procedimiento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        try {
            for (int i = 0; i < ima.size(); i++) {
                ima.get(i).scaleAbsoluteWidth(120);
                ima.get(i).scaleAbsoluteHeight(120);
                ima.get(i).setAlignment(Element.ALIGN_RIGHT);

            }
            for (int i = -0; i < imauser.size(); i++) {
                imauser.get(i).scaleAbsolute(120, 120);
                imauser.get(i).setAlignment(Element.ALIGN_LEFT);

            }
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(document, new FileOutputStream(salida));
            PdfPTable table = new PdfPTable(ima.size() + imauser.size());
            for (int i = 0; i < ima.size(); i++) {
                table.addCell(getEmptyUser("Usuario:" + obtenerUser().get(i)));
                table.addCell(imauser.get(i));
                table.addCell(getEmptyUser("Placa: " + obtenerPlaca().get(i)));
                table.addCell(ima.get(i));
            }
            document.open();
            document.add(getHeader(header));
            document.addCreationDate();
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(table);
            document.add(getInfo(info));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getFooter(footer));
            document.close();
        } catch (Exception e) {
        }

    }

    public Paragraph getHeader(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuentebold);
        p.add(c);
        return p;
    }

    public Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        c.append(texto);
        c.setFont(fuentenormal);
        p.add(c);
        return p;
    }

    public Paragraph getEmpty(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteitalic);
        p.add(c);
        return p;
    }

    public Paragraph getEmptyUser(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_BASELINE);
        c.append(texto);
        c.setFont(fuentenormal2);
        p.add(c);
        return p;
    }

    public Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteitalic);
        p.add(c);
        return p;
    }
}
