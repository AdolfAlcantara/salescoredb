/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Login.Login;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FuryCoder
 */
public class OrdenPedido {
    
    Login log =  new Login();
    
    public ArrayList<String> productOptions(){
        try{
            Connection con = log.SQLConnection();
            PreparedStatement ps = con.prepareStatement("Select DESCRIPCION_PRODUCTO AS PRODUCTO FROM PRODUCTOS");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> productos = new ArrayList<>();
            while(rs.next()){
                productos.add(rs.getString("PRODUCTO"));
            }
            return productos;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public String getProductProperties(String producto){
        try{
            Connection con = log.SQLConnection();
            PreparedStatement ps = con.prepareStatement("Select CODIGO_PRODUCTO FROM PRODUCTOS where descripcion_producto = ?");
            ps.setString(1, producto);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int getNoOrdenPedido(){
        try{
            Connection con = log.SQLConnection();
            PreparedStatement ps = con.prepareStatement("Select count(NO_ORDEN_PEDIDO)+1 FROM ORDEN_PEDIDOS");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Integer.parseInt(rs.getString(1));
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public int getNoDetalle(){
        try{
            Connection con = log.SQLConnection();
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(NO_DETALLE)+1 AS CANTIDAD FROM DETALLES;");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return Integer.parseInt(rs.getString(1));
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public void registrarOrdenCompra(int orden_pedido,String lugar_entrega,String condicion,double total,String tipo,int codigo_cliente,int no_detalle){
        try{
            Connection con = log.SQLConnection();
            CallableStatement cs = con.prepareCall("{Call SP_CREATE_ORDEN_PEDIDOS(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1,String.valueOf(orden_pedido));
            cs.setString(2,"Completo");
            cs.setString(3,lugar_entrega);
            cs.setString(4, condicion);
            cs.setTimestamp(5,new Timestamp(new Date().getTime()));
            cs.setDouble(6, total);
            cs.setString(7, tipo);
            cs.setString(8, String.valueOf(codigo_cliente));
            cs.setString(9, String.valueOf(no_detalle));
            cs.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
