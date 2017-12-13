/*
this class will have the method needed to make the first report
 */
package Procedimientos;

import static Interfaces.Reporte_1.Fecha_fin;
import static Interfaces.Reporte_1.Fecha_ini;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
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
public class Reporte1_procedimientos {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    private Font fuentebold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuentenormal = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private Font fuenteitalic = new Font(Font.FontFamily.COURIER, 10, Font.ITALIC);

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

    public String Info() {
        SimpleDateFormat formato2 = new SimpleDateFormat("yyyy/MM/dd");
        String fecha_ini = formato2.format(Fecha_ini.getDate());
        String fecha_fin = formato2.format(Fecha_fin.getDate());
        ArrayList<String> Info = new ArrayList<String>();
        ArrayList<String> placa = new ArrayList();
        ArrayList<String> cedula = new ArrayList();
        ArrayList<String> nombre = new ArrayList();
        ArrayList<String> fecha_alqui = new ArrayList();
        ArrayList<String> fecha_devo = new ArrayList();
        String info2 = "";

        Conexion_Base_datos();
        try {

            s = connection.createStatement();
            rs = s.executeQuery("SELECT placa, cedula, nombre_usuario, fecha_hora_retiro, fecha_hora_devolucion FROM alquiler\n"
                    + "WHERE alquiler.fecha_hora_retiro between cast ('" + fecha_ini + "'  as Date) and cast('" + fecha_fin + "' as Date)");

            while (rs.next()) {

                placa.add(rs.getString("placa"));
                cedula.add(rs.getString("cedula"));
                nombre.add(rs.getString("nombre_usuario"));
                fecha_alqui.add(rs.getString("fecha_hora_retiro"));
                fecha_devo.add(rs.getString("fecha_hora_devolucion"));

            }

        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        for (int i = 0; i < nombre.size(); i++) {
            Info.add("Placa Vehiculo: " + placa.get(i) + ", Cédula Cliente: " + cedula.get(i) + ", Nombre Cliente: " + nombre.get(i) + "\nFecha Retiro: " + fecha_alqui.get(i)
                    + ", Fecha Devolución: " + fecha_devo.get(i) + ".\n \n");
            info2 += Info.get(i);
        }

        return info2;
    }

    public void generar_PDF_Reporte1(String header, String info, String footer,
            String salida) {
        
        try {
            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(salida));
            document.open();
            document.add(getHeader(header));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
            document.add(getEmpty(" "));
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
