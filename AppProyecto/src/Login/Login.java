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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es la base para el login visual
 * @author alejandro
 */
public class Login {
    
    /**
     * Este objeto es solo para llamar metodos 
     * de manera directa. Se inicializa en el constructor.
     */
    protected User user;
    protected static File FILE_USUARIOS;
    protected static ArrayList<User> USUARIOS=new ArrayList<>(); 
    
    public Login()
    {
        try {
            FILE_USUARIOS = new File("usuarios.txt");
            FILE_USUARIOS.createNewFile();
        } catch (NullPointerException | IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex); 
        }
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
     * Se llama la funcion validarUsuario para evitar usuarios duplicados.
     * @param u user
     * @param p password
     * @return true si se crea el usuario
     */
    public boolean registrar(String u, String p)
    {
        if (u.equals(""))
            return false;
        if (!validarUsuario(u,p))
        {
            USUARIOS.add(new User(u,p));
            System.out.println("Registro exitoso");
            escribirArchivo(USUARIOS, FILE_USUARIOS);
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
    
    public void printList()
    {
        for (User u: USUARIOS)
           System.out.println(u.toString());
    }
    
    /**
     *
     * @param s user
     * @param p passowrd
     * @return true si se loggea esta wea
     */
    public boolean login(String s, String p)
    {
        if (validarUsuario(s,p))
        {
            SQLConnection();
            return true;
        }
        System.out.println("Login failed");
        return false;
    }
    
    public Connection SQLConnection()
    {
        try {
                Class.forName("com.ibm.db2.jcc.DB2Driver");
                String url = "jdbc:db2://localhost:50000/Proyecto";
                Connection connection = DriverManager.getConnection(url,"db2admin","davila");
                if(connection.equals(null)) 
                {
                    System.out.println("connection was failed");
                    return null;
                }
                else
                {
                    System.out.println("connected successfully");
                    return connection;
                }
            }
            catch(ClassNotFoundException | SQLException exception)
            {
                System.out.println(exception.getMessage());
            }
        return null;
    }
}
