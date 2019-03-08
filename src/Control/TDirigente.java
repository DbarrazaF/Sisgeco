package Control;

import Datos.Conexion;
import Negocio.Dirigente;
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

public class TDirigente {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarDirigente(Dirigente dirigente) {
        boolean ing = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO Dirigente VALUES('" + dirigente.getRut_dirigente() + "'"
                    + ",'" + dirigente.getNombre_dirigente() + "','" + dirigente.getApellido_pat_dirigente() + "','" + dirigente.getApellido_mat_dirigente() + "'"
                    + ",'" + dirigente.getNro_casa_dirigente() + "','" + dirigente.getBlock_dirigente() + "','" + dirigente.getDepar_dirigente() + "',"
                    + "'" + dirigente.getPoblacion_dirigente() + "','" + dirigente.getTelefono_dirigente() + "','" + dirigente.getEmail_dirigente() + "',"
                    + "'" + dirigente.getCalle_dirigente() + "','" + dirigente.getCod_sector() + "')";

            ing = conex.efectuarTransaccionBD(sql, canal);
            if (ing) {
                System.out.println("Dirigente Ingresado...");
            } else {
                System.out.println("Dirigente NO Ingresado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.ID " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ing;
    }

    //Metodo que permite rescatar tabla de datos
    public List<Dirigente> listarDirigente() {
        List<Dirigente> lista = new ArrayList<Dirigente>();

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Dirigente");

            while (resul.next()) {
                lista.add(new Dirigente(resul.getString(1), resul.getString(2),
                        resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7), resul.getString(8),
                        resul.getString(9), resul.getString(10), resul.getString(11), resul.getString(12)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LD" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;

    }
    //Metodo de busqueda de datos

    public String[] buscarDirigente(String rut_dirigente) {

        String[] vector = new String[12];

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM dirigente WHERE rut_dirigente='" + rut_dirigente + "'");

            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));
                vector[2] = new String(resul.getString(3));
                vector[3] = new String(resul.getString(4));
                vector[4] = new String(resul.getString(5));
                vector[5] = new String(resul.getString(6));
                vector[6] = new String(resul.getString(7));
                vector[7] = new String(resul.getString(8));
                vector[8] = new String(resul.getString(9));
                vector[9] = new String(resul.getString(10));
                vector[10] = new String(resul.getString(11));
                vector[11] = new String(resul.getString(12));

            } else {
                vector[0] = new String("");
                vector[1] = new String("");
                vector[2] = new String("");
                vector[3] = new String("");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BD " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean modificarDirigente(Dirigente dirigente) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE dirigente SET nombre_dirigente='" + dirigente.getNombre_dirigente() + "',apellido_pat_dirigente='" + dirigente.getApellido_pat_dirigente() + "',apellido_mat_dirigente='" + dirigente.getApellido_mat_dirigente() + "',"
                    + "nro_casa_dirigente='" + dirigente.getNro_casa_dirigente() + "',block_dirigente='" + dirigente.getBlock_dirigente() + "',"
                    + "depar_dirigente='" + dirigente.getDepar_dirigente() + "',poblacion_dirigente='" + dirigente.getPoblacion_dirigente() + "',"
                    + "telefono_dirigente='" + dirigente.getTelefono_dirigente() + "',email_dirigente='" + dirigente.getEmail_dirigente() + "',"
                    + "calle_dirigente='" + dirigente.getCalle_dirigente() + "',cod_sector='" + dirigente.getCod_sector() + "' where rut_dirigente='" + dirigente.getRut_dirigente() + "'";

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
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //metodo para eliminar datos
    public boolean eliminarDirigente(String rut) {
        boolean elim = false;
        try {
            canal = conex.abrirConexionURL();
            sql = "DELETE FROM dirigente WHERE rut_dirigente='" + rut + "'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("Dirigente ELIMINADO...");
            } else {
                System.out.println("Dirigente PERDIDO.....");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. ED" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }

}
