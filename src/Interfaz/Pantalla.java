package Interfaz;

import clases.ConexionDB;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rploaiza
 */
public class Pantalla extends javax.swing.JInternalFrame {

    public Pantalla() {
        // Mostrar los Frame
        initComponents();
//        mostrardatos("");
        this.ocultarBarraTitulo();
        this.jestudiante.setVisible(false);
        this.jautores.setVisible(false);
        this.jeditor.setVisible(false);
        this.jpersonal.setVisible(false);
    }

    void mostrardatosest(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("COD ESTUDIANTE");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("EMAIL");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("COD DE CARRERA");
        modelo.addColumn("CICLO");
        modelo.addColumn("AREA");
        modelo.addColumn("CARRERA");
        JTablaEst.setModel(modelo);
        String sql = ("SELECT * FROM ESTUDIANTE, ACADEMICO WHERE ESTUDIANTE.CED_EST = ACADEMICO.CED_EST AND ESTUDIANTE.CED_EST LIKE'" + valor + "'");

        String[] datos = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                //datos[5] = rs.getString(6);
                datos[5] = rs.getString(7);
                datos[6] = rs.getString(8);
                datos[7] = rs.getString(9);
                datos[8] = rs.getString(10);
                modelo.addRow(datos);
            }
            JTablaEst.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatosbib(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CARGO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("EMAIL");
        tbibliotecario.setModel(modelo);
        String sql = ("SELECT * FROM PERSONAL_BIBLIOTECA WHERE BIB_COD LIKE'" + valor + "'");

        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(3);
                datos[1] = rs.getString(4);
                datos[2] = rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);

