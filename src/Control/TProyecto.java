/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;
import Negocio.Proyecto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Registros.archivoLog;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class TProyecto {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    Connection cn;
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarProyecto(Proyecto proye) {
        boolean ins = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO proyecto VALUES('" + proye.getAno_postulacion_proyecto() + "','" + proye.getNro_ingreso_proyecto() + "',"
                    + "'" + proye.getObjetivo_proyecto() + "','" + proye.getNro_partici_proyecto() + "','" + proye.getFecha_ingre_proyecto() + "',"
                    + "'" + proye.getDuracion_proyecto() + "','" + proye.getCalle_referen_proyecto() + "','" + proye.getAporte_otra_organ_proyecto() + "',"
                    + "'" + proye.getMonto_solici_proyecto() + "','" + proye.getAporte_munici_proyecto() + "','" + proye.getComentario_proyecto() + "',"
                    + "'" + proye.getAporte_organ_proyecto() + "','" + proye.getMonto_aprob_proyecto() + "','" + proye.getNro_matriz_proyecto() + "',"
                    + "'" + proye.getNro_aproba_proyecto() + "','" + proye.getAno_matriz_proyecto() + "','" + proye.getAno_decreto_proyecto() + "',"
                    + "'" + proye.getAno_aproba_proyecto() + "','" + proye.getNombre_proyecto() + "','" + proye.getNro_tipo_proyecto() + "',"
                    + "'" + proye.getRut_coves() + "')";

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
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.IP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ins;
    }

    //Metodo de busqueda de datos
    public String[] buscarProyecto(String anopro, String nroingre) {

        String[] vector = new String[21];
        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM PROYECTO WHERE(ano_postulacion_proyecto='" + anopro + "' && nro_ingreso_proyecto='" + nroingre + "')");
            if (resul.next()) {
                vector[0] = resul.getString(1);
                vector[1] = resul.getString(2);
                vector[2] = resul.getString(3);
                vector[3] = resul.getString(4);
                vector[4] = resul.getString(5);
                vector[5] = resul.getString(6);
                vector[6] = resul.getString(7);
                vector[7] = resul.getString(8);
                vector[8] = resul.getString(9);
                vector[9] = resul.getString(10);
                vector[10] = resul.getString(11);
                vector[11] = resul.getString(12);
                vector[12] = resul.getString(13);
                vector[13] = resul.getString(14);
                vector[14] = resul.getString(15);
                vector[15] = resul.getString(16);
                vector[16] = resul.getString(17);
                vector[17] = resul.getString(18);
                vector[18] = resul.getString(19);
                vector[19] = resul.getString(20);
                vector[20] = resul.getString(21);

            } else {
                vector[0] = "";
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TProyecto.class.getName()).log(Level.SEVERE, null, ex);
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

    //Metodo que permite rescatar tabla segun el filtro
    public void listarProyectoFiltroTipo(JTable tabla, String dato) {

        DefaultTableModel modelo;
        String[] titulo = {"Año Postulacion", "Nro Registro", "Tipo Proyecto","Rut Coves", "Nombre Coves"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[5];
        String sql = "SELECT ano_postulacion_proyecto,nro_ingreso_proyecto,nombre_tipo_proyecto,proyecto.rut_coves,nombre_coves "
                + "FROM coves join proyecto on coves.rut_coves=proyecto.rut_coves join tipo_proyecto on proyecto.nro_tipo_proyecto=tipo_proyecto.nro_tipo_proyecto where nombre_tipo_proyecto like '" + dato + "%' order by ano_postulacion_proyecto ASC ";
        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 5; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error al filtrar " + ex.getMessage());
            try {
                archi.crearLog("Error al filtrar LPFT" + ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(TProyecto.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    //Metodo que permite rescatar tabla segun el filtro
    public void listarProyectoFiltroAno(JTable tabla, String ano) {

        DefaultTableModel modelo;
        String[] titulo = {"Año Postulacion", "Nro Registro", "Tipo Proyecto","Rut Coves", "Nombre Coves"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[5];
        String sql = "SELECT ano_postulacion_proyecto,nro_ingreso_proyecto,nombre_tipo_proyecto,proyecto.rut_coves,nombre_coves "
                + "FROM coves join proyecto on coves.rut_coves=proyecto.rut_coves join tipo_proyecto on proyecto.nro_tipo_proyecto=tipo_proyecto.nro_tipo_proyecto where ano_postulacion_proyecto like '" + ano + "%' order by nro_ingreso_proyecto ASC";
        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 5; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error al filtrar " + ex.getMessage());
            try {
                archi.crearLog("Error al filtrar LPFA" + ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(TProyecto.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    //Metodo para modificar datos
    public boolean modificarProyecto(Proyecto proyecto) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE proyecto SET nombre_proyecto='" + proyecto.getNombre_proyecto() + "',objetivo_proyecto='" + proyecto.getObjetivo_proyecto() + "',nro_partici_proyecto='" + proyecto.getNro_partici_proyecto() + "',"
                    + "duracion_proyecto='" + proyecto.getDuracion_proyecto() + "',calle_referen_proyecto='" + proyecto.getCalle_referen_proyecto() + "',"
                    + "monto_solici_proyecto='" + proyecto.getMonto_solici_proyecto() + "',aporte_munici_proyecto='" + proyecto.getAporte_munici_proyecto() + "',"
                    + "aporte_organ_proyecto='" + proyecto.getAporte_organ_proyecto() + "',aporte_otra_organ_proyecto='" + proyecto.getAporte_otra_organ_proyecto() + "',"
                    + "ano_aproba_proyecto='" + proyecto.getAno_aproba_proyecto() + "',ano_decreto_proyecto='" + proyecto.getAno_decreto_proyecto() + "',"
                    + "ano_matriz_proyecto='" + proyecto.getAno_matriz_proyecto() + "',nro_aproba_proyecto='" + proyecto.getNro_aproba_proyecto() + "',"
                    + "monto_aprob_proyecto='" + proyecto.getMonto_aprob_proyecto() + "',nro_matriz_proyecto='" + proyecto.getNro_matriz_proyecto() + "',"
                    + "comentario_proyecto='" + proyecto.getComentario_proyecto() + "',nro_tipo_proyecto='" + proyecto.getNro_tipo_proyecto() + "' where ano_postulacion_proyecto='" + proyecto.getAno_postulacion_proyecto() + "'"
                    + "&& nro_ingreso_proyecto='" + proyecto.getNro_ingreso_proyecto() + "'";

            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Proyecto Modificado...");
            } else {
                System.out.println("Proyecto NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //Metodo que permite rescatar tabla segun el filtro
    public void listarProyectoFiltroAnoyTipo(JTable tabla, String ano, String tipo) {

        DefaultTableModel modelo;
        String[] titulo = {"Año Postulacion", "Nro Registro", "Tipo Proyecto","Rut Coves", "Nombre Coves"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[5];
        String sql = "SELECT ano_postulacion_proyecto,nro_ingreso_proyecto,nombre_tipo_proyecto,proyecto.rut_coves,nombre_coves "
                + "FROM coves join proyecto on coves.rut_coves=proyecto.rut_coves join tipo_proyecto on proyecto.nro_tipo_proyecto=tipo_proyecto.nro_tipo_proyecto where ano_postulacion_proyecto like '" + ano + "%' && nombre_tipo_proyecto like '" + tipo + "%'";
        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 5; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("Error al filtrar " + ex.getMessage());
            try {
                archi.crearLog("Error al filtrar LPFAyT " + ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(TProyecto.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

}
