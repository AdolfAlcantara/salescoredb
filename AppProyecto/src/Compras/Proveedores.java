/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Login.Login;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Proveedores {
    
    public void registrarProveedor(String cod, String est, String nom, String city, int cal, int ave)
    {
        Login log = new Login();
        try{
           Connection cn = log.SQLConnection();
           CallableStatement cs = cn.prepareCall("{call SP_CREATE_PROVEEDORES(?, ?, ?, ?, ?, ?)}");
           cs.setString(1, cod);
           cs.setString(2, est);
           cs.setString(3, nom);
           cs.setString(4, city);
           cs.setInt(5, cal);
           cs.setInt(6, ave);
           cs.execute();
           cn.close();
           System.out.println("Se creo Proveedor de manera exitosa");
        }
        catch (SQLException ex){
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }        
    
    public void actualizarProveedor(String cod, String est, String nom, String city, int cal, int ave, String noCta)
    {
        Login log = new Login();
        try
        {
            Connection cn = log.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_UPDATE_PROVEEDORES(?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, cod);
            cs.setString(2, est);
            cs.setString(3, nom);
            cs.setString(4, city);
            cs.setInt(5, cal);
            cs.setInt(6, ave);
            cs.setString(7, noCta);
            cs.execute();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
