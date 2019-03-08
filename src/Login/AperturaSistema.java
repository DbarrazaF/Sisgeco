
package Login;

import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Barraza
 */
public class AperturaSistema {
    //crea una nueva variable tipo ServerSocket 
    private static ServerSocket server_socket;
    
    public static void main( String args[]){
        Index index=new Index();//crea un nuevo objeto tipo index
        //Verifica si el sistema se encuentra abierto 
        try {
            //inicializa el ServerSocket
            server_socket=new ServerSocket(1334);
            //carga la ventana index
            index.index();
            
        } //termina try
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"EL SISTEMA YA SE ENCUENTRA EN EJECUCION",
        "AVISO DE SISTEMA", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            System.exit(0);//cierra segunda instancia en caso de que se encuentre abierta
        }//termina catch
        
        
    }
    
}
