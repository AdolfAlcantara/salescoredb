/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 * Esta clase es la base para el login visual
 * @author alejandro
 */
public class Login {
    
    /**
     * Este objeto es solo para llamar metodos 
     * de manera directa. Se inicializa en el constructor.
     */
    public static User USER_LOGGED = new User();
    //protected static File FILE_USUARIOS;
    //protected static ArrayList<User> USUARIOS=new ArrayList<>(); 
    
    public Login()
    {
        /*try {
            FILE_USUARIOS = new File("usuarios.txt");
            FILE_USUARIOS.createNewFile();
        } catch (NullPointerException | IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex); 
        }*/
    }
    
/*        
    /**
     * Esta funcion es para comprobar si el usuario ya existe al momento
     * de crearlo
     * @param p es el nombre del usuario
     * @return true si encuentra un usuario con el mismo nombre
     
    public boolean usuarioFound(String p){
        if(USUARIOS!= null){
            return USUARIOS.stream().anyMatch((u) -> (u.user.equalsIgnoreCase(p)));
        }
        return false;
    }
    */
    /**
     *
     * @param u nombre de usuario
     * @param p password
     * @return true si el nombre de usuario y la password coinciden
     */
    public boolean validarUsuario(String u, String p)
    {
        SQLConnections cn = new SQLConnections();
        return cn.cargarDeBD(u,p);
    }
    
    /**
     * Se llama la funcion validarUsuario para evitar usuarios duplicados.
     * @param u user
     * @param p password
     * @return true si se crea el usuario
     */
    public boolean registrar(String u, String p)
    {
        SQLConnections cn = new SQLConnections();
        if (u.equals(""))
            return false;
        if (!validarUsuario(u,p))
        {
            //USUARIOS.add(new User(u,p));
            System.out.println("Registro exitoso");
            //escribirArchivo(USUARIOS, FILE_USUARIOS);
            cn.guardarEnBD(u, p);
            return true;
        }
        return false;
    }
    
    /**
     * Esta funcion carga los usuarios de un archivo de objetos
     * @return true si se cargo info del archivo
     */
 /*   public boolean cargarArchivo()
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
/*    
    /**
     *
     * @param list recibe de parametro el ArrayList de usuarios
     * @param f es el archivo donde se guarda todo
     * @return true si se guardo
     
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
 */   
    /**
     *
     * @param s user
     * @param p passowrd
     * @return true si se loggea esta wea
     */
    public boolean login(String s, String p)
    {
        SQLConnections cn = new SQLConnections();
        if (validarUsuario(s,p)){
            USER_LOGGED.user = s;
            USER_LOGGED.password = p;
            return true;
        }
        /*if (validarUsuario(s,p))
        {
            SQLConnection();
            return true;
        }*/
        System.out.println("Login failed");
        return false;
    }
    
    /**
     * Esta funcion es para guardar los usuarios en la tabla USUARIOS de la base de datos
     * @param u nombre de usuario
     * @param p password
     * El usuario de la computadora se guarda mediante una variable interna llamada username
     */
    protected void guardarEnBD(String u, String p)
    {
        String username = System.getProperty("user.name");
        try{
            Connection cn = SQLConnection();
            CallableStatement cs = cn.prepareCall("{call SP_CREATE_USUARIOS(?, ?, ?)}");
            cs.setString(1, u);
            cs.setString(2, p);
            cs.setString(3, username);
            cs.execute();
            cs.close();
            System.out.println("Se guardo el usuario en la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Esta funcion genera una Connection que se utiliza al llamar todos los procedimientos en la aplicacion
     * @return Connection
     */
    public Connection SQLConnection()
    {
        try {
                Class.forName("com.ibm.db2.jcc.DB2Driver");
                String url = "jdbc:db2://192.168.56.101:50000/proyecto";
                Connection connection = DriverManager.getConnection(url,"db2admin","hitler45");
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
    
    public DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
}
