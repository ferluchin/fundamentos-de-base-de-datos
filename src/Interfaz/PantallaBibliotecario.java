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
public class PantallaBibliotecario extends javax.swing.JInternalFrame {

    /**
     * Creates new form PantallaAdministrador
     */
    public PantallaBibliotecario() {
        // Mostrar los Frame
        initComponents();
//        mostrardatos("");
        this.ocultarBarraTitulo();
        this.recurso_bib.setVisible(false);
        this.jDevolucion.setVisible(false);
        this.jPrestacion.setVisible(false);
        this.jUsuarios.setVisible(false);
    }

    void mostrardatoedi(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID PAGO");
        modelo.addColumn("MEDIO PAGO");
        modelo.addColumn("ID MULTA");
        modelo.addColumn("FECHA PAGO");
        Jpago.setModel(modelo);
        String sql = ("SELECT * FROM PAGO WHERE ID_PAGO LIKE'" + valor + "'");
        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                modelo.addRow(datos);
            }
            Jpago.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardato(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ESTUDIANTE");
        modelo.addColumn("BIBLIOTECARIO");
        modelo.addColumn("FECHA ENTRGA");
        modelo.addColumn("FECHA RECIBO");
        modelo.addColumn("ESTADO");
        Jpago1.setModel(modelo);
        String sql = ("SELECT CED_EST, BIB_COD, FECHAINICIO_P, FECHAFIN_P, ESTADO_PRE FROM PRESTAMOS WHERE CED_EST LIKE'" + valor + "'");
        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                modelo.addRow(datos);
            }
            Jpago1.setModel(modelo);
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
        empleado = new javax.swing.JButton();
        actDatos = new javax.swing.JButton();
        consulta = new javax.swing.JButton();
        sueldo = new javax.swing.JButton();
        escritorioAdmin = new javax.swing.JDesktopPane();
        recurso_bib = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbguardar = new javax.swing.JButton();
        jpaginas = new javax.swing.JTextField();
        jdescripcion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jeditorial = new javax.swing.JTextField();
        jestado = new javax.swing.JComboBox();
        jlencabezado_empleado = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jIdioma = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jedicion = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jfecha = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jlugar = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jcantidad = new javax.swing.JTextField();
        jtitulo = new javax.swing.JTextField();
        jnombre = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jbibliotecario = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jcodeditorial = new javax.swing.JTextField();
        JISBN = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jDevolucion = new javax.swing.JInternalFrame();
        jFObservacion1 = new javax.swing.JTextField();
        jFCondicion1 = new javax.swing.JTextField();
        jFISBN1 = new javax.swing.JTextField();
        jFEstudiante1 = new javax.swing.JTextField();
        jlencabezado_empleado3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFechaFin1 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jlencabezado_empleado4 = new javax.swing.JLabel();
        jbguardar3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        Jpago1 = new javax.swing.JTable();
        jUsuarios = new javax.swing.JInternalFrame();
        jLabel22 = new javax.swing.JLabel();
        nom_adm = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        user_adm = new javax.swing.JTextField();
        jbguardar1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        contra_adm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ape_adm = new javax.swing.JTextField();
        jPrestacion = new javax.swing.JInternalFrame();
        jbguardar2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jestado1 = new javax.swing.JComboBox();
        jlencabezado_empleado1 = new javax.swing.JLabel();
        jlencabezado_empleado2 = new javax.swing.JLabel();
        jFObservacion = new javax.swing.JTextField();
        jFISBN = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jestado3 = new javax.swing.JComboBox();
        multa = new javax.swing.JInternalFrame();
        jobservmulta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jbguardar4 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jlencabezado_empleado5 = new javax.swing.JLabel();
        jFechaemision = new javax.swing.JFormattedTextField();
        jFechacobro = new javax.swing.JFormattedTextField();
        jlencabezado_empleado6 = new javax.swing.JLabel();
        jmotivo = new javax.swing.JComboBox();
        Valor = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jmotivo1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        pago = new javax.swing.JInternalFrame();
        jobservmulta1 = new javax.swing.JTextField();
        jbguardar5 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jlencabezado_empleado7 = new javax.swing.JLabel();
        jFechaemision1 = new javax.swing.JFormattedTextField();
        codDevo1 = new javax.swing.JTextField();
        Valor1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        Jpago = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        Ejemplar = new javax.swing.JInternalFrame();
        jdescripcion2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jbguardar6 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jestado2 = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        jlencabezado_empleado8 = new javax.swing.JLabel();
        jFechaInicio1 = new javax.swing.JFormattedTextField();
        jFechaFin2 = new javax.swing.JFormattedTextField();
        jlencabezado_empleado9 = new javax.swing.JLabel();
        jFObservacion2 = new javax.swing.JTextField();
        jFCondicion2 = new javax.swing.JTextField();
        jFISBN2 = new javax.swing.JTextField();
        jFBibliotecario1 = new javax.swing.JTextField();
        jFEstudiante2 = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jMenuItem1.setText("Modificar");
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

