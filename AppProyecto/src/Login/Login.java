/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

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
    
    public Login()
    {
        user = new User();
    }
    
    /**
     *
     * @param s user
     * @param p passowrd
     * @return true si se loggea esta wea
     */
    public boolean login(String s, String p)
    {
        return (user.validarUsuario(p,p));
    }
    
    /**
     *
     * @param u user 
     * @param p password
     * @return true si se crea el usuario.
     * Tambien, se escribe en el archivo.
     */
    public boolean registrar(String u, String p)
    {
        if (user.registrar(u,p))
        {
            user.escribirArchivo(User.USUARIOS, User.FILE_USUARIOS);
            return true;
        }
        return false;
    }
}
