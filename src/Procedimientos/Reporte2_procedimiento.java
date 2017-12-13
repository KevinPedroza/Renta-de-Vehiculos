/*
this class will have the method needed to make the second report
 */
package Procedimientos;

import static Interfaces.Reporte_1.Fecha_fin;
import static Interfaces.Reporte_1.Fecha_ini;
import static Interfaces.Reporte_2.Estado;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Reporte2_procedimiento {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    private Font fuentebold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private Font fuentenormal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
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
            System.out.println("Problem when connecting to the database"+e);
        }
    }

    public String Infoplaca() {
        String estado = Estado.getSelectedItem().toString();
        ArrayList<String> Info = new ArrayList<String>();
        ArrayList<String> placa = new ArrayList();
        ArrayList<String> marca = new ArrayList();
        ArrayList<String> modelo = new ArrayList();
        ArrayList<String> estilo = new ArrayList();
        String info2 = "";

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa, marcas.nombre as marca, modelo.nombre as modelo, estilo.nombre as estilo FROM vehiculo\n"
                    + " inner join marcas on marcas.id_marca = vehiculo.id_marca inner join modelo on modelo.id_modelo = vehiculo.id_modelo "
                    + "inner join estilo on estilo.id_estilo = vehiculo.id_estilo WHERE vehiculo.estado = '" + estado + "'");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {
            Info.add("Placa Vehiculo: " + placa.get(i) + "\n");
            info2 += Info.get(i);
        }

        return info2;
    }

    public String Infomarca() {
        String estado = Estado.getSelectedItem().toString();
        ArrayList<String> Info = new ArrayList<String>();
        ArrayList<String> placa = new ArrayList();
        ArrayList<String> marca = new ArrayList();
        ArrayList<String> modelo = new ArrayList();
        ArrayList<String> estilo = new ArrayList();
        String info2 = "";

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa, marcas.nombre as marca, modelo.nombre as modelo, estilo.nombre as estilo FROM vehiculo\n"
                    + " inner join marcas on marcas.id_marca = vehiculo.id_marca inner join modelo on modelo.id_modelo = vehiculo.id_modelo "
                    + "inner join estilo on estilo.id_estilo = vehiculo.id_estilo WHERE vehiculo.estado = '" + estado + "'");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {
            Info.add("Marca Vehiculo: " + marca.get(i) + "\n");
            info2 += Info.get(i);
        }

        return info2;
    }

    public String Infomodelo() {
        String estado = Estado.getSelectedItem().toString();
        ArrayList<String> Info = new ArrayList<String>();
        ArrayList<String> placa = new ArrayList();
        ArrayList<String> marca = new ArrayList();
        ArrayList<String> modelo = new ArrayList();
        ArrayList<String> estilo = new ArrayList();
        String info2 = "";

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa, marcas.nombre as marca, modelo.nombre as modelo, estilo.nombre as estilo FROM vehiculo\n"
                    + " inner join marcas on marcas.id_marca = vehiculo.id_marca inner join modelo on modelo.id_modelo = vehiculo.id_modelo "
                    + "inner join estilo on estilo.id_estilo = vehiculo.id_estilo WHERE vehiculo.estado = '" + estado + "'");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {
            Info.add("Modelo Vehiculo: " + modelo.get(i) + "\n");
            info2 += Info.get(i);
        }

        return info2;
    }

    public String Infoestilo() {
        String estado = Estado.getSelectedItem().toString();
        ArrayList<String> Info = new ArrayList<String>();
        ArrayList<String> placa = new ArrayList();
        ArrayList<String> marca = new ArrayList();
        ArrayList<String> modelo = new ArrayList();
        ArrayList<String> estilo = new ArrayList();
        String info2 = "";

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa, marcas.nombre as marca, modelo.nombre as modelo, estilo.nombre as estilo FROM vehiculo\n"
                    + " inner join marcas on marcas.id_marca = vehiculo.id_marca inner join modelo on modelo.id_modelo = vehiculo.id_modelo "
                    + "inner join estilo on estilo.id_estilo = vehiculo.id_estilo WHERE vehiculo.estado = '" + estado + "'");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                marca.add(rs.getString("marca"));
                modelo.add(rs.getString("modelo"));
                estilo.add(rs.getString("estilo"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < placa.size(); i++) {
            Info.add("Estilo Vehiculo: " + estilo.get(i) + "\n");
            info2 += Info.get(i);
        }

        return info2;
    }

    public void generar_PDF_Reporte2(String header, String infoplaca, String infomarca, String modelo, String estilo, String footer,
            String salida) {
        try {
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(document, new FileOutputStream(salida));

            PdfPTable table = new PdfPTable(4);
            table.addCell(getInfo(infoplaca));
            table.addCell(getInfo(infomarca));
            table.addCell(getInfo(modelo));
            table.addCell(getInfo(estilo));
            document.open();
            document.add(getHeader(header));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(table);
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
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteitalic);
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