        jMenuItem3.setText("jMenuItem3");
        jPopupMenu2.add(jMenuItem3);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setPreferredSize(new java.awt.Dimension(1117, 539));

        empleado.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Personal.png"))); // NOI18N
        empleado.setText("Recursos"); // NOI18N
        empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleadoActionPerformed(evt);
            }
        });

        actDatos.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        actDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edi.png"))); // NOI18N
        actDatos.setText("Devolucion"); // NOI18N
        actDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actDatosActionPerformed(evt);
            }
        });

        consulta.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        consulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        consulta.setText("Prestamos"); // NOI18N
        consulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaActionPerformed(evt);
            }
        });

        sueldo.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        sueldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salario.png"))); // NOI18N
        sueldo.setText("Personal"); // NOI18N
        sueldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sueldoActionPerformed(evt);
            }
        });

        escritorioAdmin.setPreferredSize(new java.awt.Dimension(1100, 530));
        escritorioAdmin.setLayout(null);

        recurso_bib.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        recurso_bib.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        recurso_bib.setEnabled(false);
        recurso_bib.setPreferredSize(new java.awt.Dimension(700, 460));
        recurso_bib.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel1.setText("ISBN"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel2.setText("Nombre"); // NOI18N

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel3.setText("Paginas"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel4.setText("Titulo"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel6.setText("Descripcion"); // NOI18N

        jbguardar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar.setText("Guardar"); // NOI18N
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jpaginas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jpaginasKeyTyped(evt);
            }
        });

        jdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdescripcionKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel21.setText("Estado"); // NOI18N

        jLabel25.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel25.setText("Editorial"); // NOI18N

        jeditorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jeditorialKeyTyped(evt);
            }
        });

        jestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Exelente", "Bueno", "Malo", "Pesimo" }));

        jlencabezado_empleado.setText("RECURSOS BIBLIOGRAFICOS");

        jLabel29.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel29.setText("Idioma"); // NOI18N

        jIdioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jIdiomaKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel14.setText("Edición"); // NOI18N

        jedicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jedicionKeyTyped(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel30.setText("Fecha edición"); // NOI18N

        jfecha.setText("YYYY-MM_DD");
        jfecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jfechaKeyTyped(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel31.setText("Lugar de edición"); // NOI18N

        jlugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jlugarKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel32.setText("Cantidad dispnibles"); // NOI18N

        jcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcantidadKeyTyped(evt);
            }
        });

        jtitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtituloKeyTyped(evt);
            }
        });

        jnombre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Libro", "Revista", "Tesis", "Periodico" }));

        jLabel33.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel33.setText("COD Bibliotecario"); // NOI18N

        jbibliotecario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jbibliotecarioKeyTyped(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel28.setText("COD"); // NOI18N

        jcodeditorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcodeditorialKeyTyped(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calend.png"))); // NOI18N
        jButton6.setText("Ejemplares");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout recurso_bibLayout = new javax.swing.GroupLayout(recurso_bib.getContentPane());
        recurso_bib.getContentPane().setLayout(recurso_bibLayout);
        recurso_bibLayout.setHorizontalGroup(
            recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recurso_bibLayout.createSequentialGroup()
                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recurso_bibLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlencabezado_empleado)
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jfecha, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtitulo)
                                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(recurso_bibLayout.createSequentialGroup()
                                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel29))
                                        .addGap(18, 18, 18)
                                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                                .addComponent(jeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jcodeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, recurso_bibLayout.createSequentialGroup()
                                            .addComponent(jLabel32)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jcantidad))
                                        .addGroup(recurso_bibLayout.createSequentialGroup()
                                            .addComponent(jLabel31)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(recurso_bibLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jedicion, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recurso_bibLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel33)))
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(recurso_bibLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(recurso_bibLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jpaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(recurso_bibLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jButton6)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        recurso_bibLayout.setVerticalGroup(
            recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recurso_bibLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlencabezado_empleado)
                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(recurso_bibLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jedicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14)
                                .addComponent(jpaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recurso_bibLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(recurso_bibLayout.createSequentialGroup()
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, recurso_bibLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(jbibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(recurso_bibLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(recurso_bibLayout.createSequentialGroup()
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(jIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(jeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(jcodeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(jcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recurso_bibLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel31)))))
                .addGap(18, 18, 18)
                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbguardar)
                    .addComponent(jButton6))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        escritorioAdmin.add(recurso_bib);
        recurso_bib.setBounds(0, 0, 1230, 560);

        jDevolucion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDevolucion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDevolucion.setEnabled(false);
        jDevolucion.setPreferredSize(new java.awt.Dimension(600, 600));
        jDevolucion.setVisible(true);

        jlencabezado_empleado3.setText("DEVOLUCIÓN");

        jLabel12.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel12.setText("ISBN"); // NOI18N

        jFechaFin1.setText("YYYY-MM-DD");

        jLabel9.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel9.setText("Estudiante COD"); // NOI18N

        jLabel37.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel37.setText("Obs. Bibliotecario"); // NOI18N

        jlencabezado_empleado4.setText("BIBLIOTECARIO");

        jbguardar3.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar3.setText("Guardar"); // NOI18N
        jbguardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel16.setText("Estado"); // NOI18N

        jLabel27.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel27.setText("Fecha Devolución"); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cons.jpg"))); // NOI18N
        jButton2.setText("Multa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Jpago1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(Jpago1);

        javax.swing.GroupLayout jDevolucionLayout = new javax.swing.GroupLayout(jDevolucion.getContentPane());
        jDevolucion.getContentPane().setLayout(jDevolucionLayout);
        jDevolucionLayout.setHorizontalGroup(
            jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDevolucionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDevolucionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlencabezado_empleado3)
                        .addGap(223, 223, 223))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDevolucionLayout.createSequentialGroup()
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDevolucionLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jFEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(jFechaFin1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDevolucionLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jDevolucionLayout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFObservacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDevolucionLayout.createSequentialGroup()
                                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jlencabezado_empleado4)
                                            .addGroup(jDevolucionLayout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(jFISBN1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(109, 109, 109)
                                                .addComponent(jLabel16)))
                                        .addGap(33, 33, 33)
                                        .addComponent(jFCondicion1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jDevolucionLayout.createSequentialGroup()
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDevolucionLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jbguardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176)
                        .addComponent(jButton2))
                    .addGroup(jDevolucionLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDevolucionLayout.setVerticalGroup(
            jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDevolucionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlencabezado_empleado4)
                .addGap(39, 39, 39)
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16)
                    .addComponent(jFCondicion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFISBN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jFObservacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jlencabezado_empleado3)
                .addGap(44, 44, 44)
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jFechaFin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jFEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addGap(37, 37, 37)
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbguardar3)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        escritorioAdmin.add(jDevolucion);
        jDevolucion.setBounds(0, 0, 1230, 550);

        jUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUsuarios.setEnabled(false);
        jUsuarios.setPreferredSize(new java.awt.Dimension(600, 600));
        jUsuarios.setVisible(true);

        jLabel22.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel22.setText("Contraseña"); // NOI18N

        nom_adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nom_admKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel11.setText("Usuario"); // NOI18N

        user_adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_admKeyTyped(evt);
            }
        });

        jbguardar1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar1.setText("Guardar"); // NOI18N
        jbguardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar1ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel34.setText("Apellido"); // NOI18N

        contra_adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contra_admKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel7.setText("Nombre"); // NOI18N

        ape_adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ape_admKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jUsuariosLayout = new javax.swing.GroupLayout(jUsuarios.getContentPane());
        jUsuarios.getContentPane().setLayout(jUsuariosLayout);
        jUsuariosLayout.setHorizontalGroup(
            jUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUsuariosLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(jUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jUsuariosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(nom_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jUsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(ape_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jUsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contra_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jUsuariosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(user_adm, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jUsuariosLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jbguardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jUsuariosLayout.setVerticalGroup(
            jUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUsuariosLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nom_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(ape_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(user_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(contra_adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125)
                .addComponent(jbguardar1)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        escritorioAdmin.add(jUsuarios);
        jUsuarios.setBounds(0, 0, 1230, 550);

        jPrestacion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPrestacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jPrestacion.setEnabled(false);
        jPrestacion.setPreferredSize(new java.awt.Dimension(600, 600));
        jPrestacion.setVisible(true);

        jbguardar2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar2.setText("Guardar"); // NOI18N
        jbguardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar2ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel23.setText("Condicion"); // NOI18N

        jLabel36.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel36.setText("Nombre"); // NOI18N

        jLabel10.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel10.setText("ISBN"); // NOI18N

        jestado1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excelente", "Bueno", "Malo" }));

        jlencabezado_empleado1.setText("EJEMPLAR");

        jlencabezado_empleado2.setText("CONDICIONES");

        jLabel52.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel52.setText("Estado"); // NOI18N

        jestado3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "Baja" }));

        javax.swing.GroupLayout jPrestacionLayout = new javax.swing.GroupLayout(jPrestacion.getContentPane());
        jPrestacion.getContentPane().setLayout(jPrestacionLayout);
        jPrestacionLayout.setHorizontalGroup(
            jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPrestacionLayout.createSequentialGroup()
                .addGroup(jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPrestacionLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPrestacionLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(jFObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPrestacionLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jFISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPrestacionLayout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jlencabezado_empleado1))))
                    .addGroup(jPrestacionLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel52)
                        .addGap(44, 44, 44)
                        .addComponent(jestado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel23)
                        .addGap(45, 45, 45)
                        .addComponent(jestado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPrestacionLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jbguardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPrestacionLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jlencabezado_empleado2)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPrestacionLayout.setVerticalGroup(
            jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPrestacionLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlencabezado_empleado1)
                .addGap(42, 42, 42)
                .addGroup(jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jFObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jlencabezado_empleado2)
                .addGroup(jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPrestacionLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jbguardar2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPrestacionLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPrestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jestado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel23)
                            .addComponent(jestado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(276, 276, 276))))
        );

        escritorioAdmin.add(jPrestacion);
        jPrestacion.setBounds(0, 0, 1230, 560);

        multa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        multa.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        multa.setEnabled(false);
        multa.setPreferredSize(new java.awt.Dimension(600, 600));
        multa.setVisible(true);

        jobservmulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jobservmultaKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel13.setText("Observación"); // NOI18N

        jbguardar4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar4.setText("Guardar"); // NOI18N
        jbguardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel24.setText("Motivo"); // NOI18N

        jLabel35.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel35.setText("Fecha Cobro"); // NOI18N

        jLabel17.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel17.setText("Valor"); // NOI18N

        jLabel41.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel41.setText("Fecha Emision"); // NOI18N

        jlencabezado_empleado5.setText("MULTAS");

        jFechaemision.setText("YYYY-MM-DD");

        jFechacobro.setText("YYYY-MM-DD");

        jlencabezado_empleado6.setText("VALORES");

        jmotivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mal uso", "Retraso", "Otro" }));

        Valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ValorKeyTyped(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel39.setText("Medio"); // NOI18N

        jmotivo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efectivo", "Deposito" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salario.png"))); // NOI18N
        jButton1.setText("Pago");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout multaLayout = new javax.swing.GroupLayout(multa.getContentPane());
        multa.getContentPane().setLayout(multaLayout);
        multaLayout.setHorizontalGroup(
            multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multaLayout.createSequentialGroup()
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(multaLayout.createSequentialGroup()
                                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jFechacobro)
                                        .addComponent(jFechaemision)
                                        .addComponent(jobservmulta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, multaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlencabezado_empleado5)
                                .addGap(18, 18, 18)
                                .addComponent(jlencabezado_empleado6)))
                        .addGap(33, 33, 33)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jLabel24)))
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jbguardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jmotivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        multaLayout.setVerticalGroup(
            multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlencabezado_empleado6)
                    .addComponent(jlencabezado_empleado5))
                .addGap(27, 27, 27)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jmotivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFechacobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(multaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jFechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jobservmulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbguardar4)
                    .addComponent(jButton1))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        escritorioAdmin.add(multa);
        multa.setBounds(0, 0, 1230, 560);

        pago.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pago.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        pago.setEnabled(false);
        pago.setPreferredSize(new java.awt.Dimension(600, 600));
        pago.setVisible(true);

        jobservmulta1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jobservmulta1KeyTyped(evt);
            }
        });

        jbguardar5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar5.setText("Guardar"); // NOI18N
        jbguardar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar5ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel43.setText("COD Multa"); // NOI18N

        jLabel20.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel20.setText("Medio"); // NOI18N

        jLabel44.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel44.setText("ID PAGO"); // NOI18N

        jLabel45.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel45.setText("Fecha Cancelada"); // NOI18N

        jlencabezado_empleado7.setText("MULTAS PAGADAS");

        jFechaemision1.setText("YYYY-MM-DD");

        Valor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Valor1KeyTyped(evt);
            }
        });

        jButton3.setText("Pago");

        Jpago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(Jpago);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pagoLayout = new javax.swing.GroupLayout(pago.getContentPane());
        pago.getContentPane().setLayout(pagoLayout);
        pagoLayout.setHorizontalGroup(
            pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagoLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jButton3))
                    .addGroup(pagoLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jlencabezado_empleado7))
                    .addGroup(pagoLayout.createSequentialGroup()
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(pagoLayout.createSequentialGroup()
                                    .addComponent(jLabel45)
                                    .addGap(29, 29, 29)
                                    .addComponent(jFechaemision1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pagoLayout.createSequentialGroup()
                                    .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel43)
                                        .addComponent(jLabel20))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jobservmulta1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(Valor1))))
                            .addGroup(pagoLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jbguardar5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pagoLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(codDevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pagoLayout.setVerticalGroup(
            pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlencabezado_empleado7)
                .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(codDevo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(32, 32, 32)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jobservmulta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(Valor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFechaemision1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(30, 30, 30)
                        .addComponent(jbguardar5))
                    .addGroup(pagoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(50, 50, 50))
        );

        escritorioAdmin.add(pago);
        pago.setBounds(0, 0, 1230, 560);

        Ejemplar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Ejemplar.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Ejemplar.setEnabled(false);
        Ejemplar.setPreferredSize(new java.awt.Dimension(600, 600));
        Ejemplar.setVisible(true);

        jdescripcion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdescripcion2KeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel18.setText("Observación"); // NOI18N

        jbguardar6.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbguardar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        jbguardar6.setText("Guardar"); // NOI18N
        jbguardar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardar6ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel42.setText("Estado"); // NOI18N

        jLabel46.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel46.setText("Fecha Termina"); // NOI18N

        jLabel47.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel47.setText("Obs. Bibliotecario"); // NOI18N

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel19.setText("Estudiante COD"); // NOI18N

        jLabel48.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel48.setText("Condiciones"); // NOI18N

        jLabel49.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel49.setText("ISBN"); // NOI18N

        jLabel50.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel50.setText("Fecha Inicio"); // NOI18N

        jestado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excelente", "Bueno", "Malo" }));

        jLabel51.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel51.setText("Bibliotecario COD"); // NOI18N

        jlencabezado_empleado8.setText("BIBLIOTECARIO");

        jFechaInicio1.setText("YYYY-MM-DD");

        jFechaFin2.setText("YYYY-MM-DD");

        jlencabezado_empleado9.setText("PRESTACIÓN");

        javax.swing.GroupLayout EjemplarLayout = new javax.swing.GroupLayout(Ejemplar.getContentPane());
        Ejemplar.getContentPane().setLayout(EjemplarLayout);
        EjemplarLayout.setHorizontalGroup(
            EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemplarLayout.createSequentialGroup()
                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemplarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(EjemplarLayout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(18, 18, 18)
                                .addComponent(jFObservacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EjemplarLayout.createSequentialGroup()
                                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlencabezado_empleado8)
                                    .addGroup(EjemplarLayout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFISBN2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel48)))
                                .addGap(33, 33, 33)
                                .addComponent(jFCondicion2))))
                    .addGroup(EjemplarLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel50)
                            .addComponent(jLabel18)
                            .addComponent(jlencabezado_empleado9))
                        .addGap(18, 18, 18)
                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EjemplarLayout.createSequentialGroup()
                                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFechaInicio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(jFEstudiante2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdescripcion2))
                                .addGap(18, 18, 18)
                                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel42))
                                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EjemplarLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jestado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(EjemplarLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jFechaFin2)
                                            .addComponent(jFBibliotecario1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(EjemplarLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jbguardar6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EjemplarLayout.setVerticalGroup(
            EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EjemplarLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlencabezado_empleado8)
                .addGap(39, 39, 39)
                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48)
                    .addComponent(jFCondicion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFISBN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jFObservacion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jlencabezado_empleado9)
                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EjemplarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jFEstudiante2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(jFechaInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EjemplarLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jdescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addGroup(EjemplarLayout.createSequentialGroup()
                                .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(EjemplarLayout.createSequentialGroup()
                                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel51)
                                            .addComponent(jFBibliotecario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56)
                                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jestado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel42)))
                                    .addGroup(EjemplarLayout.createSequentialGroup()
                                        .addGroup(EjemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel46)
                                            .addComponent(jFechaFin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(47, 47, 47)))
                                .addGap(1, 1, 1)))))
                .addGap(33, 33, 33)
                .addComponent(jbguardar6)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        escritorioAdmin.add(Ejemplar);
        Ejemplar.setBounds(0, 0, 1230, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sueldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(escritorioAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(actDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorioAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actDatosActionPerformed

        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jDevolucion);
        jDevolucion.show();
    }//GEN-LAST:event_actDatosActionPerformed

    private void empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleadoActionPerformed

        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(recurso_bib);
        recurso_bib.show();
    }//GEN-LAST:event_empleadoActionPerformed

    private void sueldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sueldoActionPerformed
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jUsuarios);
        jUsuarios.show();
    }//GEN-LAST:event_sueldoActionPerformed


    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        // TODO add your handling code here:
        String isbn, nombre, titulo, fecha, descripcion, edicion, paginas, idioma, editorial, cantidad, lugar, estado, bibliotecario, cod_editorial;
        boolean flag = true;

        if (JISBN.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jbibliotecario.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese su codigo de personal bibliotecario", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jtitulo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el titulo del recurso", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jfecha.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jdescripcion.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese una descripción", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jedicion.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el numero de edición", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jpaginas.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el numero de paginas", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jIdioma.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el idioma", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jeditorial.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la editorial", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jcantidad.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la cantidad disponible", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jlugar.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el lugar de edición", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            isbn = this.JISBN.getText();
            bibliotecario = this.jbibliotecario.getText();
            nombre = this.jnombre.getSelectedItem().toString();
            titulo = this.jtitulo.getText();
            fecha = this.jfecha.getText();
            descripcion = this.jdescripcion.getText();
            edicion = this.jedicion.getText();
            paginas = this.jpaginas.getText();
            idioma = this.jIdioma.getText();
            editorial = this.jeditorial.getText();
            cantidad = this.jcantidad.getText();
            lugar = this.jlugar.getText();
            estado = this.jestado.getSelectedItem().toString();
            cod_editorial = this.jcodeditorial.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into RECURSO_DETALLE values(?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, isbn);
                datos.setString(2, titulo);
                datos.setString(3, descripcion);
                datos.setString(4, paginas);
                datos.setString(5, edicion);
                datos.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInser = "insert into RECURSOS_BIBLIOGRAFICOS values(?,?,?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement dato = con.prepareStatement(sInser);
                dato.setString(1, isbn);
                dato.setString(2, cod_editorial);
                dato.setString(3, bibliotecario);
                dato.setString(4, nombre);
                dato.setString(5, estado);
                dato.setString(6, idioma);
                dato.setString(7, cantidad);
                dato.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInse = "insert into EDICIONES values(?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement dat = con.prepareStatement(sInse);

                dat.setString(1, isbn);
                dat.setString(2, editorial);
                dat.setString(3, fecha);
                dat.setString(4, lugar);
                dat.setString(5, edicion);
                dat.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }
            jpaginas.setText("");
            JISBN.setText("");
            jdescripcion.setText("");
            jedicion.setText("");
            jbibliotecario.setText("");
            jeditorial.setText("");
            jIdioma.setText("");
            jcantidad.setText("");
            jtitulo.setText("");
            jpaginas.setText("");
            jcodeditorial.setText("");
            jlugar.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jpaginasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpaginasKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar(); //coje caracter ingresado
        if (((k < '0') || (k > '9')) && (k != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_jpaginasKeyTyped

    private void jdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdescripcionKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jdescripcionKeyTyped

    private void consultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaActionPerformed
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jPrestacion);
        jPrestacion.show();
    }//GEN-LAST:event_consultaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
