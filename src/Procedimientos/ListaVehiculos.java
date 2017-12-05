package Procedimientos;

import Herencia.Vehiculos;
import java.awt.Component;
import java.awt.Image;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Carol
 */
public class ListaVehiculos extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Vehiculos) {
            Vehiculos vehiculo = (Vehiculos) value;
            String texto = vehiculo.getPlaca_vehiculo();
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

//    public DefaultListModel llenarLista(JList lista, LinkedList<Vehiculos> vehiculos) {
//        DefaultListModel modelo = new DefaultListModel();
//        lista.setModel(modelo);
//        for (int i = 0; i < vehiculos.size(); i++) {
//            try {
//                modelo.addElement(vehiculos.get(i));
//            } catch (Exception e) {
//            }
//        }
//        return modelo;
//    }
}
