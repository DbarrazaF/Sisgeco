/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;
import Negocio.Decreto;
import Registros.archivoLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class TDecreto {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo que permite rescatar tabla de datos
    public List<Decreto> listarDecreto(String ano_postu, String nro_ingreso) {
        List<Decreto> lista = new ArrayList<Decreto>();

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Decreto where( ano_postu_proyecto='" + ano_postu + "' && nro_ingreso_proyecto='" + nro_ingreso + "')");

            while (resul.next()) {
                lista.add(new Decreto(resul.getString(1), resul.getString(2),
                        resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));

            }
            orden.close();
            resul.close();

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LD " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDecreto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;
    }

//Metodo de ingreso de datos
    public boolean insertarDecreto(Decreto decreto) {
        boolean ing = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO decreto VALUES('" + decreto.getNro_decreto() + "',"
                    + "'" + decreto.getFecha_decreto() + "','" + decreto.getFecha_retiro_cheque_decreto() + "',"
                    + "'" + decreto.getRetira_cheque_decreto() + "','" + decreto.getAno_postu_proyecto() + "',"
                    + "'" + decreto.getNro_ingreso_proyecto() + "','" + decreto.getEstado_decreto() + "')";

            ing = conex.efectuarTransaccionBD(sql, canal);
            if (ing) {
                System.out.println("Deccreto Ingresado...");
            } else {
                System.out.println("Decreto NO Ingresado...");
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ID " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDecreto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {

            conex.cerrarConexionURL(canal);
        }
        return ing;
    }
    //Metodo para modificar datos

    public boolean modificarDecreto(Decreto decreto) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE decreto SET fecha_retiro_cheque_decreto='" + decreto.getFecha_retiro_cheque_decreto() + "',retira_cheque_decreto='" + decreto.getRetira_cheque_decreto() + "'"
                    + ",estado='" + decreto.getEstado_decreto() + "' WHERE 	nro_decreto='" + decreto.getNro_decreto() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Decreto Modificado...");
            } else {
                System.out.println("Decreto NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MD " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDecreto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

}
