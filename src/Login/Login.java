/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Datos.Conexion;
import Registros.archivoLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Login {


    Conexion conex=new Conexion();
    Connection canal=null;
    Statement  orden=null;
    ResultSet  resul=null;
    String[] usu=new String[1];
    String sql=null;
    archivoLog archi=new archivoLog();
    //busca si el usuario existe en la base de datos
   public String[] buscarUsuario(String usuario,String clave)
    { 
        try { 
        orden=conex.abrirConexionURL().createStatement();
        sql="SELECT tipo_funcionario FROM Funcionario WHERE(rut_funcionario='"+usuario+"' && contra_funcionario='"+clave+"')";
        resul=orden.executeQuery(sql);
        if(resul.next())
        { usu[0]=new String(resul.getString(1));
        }
        else{usu[0]=new String("");
        }
      } catch (Exception e)
       { 
           System.out.println("ERROR DE CONEXION O SQL :"+e.getMessage());  
            try {
                archi.crearLog("ERROR DE CONEXION O SQL : "+e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
         
      return usu;
    }        
    
}
