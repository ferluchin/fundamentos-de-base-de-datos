package clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionDB {

    Connection coneccion;//objeto de la clase Connection
    ResultSet rsDatos;
    Statement stSentencias;
    PreparedStatement Sentencias;

    public ConexionDB() {
        cargarDriver();//constructor de la clase
    }

    //metodo para cargar el driver
    public void cargarDriver() {
        try {
            try {
                Driver d = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();//llamamos al driver para bases de datos de acces
            } catch (InstantiationException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("No se puede cargar el driver");//exepcion si el driver no se cargo despliega mensaje por consola de error
            ex.printStackTrace();
        }
    }

    //metodo para obtener la coneccion a la BD
    public Connection obtenerConexion() {
        try {
            coneccion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BD_Biblioteca", "root", "");
        stSentencias = coneccion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY, ResultSet.CONCUR_UPDATABLE);
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede establecer conexion a base de dato");
            System.out.println("no se puede establecer conexion a base de datos");
            ex.printStackTrace();
        }

        return coneccion;//retorna la coneccion
    }

    //metodo para cerrar la coneccion
    public void cerrarConexion() {
        try {
            coneccion.close();//metodo que cierra la conexion a la base de datos
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet consulta(String sql) throws SQLException {
        try {
            rsDatos = stSentencias.executeQuery(sql);
        } catch (SQLException ex) {
            throw ex;
        }
        return rsDatos;
    }
}
