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
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class OrdenCompras {
    
    /**
     * Esta funcion genera orden de compras. 
     * @param noOrden
     * @param estado
     * @param lugar
     * @param fecha
     * @param condicion
     * @param total
     * @param codProv debe existir previamente
     * @param noDetalle debe existir previamente
     */
    public void createOrdenC(String noOrden, String estado, String lugar, Timestamp fecha, String condicion, double total, String codProv, String noDetalle)
    {
        SQLConnections cons = new SQLConnections();
        try{
            Connection cn = cons.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_CREATE_ORDEN_COMPRAS(?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, noOrden);
            cs.setString(2, estado);
            cs.setString(3, lugar);
            cs.setTimestamp(4, fecha);
            cs.setString(5, condicion);
            cs.setDouble(6, total);
            cs.setString(7, codProv);
            cs.setString(8, noDetalle);
            cs.execute();
            cs.close();
            System.out.println("Se creo Orden de Compra exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateOrdenC(String noOrden, String estado, String lugar, Timestamp fecha, String condicion, double total, String codProv, String noDetalle)
    {
        SQLConnections cons = new SQLConnections();
        try{
            Connection cn = cons.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_UPDATE_ORDEN_COMPRAS(?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, noOrden);
            cs.setString(2, estado);
            cs.setString(3, lugar);
            cs.setTimestamp(4, fecha);
            cs.setString(5, condicion);
            cs.setDouble(6, total);
            cs.setString(7, codProv);
            cs.setString(8, noDetalle);
            cs.execute();
            cs.close();
            System.out.println("Se actualizo Orden de Compra exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteOrdenC(String noOrden)
    {
        SQLConnections cons = new SQLConnections();
        try{
            Connection cn = cons.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_DELETE_ORDEN_COMPRAS(?)}");
            cs.setString(1, noOrden);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Orden de compra borrada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Esta funcion es para generar Documento de Orden de Compra
     * @param noDocumento
     * @param noOrdenCompra
     */
    public void createOrdenCompraDocumento(String noDocumento, String noOrdenCompra)
    {
        SQLConnections con = new SQLConnections();
        try{
            Connection cn = con.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_CREATE_ORDEN_COMPRA_DOCUMENTOS(?, ?)}");
            cs.setString(1, noDocumento);
            cs.setString(2, noOrdenCompra);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Documento de Orden de Compra creado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteOrdenCompraDocumento(String noOrdenCompra)
    {
        SQLConnections con = new SQLConnections();
        try{
            Connection cn = con.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_DELETE_ORDEN_COMPRA_DOCUMENTOS(?)}");
            cs.setString(1, noOrdenCompra);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Documento de Orden de Compra borrado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(OrdenCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
