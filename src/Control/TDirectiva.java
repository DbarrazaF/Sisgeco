package Control;

import Datos.Conexion;
import Negocio.Control_Directiva;
import Negocio.Directiva;
import Registros.archivoLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TDirectiva {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarDirectiva(Directiva direc) {
        boolean ing = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO directiva VALUES('" + direc.getRut_dirigente() + "','" + direc.getRut_coves() + "',"
                    + "'" + direc.getCargo_dirigente() + "')";

            ing = conex.efectuarTransaccionBD(sql, canal);
            if (ing) {
                System.out.println("Dirigente Asignado...");
            } else {
                System.out.println("Dirigente NO Asignado...");
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ID" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirectiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ing;
    }

    //Metodo que permite rescatar tabla de datos
    public List<Control_Directiva> listarDirectivaDirigente(String rut_coves) {
        List<Control_Directiva> lista = new ArrayList<Control_Directiva>();

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT dirigente.rut_dirigente,dirigente.nombre_dirigente,dirigente.apellido_pat_dirigente,directiva.cargo_dirigente,dirigente.telefono_dirigente from directiva "
                    + "join dirigente where dirigente.rut_dirigente=directiva.rut_dirigente and directiva.rut_coves='" + rut_coves + "'");

            while (resul.next()) {
                lista.add(new Control_Directiva(resul.getString(1), resul.getString(2),
                        resul.getString(3), resul.getString(4), resul.getString(5)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LDD" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirectiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(TDirectiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

    //Metodo para modificar datos
    public boolean modificarDirectiva(Directiva directiva) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            System.out.println(directiva.getCargo_dirigente());
            sql = "UPDATE directiva SET cargo_dirigente='" + directiva.getCargo_dirigente() + "' WHERE rut_dirigente='" + directiva.getRut_dirigente() + "' && rut_coves='" + directiva.getRut_coves() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Dirigente Modificado...");
            } else {
                System.out.println("Dirigente NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MD" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirectiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }
    //metodo para eliminar datos

    public boolean Retirar_dirigente(String rut_coves, String rut_dirigente) {
        boolean elim = false;
        try {
            canal = conex.abrirConexionURL();
            sql = "DELETE FROM directiva WHERE rut_dirigente='" + rut_dirigente + "' && rut_coves='" + rut_coves + "'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("Dirigente RETIRADO...");
            } else {
                System.out.println("Dirigente PERDIDO.....");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. RD " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirectiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }

    //Metodo de busqueda de datos
    public String[] buscarDirigenteDirectiva(String rut_diri) {
        String[] vector = new String[3];

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT nombre_dirigente,apellido_pat_dirigente, apellido_mat_dirigente FROM dirigente WHERE rut_dirigente='" + rut_diri + "'");

            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));
                vector[2] = new String(resul.getString(3));

            } else {
                vector[0] = "";
            }
            orden.close();
            resul.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BDD" + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BDD" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirectiva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vector;

    }

}
