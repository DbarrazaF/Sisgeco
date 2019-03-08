/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;

import Negocio.Tipo_Proyecto;
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
 * @author Daniel Barraza
 */
public class TTipo_Proyecto {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarTipoProyecto(Tipo_Proyecto tipo_pro) {
        boolean ins = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO tipo_proyecto VALUES('" + tipo_pro.getNro_tipo_proyecto() + "','" + tipo_pro.getNombre_tipo_proyecto() + "')";
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
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ITP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ins;
    }

    //Metodo de busqueda de datos
    public String[] buscarTipo_Proyecto(String cod_tipo) {

        String[] vector = new String[2];

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM tipo_proyecto WHERE(nro_tipo_proyecto='" + cod_tipo + "')");
            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));

            } else {
                vector[0] = new String("");
                vector[1] = new String("");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.BTP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean modificarTipoProyecto(Tipo_Proyecto tipo_pro) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE tipo_proyecto SET nombre_tipo_proyecto='" + tipo_pro.getNombre_tipo_proyecto() + "' "
                    + "where nro_tipo_proyecto='" + tipo_pro.getNro_tipo_proyecto() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Tipo de  Proyecto Modificado...");
            } else {
                System.out.println("Tipo de Proyecto NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MTP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //Metodo que permite rescatar tabla de datos
    public List<Tipo_Proyecto> listarTipoProyecto() {
        List<Tipo_Proyecto> lista = new ArrayList<Tipo_Proyecto>();

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM tipo_proyecto");

            while (resul.next()) {
                lista.add(new Tipo_Proyecto(resul.getString(1), resul.getString(2)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LTP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
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

}
