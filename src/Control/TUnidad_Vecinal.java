/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;

import Negocio.Unidad_Vecinal;
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

/**
 *
 * @author Daniel
 */
public class TUnidad_Vecinal {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

//Metodo de ingreso de datos
    public boolean insertarUnidadVecinal(Unidad_Vecinal unidad) {
        boolean ins = false;

        try {

            canal = conex.abrirConexionURL();
            sql = "INSERT INTO unidad_vecinal VALUES('" + unidad.getCod_unidad() + "','" + unidad.getNombre_unidad() + "','" + unidad.getCod_sector() + "')";
            ins = conex.efectuarTransaccionBD(sql, canal);
            if (ins) {
                System.out.println("Coves Ingresado...");
            } else {
                System.out.println("Coves NO Ingresado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.IUV " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TUnidad_Vecinal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }

        return ins;
    }

    //Metodo que permite rescatar tabla de datos
    public List<Unidad_Vecinal> listarUnidadVecinal() {
        List<Unidad_Vecinal> lista = new ArrayList<Unidad_Vecinal>();

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM unidad_vecinal ORDER BY CAST(cod_unidad AS INT) ASC ");

            while (resul.next()) {
                lista.add(new Unidad_Vecinal(resul.getString(1), resul.getString(2),
                        resul.getString(3)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.LUV " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TUnidad_Vecinal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(TFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

    //Metodo para modificar datos
    public boolean modificarUnidadVecinal(Unidad_Vecinal unidad_vecinal) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE unidad_vecinal SET nombre_unidad='" + unidad_vecinal.getNombre_unidad() + "'"
                    + "where cod_unidad='" + unidad_vecinal.getCod_unidad() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Unidad Vecinal Modificada...");

            } else {
                System.out.println("Unidad Vecinal NO Modificada...");
            }
        } catch (Exception e) {

            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MUV " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TUnidad_Vecinal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //Metodo de busqueda de datos
    public String[] buscarUnidad_Vecinal(String cod_unidad) {

        String[] vector = new String[4];

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM unidad_vecinal WHERE cod_unidad='" + cod_unidad + "'");

            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));
                vector[2] = new String(resul.getString(3));

            } else {
                vector[0] = new String("");
                vector[1] = new String("");
                vector[2] = new String("");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BUV " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TUnidad_Vecinal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(TFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vector;
    }
    //metodo para eliminar datos
    public boolean eliminarUnidad(String cod_unidad) {
        boolean elim = false;
        try {
            canal = conex.abrirConexionURL();
            sql = "DELETE FROM unidad_vecinal WHERE cod_unidad='"+ cod_unidad +"'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("Unidad Vecinal ELIMINADA...");
            } else {
                System.out.println("Unidad Vecinal PERDIDa.....");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. EUV" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }
}
