/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;
import Negocio.Sector;
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

public class TSector {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarSector(Sector sector) {
        boolean ins = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO Sector VALUES('" + sector.getCod_sector() + "','" + sector.getNom_sector() + "')";

            ins = conex.efectuarTransaccionBD(sql, canal);
            if (ins) {
                System.out.println("Sector Ingresado...");
            } else {
                System.out.println("Sector NO Ingresado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. IS" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TSector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {

            conex.cerrarConexionURL(canal);
        }
        return ins;
    }

    //Metodo para modificar datos
    public boolean modificarSector(Sector sector) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE Sector SET nom_sector='" + sector.getNom_sector() + "' WHERE cod_sector='" + sector.getCod_sector() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Sector Modificado...");
            } else {
                System.out.println("Sector NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MS" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TSector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //Metodo que permite rescatar tabla de datos
    public List<Sector> listarSector() {
        List<Sector> lista = new ArrayList<Sector>();

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Sector");
            while (resul.next()) {
                lista.add(new Sector(resul.getString(1), resul.getString(2)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LS" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TSector.class.getName()).log(Level.SEVERE, null, ex);
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
    public String[] buscarSector(String cod_sector) {
        String[] vector = new String[2];

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM sector WHERE cod_sector='" + cod_sector + "'");

            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));

            } else {
                vector[0] = "";
            }
            orden.close();
            resul.close();
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BS" + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BS" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vector;

    }
    //metodo para eliminar datos
    public boolean eliminarSector(String cod_sector) {
        boolean elim = false;
        try {
            canal = conex.abrirConexionURL();
            sql = "DELETE FROM sector WHERE cod_sector='" + cod_sector + "'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("Sector ELIMINADO...");
            } else {
                System.out.println("Sector PERDIDO.....");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ES" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }
}
