/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appproyecto;

import Login.Login;
import Login.User;

/**
 *
 * @author alejandro
 */
public class main {

    /**
     */
    public static MainV mv = new MainV();
    public static Login log = new Login();
    
    public static void main(String[] args) {
        log.cargarArchivo();
        mv.setVisible(true);
    }
    
}
