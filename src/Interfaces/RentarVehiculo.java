package Interfaces;

import Procedimientos.Conexion_busqueda;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import Procedimientos.CRUD_oficina;
import Herencia.Oficina;
import Procedimientos.Rentar;
import Herencia.Usuario;
import Herencia.Vehiculos;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Carol
 */
public class RentarVehiculo extends javax.swing.JFrame {

    Usuario usuario;
    Vehiculos vehiculo;
    Rentar r;

    /**
     * Creates new form RentarVehiculo
     */
    public RentarVehiculo() {
        initComponents();
        setLocationRelativeTo(null);
        vehiculo = new Vehiculos("AA0-01", 0, 0, 0, "Automático", "2015", 200, new File("C:/Users/DELL/Pictures/Saved Pictures/carro3.jpg"), "Disponible");
        usuario = new Usuario("207770677", "Carol", "86889251", "Gamonales", "2103", "c", null);
        r = new Rentar(vehiculo.getPlaca_vehiculo(), usuario.getCedula(), usuario.getNombre(), vehiculo.getPrecio());
        dtretiro.setMinSelectableDate(new Date());
        dtdevolucion.setMinSelectableDate(new Date());
        buscarOficinas();
        llenarDatos();
    }

    private void buscarOficinas() {
        CRUD_oficina c = new CRUD_oficina();
        ArrayList<Oficina> oficinas = c.obtenerOficina();
        DefaultComboBoxModel model1 = new DefaultComboBoxModel();
        cmboficinadev.setModel(model1);
        DefaultComboBoxModel model2 = new DefaultComboBoxModel();
        cmboficinaret.setModel(model2);
        for (int i = 0; i < oficinas.size(); i++) {
            model1.addElement(oficinas.get(i).getNombre_oficina());
            model2.addElement(oficinas.get(i).getNombre_oficina());
        }
    }

    private void actualizarPrecioTotal() {
        int dif = r.diferenciaDeDias();
        if (dif >= 0) {
            double total = ((dif + 1) * vehiculo.getPrecio()) + r.getGps() + r.getBooster() + r.getSilla();
            r.setPrecio_total(total);
            lbltotal.setText("Total: $" + r.getPrecio_total());
        }
    }

