package Procedimientos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Carol
 */
public class Rentar {

    private String placa, cedula, nombre_usuario;
    private String oficinaret, oficinadev, fecharet, fechadev, horaret, horadev;
    private double precio_total, gps, booster, silla;

    public Rentar() {
    }

    public Rentar(String placa, String cedula, String nombre_usuario, double precio_total) {
        this.placa = placa;
        this.cedula = cedula;
        this.nombre_usuario = nombre_usuario;
        this.precio_total = precio_total;
        fecharet = fechaDeHoy();
        fechadev = fechaDeHoy();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public String getFecharet() {
        return fecharet;
    }

    public void setFecharet(String fecharet) {
        this.fecharet = fecharet;
    }

    public String getFechadev() {
        return fechadev;
    }

    public void setFechadev(String fechadev) {
        this.fechadev = fechadev;
    }

    public String getHoraret() {
        return horaret;
    }

    public void setHoraret(String horaret) {
        this.horaret = horaret;
    }

    public String getHoradev() {
        return horadev;
    }

    public void setHoradev(String horadev) {
        this.horadev = horadev;
    }

    public double getGps() {
        return gps;
    }

    public void setGps(double gps) {
        this.gps = gps;
    }

    public double getBooster() {
        return booster;
    }

    public void setBooster(double booster) {
        this.booster = booster;
    }

    public double getSilla() {
        return silla;
    }

    public void setSilla(double silla) {
        this.silla = silla;
    }

    public String getOficinaret() {
        return oficinaret;
    }

    public void setOficinaret(String oficinaret) {
        this.oficinaret = oficinaret;
    }

    public String getOficinadev() {
        return oficinadev;
    }

    public void setOficinadev(String oficinadev) {
        this.oficinadev = oficinadev;
    }

    @Override
    public String toString() {
        return "'" + placa + "', '" + cedula + "', '" + nombre_usuario + "', '" + oficinaret + "', '" + oficinadev + "', '" + fecharet + "', '" + fechadev +  "', " + precio_total;
    }

    public String fechaDeHoy() {
        String fecha = "";
        Calendar c = Calendar.getInstance();
        fecha += String.format("%02d", c.get(Calendar.DATE)) + "/" + String.format("%02d", (c.get(Calendar.MONTH) + 1)) + "/" + c.get(Calendar.YEAR);
        return fecha;
    }
    
    public int diferenciaDeDias() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = formato.parse(fecharet);
            Calendar cal = new GregorianCalendar();
            cal.setTime(d);
            int diaret = cal.get(Calendar.DAY_OF_YEAR);
            d = formato.parse(fechadev);
            cal.setTime(d);
            int diadev = cal.get(Calendar.DAY_OF_YEAR);
            return diadev - diaret;
        }catch(ParseException e){
            return -1;
        }
    }
    
    public boolean registrar() {
        Conexion_busqueda c = new Conexion_busqueda();
        boolean res = c.insertar("INSERT INTO alquiler (placa, cedula, nombre_usuario, oficina_retiro, oficina_devolucion, fecha_hora_retiro, fecha_hora_devolucion, precio)"
                + "VALUES (" + toString() + ")");
        if (res) {
            boolean update = c.update("UPDATE vehiculo SET estado='Ocupado' WHERE placa='" + placa + "'");
        }
        return res;
    }

}
