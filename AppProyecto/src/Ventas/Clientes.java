/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Compras.Proveedores;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Login.SQLConnections;

/**
 *
 * @author FuryCoder
 */
public class Clientes {
    SQLConnections log = new SQLConnections();
    Connection con = log.SQLConnection();

    public void regtClientes(String name, String city, int ave, int street){
        try{
            CallableStatement cs = con.prepareCall("{CALL SP_CREATE_CLIENTE(?,?,?,?,?)}");
            cs.setString(1, "0");
            cs.setString(2, name);
            cs.setString(3, city);
            cs.setInt(4, street);
            cs.setInt(5, ave);
            cs.execute();
            con.close();
        }catch(Exception e){
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }
    
    public void actClientes(String codigo,String name, String city, int ave, int street){
        try{
            CallableStatement cs;
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT codigo_cliente FROM CLIENTES WHERE codigo_cliente =?");
            ps.setString(1,codigo);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                cs = con.prepareCall("{CALL SP_UPDATE_CLIENTES(?,?,?,?,?)}");
                cs.setString(1, codigo);
                cs.setString(2, name);
                cs.setString(3, city);
                cs.setInt(4, street);
                cs.setInt(5, ave);
                cs.execute();
                con.close();
            }else{
                JOptionPane.showMessageDialog(null, "El cliente con codigo "+codigo+" no existe.", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void delClientes(String code){
        try{
            CallableStatement cs = con.prepareCall("{CALL SP_DELETE_CLIENTES(?)}");
            cs.setString(1, code);
            cs.execute();
            con.close();
        }catch (Exception e){
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String[][] tableValues(){
        String [][] valoresN;
        System.out.println("lbefore try?");
        try{
            System.out.println("lbefore statement?");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM VER_CC_CLIENTE");
            System.out.println("results?");
            ResultSet rs = ps.executeQuery();
            System.out.println("lbefore metadata?");
            ResultSetMetaData rsmd = rs.getMetaData();
            int countColumns = rsmd.getColumnCount();
            System.out.println("columnas: "+countColumns);
            int y=0;
            valoresN = new String [1050][countColumns];
            System.out.println("lbefore?");
            while(rs.next()){
//                System.out.println("loop while?");
//                actualRow+=1;
//                String [][] valores = new String[actualRow][countColumns];
//                
//                for(int x=0;x<valoresN.length;x++){
//                    for(int y=0;y<valoresN[actualRow].length;y++){
////                        for(int column=1;column<=countColumns;column++){\
                            
                            valoresN[y][0] = rs.getString(1);
                            valoresN[y][1] = rs.getString(2);
                            valoresN[y][2] = rs.getString(3);
                            valoresN[y][3] = String.valueOf(rs.getDouble(4));
////                        }
//                    }
//                }
//                valoresN = new String[actualRow][countColumns];
//                 for(int x=0;x<valoresN.length;x++){
//                    for(int y=0;y<valores[actualRow-1].length;y++){
//                        
//                    }
//                 }
                y+=1;
            };
            return valoresN;
        }catch(Exception e){
            System.out.println("catch?");
            e.printStackTrace();
        }
        return null;
    }
    
    public String[] tableColumnNames(){
        String[] nombres;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM VER_CC_CLIENTE");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantColumn = rsmd.getColumnCount();
            nombres = new String[cantColumn];
            for(int x=0;x<cantColumn;x++){
                nombres[x] = rsmd.getColumnName(x+1);
            }
            return nombres;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
