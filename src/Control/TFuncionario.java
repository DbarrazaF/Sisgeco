package Control;

import Datos.Conexion;
import Negocio.Funcionario;
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

public class TFuncionario {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    archivoLog archi = new archivoLog();

    //Metodo de ingreso de datos
    public boolean insertarFuncionario(Funcionario funci) {
        boolean ing = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO Funcionario VALUES('" + funci.getRut_funcionario() + "','" + funci.getNombre_funcionario() + "',"
                    + "'" + funci.getApell_pat_funcionario() + "','" + funci.getApell_mat_funcionario() + "','" + funci.getContra_funcionario() + "',"
                    + "'" + funci.getTipo_funcionario() + "','" + funci.getEstado_funcionario() + "')";

            ing = conex.efectuarTransaccionBD(sql, canal);
            if (ing) {
                System.out.println("Funcionario Ingresado...");
            } else {
                System.out.println("Funcionario NO Ingresado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. IF " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return ing;
    }

    //Metodo de busqueda de datos
    public String[] buscarFuncionarios(String rut_funcionario) {

        String[] vector = new String[7];

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM funcionario WHERE rut_funcionario='" + rut_funcionario + "'");

            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));
                vector[2] = new String(resul.getString(3));
                vector[3] = new String(resul.getString(4));
                vector[4] = new String(resul.getString(5));
                vector[5] = new String(resul.getString(6));
                vector[6] = new String(resul.getString(7));

            } else {
                vector[0] = new String("");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA.BF " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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

    //Metodo que permite rescatar tabla de datos
    public List<Funcionario> listarFuncionarios() {

        List<Funcionario> lista = new ArrayList<Funcionario>();

        try {//Trabajo en Espacio Virtual
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM funcionario");

            while (resul.next()) {
                lista.add(new Funcionario(resul.getString(1), resul.getString(2),
                        resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LF" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean modificarFuncionario(Funcionario funcionario) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE funcionario SET nombre_funcionario='" + funcionario.getNombre_funcionario() + "',apell_pat_funcionario='" + funcionario.getApell_pat_funcionario() + "',apell_mat_funcionario='" + funcionario.getApell_mat_funcionario() + "',"
                    + "contra_funcionario='" + funcionario.getContra_funcionario() + "',tipo_funcionario='" + funcionario.getTipo_funcionario() + "',"
                    + "estado_funcionario='" + funcionario.getEstado_funcionario() + "' where rut_funcionario='" + funcionario.getRut_funcionario() + "'";

            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Funcionario Modificado...");
            } else {
                System.out.println("Funcionario NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MF " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "DELETE FROM funcionario WHERE rut_funcionario='" + rut + "'";
            elim = conex.efectuarTransaccionBD(sql, canal);
            if (elim) {
                System.out.println("funcionario ELIMINADO...");
            } else {
                System.out.println("funcionario PERDIDO.....");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA." + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. EF" + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TDirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return elim;
    }

}
