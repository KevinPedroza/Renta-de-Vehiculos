package Procedimientos;

import Herencia.Vehiculos;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Carol
 */
public class ListaVehiculos extends JLabel implements ListCellRenderer {

    Conexion_busqueda c = new Conexion_busqueda();
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Vehiculos) {
            Vehiculos vehiculo = (Vehiculos) value;
            String texto = c.buscar("SELECT nombre FROM marcas WHERE id_marca='" + vehiculo.getCodigo_marca() + "'") + " ";
            texto += c.buscar("SELECT nombre FROM modelo WHERE id_modelo='" + vehiculo.getCodigo_modelo() + "'") + " ";
            texto += c.buscar("SELECT nombre FROM estilo WHERE id_estilo='" + vehiculo.getCodigo_estilo() + "'") + " ";
            texto += vehiculo.getAño() + " " + vehiculo.getTransmision_vehiculo() + "  PLACA: " +vehiculo.getPlaca_vehiculo();
            setText(texto);
            Image image = vehiculo.getImagen().getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(image));

        }
        if (isSelected) {
            setBackground(list.getSelectionBackground().brighter());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground().darker());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
    }
}
