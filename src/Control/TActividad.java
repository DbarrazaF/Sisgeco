/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;
import Negocio.Actividad;
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

public class TActividad {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarActividad(Actividad suce) {
        boolean ins = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO Suceso VALUES('" + suce.getCod_suceso() + "','" + suce.getFecha_suceso() + "'"
                    + ",'" + suce.getDescripcion_suceso() + "','" + suce.getAfiche_suceso() + "','" + suce.getRut_coves() + "',"
                    + "'" + suce.getRut_funcionario() + "','" + suce.getCod_tipo_suceso() + "','" + suce.getNro_participantes() + "')";

            ins = conex.efectuarTransaccionBD(sql, canal);
            if (ins) {
                System.out.println("Actividad Ingresada...");
            } else {
                System.out.println("Actividad NO Ingresada...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. " + e.getMessage());
            JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ins;
    }

    //Metodo que permite rescatar tabla de datos//query
    public List<Actividad> listarActividad(String rut_coves) {

        List<Actividad> lista = new ArrayList<Actividad>();
        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Suceso where rut_coves='" + rut_coves + "'");

            while (resul.next()) {
                lista.add(new Actividad(Integer.parseInt(resul.getString(1)), resul.getString(2),
                        resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6),
                        resul.getString(7), resul.getString(8)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA.LS " + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LS " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TActividad.class.getName()).log(Level.SEVERE, null, ex);
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

    //Metodo de busqueda de datos
    public String[] buscarActividad(String cod_suceso) {

        String[] vector = new String[8];

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Suceso WHERE(cod_suceso='" + cod_suceso + "')");
            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));
                vector[2] = new String(resul.getString(3));
                vector[3] = new String(resul.getString(4));
                vector[4] = new String(resul.getString(5));
                vector[5] = new String(resul.getString(6));
                vector[6] = new String(resul.getString(7));
                vector[7] = new String(resul.getString(8));

            } else {
                vector[0] = new String("");
                vector[1] = new String("");
                vector[2] = new String("");
                vector[3] = new String("");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BS" + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BS " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TActividad.class.getName()).log(Level.SEVERE, null, ex);
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

    //Metodo para modificar datos
    public boolean modificarActividad(Actividad suceso) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE suceso SET descripcion_suceso='" + suceso.getDescripcion_suceso() + "',afiche_suceso='" + suceso.getAfiche_suceso() + "'"
                    + ",rut_funcionario='" + suceso.getRut_funcionario() + "', cod_tipo_suceso='" + suceso.getCod_tipo_suceso() + "' "
                    + ", nro_participantes='" + suceso.getNro_participantes() + "' WHERE cod_suceso='" + suceso.getCod_suceso() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Actividad Modificada...");
            } else {
                System.out.println("Actividad NO Modificada...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MS " + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MS " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TActividad.class.getName()).log(Level.SEVERE, null, ex);
            }

        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }
    //metodo para eliminar datos
    public boolean eliminarActividad(String cod_acti) {
        boolean elim = false;
        try {
            canal = conex.abrirConexionURL();
            sql = "DELETE FROM suceso WHERE cod_suceso='" + cod_acti + "'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("Actvidad ELIMINADA...");
            } else {
                System.out.println("Actvidad PERDIDA.....");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. EA" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }

}
