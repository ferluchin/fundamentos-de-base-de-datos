package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlclass {

    ConexionDB con;

    public sqlclass() {
        con = new ConexionDB();
    }

    public boolean existe(String tabla, String colName, String id) {
        int registros = 0;
        try {
            PreparedStatement pstm = con.obtenerConexion().prepareStatement("SELECT count(1) as total FROM " + tabla + " where " + colName + " = ?");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (registros > 0) {
            return true;
        } else {
            return false;
        }
    }

//Insert
    public void InsertarRegistro(String sql) {
        try {
            PreparedStatement pstm = con.obtenerConexion().prepareStatement(sql);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Object[] GetColumna(String tabla, String colName, String sql) {
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = con.obtenerConexion().prepareStatement("SELECT count(1) as total FROM " + tabla);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        Object[] data = new String[registros];
        try {
            PreparedStatement pstm = con.obtenerConexion().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                data[i] = res.getString(colName);
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

    public String GetData(String colName, String sql) {
        String data = new String();
        try {
            PreparedStatement pstm = con.obtenerConexion().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                data = res.getString(colName);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

}
