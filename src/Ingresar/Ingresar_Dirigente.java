/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresar;
import Control.TDirigente;
import Control.TSector;
import Datos.Conexion;

import Negocio.Dirigente;
import Validacion.Validar;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;
/**
 *
 * @author Daniel Barraza
 */
public class Ingresar_Dirigente extends javax.swing.JFrame {

    public static boolean ventana_ingresar_dirigente=false;
    private DefaultComboBoxModel sectorcombo;//creamos un default combobox
    static int control=0;
    Validar validar=new Validar();
    

    TDirigente tdirige;
    
    public Ingresar_Dirigente() {
        sectorcombo = new DefaultComboBoxModel(new String [] {});//iniciamos el combobox
        
        initComponents();
        this.setLocationRelativeTo(null);
        Select_Sector();
        tdirige=new TDirigente();
        //validacion de datos
        validar.validarSoloRut(textrutdiri);
        validar.limitarCaracteres(textrutdiri,11);
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
        validar.validarTelefono(texttelediri);
        validar.limitarCaracteres(texttelediri,23);
        validar.limitarCaracteres(textcallediri,40);
        validar.limitarCaracteres(textemaildiri,50);
       
    }

    //cargamos la infomacion del sector en el combobox
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
                Logger.getLogger(Ingresar_Dirigente.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textrutdiri = new javax.swing.JTextField();
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
        textnomdiri = new javax.swing.JTextField();
        text_sector = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Nuevo Dirigente");
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

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ingresar");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ingresar Nuevo Dirigente");

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

        text_sector.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel12)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addGap(260, 260, 260)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel9)))
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textcallediri, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textblock, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textdepdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textpobladiri, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texttelediri, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(185, 185, 185))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textnrocasa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textemaildiri, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combosector, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textrutdiri, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textmatdiri, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(textpatdiri, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addComponent(textnomdiri, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(textblock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textrutdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(textdepdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textnomdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(textpatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textpobladiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textmatdiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(texttelediri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textnrocasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(textcallediri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(textemaildiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(combosector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
            dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean ins=false;
        //valida si los campos no estan vacios
        if(textrutdiri.getText().length()!=0 && textnomdiri.getText().length()!=0 && textpatdiri.getText().length()!=0 && textmatdiri.getText().length()!=0 
         && textpobladiri.getText().length()!=0 && textcallediri.getText().length()!=0){
        ins=tdirige.insertarDirigente(new Dirigente(textrutdiri.getText(),textnomdiri.getText(),textpatdiri.getText(),textmatdiri.getText(),textnrocasa.getText(),
            textblock.getText(),textdepdiri.getText(),textpobladiri.getText(),texttelediri.getText(),textemaildiri.getText(),textcallediri.getText(),combosector.getItemAt(combosector.getSelectedIndex())));
    if(ins){ JOptionPane.showMessageDialog(null,"REGISTRO INGRESADO A BD",
        "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            //reiniciamos los campos
            textrutdiri.setText(null);
            textnomdiri.setText(null);
            textpatdiri.setText(null);
            textmatdiri.setText(null);
            textnrocasa.setText(null);
            textemaildiri.setText(null);
            textblock.setText(null);
            textdepdiri.setText(null);
            textpobladiri.setText(null);
            texttelediri.setText(null);
            textcallediri.setText(null);
    
      }else     JOptionPane.showMessageDialog(null,"REGISTRO PERDIDO O EXISTE",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"FALTAN CAMPOS POR INGRESAR",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }    
                       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textemaildiriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textemaildiriKeyTyped
        //permitimos solo el ingreso de una @ en el campo correo
        if(evt.getKeyChar()=='@' && textemaildiri.getText().contains("@")){
            evt.consume();
            }
    }//GEN-LAST:event_textemaildiriKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       ventana_ingresar_dirigente=false;//volvemos la variable a su valor inicial al cerrar la ventana
    }//GEN-LAST:event_formWindowClosed

    private void combosectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combosectorActionPerformed
        //Mostramos la infomacion en un jtextfield segun lo seleccionado en el combobox
        TSector tsector=new TSector();
        String[] vector = new String[1];
         vector=tsector.buscarSector(combosector.getItemAt(combosector.getSelectedIndex()));
        text_sector.setText(vector[1]);
    }//GEN-LAST:event_combosectorActionPerformed

    public void  ingresar_dirigente() {
       
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
            java.util.logging.Logger.getLogger(Ingresar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Dirigente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Dirigente().setVisible(true);
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
