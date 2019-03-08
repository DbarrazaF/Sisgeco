/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Datos.Conexion;
import Listar.Listar_Coves;
import Negocio.Coves;
import Negocio.Proyecto;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TCoves {

    Connection canal = null;
    Statement orden = null;
    ResultSet resul = null;
    String sql = null;
    Conexion conex = new Conexion();
    Connection cn;
    archivoLog archi = new archivoLog();

    public TCoves() {
    }

    //Metodo de ingreso de datos
    public boolean insertarCoves(Coves in_coves) {
        boolean ins = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "INSERT INTO coves VALUES('" + in_coves.getRut_coves() + "','" + in_coves.getNombre_coves() + "'"
                    + ",'" + in_coves.getEstado_coves() + "','" + in_coves.getCod_unidad() + "','" + in_coves.getAno_coves() + "'"
                    + ",'" + in_coves.getDireccion_coves() + "','" + in_coves.getTelefono_coves() + "')";

            ins = conex.efectuarTransaccionBD(sql, canal);
            if (ins) {
                System.out.println("Coves Ingresado...");
            } else {
                System.out.println("Coves NO Ingresado...");
            }

        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. IC" + e.getMessage());
             JOptionPane.showMessageDialog(null, "DATOS PERDIDOS VERIFIQUE SERVIDOR",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. IC " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
            try {
                canal.close();
            } catch (Exception e) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, e);
                try {
                    archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. IC " + e.getMessage());
                } catch (IOException ex) {
                    Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ins;
    }

//Metodo para modificar datos
    public boolean modificarCoves(Coves coves) {
        boolean modi = false;

        try {
            canal = conex.abrirConexionURL();
            sql = "UPDATE coves SET nombre_coves='" + coves.getNombre_coves() + "',estado_coves='" + coves.getEstado_coves() + "', ano_coves='" + coves.getAno_coves() + "', direccion_coves='" + coves.getDireccion_coves() + "',telefono_coves='" + coves.getTelefono_coves() + "' WHERE(rut_coves='" + coves.getRut_coves() + "')";

            modi = conex.efectuarTransaccionBD(sql, canal);
            if (modi) {
                System.out.println("Coves Modificado...");
            } else {
                System.out.println("Coves NO Modificado...");
            }
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MC" + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. MC " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            conex.cerrarConexionURL(canal);
        }
        return modi;
    }

    //Metodo de busqueda de datos
    public String[] buscarCoves(String rut_coves) {
        String[] vector = new String[7];

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM coves WHERE rut_coves='" + rut_coves + "'");

            if (resul.next()) {
                vector[0] = new String(resul.getString(1));
                vector[1] = new String(resul.getString(2));
                vector[2] = new String(resul.getString(3));
                vector[3] = new String(resul.getString(4));
                vector[4] = resul.getString(5);
                vector[5] = new String(resul.getString(6));
                vector[6] = new String(resul.getString(7));

            } else {
                vector[0] = "";
            }
            orden.close();
            resul.close();
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BC" + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BC " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return vector;

    }

    //Metodo que permite rescatar tabla de datos//query
    public List<Proyecto> listarProyectoCoves(String rut) {
        List<Proyecto> lista = new ArrayList<Proyecto>();

        try {
            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM proyecto where (rut_coves='" + rut + "')");

            while (resul.next()) {
                lista.add(new Proyecto(resul.getString(1), resul.getString(2),
                        resul.getString(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7), resul.getString(8),
                        resul.getString(9), resul.getString(10), resul.getString(11), resul.getString(12), resul.getString(13), resul.getString(14),
                        resul.getString(15), resul.getString(16), resul.getString(17), resul.getString(18), resul.getString(19), resul.getString(20), resul.getString(21)));

            }
            orden.close();
            resul.close();
        } catch (Exception e) {
            System.out.println("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCP" + e.getMessage());
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCP " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;

    }

    //Metodo que permite rescatar datos de la tabla segun su filtro
    public void listarCovesFiltroSector(JTable tabla, String sector) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector  where  sector.nom_sector like '" + sector + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            Logger.getLogger(Listar_Coves.class.getName()).log(Level.SEVERE, null, e);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFS " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //Metodo que permite rescatar datos de la tabla segun su filtro
    public void listarCovesFiltroUnidad(JTable tabla, String unidad) {
        DefaultTableModel modelo;

        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector where  unidad_vecinal.cod_unidad like '" + unidad + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);

            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);

            }

            tabla.setModel(modelo);

        } catch (Exception e) {
            Logger.getLogger(Listar_Coves.class.getName()).log(Level.SEVERE, null, e);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFU " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    //Metodo que permite rescatar datos de la tabla segun su filtro

    public void listarCovesFiltroEstado(JTable tabla, String estado) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector  "
                + "where  coves.estado_coves like '" + estado + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFE " + ex.getMessage());
            } catch (IOException ex1) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

    }

    //Metodo que permite rescatar datos de la tabla segun su filtro
    public void listarCovesFiltroUnidadyEstado(JTable tabla, String unidad, String estado) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector "
                + "where unidad_vecinal.cod_unidad like '" + unidad + "%' && coves.estado_coves like '" + estado + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());
            Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFUyE " + ex.getMessage());
            } catch (IOException exuye) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, exuye);
            }
        }

    }

    //Metodo que permite rescatar datos de la tabla segun su filtro
    public void listarCovesFiltroSectoryEstado(JTable tabla, String sector, String estado) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector where  sector.nom_sector like '" + sector + "%' && coves.estado_coves like '" + estado + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFSyE " + ex.getMessage());
            } catch (IOException exsye) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, exsye);
            }
        }

    }

    //Metodo que permite buscar por nombre
    public void BuscarCovesNombre(JTable tabla, String nombre) {
        DefaultTableModel modelo;
        String[] titulo = {"Rut", "Nombre"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[2];
        String sql = "SELECT rut_coves,nombre_coves FROM Coves where nombre_coves like '" + nombre + "%'";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 2; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. BN " + ex.getMessage());
            } catch (IOException exbn) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, exbn);
            }
        }

    }
