/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

/**
 *
 * @author Daniel Barraza
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class archivoLog {
     FileWriter archivo; //nuestro archivo log
/**
 * 
 * @param operacion
 * @throws IOException 
 */
     public void crearLog(String operacion) throws IOException {

        //Pregunta el archivo existe, caso contrario crea uno con el nombre log.txt
        if (new File("lib/log.txt").exists()==false){
            try {
                archivo=new FileWriter(new File("lib/log.txt"),false);
            } catch (IOException ex) {
                Logger.getLogger(archivoLog.class.getName()).log(Level.SEVERE, null, ex);
            }
}
         try {
             archivo = new FileWriter(new File("lib/log.txt"), true);
         } catch (IOException ex) {
             Logger.getLogger(archivoLog.class.getName()).log(Level.SEVERE, null, ex);
         }
             Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar    
             //Empieza a escribir en el archivo
             archivo.write((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                  +"/"+String.valueOf(fechaActual.get(Calendar.MONTH)+1)
                  +"/"+String.valueOf(fechaActual.get(Calendar.YEAR))
                  +"; "+String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                  +":"+String.valueOf(fechaActual.get(Calendar.MINUTE))
                  +":"+String.valueOf(fechaActual.get(Calendar.SECOND)))+"; "+operacion+"\r\n");
             archivo.close(); //Se cierra el archivo
     }//Fin del metodo crearLog

}