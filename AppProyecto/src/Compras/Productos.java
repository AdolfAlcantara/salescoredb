/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Login.Login;
import Login.SQLConnections;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Productos {
   
    /**
     * Con esta funcion crea Productos locales (tabla PRODUCTOS)
     * @param cod
     * @param line
     * @param tipo
     * @param activo
     * @param medida
     * @param centro
     * @param destino
     * @param descripcion
     * @param control
     * @param stockMin
     * @param stockMax
     */
    public void createProductoL(String cod, String line, String tipo, String activo, double medida, int centro, String destino, String descripcion)
    {
       SQLConnections cons = new SQLConnections();
       try{
           Connection con = cons.SQLConnection();
           CallableStatement cs = con.prepareCall("{call SP_CREATE_PRODUCTOS(?, ?, ?, ?, ?, ?, ?, ?)}");
           cs.setString(1, cod);
           cs.setString(2, line);
           cs.setString(3, tipo);
           cs.setString(4, activo);
           cs.setDouble(5, medida);
           cs.setInt(6, centro);
           cs.setString(7, destino);
           cs.setString(8, descripcion);
           cs.execute();
           cs.close();
           con.close();
           System.out.println("Se creo Producto Local exitosamente");
           //createProductoA(cod,control,stockMin,stockMax);           
       } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Funcion para actualizar productos en la tabla PRODUCTOS
     * @param cod
     * @param line
     * @param tipo
     * @param activo
     * @param medida
     * @param centro
     * @param destino
     * @param descripcion
     * @param control
     * @param stockMin
     * @param stockMax
     */
    public void updateProductoL(String cod, String line, String tipo, String activo, double medida, int centro, String destino, String descripcion)
    {
        SQLConnections con = new SQLConnections();
        try{
           Connection cn = con.SQLConnection();
           CallableStatement cs = cn.prepareCall("{call SP_UPDATE_PRODUCTOS(?, ?, ?, ?, ?, ?, ?, ?)}");
           cs.setString(1, cod);
           cs.setString(2, line);
           cs.setString(3, tipo);
           cs.setString(4, activo);
           cs.setDouble(5, medida);
           cs.setInt(6, centro);
           cs.setString(7, destino);
           cs.setString(8, descripcion);
           cs.execute();
           cs.close();
           cn.close();
           System.out.println("Se actualizo Producto Local exitosamente");
           //updateProductoA(cod,control,stockMin,stockMax);
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Funcion para borrar Productos almacenados en tabla PRODUCTOS
     * @param cod
     */
    public void deleteProductoL(String cod)
    {
        SQLConnections con = new SQLConnections();
        try{
            //deleteProductoA(cod);
            Connection cn = con.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_DELETE_PRODUCTOS(?)}");
            cs.setString(1, cod);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Producto Local borrado exitosamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Esta funcion crea productos almacenados (tabla PRODUCTO_A)
     * @param cod
     * @param control
     * @param stockMin
     * @param stockMax
     */
    public void createProductoA(String cod, int control, int stockMin, int stockMax)
    {
        SQLConnections cons = new SQLConnections();
        try{
            //createProductoL(cod,"","","",0,0,"","");
            Connection con = cons.SQLConnection();
            CallableStatement cs = con.prepareCall("{call SP_CREATE_PRODUCTOS_A(?, ?, ?, ?)}");
            cs.setString(1, cod);
            cs.setInt(2, control);
            cs.setInt(3, stockMin);
            cs.setInt(4, stockMax);
            cs.execute();
            cs.close();
            System.out.println("Se creo Producto Almacenado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Funcion que actualiza productos en la tabla PRODUCTOS_A
     * @param cod
     * @param control
     * @param stockMin
     * @param stockMax
     */
    public void updateProductoA(String cod, int control, int stockMin, int stockMax)
    {
        SQLConnections cons = new SQLConnections();
        try{
            Connection con = cons.SQLConnection();
            CallableStatement cs = con.prepareCall("{call SP_UPDATE_PRODUCTOS_A(?, ?, ?, ?)}");
            cs.setString(1, cod);
            cs.setInt(2, control);
            cs.setInt(3, stockMin);
            cs.setInt(4, stockMax);
            cs.execute();
            cs.close();
            con.close();
            System.out.println("Se actualizo Producto Almacenado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteProductoA(String cod)
    {
        SQLConnections cons = new SQLConnections();
        try{
            Connection cn = cons.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_DELETE_PRODUCTOS_A(?)}");
            cs.setString(1, cod);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Producto Almacenado borrado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
