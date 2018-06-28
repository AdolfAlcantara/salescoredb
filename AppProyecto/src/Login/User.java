/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.Serializable;

/**
 *
 * @author alejandro
 */
public class User implements Serializable {
    public String user;
    protected String password;
    protected transient boolean logged;
    
    public User() {
        
    }
   
    public User(String u, String p)
    {
        user = u;
        password = p;
    }

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", password=" + password + '}';
    }
    
}
