/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class SQLConnections {

    /**
     * Esta funcion es para guardar los usuarios en la tabla USUARIOS de la base de datos
     * @param u nombre de usuario
     * @param p password
     * El usuario de la computadora se guarda mediante una variable interna llamada username
     */
    protected void guardarEnBD(String u, String p) {
        String username = System.getProperty("user.name");
        try {
            Connection cn = SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_CREATE_USUARIOS(?, ?, ?)}");
            cs.setString(1, u);
            cs.setString(2, p);
            cs.setString(3, username);
            cs.execute();
            cs.close();
            System.out.println("Se guardo el usuario en la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Esta funcion genera una Connection que se utiliza al llamar todos los procedimientos en la aplicacion
     * @return Connection
     */
    public Connection SQLConnection() {
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            String url = "jdbc:db2://localhost:50000/Proyecto";
            Connection connection = DriverManager.getConnection(url, "db2admin", "davila");
            if (connection.equals(null)) {
                System.out.println("connection was failed");
                return null;
            } else {
                System.out.println("connected successfully");
                return connection;
            }
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    /**
     *
     * @param u
     * @param p
     * @return
     */
    protected boolean cargarDeBD(String u, String p) {
        try {
            Connection cn = SQLConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT NOMBRE,PASSWORD FROM USUARIOS");
            while (rs.next()) {
                if (u.equals(rs.getString(1)) && p.equals(rs.getString(2))) {
                    rs.close();
                    st.close();
                    cn.close();
                    System.out.println("Usuario encontrado en tabla USUARIOS");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