//        int fila = TEditar.getSelectedRow();
//        if (fila >= 0) {
//            jt_cedula.setText(TEditar.getValueAt(fila, 0).toString());
//            jtnombre_ed.setText(TEditar.getValueAt(fila, 1).toString());
//            jtapellidos.setText(TEditar.getValueAt(fila, 2).toString());
//            jtdire.setText(TEditar.getValueAt(fila, 3).toString());
//            jttele.setText(TEditar.getValueAt(fila, 4).toString());
//            jt_cargo_ed.setText(TEditar.getValueAt(fila, 5).toString());
//            jtsalario1.setText(TEditar.getValueAt(fila, 6).toString());
//            jtHora1.setSelectedItem(TEditar.getValueAt(fila, 7).toString());
//
//        } else {
//            JOptionPane.showMessageDialog(null, "no seleciono fila");
//        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
////        int fila = TEditar.getSelectedRow();
////        String valor = "";
////        valor = TEditar.getValueAt(fila, 0).toString();
////
////        int exit = JOptionPane.showConfirmDialog(this, "<html><font face=\"Consolas\"> <i>Esta seguro que desea <u><b>eliminar</b></u> ?<i/></font>", "Sistema", JOptionPane.YES_NO_OPTION);
////        if (exit == JOptionPane.YES_OPTION) {
////            try {
////                PreparedStatement pst = cn.prepareStatement("DELETE FROM empleados WHERE  cedula='" + valor + "'");
////                pst.executeUpdate();
//////                mostrardatos("");
////            } catch (Exception e) {
////            }
////            // JOptionPane.showConfirmDialog(TEditar, exit, null, WIDTH);
//            //  JOptionPane.showConfirmDialog(panelNice1, a, null, WIDTH);
//        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jeditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jeditorialKeyTyped
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jeditorialKeyTyped

    private void jIdiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIdiomaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jIdiomaKeyTyped

    private void jedicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jedicionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jedicionKeyTyped

    private void jfechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jfechaKeyTyped

    private void jlugarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlugarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jlugarKeyTyped

    private void jcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcantidadKeyTyped

    private void jtituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtituloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtituloKeyTyped

    private void jbibliotecarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbibliotecarioKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jbibliotecarioKeyTyped

    private void jcodeditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodeditorialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jcodeditorialKeyTyped

    private void contra_admKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contra_admKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contra_admKeyTyped

    private void ape_admKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ape_admKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ape_admKeyTyped

    private void jbguardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar1ActionPerformed
        // TODO add your handling code here:
        String nombre, apellido, usuario, contra;
        boolean flag = true;

        if (user_adm.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el usuario del administrador", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (nom_adm.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el nombre del admistrador", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (ape_adm.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el apellido del administrador", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (contra_adm.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la contraseña del administrador", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            nombre = this.nom_adm.getText();
            apellido = this.ape_adm.getText();
            usuario = this.user_adm.getText();
            contra = this.contra_adm.getText();

            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into ADMINISTRADOR (NOMBRE_ADM, APELLIDO_ADM, USUARIO_PER, CONTRASE_PER) values(?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, nombre);
                datos.setString(2, apellido);
                datos.setString(3, usuario);
                datos.setString(4, contra);
                datos.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }

            jpaginas.setText("");
            JISBN.setText("");
            jdescripcion.setText("");
            jedicion.setText("");
            jbibliotecario.setText("");
            jeditorial.setText("");
            jIdioma.setText("");
            jcantidad.setText("");
            jtitulo.setText("");
            jpaginas.setText("");
            jcodeditorial.setText("");
            jlugar.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jbguardar1ActionPerformed

    private void nom_admKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_admKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_admKeyTyped

    private void user_admKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_admKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_user_admKeyTyped

    private void jbguardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar2ActionPerformed
        // TODO add your handling code here:
        String isbn, condicion, observacion, estudiante, bibliotecario, fecha_ini, fecha_fin, obser_pres, estado;
        boolean flag = true;
        if (jFISBN.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFObservacion.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el titulo del recurso", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
            isbn = this.jFISBN.getText();
            observacion = this.jFObservacion.getText();
            estado = this.jestado1.getSelectedItem().toString();
            condicion=jestado3.getSelectedItem().toString();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into EJEMPLAR (ISBN, NOM_EJEMPLAR, CONDICION_EJEM, ESTADO_EJE) values(?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, isbn);
                datos.setString(2, observacion);
                datos.setString(3, estado);
                datos.setString(4, condicion);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInser = "insert into PRESTAMO_DETALLE (ISBN, ESTADO_DET, OBSERVACION_DET)  values(?,?,?)"; // Manipulacion de tablas
                PreparedStatement dato = con.prepareStatement(sInser);
                dato.setString(1, isbn);
                dato.setString(2, condicion);
                dato.setString(3, observacion);
                dato.executeUpdate();

                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        jFISBN.setText("");
        jFObservacion.setText("");

        JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jbguardar2ActionPerformed

    private void jbguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar3ActionPerformed
        // TODO add your handling code here:
        String cod, estado, observacion, estudiante, fecha_fin;
        boolean flag = true;

        if (jFISBN1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFCondicion1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Cambie el estado", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFObservacion1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese alguna observacion", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFEstudiante1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese cod de estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFechaFin1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha devuelta", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {
            cod = this.jFechaFin1.getText();
            estado = this.jFCondicion1.getText();
            observacion = this.jFObservacion1.getText();
            estudiante = this.jFEstudiante1.getText();
            fecha_fin = this.jFechaFin1.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into DEVOLUCION_DETALLE (ISBN, ESTADO_DEV, OBSERVACION_DEV) values(?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, cod);
                datos.setString(2, estado);
                datos.setString(3, observacion);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into DEVOLUCION (CED_EST, FECHA_DEV) values(?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, estudiante);
                datos.setString(2, fecha_fin);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }
            Valor.setText("");
            jobservmulta.setText("");

            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jbguardar3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(multa);
        multa.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jobservmultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobservmultaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jobservmultaKeyTyped

    private void jbguardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar4ActionPerformed
        // TODO add your handling code here:
        String valor, fecha_ini, fecha_fin, observacion, estado, medio;
        boolean flag = true;

        if (Valor.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el valor de multa", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFechaemision.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha de emisión", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFechacobro.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha de cobro", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jobservmulta.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese alguna observación", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {

            valor = this.Valor.getText();
            estado = this.jmotivo.getSelectedItem().toString();
            medio = this.jmotivo1.getSelectedItem().toString();
            observacion = this.jobservmulta.getText();
            fecha_ini = this.jFechaemision.getText();
            fecha_fin = this.jFechacobro.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into MULTAS (VALOR_MULTA, FECHA_EMISION_MULTA, FECHA_COBRO_MULTA, MOTIVO_MULTA, OBSERVACION_MUL) values(?,?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, valor);
                datos.setString(2, fecha_ini);
                datos.setString(3, fecha_fin);
                datos.setString(4, estado);
                datos.setString(5, observacion);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into DEPOSITO (MEDIO_PAGO) values(?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, medio);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into PAGO (MEDIO_PAGO) values(?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, medio);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }

            Valor.setText("");
            jobservmulta.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_jbguardar4ActionPerformed

    private void ValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ValorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorKeyTyped

    private void jobservmulta1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobservmulta1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jobservmulta1KeyTyped

    private void jbguardar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar5ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String valor, fecha_ini, fecha_fin, observacion, estado, medio;
        boolean flag = true;

        if (codDevo1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ID_PAGO", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jobservmulta1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha de pago", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (Valor1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el medio de pago", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFechaemision1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ID_MULTA", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {

            valor = this.codDevo1.getText();
            estado = this.Valor1.getText();
            observacion = this.jobservmulta1.getText();
            fecha_ini = this.jFechaemision1.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into PAGO (ID_PAGO, MEDIO_PAGO, ID_MULTA, FECHA_PAGO) values(?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, valor);
                datos.setString(2, estado);
                datos.setString(3, observacion);
                datos.setString(4, fecha_ini);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
    }//GEN-LAST:event_jbguardar5ActionPerformed
        }
    }
    private void Valor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Valor1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Valor1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(pago);
        pago.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        mostrardatoedi(codDevo1.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        mostrardato(jFEstudiante1.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jdescripcion2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdescripcion2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jdescripcion2KeyTyped

    private void jbguardar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbguardar6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Ejemplar;
    private javax.swing.JTextField JISBN;
    private javax.swing.JTable Jpago;
    private javax.swing.JTable Jpago1;
    private javax.swing.JTextField Valor;
    private javax.swing.JTextField Valor1;
    private javax.swing.JButton actDatos;
    private javax.swing.JTextField ape_adm;
    private javax.swing.JTextField codDevo1;
    private javax.swing.JButton consulta;
    private javax.swing.JTextField contra_adm;
    private javax.swing.JButton empleado;
    private javax.swing.JDesktopPane escritorioAdmin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JInternalFrame jDevolucion;
    private javax.swing.JTextField jFBibliotecario1;
    private javax.swing.JTextField jFCondicion1;
    private javax.swing.JTextField jFCondicion2;
    private javax.swing.JTextField jFEstudiante1;
    private javax.swing.JTextField jFEstudiante2;
    private javax.swing.JTextField jFISBN;
    private javax.swing.JTextField jFISBN1;
    private javax.swing.JTextField jFISBN2;
    private javax.swing.JTextField jFObservacion;
    private javax.swing.JTextField jFObservacion1;
    private javax.swing.JTextField jFObservacion2;
    private javax.swing.JFormattedTextField jFechaFin1;
    private javax.swing.JFormattedTextField jFechaFin2;
    private javax.swing.JFormattedTextField jFechaInicio1;
    private javax.swing.JFormattedTextField jFechacobro;
    private javax.swing.JFormattedTextField jFechaemision;
    private javax.swing.JFormattedTextField jFechaemision1;
    private javax.swing.JTextField jIdioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JInternalFrame jPrestacion;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JInternalFrame jUsuarios;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbguardar1;
    private javax.swing.JButton jbguardar2;
    private javax.swing.JButton jbguardar3;
    private javax.swing.JButton jbguardar4;
    private javax.swing.JButton jbguardar5;
    private javax.swing.JButton jbguardar6;
    private javax.swing.JTextField jbibliotecario;
    private javax.swing.JTextField jcantidad;
    private javax.swing.JTextField jcodeditorial;
    private javax.swing.JTextField jdescripcion;
    private javax.swing.JTextField jdescripcion2;
    private javax.swing.JTextField jedicion;
    private javax.swing.JTextField jeditorial;
    private javax.swing.JComboBox jestado;
    private javax.swing.JComboBox jestado1;
    private javax.swing.JComboBox jestado2;
    private javax.swing.JComboBox jestado3;
    private javax.swing.JTextField jfecha;
    private javax.swing.JLabel jlencabezado_empleado;
    private javax.swing.JLabel jlencabezado_empleado1;
    private javax.swing.JLabel jlencabezado_empleado2;
    private javax.swing.JLabel jlencabezado_empleado3;
    private javax.swing.JLabel jlencabezado_empleado4;
    private javax.swing.JLabel jlencabezado_empleado5;
    private javax.swing.JLabel jlencabezado_empleado6;
    private javax.swing.JLabel jlencabezado_empleado7;
    private javax.swing.JLabel jlencabezado_empleado8;
    private javax.swing.JLabel jlencabezado_empleado9;
    private javax.swing.JTextField jlugar;
    private javax.swing.JComboBox jmotivo;
    private javax.swing.JComboBox jmotivo1;
    private javax.swing.JComboBox jnombre;
    private javax.swing.JTextField jobservmulta;
    private javax.swing.JTextField jobservmulta1;
    private javax.swing.JTextField jpaginas;
    private javax.swing.JTextField jtitulo;
    private javax.swing.JInternalFrame multa;
    private javax.swing.JTextField nom_adm;
    private javax.swing.JInternalFrame pago;
    private javax.swing.JInternalFrame recurso_bib;
    private javax.swing.JButton sueldo;
    private javax.swing.JTextField user_adm;
    // End of variables declaration//GEN-END:variables
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    ConexionDB cc = new ConexionDB();
    Connection cn = cc.obtenerConexion();
}
