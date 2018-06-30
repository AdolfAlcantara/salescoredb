/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Almacen;

import Login.Login;
import Login.SQLConnections;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Almacen {

    /**
     *
     * @param cod recibe el codigo para buscar la medida
     * @return 
     * equivalencia[0] = kg
     * equivalencia[1] = g
     * equivalencia[2] = lb
     */
    public double[] equivalencia(String cod)
    {
        double[] equivalencias = new double[3];
        SQLConnections con = new SQLConnections(); 
        try {
            Connection cn = con.SQLConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT CODIGO_PRODUCTO,UNIDAD_MEDIDA_PRODUCTO FROM PRODUCTOS");
            while (rs.next()) {
                if (cod.equals(rs.getString(1))) {
                    double medida = rs.getDouble(2);
                    equivalencias[0] = medida;
                    equivalencias[1] = medida * 1000;
                    equivalencias[2] = medida * 2.2;
                    rs.close();
                    st.close();
                    cn.close();
                    System.out.println("Conversion exitosa");
                    return equivalencias;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
