/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresar;



import Control.TCoves;
import Datos.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Ingresar_Nuevo_Proyecto extends javax.swing.JFrame {

    private DefaultComboBoxModel rut_coves_combo;
    
   
    public Ingresar_Nuevo_Proyecto() {
        rut_coves_combo = new DefaultComboBoxModel(new String [] {});
        
        initComponents();
        this.setLocationRelativeTo(null);
        Select_Coves();
       
    }

   private void Select_Coves(){
    Statement   orden=null;
    ResultSet   resul=null;
    Conexion    conex=new Conexion(); 
   
       
       try {
    
                    orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT * FROM Coves");
     while(resul.next()){
    rut_coves_combo.addElement(resul.getString(1));
      }
  } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
  }finally{
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                 Logger.getLogger(Ingresar_Nuevo_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
             }
   
       
   
   
   }
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_rut_coves = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        text_nom_coves = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Nuevo Proyecto");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ingresar Nuevo proyecto");

        jLabel2.setText("Ingrese rut de coves:");

        combo_rut_coves.setModel(rut_coves_combo);
        combo_rut_coves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_rut_covesActionPerformed(evt);
            }
        });

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        text_nom_coves.setEditable(false);

        jLabel3.setText("Nombre Coves:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton2)
                        .addGap(103, 103, 103)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_nom_coves)
                            .addComponent(combo_rut_coves, 0, 224, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nom_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Ingresar_Proyecto  ingresar_proyecto=new Ingresar_Proyecto();
       if(Ingresar_Proyecto.ventana_ingresar_proyecto==false){
        String rut=combo_rut_coves.getItemAt(combo_rut_coves.getSelectedIndex());
        int control=6;
        ingresar_proyecto.ingresar_Proyecto(rut,control);
        Ingresar_Proyecto.ventana_ingresar_proyecto=true;
        this.setVisible(false);
       }else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR PROYECTO SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combo_rut_covesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_rut_covesActionPerformed
      //asigna valor a jtextfield segun lo seleciona en el combobox
      TCoves tcoves=new TCoves();
        String[] vector = new String[1];
         vector=tcoves.buscarCoves(combo_rut_coves.getItemAt(combo_rut_coves.getSelectedIndex()));
        text_nom_coves.setText(vector[1]);
    }//GEN-LAST:event_combo_rut_covesActionPerformed

    /**
     * @param args the command line arguments
     */
    public void ingresar_nuevo_proyecto() {
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
            java.util.logging.Logger.getLogger(Ingresar_Nuevo_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Nuevo_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Nuevo_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Nuevo_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Nuevo_Proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_rut_coves;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField text_nom_coves;
    // End of variables declaration//GEN-END:variables
}
