/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import Login.SQLConnections;
import static java.lang.Math.random;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class Documentos {
    
    /**
     * Esta funcion es para crear registros en la tabla DOCUMENTOS
     * @param noDocumento
     * @param observaciones
     * @param descuento
     * @param precio
     * @param cantProductos
     */
    public void createDocumentos(String noDocumento, String observaciones, double descuento, double precio, int cantProductos)
    {
        SQLConnections con = new SQLConnections();
        try{
            Connection cn = con.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_CREATE_DOCUMENTOS(?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, noDocumento);
            cs.setString(2, observaciones);
            Timestamp fecha = Timestamp.valueOf(LocalDateTime.now());
            cs.setTimestamp(3, fecha);
            cs.setDouble(4, descuento);
            cs.setDouble(5, precio);
            cs.setInt(6, cantProductos);
            double importeTotal = cantProductos * precio - (precio*descuento);
            cs.setDouble(7, importeTotal);
            Random ram = new Random();
            int ctaCte = ram.nextInt(2000) + 1;
            cs.setString(8, String.valueOf(ctaCte));
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Documento creado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDocumentos(String noDocumento, String observaciones, double descuento, double precio, int cantProductos)
    {
        SQLConnections con = new SQLConnections();
        try{
            Connection cn = con.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_UPDATE_DOCUMENTOS(?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setString(1, noDocumento);
            cs.setString(2, observaciones);
            Timestamp fecha = Timestamp.valueOf(LocalDateTime.now());
            cs.setTimestamp(3, fecha);
            cs.setDouble(4, descuento);
            cs.setDouble(5, precio);
            cs.setInt(6, cantProductos);
            double importeTotal = cantProductos * precio - (precio*descuento);
            cs.setDouble(7, importeTotal);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Documento actualizado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void deleteDocumentos(String noDocumento)
    {
        SQLConnections con = new SQLConnections();
        try{
            Connection cn = con.SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_DELETE_DOCUMENTOS(?)}");
            cs.setString(1, noDocumento);
            cs.execute();
            cs.close();
            cn.close();
            System.out.println("Documento borrado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void asignarCCProveedor(String noOrdenCompra)
    {
        SQLConnections con = new SQLConnections();
        try{           
            Connection cn = con.SQLConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT O.NO_ORDEN_COMPRA,O.CODIGO_PROVEEDOR,D.NO_CUENTA_CORRIENTE "
                    + "FROM ORDEN_COMPRAS O INNER JOIN ORDEN_COMPRA_DOCUMENTOS C ON O.NO_ORDEN_COMPRA = C.NO_ORDEN_COMPRA"
                    + "INNER JOIN DOCUMENTOS D ON C.NO_DOCUMENTO = D.NO_DOCUMENTO");
            while (rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(noOrdenCompra)) {
                    String codigoProveedor = rs.getString(2);
                    String cc = rs.getString(3);
                    ResultSet rs1 = st.executeQuery("UPDATE PROVEEDORES SET NO_CUENTA_CORRIENTE = "+cc+" WHERE CODIGO_PROVEEDOR = "+codigoProveedor);
                    rs.close();
                    rs1.close();
                    st.close();
                    cn.close();
                    System.out.println("Usuario encontrado en tabla USUARIOS");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Documentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
