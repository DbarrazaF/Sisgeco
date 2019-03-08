/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modificar;

import Control.TDirigente;
import Control.TSector;
import Datos.Conexion;
import Negocio.Dirigente;
import Validacion.Validar;
import javax.swing.ImageIcon;
import Ver.Ver_Dirigente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Barraza
 */
public class Modificar_Dirigente extends javax.swing.JFrame {
    Validar validar=new Validar();
   private DefaultComboBoxModel sectorcombo;//creamos un default combobox
   TDirigente tdirigente;
   static String rut_dirigente="";
   static String rut_cov="";
   static int control=0;
   public static boolean ventana_modificar_dirigente=false;
   
     public Modificar_Dirigente() {
        sectorcombo = new DefaultComboBoxModel(new String [] {});//iniciamos un defaul combobox
       
        initComponents();
        tdirigente=new TDirigente();
        this.setLocationRelativeTo(null);
        //asigna valores
        textrutdiri.setText(rut_dirigente);
        rut_coves.setText(rut_cov);
        text_control.setText(Integer.toString(control));
        Select_Sector();
        Mostrar_dirigente();
        //validamos campos
        validar.validarSoloLetras(textnomdiri);
        validar.limitarCaracteres(textnomdiri,20);
        validar.validarSoloLetras(textpatdiri);
        validar.limitarCaracteres(textpatdiri, 20);
        validar.validarSoloLetras(textmatdiri);
        validar.limitarCaracteres(textmatdiri, 20);
        validar.limitarCaracteres(textnrocasa, 6);
        validar.limitarCaracteres(textblock,3);
        validar.limitarCaracteres(textdepdiri,3);
        validar.limitarCaracteres(textpobladiri,30);
        validar.validarSoloNumeros(texttelediri);
        validar.limitarCaracteres(texttelediri,11);
        validar.limitarCaracteres(textcallediri,40);
        validar.limitarCaracteres(textemaildiri,50);
        rut_coves.setVisible(false);

        
        
    }
    //Muestra infomacion de sector en combobox
    private void Select_Sector(){
     Statement   orden=null;
    ResultSet   resul=null;
    Conexion    conex=new Conexion(); 
        try {
         orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT * FROM Sector");
       
            while(resul.next()){
            sectorcombo.addElement(resul.getString(1));
              }
    } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Modificar_Dirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     private void Mostrar_dirigente(){
    //muestra informacion de dirigente
        String[] vectordiri=new String[11];
       vectordiri=tdirigente.buscarDirigente(textrutdiri.getText());
        
        textnomdiri.setText(vectordiri[1]);
        textpatdiri.setText(vectordiri[2]);
        textmatdiri.setText(vectordiri[3]);
        textnrocasa.setText(vectordiri[4]);
        textblock.setText(vectordiri[5]);
        textdepdiri.setText(vectordiri[6]);
        textpobladiri.setText(vectordiri[7]);
        texttelediri.setText(vectordiri[8]);
        textemaildiri.setText(vectordiri[9]);
        textcallediri.setText(vectordiri[10]);
        combosector.setSelectedItem(vectordiri[11]);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textblock = new javax.swing.JTextField();
        textdepdiri = new javax.swing.JTextField();
        textpobladiri = new javax.swing.JTextField();
        texttelediri = new javax.swing.JTextField();
        textcallediri = new javax.swing.JTextField();
        combosector = new javax.swing.JComboBox<>();
        textpatdiri = new javax.swing.JTextField();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textrutdiri = new javax.swing.JTextField();
        textnomdiri = new javax.swing.JTextField();
        rut_coves = new javax.swing.JTextField();
        text_control = new javax.swing.JTextField();
        text_sector = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Dirigente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        combosector.setModel(sectorcombo);
        combosector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combosectorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Modificar Dirigente");

        jLabel2.setText("Rut:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellido Paterno:");

        jLabel5.setText("Apellido Materno:");

        jLabel6.setText("Nro casa:");

        jLabel7.setText("Bock:");

        textemaildiri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textemaildiriKeyTyped(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("nro Departamento:");

        jLabel9.setText("Poblacion:");

        jLabel10.setText("Telefono:");

        jLabel11.setText("Calle:");

        jLabel12.setText("Email:");

        jLabel13.setText("Sector");

        textrutdiri.setEditable(false);

        rut_coves.setEditable(false);
        rut_coves.setDisabledTextColor(new java.awt.Color(204, 204, 255));
        rut_coves.setEnabled(false);

        text_control.setEditable(false);
        text_control.setEnabled(false);

        text_sector.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addGap(54, 54, 54)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textnomdiri)
                                                    .addComponent(textrutdiri, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(textpatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel9))
                                                    .addComponent(textemaildiri, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(combosector, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(textmatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textnrocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel11)
                                                            .addComponent(jLabel10)))))
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(textblock, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textdepdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textpobladiri, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                                .addComponent(texttelediri))
                                            .addComponent(textcallediri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(jButton1)
                                .addGap(106, 106, 106)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(textrutdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(textnomdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textdepdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(textpatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textpobladiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texttelediri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textmatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textnrocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textcallediri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textemaildiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(combosector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
               Ver_Dirigente ver_dirigente=new Ver_Dirigente();
               ver_dirigente.ver_dirigente(textrutdiri.getText(),rut_coves.getText(),Integer.parseInt(text_control.getText()),9);
               dispose(); 
       
        
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       boolean modi=false;
       if(textnomdiri.getText().length()!=0 && textpatdiri.getText().length()!=0 && textmatdiri.getText().length()!=0 
            && textpobladiri.getText().length()!=0 && textcallediri.getText().length()!=0){//valida campos vacios
        
           modi=tdirigente.modificarDirigente(new Dirigente(textrutdiri.getText(),textnomdiri.getText(),textpatdiri.getText()
        ,textmatdiri.getText(),textnrocasa.getText(),textblock.getText(),textdepdiri.getText()
        ,textpobladiri.getText(),texttelediri.getText(),textemaildiri.getText(),textcallediri.getText(),combosector.getItemAt(combosector.getSelectedIndex())));
        if(modi){ 
                JOptionPane.showMessageDialog(null,"REGISTRO MODIFICADO",
                "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                Ver_Dirigente ver_dirigente=new Ver_Dirigente();
               ver_dirigente.ver_dirigente(textrutdiri.getText(),rut_coves.getText(),1,9);
                
                dispose();
        }
        else     JOptionPane.showMessageDialog(null,"REGISTRO PERDIDO",
                 "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE); 
                                          
       }else{
        JOptionPane.showMessageDialog(null,"FALTAN CAMPOS POR INGRESAR",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textemaildiriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textemaildiriKeyTyped
        //valida que solo se ingrese un @ en el jtextfield email
        if(evt.getKeyChar()=='@' && textemaildiri.getText().contains("@")){
            evt.consume();
            }
    
    }//GEN-LAST:event_textemaildiriKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventana_modificar_dirigente=false;//vuelve los campos a sus estado inicial, al cerrar la ventana
    }//GEN-LAST:event_formWindowClosed

    private void combosectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosectorActionPerformed
       TSector tsector=new TSector();
       //carga infomacion en ttextfield segun lo seleccionado en el combobox
        String[] vector = new String[4];
         vector=tsector.buscarSector(combosector.getItemAt(combosector.getSelectedIndex()));
        text_sector.setText(vector[1]);
    }//GEN-LAST:event_combosectorActionPerformed

   /**
    * 
    * @param rut_dirigente
    * @param rut_cov
    * @param control 
    */
    public void modificar_dirigente(String rut_dirigente,String rut_cov, int control) {
       this.rut_dirigente=rut_dirigente;
       this.rut_cov=rut_cov;
       this.control=control;
       
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
            java.util.logging.Logger.getLogger(Modificar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_Dirigente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combosector;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField rut_coves;
    private javax.swing.JTextField text_control;
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