    private void llenarDatos() {
        Conexion_busqueda c = new Conexion_busqueda();
        String info1 = "", sql, res;
        sql = "SELECT nombre FROM marcas WHERE id_marca = " + vehiculo.getCodigo_marca();
        res = c.buscar(sql);
        if (res != null) {
            info1 += res + " ";
        }
        sql = "SELECT nombre FROM modelo WHERE id_modelo = " + vehiculo.getCodigo_modelo();
        res = c.buscar(sql);
        if (res != null) {
            info1 += res + " ";
        }
        sql = "SELECT nombre FROM estilo WHERE id_estilo = " + vehiculo.getCodigo_estilo();
        res = c.buscar(sql);
        if (res != null) {
            info1 += res + " " + vehiculo.getAño();
        }
        lblplaca.setText("Placa: " + vehiculo.getPlaca_vehiculo());
        lblinfo1.setText(info1);
        lbltransmision.setText("Transmisión: " + vehiculo.getTransmision_vehiculo());
        lblprecio.setText("Precio: $" + vehiculo.getPrecio());
        actualizarPrecioTotal();
        try {
            Image img = ImageIO.read(vehiculo.getFoto()).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
            lblfoto.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmboficinadev = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbhoradev = new javax.swing.JComboBox<>();
        dtdevolucion = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmboficinaret = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbhoraret = new javax.swing.JComboBox<>();
        dtretiro = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        chkGPS = new javax.swing.JCheckBox();
        chkBooster = new javax.swing.JCheckBox();
        chkSilla = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        lblfoto = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        lblplaca = new javax.swing.JLabel();
        lblinfo1 = new javax.swing.JLabel();
        lbltransmision = new javax.swing.JLabel();
        lblprecio = new javax.swing.JLabel();
        btnatras = new javax.swing.JButton();
        btnrentar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Devolución de vehiculo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Text", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel1.setText("Oficina");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel3.setText("Hora");

        cmbhoradev.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30" }));
        cmbhoradev.setSelectedIndex(22);

        dtdevolucion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtdevolucionPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmboficinadev, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(dtdevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cmbhoradev, 0, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmboficinadev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(cmbhoradev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtdevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Retiro de vehiculo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Text", 1, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel4.setText("Oficina");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel6.setText("Hora");

        cmbhoraret.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30" }));
        cmbhoraret.setSelectedIndex(22);

        dtretiro.setMinSelectableDate(new java.util.Date(1512543678000L));
        dtretiro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtretiroPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmboficinaret, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(dtretiro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(cmbhoraret, 0, 76, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dtretiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cmboficinaret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(cmbhoraret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Adicionar artículos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sitka Text", 1, 12))); // NOI18N

        chkGPS.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        chkGPS.setText("GPS");
        chkGPS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkGPSItemStateChanged(evt);
            }
        });

        chkBooster.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        chkBooster.setText("Booster");
        chkBooster.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkBoosterItemStateChanged(evt);
            }
        });

        chkSilla.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        chkSilla.setText("Silla de bebé");
        chkSilla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkSillaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkGPS)
                    .addComponent(chkBooster)
                    .addComponent(chkSilla))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(chkGPS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkBooster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkSilla)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbltotal.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        lbltotal.setText("Total: ");

        lblplaca.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        lblplaca.setText("Placa:");

        lblinfo1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        lblinfo1.setText("Marca Modelo Estilo Año");

        lbltransmision.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        lbltransmision.setText("Transmisión ");

        lblprecio.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        lblprecio.setText("Precio: $");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblinfo1)
                            .addComponent(lblplaca)
                            .addComponent(lbltransmision)
                            .addComponent(lblprecio))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblplaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblinfo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltransmision)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblprecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltotal))
                    .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnatras.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        btnatras.setText("Atrás");

        btnrentar.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        btnrentar.setText("Rentar");
        btnrentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrentarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnatras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnrentar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnatras)
                    .addComponent(btnrentar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnrentarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrentarMouseClicked
        r.setOficinaret((String) cmboficinaret.getSelectedItem());
        r.setOficinadev((String) cmboficinadev.getSelectedItem());
        r.setHoraret((String) cmbhoraret.getSelectedItem());
        r.setHoradev((String) cmbhoradev.getSelectedItem());
        boolean res = r.registrar();
        if (res) {
            JOptionPane.showMessageDialog(null, "Gracias por alquilar");
        } else {
            JOptionPane.showMessageDialog(null, "No se puede registrar la renta del vehículo");
        }
    }//GEN-LAST:event_btnrentarMouseClicked

    private void dtretiroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtretiroPropertyChange
        try {
            String[] fecha = dtretiro.getDate().toString().split(" ");
            int mes = dtretiro.getDate().getMonth() + 1;
            String fecharet = fecha[2] + "/" + String.format("%02d", mes) + "/" + fecha[5];
            r.setFecharet(fecharet);
            chkGPSItemStateChanged(new ItemEvent((ItemSelectable) chkGPS, 1, 1, 1));
            chkBoosterItemStateChanged(new ItemEvent((ItemSelectable) chkBooster, 1, 1, 1));
            chkSillaItemStateChanged(new ItemEvent((ItemSelectable) chkSilla, 1, 1, 1));
        } catch (Exception e) {
            dtretiro.setDate(new Date());
        }
    }//GEN-LAST:event_dtretiroPropertyChange

    private void dtdevolucionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtdevolucionPropertyChange
        try {
            String[] fecha = dtdevolucion.getDate().toString().split(" ");
            int mes = dtdevolucion.getDate().getMonth() + 1;
            String fechadev = fecha[2] + "/" + String.format("%02d", mes) + "/" + fecha[5];
            r.setFechadev(fechadev);
            chkGPSItemStateChanged(new ItemEvent((ItemSelectable) chkGPS, 1, 1, 1));
            chkBoosterItemStateChanged(new ItemEvent((ItemSelectable) chkBooster, 1, 1, 1));
            chkSillaItemStateChanged(new ItemEvent((ItemSelectable) chkSilla, 1, 1, 1));
        } catch (Exception e) {
            dtdevolucion.setDate(new Date());
        }
    }//GEN-LAST:event_dtdevolucionPropertyChange

    private void chkGPSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkGPSItemStateChanged
        if (chkGPS.isSelected()) {
            int dif = r.diferenciaDeDias();
            if (dif >= 0) {
                r.setGps((dif + 1) * 9);
            }
        } else {
            r.setGps(0);
        }
        actualizarPrecioTotal();
    }//GEN-LAST:event_chkGPSItemStateChanged

    private void chkBoosterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkBoosterItemStateChanged
        if (chkBooster.isSelected()) {
            int dif = r.diferenciaDeDias();
            if (dif >= 0) {
                r.setBooster((dif + 1) * 11);
            }
        } else {
            r.setBooster(0);
        }
        actualizarPrecioTotal();
    }//GEN-LAST:event_chkBoosterItemStateChanged

    private void chkSillaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkSillaItemStateChanged
        if (chkSilla.isSelected()) {
            int dif = r.diferenciaDeDias();
            if (dif >= 0) {
                r.setSilla((dif + 1) * 3);
            }
        } else {
            r.setSilla(0);
        }
        actualizarPrecioTotal();
    }//GEN-LAST:event_chkSillaItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RentarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RentarVehiculo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnrentar;
    private javax.swing.JCheckBox chkBooster;
    private javax.swing.JCheckBox chkGPS;
    private javax.swing.JCheckBox chkSilla;
    private javax.swing.JComboBox<String> cmbhoradev;
    private javax.swing.JComboBox<String> cmbhoraret;
    private javax.swing.JComboBox<String> cmboficinadev;
    private javax.swing.JComboBox<String> cmboficinaret;
    private com.toedter.calendar.JDateChooser dtdevolucion;
    private com.toedter.calendar.JDateChooser dtretiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JLabel lblinfo1;
    private javax.swing.JLabel lblplaca;
    private javax.swing.JLabel lblprecio;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lbltransmision;
    // End of variables declaration//GEN-END:variables
}
