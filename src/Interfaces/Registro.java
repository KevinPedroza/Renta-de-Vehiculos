package Interfaces;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Herencia.Usuario;
import Procedimientos.Instancias;
import Procedimientos.LoginUser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
this jform will let add a new customner or administrator to the data base 
 */
public class Registro extends javax.swing.JDialog {

    private Usuario usuario;
    Instancias instancias = new Instancias();
    LoginUser user = new LoginUser();

    /**
     * Creates new form Registro
     */
    public Registro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        usuario = new Usuario();
        setLocationRelativeTo(null);
        this.setTitle("Registro Usuario");
        user.verificarAdmi();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblfoto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnfoto = new javax.swing.JButton();
        txtcontrasena = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        Administrador_check = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");

        btnguardar.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel4.setText("Teléfono");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel5.setText("Dirección");

        txtnombre.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N

        txtcedula.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N

        txttelefono.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N

        txtdireccion.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        jLabel2.setText("Cédula");

        btnfoto.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        btnfoto.setText("Agregar foto");
        btnfoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnfotoMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jButton1.setText("Atrás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Administrador_check.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        Administrador_check.setText("Administrador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcedula)
                                    .addComponent(txtnombre)
                                    .addComponent(txttelefono)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(txtcontrasena)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 112, Short.MAX_VALUE)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnfoto, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Administrador_check))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(Administrador_check))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(76, 76, 76)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfotoMouseClicked
        lblfoto.setIcon(null);
        JFileChooser f = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, gif o png", "jpg", "gif", "png");
        f.setFileFilter(filter);
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        f.setDialogTitle("Seleccionar foto del usuario");
        f.setCurrentDirectory(new File("C:/Users/DELL/Pictures"));
        int res = f.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                usuario.setFoto(new FileInputStream(f.getSelectedFile()));
                usuario.setUrl(f.getSelectedFile().getAbsolutePath());
                Image foto = ImageIO.read(f.getSelectedFile()).getScaledInstance(lblfoto.getWidth(), lblfoto.getHeight(), Image.SCALE_DEFAULT);
                lblfoto.setIcon(new ImageIcon(foto));
                lblfoto.updateUI();
            } catch (IOException e) {

            }
        }
    }//GEN-LAST:event_btnfotoMouseClicked

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked
        usuario.setCedula(txtcedula.getText());
        usuario.setNombre(txtnombre.getText());
        usuario.setTelefono(txttelefono.getText());
        usuario.setDireccion(txtdireccion.getText());
        usuario.setContrasena(new String(txtcontrasena.getPassword()));
        if (Administrador_check.isSelected()) {
            usuario.setTipo("v");
        } else {
            usuario.setTipo("c");
        }

        if (validarDatos()) {
            boolean res = usuario.registrar();
            if (res) {
                this.dispose();
                JOptionPane.showMessageDialog(null, "Se registró el usuario exitosamente");
                instancias.Login();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos para registrar al usuario");
        }
    }//GEN-LAST:event_btnguardarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        instancias.Login();
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean validarDatos() {
        if ("".equals(usuario.getCedula())) {
            return false;
        }
        if ("".equals(usuario.getNombre())) {
            return false;
        }
        if ("".equals(usuario.getTelefono())) {
            return false;
        }
        if ("".equals(usuario.getContrasena())) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JCheckBox Administrador_check;
    private javax.swing.JButton btnfoto;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JPasswordField txtcontrasena;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
