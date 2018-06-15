/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class User implements Serializable {
    protected String user;
    protected String password;
    protected static ArrayList <User> USUARIOS = new ArrayList<>();
    protected static File FILE_USUARIOS;
    protected transient boolean logged;
    
    public User() {
        try {
            FILE_USUARIOS = new File("usuarios.txt");
            FILE_USUARIOS.createNewFile();
        } catch (NullPointerException | IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
   
    public User(String u, String p)
    {
        user = u;
        password = p;
    }
    
    /**
     * Esta funcion es para comprobar si el usuario ya existe al momento
     * de crearlo
     * @param p es el nombre del usuario
     * @return true si encuentra un usuario con el mismo nombre
     */
    public boolean usuarioFound(String p){
        if(USUARIOS!= null){
            return USUARIOS.stream().anyMatch((u) -> (u.user.equalsIgnoreCase(p)));
        }
        return false;
    }
    
    /**
     *
     * @param u nombre de usuario
     * @param p password
     * @return true si el nombre de usuario y la password coinciden
     */
    public boolean validarUsuario(String u, String p)
    {
        if (USUARIOS!=null)
        {
            return USUARIOS.stream().anyMatch((User us) -> (us.user.equalsIgnoreCase(u) 
                    && us.password.equalsIgnoreCase(p)));
        }
        return false;
    }
    
    /**
     * Se carga el archivo en esta funcion por si las moscas.
     * Se llama la funcion validarUsuario para evitar usuarios duplicados.
     * @param u user
     * @param p password
     * @return true si se crea el usuario
     */
    public boolean registrar(String u, String p)
    {
        cargarArchivo();
        if (!validarUsuario(u,p))
        {
            USUARIOS.add(new User(u,p));
            System.out.println("Registro exitoso");
            return true;
        }
        return false;
    }
    
    /**
     * Esta funcion carga los usuarios de un archivo de objetos
     * @return true si se cargo info del archivo
     */
    public boolean cargarArchivo()
    {
        if (FILE_USUARIOS.exists())
        {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_USUARIOS)))
            {
                USUARIOS = (ArrayList) in.readObject();
                in.close();
                System.out.println("Info cargada");
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    /**
     *
     * @param list recibe de parametro el ArrayList de usuarios
     * @param f es el archivo donde se guarda todo
     * @return true si se guardo
     */
    public boolean escribirArchivo(ArrayList list, File f)
    {
        if (!list.isEmpty())
        {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f)))
            {
                out.writeObject(list);
                System.out.println("Se guardo");
                out.flush();
                return true;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