//Metodo que permite rescatar datos de la tabla segun su filtro

    public void listarCovesFiltroAno(JTable tabla, String ano) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector where  coves.ano_coves like '" + ano + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFA " + ex.getMessage());
            } catch (IOException exa) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, exa);
            }
        }

    }

//Metodo que permite rescatar datos de la tabla segun su filtro
    public void listarCovesFiltroTodos(JTable tabla) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector ORDER BY sector.nom_sector ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            Logger.getLogger(Listar_Coves.class.getName()).log(Level.SEVERE, null, e);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFT " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    //Metodo que permite rescatar datos de la tabla segun su filtro
    public void listarCovesFiltroAnoyEstado(JTable tabla, String ano, String estado) {
        DefaultTableModel modelo;
        String[] titulo = {"Nombre", "Rut", "Estado", "Unidad Vecinal", "Sector", "Año Creacion", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulo);
        String[] registros = new String[8];
        String sql = "SELECT coves.nombre_coves,coves.rut_coves,coves.estado_coves,unidad_vecinal.cod_unidad,sector.nom_sector,coves.ano_coves,coves.direccion_coves,coves.telefono_coves FROM COVES join unidad_vecinal on unidad_vecinal.cod_unidad=coves.cod_unidad join sector on sector.cod_sector=unidad_vecinal.cod_sector "
                + "where coves.ano_coves like '" + ano + "%' && coves.estado_coves like '" + estado + "%' ORDER BY coves.nombre_coves ASC ";

        Conexion con = new Conexion();
        cn = con.abrirConexionURL();
        try {

            Statement st = cn.createStatement();
            ResultSet resul = st.executeQuery(sql);
            while (resul.next()) {
                for (int i = 0; i < 8; i++) {
                    registros[i] = resul.getString(i + 1);
                }
                modelo.addRow(registros);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println("error " + ex.getMessage());
            Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, ex);
            try {
                archi.crearLog("CONEXION FALLADA O SENTENCIA MAL ESCRITA. LCFUyE " + ex.getMessage());
            } catch (IOException exuye) {
                Logger.getLogger(TCoves.class.getName()).log(Level.SEVERE, null, exuye);
            }
        }

    }

}
