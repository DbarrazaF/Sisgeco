/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

import Login.Index;
import Validacion.Validar;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel
 */
public class Restaurar_DB extends javax.swing.JFrame {

   Index ind=new Index();
   archivoLog archi=new archivoLog();
   Gestion_DB restaurar=new Gestion_DB();
    public Restaurar_DB() {
        initComponents();
        text_mayus.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    public void cerrar(){
            this.dispose();
            ind.index();
        }
public void realizarRespaldo(boolean res){
     
    try {
           Validar encrip = new Validar();
           String contra="2rD/T/RtzHMtkyc/u4fO5Q==";//contraseña encriptada
           File file = new File(text_ruta.getText());
           
           if (text_ruta.getText().length() != 0) {//valida ubicacion vacia
               if(file.exists()){//valida si exite el archivo
                   boolean resultado=restaurar.validarArchivo(text_ruta.getText());
                   if("sql".equals(getFileExtension(file))){//valida solo extension sql
                        if(contra.equals(encrip.encrypt(text_contra.getText())) && text_contra.getText().length()!=0 ){//valida contraseña maestra
                            if(resultado){//valida que archivo no es vacio
                                   String user = "root";
                                   String pass = "system";
                                       res = restaurar.Restaurar_DB(pass,user, text_ruta.getText());
                                   if (res) {
                                       JOptionPane.showMessageDialog(null, "RESTAURACION REALIZADA CORRECTAMENTE",
                                               "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                                       ind.index();
                                       this.dispose();
                                   } else {
                                       JOptionPane.showMessageDialog(null, "RESTAURACION PERDIDA O SERVIDOR CAIDO",
                                               "AVISO DE SISTEMA", JOptionPane.ERROR_MESSAGE);
                                   }
                               }else{
                                JOptionPane.showMessageDialog(null, "ARCHIVO DE RESPALDO VACIO, PORFAVOR VERIFICAR ARCHIVO SELECCIONADO",
                               "AVISO DE SISTEMA", JOptionPane.ERROR_MESSAGE);
                               }
                        }else{
                                   JOptionPane.showMessageDialog(null, "CONTRASEÑA MAESTRA INCORRECTA O NO INGRESADA, PORFAVOR COMUNICARSE CON EL ADMINISTRADOR DEL SISTEMA",
                                           "AVISO DE SISTEMA", JOptionPane.ERROR_MESSAGE);
                               }  
                   }else{
                       JOptionPane.showMessageDialog(null, "PORFAVOR SELECCIONAR ARCHIVO SQL",
                               "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                   }
               }else{
                   JOptionPane.showMessageDialog(null, "ARCHIVO MAL INGRESADO O NO EXISTE, PORFAVOR VERIFICAR ARCHIVO SELECCIONADO",
                           "AVISO DE SISTEMA", JOptionPane.ERROR_MESSAGE);
               }
           } else {
               JOptionPane.showMessageDialog(null, "PORFAVOR SELECCIONAR UN ARCHIVO PARA RESTAURAR",
                       "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE); 
           }
       } catch (IOException ex) {
           Logger.getLogger(Restaurar_DB.class.getName()).log(Level.SEVERE, null, ex);
       } catch (Exception ex) {
           Logger.getLogger(Restaurar_DB.class.getName()).log(Level.SEVERE, null, ex);
       }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_seleccionar = new javax.swing.JButton();
        text_ruta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_contra = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        text_mayus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        boton_seleccionar.setText("Seleccionar...");
        boton_seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_seleccionarActionPerformed(evt);
            }
        });

        text_ruta.setEditable(false);

        jLabel2.setText("Seleccione ubicacion de Archivo de respaldo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Restaurar Base de Datos");

        jLabel3.setText("Contraseña Maestra:");

        text_contra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_contraKeyReleased(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Restaurar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        text_mayus.setText("Tecla mayuscula activada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_mayus)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(text_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton_seleccionar)))
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_seleccionar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text_contra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_mayus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_seleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_seleccionarActionPerformed
       
//        carga la interfaz de archivos, para capturarla ruta
        javax.swing.JFileChooser jF1 = new javax.swing.JFileChooser();
        String ruta = "";
        jF1.setDialogTitle("Seleccionar Archivo para Restaurar...");
        jF1.setAcceptAllFileFilterUsed(false);
        jF1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.SQL", "sql");
         //Le indicamos el filtro
        jF1.setFileFilter(filtro);
         
            try {
               
                if (jF1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                ruta = jF1.getSelectedFile().getAbsolutePath();
                //asignas la ruta a un jtextfield
                text_ruta.setText(ruta);
                
                }                
            } catch (HeadlessException ex) {
            ex.getMessage();
            }
   
    }//GEN-LAST:event_boton_seleccionarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        ind.index();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       boolean resultado_usuario;
       boolean creacion_usuario;
        
        resultado_usuario=restaurar.buscarUsuario();
      
        if(resultado_usuario){
            System.out.println("lo encontro usuario");
            realizarRespaldo(resultado_usuario);
        
        }else{
            System.out.println("no lo encontro");
            creacion_usuario=restaurar.crearUsuario();
        
            if(creacion_usuario){
                 realizarRespaldo(creacion_usuario);
            }else{
                System.out.println("no creo el usuario, o paso algo pero D:");
                realizarRespaldo(false);
                try {
                    archi.crearLog("no creo el usuario, o paso algo mas, corran!!! D: crear usuario");
                } catch (IOException ex) {
                    Logger.getLogger(Restaurar_DB.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
        
        
       
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       ind.index();
    }//GEN-LAST:event_formWindowClosing

    private void text_contraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_contraKeyReleased
        boolean capsActivo = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
       text_mayus.setVisible(capsActivo);
    }//GEN-LAST:event_text_contraKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       Timer timer = new Timer (60000, new ActionListener ()
        {
           int con=0;
          @Override
          public void actionPerformed(ActionEvent e) {
              
              
              con=con+1;
              if(con==1){
                  
                  JOptionPane.showMessageDialog(null, "TIEMPO DE ESPERA PARA REALIZAR LA RESTAURACION TERMINADO, LA INTERFAZ FUE CERRADA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                  cerrar();

                  
              }
              
          }
      });
            
        timer.start();
    }//GEN-LAST:event_formWindowOpened
     private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else 
            return "no se encontro extencion";
        
    }
 
    public void Restaurar_DB() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Restaurar_DB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurar_DB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurar_DB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurar_DB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurar_DB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_seleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField text_contra;
    private javax.swing.JLabel text_mayus;
    private javax.swing.JTextField text_ruta;
    // End of variables declaration//GEN-END:variables
}