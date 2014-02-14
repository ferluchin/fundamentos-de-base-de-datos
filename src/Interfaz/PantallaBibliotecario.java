package Interfaz;

import clases.sqlclass;
import clases.ConexionDB;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Ced_prestamo.setEnabled(false);
        Cod_bib.setEnabled(false);
        Descrip_prest.setEnabled(false);
        jdescripcion2.setEnabled(false);
        jFCondicion2.setEnabled(false);
        this.recurso_bib.setVisible(false);
        this.jDevolucion.setVisible(false);
        this.jEjem.setVisible(false);
        this.jUsuarios.setVisible(false);
        jFechaInicio1.setText(fecha_in());
        jFechaInicio1.setEditable(false);
        jFechaFin1.setText(fecha_in());
        jFechaFin1.setEditable(false);
        
    }

    sqlclass seccion = new sqlclass();
    Object[][] dtSec;
    Object[] dtDep;
    int fila = -1;

    private void nuevo() {
        lbCodHer.setText(RandomCode());
    }

    private String RandomCode() {
        String cod = "0";
        for (int i = 1; i <= 5; i++) {
            int num = (int) ((Math.random() * (90 - 85)));
            cod = cod + (int) num;
        }
        return cod;
    }

    private void updateCombo() {
        dtDep = seccion.GetColumna("RECURSOS_BIBLIOGRAFICOS", "ISBN", "select ISBN from RECURSOS_BIBLIOGRAFICOS");
        coseccion.removeAllItems();
        for (int i = 0; i <= dtDep.length - 1; i++) {
            coseccion.addItem(dtDep[i]);
        }
    }

    private void GuardarPrestamo() {
        jFechaInicio1.setEditable(false);
        String estud, codBib, fecha_ini, fecha_fin, observacion, estado;
        boolean flag = true;
        if (lbCodHer.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFCondicion2.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la condicion", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (Descrip_prest.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la observacion", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (Ced_prestamo.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese cod del estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (Cod_bib.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese cod de bibliotecario", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFechaInicio1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha de prestación de inicio", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jdescripcion2.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese observaciones del bibliotecario", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {
            String CodHer = lbCodHer.getText();
            estado = this.jestado2.getSelectedItem().toString();
            estud = this.Ced_prestamo.getText();
            codBib = this.Cod_bib.getText();
            fecha_ini = jFechaInicio1.getText();
            fecha_fin = convertTostring(calendario.getDate());
            observacion = this.jdescripcion2.getText();

            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into PRESTAMOS (ID_PRESTAMO, CED_EST, BIB_COD, FECHAINICIO_P, FECHAFIN_P, OBSERVACION_PRE, ESTADO_PRE) values(?,?,?,?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, CodHer);
                datos.setString(2, estud);
                datos.setString(3, codBib);
                datos.setString(4, fecha_ini);
                datos.setString(5, fecha_fin);
                datos.setString(6, observacion);
                datos.setString(7, estado);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }
            Valor.setText("");
            jobservmulta.setText("");
            JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
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
        modelo.addColumn("FECHA_I");
        modelo.addColumn("FECHA_F");
        modelo.addColumn("ISBN");
        modelo.addColumn("OBSERVACION");
        Jdev.setModel(modelo);
        String sql = ("SELECT * FROM PRESTAMOS, DEVOLUCION_DETALLE WHERE PRESTAMOS.ID_PRESTAMO = DEVOLUCION_DETALLE.ID_DEVOLUCION AND PRESTAMOS.ID_PRESTAMO LIKE'" + valor + "'");
        String[] datos = new String[11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(2);
            //    datos[1] = rs.getString(3);
                datos[1] = rs.getString(4);
                datos[2] = rs.getString(5);
             //   datos[4] = rs.getString(7);
                datos[3] = rs.getString(9);
           //     datos[6] = rs.getString(10);
                datos[4] = rs.getString(11);

                modelo.addRow(datos);
            }
            Jdev.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrarpedido(String valor) {
        // Metodo para consultar en la BD
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ISBN");
        modelo.addColumn("Observación");
        modelo.addColumn("Condición");

        JTable_prestamo.setModel(modelo);
        String sql = "SELECT * FROM PRESTAMO_DETALLE WHERE ID_PRESTAMO";

        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);

                modelo.addRow(datos);
            }
            JTable_prestamo.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(PantallaBibliotecario.class.getName()).log(Level.SEVERE, null, ex);
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
        jfecha = new com.toedter.calendar.JDateChooser();
        jDevolucion = new javax.swing.JInternalFrame();
        jFObservacion1 = new javax.swing.JTextField();
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
        Jdev = new javax.swing.JTable();
        id = new javax.swing.JTextField();
        jFCondicion1 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
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
        jEjem = new javax.swing.JInternalFrame();
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
        jmotivo = new javax.swing.JComboBox();
        Valor = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jmotivo1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jFechacobro = new com.toedter.calendar.JDateChooser();
        jFechaemision = new com.toedter.calendar.JDateChooser();
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
        Jprestacion = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        Cod_bib = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jFechaInicio1 = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        calendario = new com.toedter.calendar.JDateChooser();
        jLabel47 = new javax.swing.JLabel();
        jdescripcion2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BuscEst = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        nombreest = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        apellidoest = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        correoest = new javax.swing.JTextField();
        Ced_prestamo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        coseccion = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        lbCodHer = new javax.swing.JLabel();
        Descrip_prest = new javax.swing.JTextField();
        jestado2 = new javax.swing.JComboBox();
        jFCondicion2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cmdAgregar = new javax.swing.JButton();
        cmdEdit = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_prestamo = new javax.swing.JTable();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

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

        jLabel14.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel14.setText("Edición"); // NOI18N

        jLabel30.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel30.setText("Fecha edición"); // NOI18N

        jLabel31.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel31.setText("Lugar de edición"); // NOI18N

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

        jfecha.setDateFormatString("yyyy/MM/d");

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
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jdescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtitulo)
                                        .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, recurso_bibLayout.createSequentialGroup()
                                        .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))))
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
                                .addGap(28, 28, 28)
                                .addComponent(jLabel30))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, recurso_bibLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(recurso_bibLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(jbibliotecario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        Jdev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(Jdev);

        jFCondicion1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Devuelto" }));

        jLabel18.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel18.setText("ID"); // NOI18N

        javax.swing.GroupLayout jDevolucionLayout = new javax.swing.GroupLayout(jDevolucion.getContentPane());
        jDevolucion.getContentPane().setLayout(jDevolucionLayout);
        jDevolucionLayout.setHorizontalGroup(
            jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDevolucionLayout.createSequentialGroup()
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDevolucionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDevolucionLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDevolucionLayout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jlencabezado_empleado3))
                                    .addGroup(jDevolucionLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jFEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFechaFin1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDevolucionLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jbguardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(89, 89, 89)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFCondicion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jDevolucionLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jDevolucionLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jDevolucionLayout.setVerticalGroup(
            jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDevolucionLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlencabezado_empleado4)
                .addGap(2, 2, 2)
                .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDevolucionLayout.createSequentialGroup()
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jFISBN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFCondicion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jFObservacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jlencabezado_empleado3)
                        .addGap(51, 51, 51)
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jFechaFin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jFEstudiante1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jDevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbguardar3)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addContainerGap(77, Short.MAX_VALUE))
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

        jEjem.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jEjem.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jEjem.setEnabled(false);
        jEjem.setPreferredSize(new java.awt.Dimension(600, 600));
        jEjem.setVisible(true);

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

        javax.swing.GroupLayout jEjemLayout = new javax.swing.GroupLayout(jEjem.getContentPane());
        jEjem.getContentPane().setLayout(jEjemLayout);
        jEjemLayout.setHorizontalGroup(
            jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEjemLayout.createSequentialGroup()
                .addGroup(jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEjemLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jEjemLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(jFObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jEjemLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jFISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jEjemLayout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jlencabezado_empleado1))))
                    .addGroup(jEjemLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel52)
                        .addGap(44, 44, 44)
                        .addComponent(jestado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel23)
                        .addGap(45, 45, 45)
                        .addComponent(jestado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jEjemLayout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jbguardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jEjemLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jlencabezado_empleado2)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jEjemLayout.setVerticalGroup(
            jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEjemLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlencabezado_empleado1)
                .addGap(42, 42, 42)
                .addGroup(jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jFObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jlencabezado_empleado2)
                .addGroup(jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jEjemLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jbguardar2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jEjemLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jEjemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jestado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel23)
                            .addComponent(jestado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(276, 276, 276))))
        );

        escritorioAdmin.add(jEjem);
        jEjem.setBounds(0, 0, 1230, 560);

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

        jFechacobro.setDateFormatString("yyyy/MM/d");

        jFechaemision.setDateFormatString("yyyy/MM/d");

        javax.swing.GroupLayout multaLayout = new javax.swing.GroupLayout(multa.getContentPane());
        multa.getContentPane().setLayout(multaLayout);
        multaLayout.setHorizontalGroup(
            multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel13)
                    .addComponent(jLabel35)
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jobservmulta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFechacobro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel24))
                .addGap(44, 44, 44)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jmotivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
            .addGroup(multaLayout.createSequentialGroup()
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jbguardar4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jlencabezado_empleado5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        multaLayout.setVerticalGroup(
            multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multaLayout.createSequentialGroup()
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jlencabezado_empleado5)
                        .addGap(30, 30, 30)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35)
                            .addComponent(jFechacobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jFechaemision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13))
                    .addGroup(multaLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addGroup(multaLayout.createSequentialGroup()
                                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39)
                                    .addComponent(jmotivo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(jmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jobservmulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(multaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbguardar4)
                    .addComponent(jButton1))
                .addContainerGap(255, Short.MAX_VALUE))
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
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44)
                                .addComponent(codDevo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jobservmulta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(Valor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFechaemision1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45))
                        .addGap(30, 30, 30)
                        .addComponent(jbguardar5))
                    .addGroup(pagoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(50, 50, 50))
        );

        escritorioAdmin.add(pago);
        pago.setBounds(0, 0, 1230, 560);

        Jprestacion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Jprestacion.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Jprestacion.setEnabled(false);
        Jprestacion.setPreferredSize(new java.awt.Dimension(600, 600));
        Jprestacion.setVisible(true);
        Jprestacion.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                JprestacionInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bibliotecario"));

        jLabel51.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel51.setText("Cod"); // NOI18N

        jLabel50.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel50.setText("F.I"); // NOI18N

        jLabel46.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel46.setText("F.T"); // NOI18N

        calendario.setDateFormatString("yyyy/MM/d");

        jLabel47.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel47.setText("Observacion"); // NOI18N

        jdescripcion2.setText("Ninguna");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cod_bib, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFechaInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel47)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jdescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(Cod_bib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jFechaInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel46)
                    .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Estudiante"));

        BuscEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        BuscEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscEstActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel19.setText("Cedula"); // NOI18N

        jLabel26.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel26.setText("Nombre"); // NOI18N

        jLabel38.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel38.setText("Apellido"); // NOI18N

        jLabel40.setFont(new java.awt.Font("Consolas", 1, 13)); // NOI18N
        jLabel40.setText("Correo"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel38))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(apellidoest)
                            .addComponent(nombreest, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(correoest, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(Ced_prestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscEst)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscEst, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Ced_prestamo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidoest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(correoest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("   Introduccion de datos   "));

        jLabel8.setText(" Observación");

        jLabel56.setText("Recurso");

        coseccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Cod");

        lbCodHer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbCodHer.setText("COD-000000");

        jestado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prestado" }));

        jLabel15.setText("Condición");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(coseccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFCondicion2)
                            .addComponent(Descrip_prest))))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCodHer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jestado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbCodHer)
                    .addComponent(jestado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(coseccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Descrip_prest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFCondicion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmdAgregar.setText("Guardar");
        cmdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAgregarActionPerformed(evt);
            }
        });

        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/busq.png"))); // NOI18N
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        jButton7.setText("Nuevo");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(cmdEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdEdit)
                        .addComponent(jButton7)
                        .addComponent(cmdAgregar))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JTable_prestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(JTable_prestamo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JprestacionLayout = new javax.swing.GroupLayout(Jprestacion.getContentPane());
        Jprestacion.getContentPane().setLayout(JprestacionLayout);
        JprestacionLayout.setHorizontalGroup(
            JprestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JprestacionLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(JprestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JprestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JprestacionLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JprestacionLayout.setVerticalGroup(
            JprestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JprestacionLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(JprestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JprestacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JprestacionLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        escritorioAdmin.add(Jprestacion);
        Jprestacion.setBounds(0, 0, 1230, 560);

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
            fecha = convertTostring(jfecha.getDate());
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
        this.escritorioAdmin.add(Jprestacion);
        Jprestacion.show();
    }//GEN-LAST:event_consultaActionPerformed

    private void jeditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jeditorialKeyTyped
        int k = (int) evt.getKeyChar();
        if (k != 32 && k != 8 && k < 65 || k > 90 && k < 97 || k > 122) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "Solo ingrese letras", "Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jeditorialKeyTyped

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
        String isbn, condicion, observacion, estado;
        boolean flag = true;
        if (jFISBN.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFObservacion.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el titulo del recurso", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            isbn = this.jFISBN.getText();
            observacion = this.jFObservacion.getText();
            estado = this.jestado1.getSelectedItem().toString();
            condicion = jestado3.getSelectedItem().toString();
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
        }
        jFISBN.setText("");
        jFObservacion.setText("");

        JOptionPane.showMessageDialog(null, " Registrado Correctamente", "Sistema", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jbguardar2ActionPerformed

    private void jbguardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardar3ActionPerformed
        // TODO add your handling code here:
         String cod, estado, observacion, estudiante, fecha_fin, ID;
        boolean flag = true;

        if (id.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ID del prestamo", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFObservacion1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese el ISBN", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFObservacion1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese alguna observacion", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFEstudiante1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese cod de estudiante", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (jFechaFin1.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese la fecha devuelta", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {
            ID = this.id.getText();
            cod = this.jFISBN1.getText();
            estado = this.jFCondicion1.getSelectedItem().toString();
            observacion = this.jFObservacion1.getText();
            estudiante = this.jFEstudiante1.getText();
            fecha_fin = this.jFechaFin1.getText();
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into DEVOLUCION_DETALLE (ID_DEVOLUCION,ISBN, ESTADO_DEV, OBSERVACION_DEV) values(?,?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, ID);    
                datos.setString(2, cod);
                datos.setString(3, estado);
                datos.setString(4, observacion);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }
            try {
                ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
                Connection con = coneccion.obtenerConexion();
                String sInsert = "insert into DEVOLUCION (ID_DEVOLUCION,CED_EST, FECHA_DEV) values(?,?,?)"; // Manipulacion de tablas
                PreparedStatement datos = con.prepareStatement(sInsert);
                datos.setString(1, ID);
                datos.setString(2, estudiante);
                datos.setString(3, fecha_fin);
                datos.executeUpdate();
                coneccion.cerrarConexion();
            } catch (Exception ex) {
                System.out.print(ex.getMessage());

            }
            jFISBN1.setText("");
            jFObservacion1.setText("");
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
        } else if (jobservmulta.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese alguna observación", "Information", JOptionPane.INFORMATION_MESSAGE);

        } else {

            valor = this.Valor.getText();
            estado = this.jmotivo.getSelectedItem().toString();
            medio = this.jmotivo1.getSelectedItem().toString();
            observacion = this.jobservmulta.getText();
            
            fecha_ini = convertTostring(jFechaemision.getDate());
            fecha_fin = convertTostring(jFechacobro.getDate());
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
        String valor, fecha_ini, observacion, estado;
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
        mostrardato(id.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.escritorioAdmin.removeAll();
        this.escritorioAdmin.updateUI();
        this.escritorioAdmin.add(jEjem);
        jEjem.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    public static String convertTostring(Date Date) {
        //Convenrsion a string formato de fecha
        DateFormat df;
        String fech = null;
        df = new SimpleDateFormat("yyyy-MM-d");
        fech = df.format(Date);
        return fech;
    }

    public static String fecha_in() {
        Date fecha = new Date();
        DateFormat ft = new SimpleDateFormat("yyyy-MM-d");
        return ft.format(fecha);
    }

    private void BuscEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscEstActionPerformed
        try {
            nombreest.setEditable(false);
            apellidoest.setEditable(false);
            correoest.setEditable(false);
            ConexionDB coneccion = new ConexionDB(); //Creamos un objeto de la clase Coneccion DB
            Connection con = coneccion.obtenerConexion();
            String cons = "SELECT * FROM ESTUDIANTE "
                    + "WHERE CED_EST ='" + Ced_prestamo.getText() + "'"; // Manipulacion de tablas
            ResultSet consulta = coneccion.consulta(cons);
            consulta.next();
            nombreest.setText(consulta.getString(2));
            apellidoest.setText(consulta.getString(3));
            correoest.setText(consulta.getString(4));
            coneccion.cerrarConexion();
        } catch (Exception ex) {
            System.out.print(ex.getMessage());

        }
    }//GEN-LAST:event_BuscEstActionPerformed

    private void cmdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAgregarActionPerformed
        GuardarPrestamo();
        String CodHer = lbCodHer.getText();
        String condicion = this.jFCondicion2.getText();
        String obsB = this.Descrip_prest.getText();
        String nombre = coseccion.getSelectedItem().toString();
        String ISBN = seccion.GetData("ISBN", "select isbn from RECURSOS_BIBLIOGRAFICOS where ISBN='" + nombre + "'");
        seccion.InsertarRegistro("insert into PRESTAMO_DETALLE(ID_PRESTAMO, ISBN, ESTADO_DET, OBSERVACION_DET) values('" + CodHer + "','" + ISBN + "','" + condicion + "','" + obsB + "')");
        jFCondicion2.setText("");
        Descrip_prest.setText("");

    }//GEN-LAST:event_cmdAgregarActionPerformed

    private void JprestacionInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_JprestacionInternalFrameOpened
        // TODO add your handling code here:
        updateCombo();
    }//GEN-LAST:event_JprestacionInternalFrameOpened

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Ced_prestamo.setEnabled(true);
        Cod_bib.setEnabled(true);
        Descrip_prest.setEnabled(true);
        jdescripcion2.setEnabled(true);
        jFCondicion2.setEnabled(true);
        nombreest.setEnabled(false);
        apellidoest.setEnabled(false);
        correoest.setEnabled(false);
        nuevo();
        updateCombo();
        Ced_prestamo.setText("");
        Cod_bib.setText("");
        Descrip_prest.setText("");
        jFCondicion2.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        // TODO add your handling code here:
        mostrarpedido(lbCodHer.getText());
        JTable_prestamo.setEnabled(false);
    }//GEN-LAST:event_cmdEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscEst;
    private javax.swing.JTextField Ced_prestamo;
    private javax.swing.JTextField Cod_bib;
    private javax.swing.JTextField Descrip_prest;
    private javax.swing.JTextField JISBN;
    private javax.swing.JTable JTable_prestamo;
    private javax.swing.JTable Jdev;
    private javax.swing.JTable Jpago;
    private javax.swing.JInternalFrame Jprestacion;
    private javax.swing.JTextField Valor;
    private javax.swing.JTextField Valor1;
    private javax.swing.JButton actDatos;
    private javax.swing.JTextField ape_adm;
    private javax.swing.JTextField apellidoest;
    private com.toedter.calendar.JDateChooser calendario;
    private javax.swing.JButton cmdAgregar;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JTextField codDevo1;
    private javax.swing.JButton consulta;
    private javax.swing.JTextField contra_adm;
    private javax.swing.JTextField correoest;
    private javax.swing.JComboBox coseccion;
    private javax.swing.JButton empleado;
    private javax.swing.JDesktopPane escritorioAdmin;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JInternalFrame jDevolucion;
    private javax.swing.JInternalFrame jEjem;
    private javax.swing.JComboBox jFCondicion1;
    private javax.swing.JTextField jFCondicion2;
    private javax.swing.JTextField jFEstudiante1;
    private javax.swing.JTextField jFISBN;
    private javax.swing.JTextField jFISBN1;
    private javax.swing.JTextField jFObservacion;
    private javax.swing.JTextField jFObservacion1;
    private javax.swing.JFormattedTextField jFechaFin1;
    private javax.swing.JFormattedTextField jFechaInicio1;
    private com.toedter.calendar.JDateChooser jFechacobro;
    private com.toedter.calendar.JDateChooser jFechaemision;
    private javax.swing.JFormattedTextField jFechaemision1;
    private javax.swing.JTextField jIdioma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel26;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JInternalFrame jUsuarios;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbguardar1;
    private javax.swing.JButton jbguardar2;
    private javax.swing.JButton jbguardar3;
    private javax.swing.JButton jbguardar4;
    private javax.swing.JButton jbguardar5;
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
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JLabel jlencabezado_empleado;
    private javax.swing.JLabel jlencabezado_empleado1;
    private javax.swing.JLabel jlencabezado_empleado2;
    private javax.swing.JLabel jlencabezado_empleado3;
    private javax.swing.JLabel jlencabezado_empleado4;
    private javax.swing.JLabel jlencabezado_empleado5;
    private javax.swing.JLabel jlencabezado_empleado7;
    private javax.swing.JTextField jlugar;
    private javax.swing.JComboBox jmotivo;
    private javax.swing.JComboBox jmotivo1;
    private javax.swing.JComboBox jnombre;
    private javax.swing.JTextField jobservmulta;
    private javax.swing.JTextField jobservmulta1;
    private javax.swing.JTextField jpaginas;
    private javax.swing.JTextField jtitulo;
    private javax.swing.JLabel lbCodHer;
    private javax.swing.JInternalFrame multa;
    private javax.swing.JTextField nom_adm;
    private javax.swing.JTextField nombreest;
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
