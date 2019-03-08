/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;
 
import Datos.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
 

/**
 *
 * @author Daniel Barraza
 */
public class Gestion_DB {
    archivoLog archi=new archivoLog();
    Conexion cone=new Conexion();
    public Gestion_DB() {
    }
    
 /**
  * 
  * @param ruta
  * @return 
  */   
private String procesarRuta(String rutaprocesar){//metodo para procesar la ruta de guardado en caso
        File archivo = new File(rutaprocesar);      //de usar nombre de archivo existente
        if(archivo.exists()){
            return rutaprocesar;
        }else{
              // configuracion de la fecha actual 
        Calendar c = Calendar.getInstance();
        String fecha = String.valueOf(c.get(Calendar.DATE));
        fecha = fecha + "-" + String.valueOf(c.get(Calendar.MONTH)+1);
        fecha = fecha + "-" + String.valueOf(c.get(Calendar.YEAR));
        fecha = fecha + "." + String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        fecha = fecha + "." + String.valueOf(c.get(Calendar.MINUTE));
        fecha = fecha + "." + String.valueOf(c.get(Calendar.SECOND));
        return rutaprocesar + "_" + fecha + ".sql";
        
        }
}
    /**
     * 
     * @param user 
     * @param pass
     * @param database
     * @param ruta
     * @return 
     */
    //Metodo para respaldar base de datos 
    public boolean Respaldar_DB(String user, String pass, String database, String ruta) {
        boolean res=false;
        //verifica si el servidor se encuentra activo
        if(cone.abrirConexionURL()!=null){
      
        try {
             // clase Runtime para lanzar DOS
            Runtime runtime = Runtime.getRuntime();
            //ruta donde se encuntra mysqldump
            String patch = "C:/xampp/mysql/bin/";
            String rutalista=procesarRuta(ruta);
            File backupFile = new File(rutalista);
            //preparamos el filewrite para guardar el backup
            FileWriter filewrite = new FileWriter(backupFile);
            //se lanza el DOS
            Process child = runtime.exec(patch
                    + "mysqldump "
                    + " --opt "
                    + " --host=localhost"
                    + " --user=" + user
                    + " --password=" + pass
                    + " --databases " + database + " ");
             
            /* Se obtiene el stream de salida del programa */
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            /* Se prepara un BufferedReader para poder leer la salida más comodamente. */
            BufferedReader br = new BufferedReader(irs);
             //preparamos el backupfile con la ruta
            //y el archivo sql que tendra la fecha y hora de creacion
           
            String line;
            //mientras exista una linea
            while ((line = br.readLine()) != null) {
                filewrite.write(line+"\n");

            }
            // terminamos los servicios

            irs.close();
            br.close();
            filewrite.close();
            res=true;  
        } catch (IOException e) {
            System.out.println("Error.. No se realizo el backup!" + e.getMessage());
            try {
                archi.crearLog("Error.. No se realizo el backup! " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else{
            System.out.println("Error al respaldar, servidor de DB caido");
            try {
        archi.crearLog("Error al respaldar, servidor de DB caido");
    } catch (IOException ex) {
        Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
        return res;
    }
 
public boolean crearUsuario(){//metodo para crear un usuario en la base de datos y dar privilegios
     boolean user_creado=false;
    Connection canal = null;
    String sql1 = null;
     String sql2 = null;
    boolean res=false;
    {
        if(cone.ConexionPrueba()!=null){
        canal = cone.ConexionPrueba();
            sql1 = "create user 'Coves'@'localhost' identified by 'root'";

            res=cone.efectuarTransaccionBD(sql1, canal);
            if(res){
                sql2="GRANT ALL PRIVILEGES ON * . * TO 'Coves'@'localhost'";
                System.out.println("creo usuario :D");
                res=cone.efectuarTransaccionBD(sql2, canal);
                user_creado=true;
            }else{
                System.out.println("error user no creo D:");
                user_creado=false;
                
            }
        }else{
     System.out.println("Error al restaurar, servidor de DB caido");
     user_creado=false;
    try {
        archi.crearLog("Error al restaurar, servidor de DB caido");
    } catch (IOException ex) {
        Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
    }   
        return user_creado;
}
public boolean buscarUsuario(){//metodo para ver si existe el usuario
     boolean user_buscar=false;
    Statement orden = null;
     ResultSet resul = null;
    if(cone.ConexionPrueba()!=null)
    {   
         String[] vector = new String[1];
         try {
            
             orden=cone.ConexionPrueba().createStatement();
             resul = orden.executeQuery("select user from mysql.user where user='Coves'");
             if (resul.next()) {
                vector[0] = resul.getString(1);
                user_buscar=true;
                 System.out.println("user encontrado");
                
             }else{
                 vector[0]=null;
                 user_buscar=false;
                 System.out.println("user no encontrado");
             }
         } catch (SQLException ex) {
             Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
 else{
     System.out.println("Error al crear usuario, servidor de DB caido");
     user_buscar=false;
    try {
        archi.crearLog("Error al crear usuario, servidor de DB caido");
    } catch (IOException ex) {
        Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    }  
        return user_buscar;
        
    
}
public boolean Restaurar_DB(String pass, String user, String ruta){//restaura la base de datos desde archivo sql
boolean res=false;

 if(cone.ConexionPrueba()!=null)
    {
    try {
        String patch = "C:/xampp/mysql/bin/";
        String sentencia = "cmd /c " + patch +"mysql "
            + "--user="+user+"  "
            + "--password="+pass+" "
            + "< "+ruta;
        Runtime rt = Runtime.getRuntime();
        rt.exec(sentencia);//Ejecuta secuencia de respaldo
        res = true;
        }catch (IOException ex) {
            
            Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error al realizar la restauracion");        
        }
    }
 else{
     System.out.println("Error al restaurar, servidor de DB caido");
    try {
        archi.crearLog("Error al restaurar, servidor de DB caido");
    } catch (IOException ex) {
        Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
    }
 }
        return res; 
    }
//verifica si archivo de respaldo no este vacio
public boolean validarArchivo(String ruta) throws IOException{//
        boolean result=false;
   try {
            FileReader fr;
            int caract;
            fr = new FileReader(ruta);
            caract = fr.read();
            while(caract != -1) {
                //Hacer algo con el carácter leído
                caract = fr.read();
            if(caract>0){
                result=true;
                return result;
            }
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gestion_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
        
}

}
