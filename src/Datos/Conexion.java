/*Patron Singleton que genera un gateway o pasarela entre aplicacion y BD
 */
package Datos;

import java.sql.*;
import Registros.archivoLog;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    archivoLog archi=new archivoLog();
    String DRIVER = "com.mysql.jdbc.Driver";
    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    
    public Conexion() {
    }

    public Connection abrirConexionURL() {
        try { //Publicar Driver
            Class.forName(DRIVER);



//            canal = DriverManager.getConnection("jdbc:mysql://192.168.17.67/coves_proyectos", "Coves", "root");
            canal = DriverManager.getConnection("jdbc:mysql://localhost/coves_proyectos", "Coves", "root");
            orden = canal.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problema de Ubicar URL :" + e.getMessage());
            try {
                archi.crearLog("Problema de Ubicar URL :" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return canal;
    }

    public void cerrarConexionURL(Connection canal) {
        try {
            canal.close();
        } catch (SQLException e) {
            System.out.println("Problema de Cerrar URL :" + e.getMessage());
        }

    }

    //Generar trigger de bd//INSERT/UPDATE/DELETE
    public boolean efectuarTransaccionBD(String sql, Connection canal) {
        boolean ok = false;
        try {//Validar sentencia de control en espacio Virtual
            orden = canal.prepareStatement(sql);
            try {//Generar compromiso con la BD//COMMITT
                orden.execute(sql);
                ok = true;
            } catch (SQLException e) {
                System.out.println("ERROR de Compromiso..." + e.getMessage());
                try {
                    archi.crearLog("Problema de Ubicar URL :" + e.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
                ok = false;
            }
        } catch (SQLException e) {
            System.out.println("ERROR en Transaccion..." + e.getMessage());
            try {
                archi.crearLog("Problema de Ubicar URL :" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            ok = false;
        }
        return ok;
    }

    public ResultSet ejecutarConsultaBD(String sql, PreparedStatement ps) {
        try {//Llenar vector de datos 
            resul = ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("ERROR en Transaccion SQL..." + e.getMessage());
        }
        return resul;
    }
    public Connection ConexionPrueba( ) {
        try { //Publicar Driver
            Class.forName(DRIVER);

            canal = DriverManager.getConnection("jdbc:mysql://localhost/" ,"root", "system");
            orden = canal.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problema de Ubicar URL de prueba :" + e.getMessage());
            try {
                archi.crearLog("Problema de Ubicar URL de prueba :" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return canal;
    }
            
}
