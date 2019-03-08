package Control;

import Datos.Conexion;
import Negocio.Tipo_Actividad;
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

public class TTipo_Actividad {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarTipoActividad(Tipo_Actividad tipo_su) {
        boolean ins = false;

        try {

            canal = conex.abrirConexionURL();
            sql = "INSERT INTO tipo_suceso VALUES('" + tipo_su.getCod_tipo_suceso() + "','" + tipo_su.getNombre_tipo_suceso() + "')";
            ins = conex.efectuarTransaccionBD(sql, canal);
            if (ins) {
                System.out.println("Coves Ingresado...");
            } else {
                System.out.println("Coves NO Ingresado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ITS" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ins;
    }

    //Metodo para modificar datos
    public boolean modificarTipoActividad(Tipo_Actividad tipo_suc) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE tipo_suceso SET  nombre_tipo_suceso='" + tipo_suc.getNombre_tipo_suceso() + "' "
                    + "where cod_tipo_suceso='" + tipo_suc.getCod_tipo_suceso() + "'";
            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Medico Modificado...");
            } else {
                System.out.println("Medico NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.MTS " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //Metodo que permite rescatar tabla de datos
    public List<Tipo_Actividad> listarTipo_Actividad() {

        List<Tipo_Actividad> lista = new ArrayList<Tipo_Actividad>();

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Tipo_Suceso");

            while (resul.next()) {
                lista.add(new Tipo_Actividad(resul.getString(1), resul.getString(2)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.LTS " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Actividad.class.getName()).log(Level.SEVERE, null, ex);
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
    public String[] buscarTipoActividad(String cod_tipo_suceso) {

        String[] vector = new String[2];
        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM TIPO_SUCESO WHERE cod_tipo_suceso='" + cod_tipo_suceso + "' ");
            if (resul.next()) {
                vector[0] = resul.getString(1);
                vector[1] = resul.getString(2);

            } else {
                vector[0] = new String("");
                vector[1] = new String("");

            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BTS" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TTipo_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(TTipo_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return vector;
    }
    //metodo para eliminar datos
    public boolean eliminarTipoActividad(String cod_tipo_acti) {
        boolean elim = false;
        try {
            canal = conex.abrirConexionURL();
            sql = "DELETE FROM tipo_suceso WHERE cod_tipo_suceso='" + cod_tipo_acti+ "'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("Tipo de actividad ELIMINADA...");
            } else {
                System.out.println("Tipo de actividad PERDIDA...");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ETA" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }
}
