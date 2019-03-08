/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ver;

import Control.TDirigente;
import Control.TSector;
import Listar.Listar_Dirigente;
import Modificar.Modificar_Dirigente;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Ver_Dirigente extends javax.swing.JFrame {

    
    static String rut_dirigente="";
    static int control=0;
    static String rut_coves="";
//    static String nom_coves="";
    static int user=0;
    TDirigente tdirigente;
    public Ver_Dirigente() {
        initComponents();
        this.setLocationRelativeTo(null);
       tdirigente= new TDirigente();
       //asigna valores
        textrutdiri.setText(rut_dirigente);
        rut_cov.setText(rut_coves);
        text_control.setText(Integer.toString(control));
        rut_cov.setVisible(false);
         if(user==8){//verifica usuario
            boton_modi_diri.setVisible(false);
            boton_elimi_diri.setVisible(false);
        }
        Mostrar_funcionario();
        Mostrar_Sector();
    }

    private void Mostrar_funcionario(){
    //muestra informacion de funcionario
        String[] vectorfun=new String[11];
        vectorfun=tdirigente.buscarDirigente(textrutdiri.getText());
        
        textnomdiri.setText(vectorfun[1]);
        textpatdiri.setText(vectorfun[2]);
        textmatdiri.setText(vectorfun[3]);
        textnrocasa.setText(vectorfun[4]);
        textblock.setText(vectorfun[5]);
        textdepdiri.setText(vectorfun[6]);
        textpobladiri.setText(vectorfun[7]);
        texttelediri.setText(vectorfun[8]);
        textemaildiri.setText(vectorfun[9]);
        textcallediri.setText(vectorfun[10]);
        text_sector.setText(vectorfun[11]);
        
    }
        //muestra infomacion del sector
        private void Mostrar_Sector(){
            TSector tsector=new TSector();
            String[] vectorsec=new String[1];
       vectorsec=tsector.buscarSector(text_sector.getText());
        
        text_nom_sec.setText(vectorsec[1]);
   
     
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_modi_diri = new javax.swing.JButton();
        boton_elimi_diri = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        textblock = new javax.swing.JTextField();
        textdepdiri = new javax.swing.JTextField();
        textpobladiri = new javax.swing.JTextField();
        texttelediri = new javax.swing.JTextField();
        textcallediri = new javax.swing.JTextField();
        textmatdiri = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textnrocasa = new javax.swing.JTextField();
        textemaildiri = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textrutdiri = new javax.swing.JTextField();
        textnomdiri = new javax.swing.JTextField();
        textpatdiri = new javax.swing.JTextField();
        text_sector = new javax.swing.JTextField();
        rut_cov = new javax.swing.JTextField();
        text_control = new javax.swing.JTextField();
        text_nom_sec = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Dirigente");
        setResizable(false);

        boton_modi_diri.setText("modificar");
        boton_modi_diri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modi_diriActionPerformed(evt);
            }
        });

        boton_elimi_diri.setText("eliminar");
        boton_elimi_diri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_elimi_diriActionPerformed(evt);
            }
        });

        jButton3.setText("atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        textblock.setEditable(false);

        textdepdiri.setEditable(false);

        textpobladiri.setEditable(false);

        texttelediri.setEditable(false);

        textcallediri.setEditable(false);

        textmatdiri.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ver Informacion del Dirigente");

        jLabel2.setText("Rut:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Apellido Materno:");

        jLabel6.setText("Nro casa:");

        jLabel7.setText("Bock:");

        textnrocasa.setEditable(false);

        textemaildiri.setEditable(false);

        jLabel8.setText("nro Departamento:");

        jLabel9.setText("Poblacion:");

        jLabel10.setText("Telefono:");

        jLabel11.setText("Calle:");

        jLabel12.setText("Email:");

        jLabel13.setText("Sector");

        textrutdiri.setEditable(false);

        textnomdiri.setEditable(false);

        textpatdiri.setEditable(false);

        text_sector.setEditable(false);

        rut_cov.setEditable(false);
        rut_cov.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        rut_cov.setEnabled(false);

        text_control.setEditable(false);
        text_control.setEnabled(false);

        text_nom_sec.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_modi_diri)
                        .addGap(179, 179, 179)
                        .addComponent(boton_elimi_diri)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textemaildiri, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textmatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(text_nom_sec, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textnomdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textrutdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textpatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(224, 224, 224)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(textnrocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textcallediri, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textblock, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rut_cov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(250, 250, 250)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(214, 214, 214)
                            .addComponent(jLabel9)))
                    .addGap(132, 132, 132)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textdepdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textpobladiri, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(texttelediri))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textrutdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textnomdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textpatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textmatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textnrocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(textcallediri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textemaildiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rut_cov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nom_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_modi_diri)
                    .addComponent(boton_elimi_diri)
                    .addComponent(jButton3))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(textdepdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel9)
                        .addComponent(textpobladiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(texttelediri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(169, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //verifica el camino
        if(Integer.parseInt(text_control.getText())==1 || Integer.parseInt(text_control.getText())==2 || Integer.parseInt(text_control.getText())==3){
          Ver_Directiva ver_directiva=new Ver_Directiva();
          ver_directiva.ver_directiva(rut_cov.getText(), user,Integer.parseInt(text_control.getText()));
      dispose();
      }
      else{
          new Listar_Dirigente().setVisible(true);
          dispose();
      }
     
         
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void boton_modi_diriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modi_diriActionPerformed
        Modificar_Dirigente modificar_dirigente= new Modificar_Dirigente();
        if(Modificar_Dirigente.ventana_modificar_dirigente==false){//valida que ventana no se encuentre abierta
        modificar_dirigente.modificar_dirigente(textrutdiri.getText(),rut_cov.getText(),Integer.parseInt(text_control.getText()));
        Modificar_Dirigente.ventana_modificar_dirigente=true;//cambia valor de la varieble en la siguente ventana
          this.setVisible(false);
        }
         else{
           JOptionPane.showMessageDialog(null,"VENTANA MODIFICAR DIRIGENTE YA SE ENCUENTRA ABIERTA",
        "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
       }
        
    }//GEN-LAST:event_boton_modi_diriActionPerformed

    private void boton_elimi_diriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_elimi_diriActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea Eliminar a '"+textrutdiri.getText()+"'?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == 0) {
        boolean elim=false;
        elim=tdirigente.eliminarDirigente(textrutdiri.getText());
        if (elim){
            JOptionPane.showMessageDialog(null,"Dirigente ELIMINADO",
                 "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                 dispose();
        }
        else     JOptionPane.showMessageDialog(null,"REGISTRO PERDIDO, VERIFIQUE QUE NO PERTENEZCA A NINGUNA DIRECTIVA ",
                 "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);  
        }
        
    }//GEN-LAST:event_boton_elimi_diriActionPerformed

   /**
    * 
    * @param rut_dirigente
    * @param rut_coves
    * @param control
    * @param user 
    */
    public void ver_dirigente(String rut_dirigente,String rut_coves, int control,int user) {
        this.rut_dirigente=rut_dirigente;
        this.control=control;
        this.rut_coves=rut_coves;
        this.user=user;
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
            java.util.logging.Logger.getLogger(Ver_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Dirigente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_elimi_diri;
    private javax.swing.JButton boton_modi_diri;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField rut_cov;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField text_nom_sec;
    private javax.swing.JTextField text_sector;
    private javax.swing.JTextField textblock;
    private javax.swing.JTextField textcallediri;
    private javax.swing.JTextField textdepdiri;
    private javax.swing.JTextField textemaildiri;
    private javax.swing.JTextField textmatdiri;
    private javax.swing.JTextField textnomdiri;
    private javax.swing.JTextField textnrocasa;
    private javax.swing.JTextField textpatdiri;
    private javax.swing.JTextField textpobladiri;
    private javax.swing.JTextField textrutdiri;
    private javax.swing.JTextField texttelediri;
    // End of variables declaration//GEN-END:variables
}
