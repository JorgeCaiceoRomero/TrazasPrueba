package controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import vista.Main;


public class Conexion {

    static String bd ;
    static String JDBC_USER ;
    static  String JDBC_PASS ;
    static  String JDBC_DB_HOST ; //localhost
    static  String JDBC_BD ;
    static  String JDBC_DRIVER ;
    static  String JDBC_DB_URL ;

    //private static GenericObjectPool gPool = null;

    public Conexion() {
     
        JDBC_USER = "root";
        JDBC_PASS = "";
        JDBC_DB_HOST = "127.0.0.1/"; 
        JDBC_BD = "prueba_serbatic";
        JDBC_DRIVER = "com.mysql.jdbc.Driver";
        JDBC_DB_URL = "jdbc:mysql://";
    }

   /* public static DataSource setUpPool() {
        try {
            Class.forName(JDBC_DRIVER);

            // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
      //      gPool = new GenericObjectPool();
        //    gPool.setMaxActive(5);

            // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
          //  ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL+JDBC_DB_HOST+ JDBC_BD, JDBC_USER, JDBC_PASS);

            // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
            //PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);

             System.out.println("La conexion a la  base de datos " + JDBC_BD + " se ha conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return new PoolingDataSource(gPool);
    }*/

    /*public static GenericObjectPool getConnectionPool() {
        return gPool;

    }*/

    public static void desconectar() {
        try {

           // gPool.close();
            //gPool = null;
            System.out.println("La conexion a la  base de datos " + JDBC_BD + " ha terminado");
            Main.logger.warn("Se ha terminado la conexion con la BD");
        //} catch (SQLException e) {
          //  System.out.println("Error al cerrar la conexion");
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static void printDbStatus() {
      //  System.out.println("Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());

    }
}