package Interfaces;

import Herencia.Estilo;
import Herencia.Marca;
import Herencia.Modelo;
import Herencia.Usuario;
import Herencia.Vehiculos;
import Procedimientos.CRUD_vehiculos;
import Procedimientos.ListaVehiculos;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Carol
 */
public class BuscarVehiculo extends javax.swing.JFrame {

    boolean[] filtros = new boolean[6];
    DefaultListModel listModel;
    LinkedList<Vehiculos> vehiculos;
    Vehiculos vehiculo;
    Usuario usuario;

    /**
     * Creates new form BuscarVehiculo
     */
    public BuscarVehiculo() {
        initComponents();
        setLocationRelativeTo(null);
        listModel = new DefaultListModel();
        lista.setModel(listModel);
        lista.setCellRenderer(new ListaVehiculos());
        mostrarVehiculos();
        llenarCombos();

    }

    public BuscarVehiculo(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);
        listModel = new DefaultListModel();
        lista.setModel(listModel);
        lista.setCellRenderer(new ListaVehiculos());
        mostrarVehiculos();
        llenarCombos();
        this.usuario = usuario;
        System.out.println(this.usuario);
    }

    private void llenarCombos() {
        CRUD_vehiculos v = new CRUD_vehiculos();
        DefaultComboBoxModel<Marca> model1 = new DefaultComboBoxModel<Marca>();
        DefaultComboBoxModel<Estilo> model2 = new DefaultComboBoxModel<Estilo>();
        DefaultComboBoxModel<Modelo> model3 = new DefaultComboBoxModel<Modelo>();

        ArrayList<Marca> marcas = v.obtenerMarca();
        for (int i = 0; i < marcas.size(); i++) {
            model1.addElement(marcas.get(i));
        }
        cmbmarca.setModel(model1);

        ArrayList<Estilo> estilos = v.obtenerEstilo();
        for (int i = 0; i < estilos.size(); i++) {
            model2.addElement(estilos.get(i));
        }
        cmbestilo.setModel(model2);

        ArrayList<Modelo> modelos = v.obtenerModelo();
        for (int i = 0; i < modelos.size(); i++) {
            model3.addElement(modelos.get(i));
        }
        cmbmodelo.setModel(model3);
    }

    private void mostrarVehiculos() {
        filtro();
        establecerDatos();
        vehiculos = vehiculo.buscar(filtros);
        listModel.removeAllElements();
        if (vehiculos != null) {
            for (int i = 0; i < vehiculos.size(); i++) {
                listModel.addElement(vehiculos.get(i));
            }
        }
        if (listModel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado algún Resultado con esos Filtros!");
        }
    }

    private void filtro() {
        filtros[0] = chkano.isSelected();
        filtros[1] = chkestilo.isSelected();
        filtros[2] = chkmarca.isSelected();
        filtros[3] = chkmodelo.isSelected();
        filtros[4] = chkprecio.isSelected();
        filtros[5] = chktrasmision.isSelected();
    }

    private void establecerDatos() {
        vehiculo = new Vehiculos();
        Estilo estilo = (Estilo) cmbestilo.getSelectedItem();
        Marca marca = (Marca) cmbmarca.getSelectedItem();
        Modelo modelo = (Modelo) cmbmodelo.getSelectedItem();
        if (chkano.isSelected()) {
            vehiculo.setAño(txtano.getText());
        }
        if (chkestilo.isSelected()) {
            vehiculo.setCodigo_estilo(estilo.getCodigo_estilo());
        }
        if (chkmarca.isSelected()) {
            vehiculo.setCodigo_marca(marca.getCodigo_marca());
        }
        if (chkmodelo.isSelected()) {
            vehiculo.setCodigo_modelo(modelo.getCodigo_modelo());
        }
        if (chkprecio.isSelected()) {
            try {
                vehiculo.setPrecio(Double.parseDouble(txtprecio.getText()));
            } catch (NumberFormatException ex) {
                filtros[4] = false;
                txtprecio.setText("");
                chkprecio.setSelected(false);
            }
        }
        if (chktrasmision.isSelected()) {
            this.vehiculo.setTransmision_vehiculo((String) cmbtransmis.getSelectedItem());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chkmarca = new javax.swing.JCheckBox();
        chkmodelo = new javax.swing.JCheckBox();
        chkestilo = new javax.swing.JCheckBox();
        chktrasmision = new javax.swing.JCheckBox();
        chkano = new javax.swing.JCheckBox();
        chkprecio = new javax.swing.JCheckBox();
        txtano = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        cmbmarca = new javax.swing.JComboBox<>();
        cmbmodelo = new javax.swing.JComboBox<>();
        cmbestilo = new javax.swing.JComboBox<>();
        cmbtransmis = new javax.swing.JComboBox<>();
        lbllogout = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        chkmarca.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        chkmarca.setText("Marca");

        chkmodelo.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        chkmodelo.setText("Modelo");

        chkestilo.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        chkestilo.setText("Estilo");

        chktrasmision.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        chktrasmision.setText("Transmision");

        chkano.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        chkano.setText("Año");

        chkprecio.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        chkprecio.setText("Precio");

        txtano.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N

        txtprecio.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N

        btnbuscar.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbuscarMouseClicked(evt);
            }
        });

        cmbmarca.setEditable(true);

        cmbmodelo.setEditable(true);

        cmbestilo.setEditable(true);

        cmbtransmis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Autómatico" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chktrasmision)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbtransmis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkano)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkprecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkmarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkmodelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkestilo)
                        .addGap(18, 18, 18)
                        .addComponent(cmbestilo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkmarca)
                            .addComponent(chkmodelo)
                            .addComponent(chkestilo)
                            .addComponent(cmbmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbestilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chktrasmision)
                            .addComponent(chkano)
                            .addComponent(chkprecio)
                            .addComponent(txtano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtransmis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbllogout.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        lbllogout.setText("Cerrar sesión");
        lbllogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbllogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbllogoutMouseExited(evt);
            }
        });

        lista.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lista);

        jButton1.setFont(new java.awt.Font("Sitka Text", 3, 12)); // NOI18N
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbllogout, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbllogout)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbuscarMouseClicked
        mostrarVehiculos();
        chkmodelo.setSelected(false);
        chkmarca.setSelected(false);
        chkestilo.setSelected(false);
        chkprecio.setSelected(false);
        chktrasmision.setSelected(false);
        chkano.setSelected(false);
    }//GEN-LAST:event_btnbuscarMouseClicked

    private void lbllogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseEntered
        lbllogout.setForeground(new Color(80, 80, 80));
    }//GEN-LAST:event_lbllogoutMouseEntered

    private void lbllogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseExited
        lbllogout.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_lbllogoutMouseExited

    private void lbllogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseClicked
        Login l = new Login(this, true);
        l.pack();
        this.dispose();
        l.setVisible(true);
    }//GEN-LAST:event_lbllogoutMouseClicked

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        JOptionPane.showMessageDialog(null, lista.getSelectedValue());
        int i = lista.getSelectedIndex();
        Vehiculos vv = vehiculos.get(i);
        RentarVehiculo renta = new RentarVehiculo(usuario, vv);
        renta.setVisible(true);
        dispose();
    }//GEN-LAST:event_listaValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Aqui la parte de renta de un vehiculo
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BuscarVehiculo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JCheckBox chkano;
    private javax.swing.JCheckBox chkestilo;
    private javax.swing.JCheckBox chkmarca;
    private javax.swing.JCheckBox chkmodelo;
    private javax.swing.JCheckBox chkprecio;
    private javax.swing.JCheckBox chktrasmision;
    private javax.swing.JComboBox<Estilo> cmbestilo;
    private javax.swing.JComboBox<Marca> cmbmarca;
    private javax.swing.JComboBox<Modelo> cmbmodelo;
    private javax.swing.JComboBox<String> cmbtransmis;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField txtano;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
