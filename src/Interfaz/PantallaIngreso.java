package Interfaz;

import clases.ConexionDB;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author rploaiza
 */
public class PantallaIngreso extends javax.swing.JInternalFrame {

    public PantallaIngreso() {
        initComponents();
        this.ocultarBarraTitulo();
    }

    public void ocultarBarraTitulo() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtext_usuario = new javax.swing.JTextField();
        jtext_contraseña = new javax.swing.JPasswordField();

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1100, 530));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Consolas", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel1.setText("Usuario"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel2.setText("Contraseña"); // NOI18N

        jtext_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtext_contraseñaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtext_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jtext_contraseña))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtext_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtext_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel1.setBounds(320, 110, 320, 150);
        jDesktopPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1100)/2, (screenSize.height-530)/2, 1100, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void jtext_contraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtext_contraseñaKeyReleased
        // Comandos para al precionar enter ingrese al sistema:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            IngresoSistema(jtext_contraseña.getText().trim(), jtext_usuario.getText().trim());
        }
    }//GEN-LAST:event_jtext_contraseñaKeyReleased

    public void IngresoSistema(String usuario, String pass) {
        //Metodo con parametros que sera llamado para el ingreso
        
        PantallaBibliotecario pa = new PantallaBibliotecario();
        usuario = this.jtext_usuario.getText();
        pass = this.jtext_contraseña.getText();
       
        try {
            //conexion base de datos 
            ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
            Connection con = coneccion.obtenerConexion();
            String cons = "select * from ADMINISTRADOR where USUARIO_PER='" + usuario + "'"; // Manipulacion de tablas
            ResultSet consulta = coneccion.consulta(cons);
            consulta.next();
            if (consulta.getString(4).equals(usuario) && consulta.getString(5).equals(pass)) {
                JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
                this.jDesktopPane1.removeAll();
                this.jDesktopPane1.updateUI();
                this.jDesktopPane1.add(pa);
                pa.show();
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                jtext_contraseña.setText("");
                jtext_usuario.setText("");
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jtext_contraseña;
    private javax.swing.JTextField jtext_usuario;
    // End of variables declaration//GEN-END:variables
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
}