                modelo.addRow(datos);
            }
            tbibliotecario.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatoaut(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("COD AUTOR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("PAIS");
        modelo.addColumn("EMAIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("PUBLICACIONES");
        tautor.setModel(modelo);
        String sql = ("SELECT * FROM AUTORES WHERE AUTOR_ID LIKE'" + valor + "'");
        String[] datos = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
            }
            tautor.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatoedi(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("COD EDITORIAL");
        modelo.addColumn("COD AUTOR");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("EMAIL");
        modelo.addColumn("CIUDAD");
        modelo.addColumn("PAIS");
        modelo.addColumn("SUC TELEFONO");
        modelo.addColumn("SUC LUGAR");
        modelo.addColumn("SUC CANT");
        modelo.addColumn("SUC EMAIL");
        teditorial.setModel(modelo);
        String sql = ("SELECT * FROM EDITORIAL, SUCURSALES WHERE EDITORIAL.COD_EDITORIAL = SUCURSALES.COD_EDITORIAL AND EDITORIAL.COD_EDITORIAL LIKE'" + valor + "'");
        String[] datos = new String[11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(9);
                datos[8] = rs.getString(11);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(12);
                modelo.addRow(datos);
            }
            teditorial.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        estudiante = new javax.swing.JButton();
        autores = new javax.swing.JButton();
        editorial = new javax.swing.JButton();
        personal = new javax.swing.JButton();
        escritorioAdmin = new javax.swing.JDesktopPane();
        jestudiante = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbguardar = new javax.swing.JButton();
        jcodcarrera = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jciclo = new javax.swing.JTextField();
        COD_EST = new javax.swing.JTextField();
        jlencabezado_empleado = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jarea = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtelefono = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        japellido = new javax.swing.JTextField();
        jnombre = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jcarrera = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTablaEst = new javax.swing.JTable();
        Modificar = new javax.swing.JButton();
        jautores = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        nom_aut = new javax.swing.JTextField();
        ape_aut = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        direccion_aut = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cod_aut = new javax.swing.JTextField();
        jemail1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        aut_pais = new javax.swing.JTextField();
        Mostrar = new javax.swing.JButton();
        jbguardar_ed = new javax.swing.JButton();
        mod_autor = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tautor = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        publicacion_aut = new javax.swing.JTextField();
        jlencabezado_empleado1 = new javax.swing.JLabel();
        jpersonal = new javax.swing.JInternalFrame();
        bib_nombre = new javax.swing.JTextField();
        Mostrar2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        bib_telefono = new javax.swing.JTextField();
        mod_autor2 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        bib_cargo = new javax.swing.JTextField();
        bib_email = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbibliotecario = new javax.swing.JTable();
        Guarda_bibliotecario = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bib_apellido = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        cod_bibliotecario = new javax.swing.JTextField();
        jlencabezado_empleado2 = new javax.swing.JLabel();
        jeditor = new javax.swing.JInternalFrame();
        Mostrar1 = new javax.swing.JButton();
        edi_nombre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        mod_autor1 = new javax.swing.JButton();
        edi_ciudad = new javax.swing.JTextField();
        edi_email = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        teditorial = new javax.swing.JTable();
        edi_pais = new javax.swing.JTextField();
        Guardar_Editor = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        edi_telefono = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cod_editorial = new javax.swing.JTextField();
        suc_lugar = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        suc_email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        suc_cant = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        edi_suc_telefono = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cod_aut2 = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jMenuItem1.setText("Editar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Editar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem3);

        jMenuItem4.setText("Eliminar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem4);

        jMenuItem5.setText("Editar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu3.add(jMenuItem5);

        jMenuItem6.setText("Eliminar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu3.add(jMenuItem6);

        jMenuItem7.setText("Editar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu4.add(jMenuItem7);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(1117, 539));

        estudiante.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        estudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Personal.png"))); // NOI18N
        estudiante.setText("Estudiante"); // NOI18N
        estudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudianteActionPerformed(evt);
            }
        });

        autores.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        autores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Personal.png"))); // NOI18N
        autores.setText("Autores"); // NOI18N
        autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoresActionPerformed(evt);
            }
        });

        editorial.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        editorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        editorial.setText("Editorial"); // NOI18N
        editorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialActionPerformed(evt);
            }
        });

        personal.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salario.png"))); // NOI18N
        personal.setText("Personal"); // NOI18N
        personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalActionPerformed(evt);
            }
        });

        escritorioAdmin.setPreferredSize(new java.awt.Dimension(1100, 530));
        escritorioAdmin.setLayout(null);

        jestudiante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jestudiante.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        jestudiante.setEnabled(false);
        jestudiante.setPreferredSize(new java.awt.Dimension(700, 460));
        jestudiante.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel1.setText("COD"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel2.setText("Nombre"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel4.setText("Apellido"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel6.setText("Telefono"); // NOI18N

        jbguardar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar.setText("Guardar"); // NOI18N
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jcodcarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcodcarreraKeyTyped(evt);
            }
        });

        jemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jemailKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel25.setText("Carrera"); // NOI18N

        jciclo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcicloKeyTyped(evt);
            }
        });

        COD_EST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                COD_ESTKeyTyped(evt);
            }
        });

        jlencabezado_empleado.setText("FORMULARIO ESTUDIANTE");

        jLabel29.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel29.setText("Area"); // NOI18N

        jarea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jareaKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel14.setText("COD CARRERA"); // NOI18N

        jtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtelefonoKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel30.setText("Email"); // NOI18N

        japellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                japellidoKeyTyped(evt);
            }
        });

        jnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jnombreKeyTyped(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel33.setText("Ciclo"); // NOI18N

        jcarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcarreraKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JTablaEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTablaEst.setComponentPopupMenu(jPopupMenu2);
        jScrollPane2.setViewportView(JTablaEst);

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edi.png"))); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jestudianteLayout = new javax.swing.GroupLayout(jestudiante.getContentPane());
        jestudiante.getContentPane().setLayout(jestudianteLayout);
        jestudianteLayout.setHorizontalGroup(
            jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jestudianteLayout.createSequentialGroup()
                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(jlencabezado_empleado))
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jestudianteLayout.createSequentialGroup()
                                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jestudianteLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jestudianteLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(39, 39, 39)
                                        .addComponent(COD_EST, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)))
                                .addGap(18, 18, 18)
                                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jestudianteLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel25))))
                                .addGap(82, 82, 82)
                                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jciclo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jcodcarrera)
                                        .addComponent(jcarrera)
                                        .addComponent(jarea, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jestudianteLayout.createSequentialGroup()
                                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jemail)
                                    .addComponent(japellido)
                                    .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jestudianteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jbguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343))
        );
        jestudianteLayout.setVerticalGroup(
            jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jestudianteLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jlencabezado_empleado)
                .addGap(80, 80, 80)
                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jestudianteLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(japellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)))
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(COD_EST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel14)
                                .addComponent(jcodcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jciclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addGroup(jestudianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jestudianteLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Modificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jestudianteLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbguardar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        escritorioAdmin.add(jestudiante);
        jestudiante.setBounds(0, 0, 1230, 560);

        jautores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jautores.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jautores.setEnabled(false);
        jautores.setPreferredSize(new java.awt.Dimension(600, 600));
        jautores.setVisible(true);

        nom_aut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nom_autKeyTyped(evt);
            }
        });

        ape_aut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ape_autKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel15.setText("Pais"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel5.setText("Apellido"); // NOI18N

        direccion_aut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                direccion_autKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel31.setText("Email"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel3.setText("COD"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel13.setText("Nombre"); // NOI18N

        cod_aut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cod_autKeyTyped(evt);
            }
        });

        jemail1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jemail1KeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel32.setText("Direccion"); // NOI18N

        aut_pais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                aut_paisKeyTyped(evt);
            }
        });

        Mostrar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        Mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });

        jbguardar_ed.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar_ed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar_ed.setText("Guardar"); // NOI18N
        jbguardar_ed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar_edActionPerformed(evt);
            }
        });

        mod_autor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edi.png"))); // NOI18N
        mod_autor.setText("Modificar");
        mod_autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod_autorActionPerformed(evt);
            }
        });

        jScrollPane5.setComponentPopupMenu(jPopupMenu1);

        tautor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tautor.setComponentPopupMenu(jPopupMenu1);
        jScrollPane5.setViewportView(tautor);

        jLabel34.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel34.setText("Nº Publicaciones"); // NOI18N

        publicacion_aut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                publicacion_autKeyTyped(evt);
            }
        });

        jlencabezado_empleado1.setText("FORMULARIO AUTORES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Mostrar)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(mod_autor)
                        .addGap(36, 36, 36)
                        .addComponent(jbguardar_ed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlencabezado_empleado1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(aut_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel32)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(direccion_aut, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(publicacion_aut, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(99, 99, 99)))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(nom_aut, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(39, 39, 39)
                            .addComponent(cod_aut, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel31))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ape_aut, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addComponent(jemail1))))
                    .addContainerGap(571, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlencabezado_empleado1)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mostrar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(aut_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34)
                        .addComponent(publicacion_aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(direccion_aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mod_autor)
                            .addComponent(jbguardar_ed))
                        .addGap(144, 144, 144))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(nom_aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(ape_aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod_aut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGap(28, 28, 28)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(jemail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(112, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jautoresLayout = new javax.swing.GroupLayout(jautores.getContentPane());
        jautores.getContentPane().setLayout(jautoresLayout);
        jautoresLayout.setHorizontalGroup(
            jautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jautoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jautoresLayout.setVerticalGroup(
            jautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jautoresLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        escritorioAdmin.add(jautores);
        jautores.setBounds(0, 0, 1230, 550);

        jpersonal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpersonal.setEnabled(false);
        jpersonal.setPreferredSize(new java.awt.Dimension(600, 600));
        jpersonal.setVisible(true);

        bib_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bib_nombreKeyTyped(evt);
            }
        });

        Mostrar2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        Mostrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        Mostrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mostrar2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel19.setText("Nombre"); // NOI18N

        bib_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bib_telefonoKeyTyped(evt);
            }
        });

        mod_autor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edi.png"))); // NOI18N
        mod_autor2.setText("Modificar");
        mod_autor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod_autor2ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel41.setText("Cargo"); // NOI18N

        bib_cargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bib_cargoKeyTyped(evt);
            }
        });

        bib_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bib_emailKeyTyped(evt);
            }
        });

        jScrollPane7.setComponentPopupMenu(jPopupMenu4);

        tbibliotecario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbibliotecario.setComponentPopupMenu(jPopupMenu4);
        jScrollPane7.setViewportView(tbibliotecario);

        Guarda_bibliotecario.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        Guarda_bibliotecario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        Guarda_bibliotecario.setText("Guardar"); // NOI18N
        Guarda_bibliotecario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guarda_bibliotecarioActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel21.setText("COD Bibliotecario"); // NOI18N

        jLabel22.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel22.setText("Apellido"); // NOI18N

        jLabel23.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel23.setText("Email"); // NOI18N

        bib_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bib_apellidoKeyTyped(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel42.setText("Telefono"); // NOI18N

        cod_bibliotecario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cod_bibliotecarioKeyTyped(evt);
            }
        });

        jlencabezado_empleado2.setText("FORMULARIO BIBLIOTECARIO");

        javax.swing.GroupLayout jpersonalLayout = new javax.swing.GroupLayout(jpersonal.getContentPane());
        jpersonal.getContentPane().setLayout(jpersonalLayout);
        jpersonalLayout.setHorizontalGroup(
            jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpersonalLayout.createSequentialGroup()
                .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpersonalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpersonalLayout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cod_bibliotecario))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpersonalLayout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(18, 18, 18)
                                    .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bib_telefono)
                                        .addComponent(bib_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(Mostrar2)
                        .addGap(29, 29, 29)
                        .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpersonalLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(40, 40, 40)
                                .addComponent(bib_email, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpersonalLayout.createSequentialGroup()
                                .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel41))
                                .addGap(18, 18, 18)
                                .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bib_nombre)
                                    .addComponent(bib_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jpersonalLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(mod_autor2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(Guarda_bibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpersonalLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpersonalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlencabezado_empleado2)
                        .addGap(455, 455, 455)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpersonalLayout.setVerticalGroup(
            jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpersonalLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlencabezado_empleado2)
                .addGap(18, 18, 18)
                .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpersonalLayout.createSequentialGroup()
                        .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cod_bibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(bib_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(bib_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Mostrar2)
                        .addGroup(jpersonalLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(bib_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel41)
                                .addComponent(bib_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(bib_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jpersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mod_autor2)
                    .addComponent(Guarda_bibliotecario))
                .addGap(109, 109, 109))
        );

        escritorioAdmin.add(jpersonal);
        jpersonal.setBounds(0, 0, 1230, 550);

        jeditor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jeditor.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jeditor.setEnabled(false);
        jeditor.setPreferredSize(new java.awt.Dimension(600, 600));
        jeditor.setVisible(true);

        Mostrar1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        Mostrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        Mostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mostrar1ActionPerformed(evt);
            }
        });

        edi_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edi_nombreKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel17.setText("Nombre"); // NOI18N

        mod_autor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edi.png"))); // NOI18N
        mod_autor1.setText("Modificar");
        mod_autor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod_autor1ActionPerformed(evt);
            }
        });

        edi_ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edi_ciudadKeyTyped(evt);
            }
        });

        edi_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edi_emailKeyTyped(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel35.setText("Email"); // NOI18N

        jScrollPane6.setComponentPopupMenu(jPopupMenu3);

        teditorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        teditorial.setComponentPopupMenu(jPopupMenu3);
        jScrollPane6.setViewportView(teditorial);

        edi_pais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edi_paisKeyTyped(evt);
            }
        });

        Guardar_Editor.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        Guardar_Editor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        Guardar_Editor.setText("Guardar"); // NOI18N
        Guardar_Editor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_EditorActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel8.setText("Telefono"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel7.setText("COD EDITORIAL"); // NOI18N

        edi_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edi_telefonoKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel16.setText("Pais"); // NOI18N

        jLabel37.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel37.setText("Ciudad"); // NOI18N

        cod_editorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cod_editorialKeyTyped(evt);
            }
        });

        suc_lugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suc_lugarKeyTyped(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel36.setText("Email"); // NOI18N

        suc_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suc_emailKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel9.setText("Telefono"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel10.setText("Nº Sucursales"); // NOI18N

        suc_cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                suc_cantKeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel38.setText("Lugar"); // NOI18N

        edi_suc_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edi_suc_telefonoKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel18.setText("COD AUTOR"); // NOI18N

        cod_aut2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cod_aut2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jeditorLayout = new javax.swing.GroupLayout(jeditor.getContentPane());
        jeditor.getContentPane().setLayout(jeditorLayout);
        jeditorLayout.setHorizontalGroup(
            jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jeditorLayout.createSequentialGroup()
                .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jeditorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jeditorLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cod_editorial))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jeditorLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(edi_ciudad)
                                        .addComponent(edi_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(Mostrar1)
                        .addGap(29, 29, 29)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jeditorLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(40, 40, 40)
                                .addComponent(edi_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jeditorLayout.createSequentialGroup()
                                .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel35))
                                .addGap(18, 18, 18)
                                .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edi_nombre)
                                    .addComponent(edi_email, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(cod_aut2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jeditorLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jeditorLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jeditorLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edi_suc_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jeditorLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(suc_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38))
                        .addGap(25, 25, 25)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(suc_email)
                            .addComponent(suc_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jeditorLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(mod_autor1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(Guardar_Editor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jeditorLayout.setVerticalGroup(
            jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jeditorLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jeditorLayout.createSequentialGroup()
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cod_editorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(edi_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(edi_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Mostrar1)
                        .addGroup(jeditorLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(edi_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(cod_aut2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(14, 14, 14)
                            .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel35)
                                .addComponent(edi_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(edi_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jeditorLayout.createSequentialGroup()
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(edi_suc_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(suc_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jeditorLayout.createSequentialGroup()
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(suc_lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(suc_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jeditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mod_autor1)
                    .addComponent(Guardar_Editor))
                .addGap(109, 109, 109))
        );

        escritorioAdmin.add(jeditor);
        jeditor.setBounds(0, 0, 1230, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(personal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(autores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estudiante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(escritorioAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(autores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editorial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(personal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorioAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void autoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoresActionPerformed

        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jautores);
        jautores.show();
    }//GEN-LAST:event_autoresActionPerformed

    private void estudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudianteActionPerformed

        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jestudiante);
        jestudiante.show();
    }//GEN-LAST:event_estudianteActionPerformed

    private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalActionPerformed
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jpersonal);
        jpersonal.show();
    }//GEN-LAST:event_personalActionPerformed

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        // TODO add your handling code here:
        String cod_est, nombre, carrera, apellido, email, telefono, codcarrera, area, ciclo;
        boolean flag = true;

        if (COD_EST.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el codigo del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jcarrera.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la carrera del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jnombre.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (japellido.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el apellido del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jemail.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el email del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jtelefono.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el telefono del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jcodcarrera.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese codigo de la carrera", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jarea.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el area academica", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jciclo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ciclo academico que estudia", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            cod_est = this.COD_EST.getText();
            carrera = this.jcarrera.getText();
            nombre = this.jnombre.getText();
            apellido = this.japellido.getText();
            email = this.jemail.getText();
            telefono = this.jtelefono.getText();
            codcarrera = this.jcodcarrera.getText();
            area = this.jarea.getText();
            ciclo = this.jciclo.getText();

            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into ACADEMICO values(?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, cod_est);
                datos.setString(2, codcarrera);
                datos.setString(3, ciclo);
                datos.setString(4, area);
                datos.setString(5, carrera);
                datos.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInse = "insert into ESTUDIANTE values(?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement dat = con.prepareStatement(sInse);

                dat.setString(1, cod_est);
                dat.setString(2, nombre);
                dat.setString(3, apellido);
                dat.setString(4, email);
                dat.setString(5, telefono);
                dat.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            jcodcarrera.setText("");
            COD_EST.setText("");
            jemail.setText("");
            jtelefono.setText("");
            jcarrera.setText("");
            jciclo.setText("");
            jarea.setText("");
            jnombre.setText("");
            jcodcarrera.setText("");
            japellido.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jbguardar_edActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar_edActionPerformed
        // TODO add your handling code here: 
        String codaut, nombre, apellido, email, pais, direccion, publicacion;
        boolean flag = true;
        if (cod_aut.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el codigo del autor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (nom_aut.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre del autor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (ape_aut.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el apellido del autor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jemail1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el email del autor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (aut_pais.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el pais del autor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (direccion_aut.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la direccion del autor", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (publicacion_aut.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el numero de publicaciones del autor ", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            codaut = this.cod_aut.getText();
            nombre = this.nom_aut.getText();
            apellido = this.ape_aut.getText();
            pais = this.aut_pais.getText();
            email = this.jemail1.getText();
            direccion = this.direccion_aut.getText();
            publicacion = this.publicacion_aut.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into AUTORES values(?,?,?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, codaut);
                datos.setString(2, nombre);
                datos.setString(3, apellido);
                datos.setString(4, pais);
                datos.setString(5, email);
                datos.setString(6, direccion);
                datos.setString(7, publicacion);
                datos.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            cod_aut.setText("");
            nom_aut.setText("");
            ape_aut.setText("");
            jemail1.setText("");
            aut_pais.setText("");
            direccion_aut.setText("");
            publicacion_aut.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jbguardar_edActionPerformed

    private void COD_ESTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_COD_ESTKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar(); //coje caracter ingresado
        if (((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (COD_EST.getText().length() == 8) {
            evt.consume();
        }
    }//GEN-LAST:event_COD_ESTKeyTyped

    private void jcodcarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodcarreraKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar(); //coje caracter ingresado
        if (((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jcodcarreraKeyTyped

    private void jemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemailKeyTyped

    }//GEN-LAST:event_jemailKeyTyped

    private void editorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialActionPerformed
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jeditor);
        jeditor.show();
    }//GEN-LAST:event_editorialActionPerformed

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
        // TODO add your handling code here:
        mostrardatoaut(cod_aut.getText());
    }//GEN-LAST:event_MostrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila = tautor.getSelectedRow();
        if (fila >= 0) {
            cod_aut.setText(tautor.getValueAt(fila, 0).toString());
            nom_aut.setText(tautor.getValueAt(fila, 1).toString());
            ape_aut.setText(tautor.getValueAt(fila, 2).toString());
            aut_pais.setText(tautor.getValueAt(fila, 3).toString());
            jemail1.setText(tautor.getValueAt(fila, 4).toString());
            direccion_aut.setText(tautor.getValueAt(fila, 5).toString());
            publicacion_aut.setText(tautor.getValueAt(fila, 6).toString());
        } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila = tautor.getSelectedRow();
        String valor = "";
        valor = tautor.getValueAt(fila, 0).toString();

        int exit = JOptionPane.showConfirmDialog(this, "<html><font face=\"Consolas\"> <i>Esta seguro que desea <u><b>eliminar</b></u> ?<i/></font>", "Sistema", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM AUTORES WHERE  AUTOR_ID='" + valor + "'");
                pst.executeUpdate();
                mostrardatoaut("");
            } catch (Exception e) {
            }
            // JOptionPane.showConfirmDialog(TEditar, exit, null, WIDTH);
            //  JOptionPane.showConfirmDialog(panelNice1, a, null, WIDTH);
        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jcicloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcicloKeyTyped
        int k = (int) evt.getKeyChar(); //coje caracter ingresado
        if (((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
        if (jciclo.getText().length() == 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jcicloKeyTyped

    private void jareaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jareaKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jareaKeyTyped

    private void jtelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtelefonoKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar(); //coje caracter ingresado
        if (((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtelefonoKeyTyped

    private void japellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_japellidoKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_japellidoKeyTyped

    private void jnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnombreKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jnombreKeyTyped

    private void jcarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcarreraKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jcarreraKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrardatosest(COD_EST.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        int fila = JTablaEst.getSelectedRow();
        if (fila >= 0) {
            COD_EST.setText(JTablaEst.getValueAt(fila, 0).toString());
            jnombre.setText(JTablaEst.getValueAt(fila, 1).toString());
            japellido.setText(JTablaEst.getValueAt(fila, 2).toString());
            jemail.setText(JTablaEst.getValueAt(fila, 3).toString());
            jtelefono.setText(JTablaEst.getValueAt(fila, 4).toString());
            jcodcarrera.setText(JTablaEst.getValueAt(fila, 5).toString());
            jarea.setText(JTablaEst.getValueAt(fila, 6).toString());
            jciclo.setText(JTablaEst.getValueAt(fila, 7).toString());
            jcarrera.setText(JTablaEst.getValueAt(fila, 8).toString());
        } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        int fila = JTablaEst.getSelectedRow();
        String valor = "";
        valor = JTablaEst.getValueAt(fila, 0).toString();

        int exit = JOptionPane.showConfirmDialog(this, "<html><font face=\"Consolas\"> <i>Esta seguro que desea <u><b>eliminar</b></u> ?<i/></font>", "Sistema", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE a1, a2 FROM ESTUDIANTE AS a1 INNER JOIN ACADEMICO AS a2 WHERE a1.CED_EST=a2.CED_EST AND a1.CED_EST LIKE'" + valor + "'");
                pst.executeUpdate();
                mostrardatosest("");
                COD_EST.setText("");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE ESTUDIANTE, ACADEMICO SET EST_NOMBRE='" + jnombre.getText()
                    + "',EST_APELLIDO='" + japellido.getText()
                    + "',EST_EMAIL='" + jemail.getText()
                    + "',EST_TELEFONO='" + jtelefono.getText()
                    + "',COD_CARRERA='" + jcodcarrera.getText()
                    + "',EST_CICLO_CURSA='" + jarea.getText()
                    + "',EST_AREA='" + jciclo.getText()
                    + "',EST_CARRERA='" + jcarrera.getText()
                    + "' WHERE ESTUDIANTE.CED_EST=ACADEMICO.CED_EST AND ESTUDIANTE.CED_EST LIKE'" + COD_EST.getText() + "'");
            pst.executeUpdate();
            mostrardatosest("");
            JOptionPane.showMessageDialog(null, "Cambios Guardados ");
            jnombre.setText("");
            japellido.setText("");
            jemail.setText("");
            jtelefono.setText("");
            jcodcarrera.setText("");
            jarea.setText("");
            jciclo.setText("");
            jcarrera.setText("");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }//GEN-LAST:event_ModificarActionPerformed

    private void nom_autKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_autKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nom_autKeyTyped

    private void ape_autKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ape_autKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ape_autKeyTyped

    private void direccion_autKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_direccion_autKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_direccion_autKeyTyped

    private void cod_autKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_autKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_autKeyTyped

    private void jemail1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jemail1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jemail1KeyTyped

    private void aut_paisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aut_paisKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aut_paisKeyTyped

    private void mod_autorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod_autorActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE AUTORES SET AUT_NOMBRE='" + nom_aut.getText()
                    + "',AUT_APELLID='" + ape_aut.getText()
                    + "',AUT_PAIS='" + aut_pais.getText()
                    + "',AUT_EMAIL='" + jemail1.getText()
                    + "',AUT_DIRECCION='" + direccion_aut.getText()
                    + "',AUT_N_PUBLICACION='" + publicacion_aut.getText()
                    + "' WHERE AUTOR_ID='" + cod_aut.getText() + "'");
            pst.executeUpdate();
            mostrardatoaut("");
            JOptionPane.showMessageDialog(null, "Cambios Guardados ");
            nom_aut.setText("");
            ape_aut.setText("");
            aut_pais.setText("");
            jemail1.setText("");
            direccion_aut.setText("");
            publicacion_aut.setText("");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_mod_autorActionPerformed

    private void publicacion_autKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publicacion_autKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_publicacion_autKeyTyped

    private void cod_editorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_editorialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_editorialKeyTyped

    private void edi_paisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edi_paisKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_edi_paisKeyTyped

    private void edi_ciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edi_ciudadKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_edi_ciudadKeyTyped

    private void edi_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edi_nombreKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_edi_nombreKeyTyped

    private void edi_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edi_telefonoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_edi_telefonoKeyTyped

    private void edi_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edi_emailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_edi_emailKeyTyped

    private void mod_autor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod_autor1ActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE EDITORIAL, SUCURSALES SET AUTOR_ID='" + cod_aut2.getText()
                    + "',EDI_NOMBRE='" + edi_pais.getText()
                    + "',EDI_TELEFONO='" + edi_telefono.getText()
                    + "',EDI_EMAIL='" + edi_email.getText()
                    + "',EDI_CIUDAD='" + edi_ciudad.getText()
                    + "',EDI_PAIS='" + edi_pais.getText()
                    + "',EDI_SUCURSAL_TELEFONO='" + edi_suc_telefono.getText()
                    + "',EDI_SUCURSALES='" + suc_cant.getText()
                    + "',EDI_LUGAR_SUCURSAL='" + suc_lugar.getText()
                    + "',EDI_SUCURSAL_EMAIL='" + suc_email.getText()
                    + "' WHERE EDITORIAL.COD_EDITORIAL=SUCURSALES.COD_EDITORIAL AND EDITORIAL.COD_EDITORIAL LIKE'" + cod_editorial.getText() + "'");
            pst.executeUpdate();
            mostrardatosest("");
            JOptionPane.showMessageDialog(null, "Cambios Guardados ");
            jnombre.setText("");
            japellido.setText("");
            jemail.setText("");
            jtelefono.setText("");
            jcodcarrera.setText("");
            jarea.setText("");
            jciclo.setText("");
            jcarrera.setText("");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }//GEN-LAST:event_mod_autor1ActionPerformed

    private void Guardar_EditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_EditorActionPerformed
        // TODO add your handling code here:
        String codedi, nombre, telefono, email, ciudad, pais, telf, sucursal, lugar, email_suc, cod;
        boolean flag = true;
        if (cod_editorial.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el codigo de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (edi_nombre.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (edi_telefono.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el telefono de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (edi_email.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el email de la editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (edi_ciudad.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la ciudad de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (edi_pais.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el pais de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (edi_suc_telefono.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el telefono de sucursal", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (suc_cant.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese cantidad de sucursales", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (suc_lugar.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese lugar de sucursal", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (suc_email.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el email de sucursal", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            codedi = this.cod_editorial.getText();
            nombre = this.edi_nombre.getText();
            telefono = this.edi_telefono.getText();
            email = this.edi_email.getText();
            ciudad = this.edi_ciudad.getText();
            pais = this.edi_pais.getText();
            telf = this.edi_suc_telefono.getText();
            sucursal = this.suc_cant.getText();
            lugar = this.suc_lugar.getText();
            email_suc = this.suc_email.getText();
            cod = this.cod_aut2.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into EDITORIAL values(?,?,?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, codedi);
                datos.setString(2, cod);
                datos.setString(3, nombre);
                datos.setString(4, telefono);
                datos.setString(5, email);
                datos.setString(6, ciudad);
                datos.setString(7, pais);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            
             try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into PERSONAL_BIBLIOTECA (ID_ADM) values(?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, codedi);
                
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInse = "insert into SUCURSALES values(?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement dat = con.prepareStatement(sInse);
                dat.setString(1, codedi);
                dat.setString(2, telf);
                dat.setString(3, sucursal);
                dat.setString(4, lugar);
                dat.setString(5, email_suc);
                dat.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            edi_nombre.setText("");
            cod_aut2.setText("");
            edi_suc_telefono.setText("");
            edi_telefono.setText("");
            edi_email.setText("");
            edi_ciudad.setText("");
            edi_pais.setText("");
            suc_lugar.setText("");
            suc_cant.setText("");
            suc_email.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Guardar_EditorActionPerformed

    private void Mostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mostrar1ActionPerformed
        // TODO add your handling code here:               
        mostrardatoedi(cod_editorial.getText());
    }//GEN-LAST:event_Mostrar1ActionPerformed

    private void suc_lugarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suc_lugarKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_suc_lugarKeyTyped

    private void suc_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suc_emailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_suc_emailKeyTyped

    private void suc_cantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suc_cantKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_suc_cantKeyTyped

    private void edi_suc_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edi_suc_telefonoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_edi_suc_telefonoKeyTyped

    private void cod_aut2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_aut2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_aut2KeyTyped

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        int fila = teditorial.getSelectedRow();
        if (fila >= 0) {
            cod_editorial.setText(teditorial.getValueAt(fila, 0).toString());
            cod_aut2.setText(teditorial.getValueAt(fila, 1).toString());
            edi_nombre.setText(teditorial.getValueAt(fila, 2).toString());
            edi_telefono.setText(teditorial.getValueAt(fila, 3).toString());
            edi_email.setText(teditorial.getValueAt(fila, 4).toString());
            edi_ciudad.setText(teditorial.getValueAt(fila, 5).toString());
            edi_pais.setText(teditorial.getValueAt(fila, 6).toString());
            edi_suc_telefono.setText(teditorial.getValueAt(fila, 7).toString());
            suc_lugar.setText(teditorial.getValueAt(fila, 8).toString());
            suc_cant.setText(teditorial.getValueAt(fila, 9).toString());
            suc_email.setText(teditorial.getValueAt(fila, 10).toString());
        } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        int fila = teditorial.getSelectedRow();
        String valor = "";
        valor = teditorial.getValueAt(fila, 0).toString();

        int exit = JOptionPane.showConfirmDialog(this, "<html><font face=\"Consolas\"> <i>Esta seguro que desea <u><b>eliminar</b></u> ?<i/></font>", "Sistema", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE a1, a2 FROM EDITORIAL AS a1 INNER JOIN SUCURSALES AS a2 WHERE a1.COD_EDITORIAL=a2.COD_EDITORIAL AND a1.COD_EDITORIAL LIKE'" + valor + "'");
                pst.executeUpdate();
                mostrardatosest("");
                cod_editorial.setText("");
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void bib_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bib_nombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bib_nombreKeyTyped

    private void Mostrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mostrar2ActionPerformed
        // TODO add your handling code here:
    mostrardatosbib(cod_bibliotecario.getText());
    }//GEN-LAST:event_Mostrar2ActionPerformed

    private void bib_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bib_telefonoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bib_telefonoKeyTyped

    private void mod_autor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod_autor2ActionPerformed
        // TODO add your handling code here:
          try {
            PreparedStatement pst = cn.prepareStatement("UPDATE PERSONAL_BIBLIOTECA SET BIB_NOMBRE='" + bib_nombre.getText()
                    + "',BIB_APELLIDO='" + bib_apellido.getText()
                    + "',BIB_CARGO='" + bib_cargo.getText()
                    + "',BIB_TELEFONO='" + bib_telefono.getText()
                    + "',BIB_EMAIL='" + bib_email.getText()+ "'");
            pst.executeUpdate();
            mostrardatoaut("");
            JOptionPane.showMessageDialog(null, "Cambios Guardados ");
            bib_nombre.setText("");
            bib_apellido.setText("");
            bib_cargo.setText("");
            bib_telefono.setText("");
            bib_email.setText("");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        
        
    }//GEN-LAST:event_mod_autor2ActionPerformed

    private void bib_cargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bib_cargoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bib_cargoKeyTyped

    private void bib_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bib_emailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bib_emailKeyTyped

    private void Guarda_bibliotecarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guarda_bibliotecarioActionPerformed
        // TODO add your handling code here:
        String codbib, nombre, apellido, cargo, telefono, email;
        boolean flag = true;
        if (cod_bibliotecario.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el codigo de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (bib_nombre.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (bib_apellido.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el telefono de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (bib_cargo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el email de la editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (bib_telefono.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la ciudad de editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (bib_email.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el email de sucursal", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            codbib = this.cod_bibliotecario.getText();
            nombre = this.bib_nombre.getText();
            apellido = this.bib_apellido.getText();
            cargo = this.bib_cargo.getText();
            telefono = this.bib_telefono.getText();
            email = this.bib_email.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into PERSONAL_BIBLIOTECA (BIB_COD, BIB_NOMBRE, BIB_APELLIDO, BIB_CARGO, BIB_TELEFONO, BIB_EMAIL) values(?,?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, codbib);
                datos.setString(2, nombre);
                datos.setString(3, apellido);
                datos.setString(4, cargo);
                datos.setString(5, telefono);
                datos.setString(6, email);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            cod_editorial.setText("");
            bib_nombre.setText("");
            bib_apellido.setText("");
            bib_cargo.setText("");
            bib_telefono.setText("");
            bib_email.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Guarda_bibliotecarioActionPerformed

    private void bib_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bib_apellidoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_bib_apellidoKeyTyped

    private void cod_bibliotecarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cod_bibliotecarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cod_bibliotecarioKeyTyped

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        int fila = tbibliotecario.getSelectedRow();
        if (fila >= 0) {
            //cod_bibliotecario.setText(tbibliotecario.getValueAt(fila, 1).toString());
            bib_nombre.setText(tbibliotecario.getValueAt(fila, 0).toString());
            bib_apellido.setText(tbibliotecario.getValueAt(fila, 1).toString());
            bib_cargo.setText(tbibliotecario.getValueAt(fila, 2).toString());
            bib_telefono.setText(tbibliotecario.getValueAt(fila, 3).toString());
            bib_email.setText(tbibliotecario.getValueAt(fila, 4).toString());
  
            
            
        } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField COD_EST;
    private javax.swing.JButton Guarda_bibliotecario;
    private javax.swing.JButton Guardar_Editor;
    private javax.swing.JTable JTablaEst;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Mostrar;
    private javax.swing.JButton Mostrar1;
    private javax.swing.JButton Mostrar2;
    private javax.swing.JTextField ape_aut;
    private javax.swing.JTextField aut_pais;
    private javax.swing.JButton autores;
    private javax.swing.JTextField bib_apellido;
    private javax.swing.JTextField bib_cargo;
    private javax.swing.JTextField bib_email;
    private javax.swing.JTextField bib_nombre;
    private javax.swing.JTextField bib_telefono;
    private javax.swing.JTextField cod_aut;
    private javax.swing.JTextField cod_aut2;
    private javax.swing.JTextField cod_bibliotecario;
    private javax.swing.JTextField cod_editorial;
    private javax.swing.JTextField direccion_aut;
    private javax.swing.JTextField edi_ciudad;
    private javax.swing.JTextField edi_email;
    private javax.swing.JTextField edi_nombre;
    private javax.swing.JTextField edi_pais;
    private javax.swing.JTextField edi_suc_telefono;
    private javax.swing.JTextField edi_telefono;
    private javax.swing.JButton editorial;
    private javax.swing.JDesktopPane escritorioAdmin;
    private javax.swing.JButton estudiante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField japellido;
    private javax.swing.JTextField jarea;
    private javax.swing.JInternalFrame jautores;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbguardar_ed;
    private javax.swing.JTextField jcarrera;
    private javax.swing.JTextField jciclo;
    private javax.swing.JTextField jcodcarrera;
    private javax.swing.JInternalFrame jeditor;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jemail1;
    private javax.swing.JInternalFrame jestudiante;
    private javax.swing.JLabel jlencabezado_empleado;
    private javax.swing.JLabel jlencabezado_empleado1;
    private javax.swing.JLabel jlencabezado_empleado2;
    private javax.swing.JTextField jnombre;
    private javax.swing.JInternalFrame jpersonal;
    private javax.swing.JTextField jtelefono;
    private javax.swing.JButton mod_autor;
    private javax.swing.JButton mod_autor1;
    private javax.swing.JButton mod_autor2;
    private javax.swing.JTextField nom_aut;
    private javax.swing.JButton personal;
    private javax.swing.JTextField publicacion_aut;
    private javax.swing.JTextField suc_cant;
    private javax.swing.JTextField suc_email;
    private javax.swing.JTextField suc_lugar;
    private javax.swing.JTable tautor;
    private javax.swing.JTable tbibliotecario;
    private javax.swing.JTable teditorial;
    // End of variables declaration//GEN-END:variables
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    ConexionDB cc = new ConexionDB();
    Connection cn = cc.obtenerConexion();
}
