/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresar;

import Control.TSector;
import Control.TUnidad_Vecinal;
import Datos.Conexion;
import javax.swing.ImageIcon;
import Negocio.Unidad_Vecinal;
import Validacion.Validar;
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
public class Ingresar_Unidad_Vecinal extends javax.swing.JFrame {

    public static boolean ventana_ingresar_unidad_vecinal=false;
    private DefaultComboBoxModel sectorCombo;//creamos un default combbox
    TUnidad_Vecinal tunidad;
    Validar validar=new Validar();

    public Ingresar_Unidad_Vecinal() {
        sectorCombo = new DefaultComboBoxModel(new String[]{});//inicializamos el combobox
        tunidad = new TUnidad_Vecinal();
        this.setLocationRelativeTo(null);
        initComponents();
        Select_Sector();
        //validamos los campos
        validar.validarSoloNumeros(textCodUni);
        validar.limitarCaracteres(textCodUni,3);
        validar.limitarCaracteres(textNomUni,50);
        

    }
    //muestra infomacion del sector en un combobox
    private void Select_Sector() {
        Statement   orden=null;
        ResultSet   resul=null;
 
       Conexion    conex=new Conexion();
        try {

            orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT * FROM sector");
            while (resul.next()) {
                sectorCombo.addElement(resul.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ingresar_Unidad_Vecinal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        comboCodSector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textCodUni = new javax.swing.JTextField();
        textNomUni = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        text_sector = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel5.setText("Codigo Sector:");

        comboCodSector.setModel(sectorCombo);
        comboCodSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCodSectorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ingresar Nueva Unidad Vecinal");

        jLabel2.setText("Codido Unidad:");

        jLabel3.setText("Nombre Unidad:");

        textCodUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodUniActionPerformed(evt);
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

        text_sector.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(textNomUni, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodUni, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboCodSector, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textCodUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNomUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboCodSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCodSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCodSectorActionPerformed
        //Muestra infomacion segun lo selecionado el el combobox
        TSector tsector=new TSector();
        String[] vector = new String[1];
         vector=tsector.buscarSector(comboCodSector.getItemAt(comboCodSector.getSelectedIndex()));
        text_sector.setText(vector[1]);
        
        
        
    }//GEN-LAST:event_comboCodSectorActionPerformed

    private void textCodUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCodUniActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean ins=false;
        //se valida el ingreso de datos
        if(textCodUni.getText().length()!=0 && textNomUni.getText().length()!=0){
        ins = tunidad.insertarUnidadVecinal(new Unidad_Vecinal(textCodUni.getText(), textNomUni.getText(),comboCodSector.getItemAt(comboCodSector.getSelectedIndex())));
        if (ins) {
            JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO A BD",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            //se reinician los campos
            textCodUni.setText(null);
            textNomUni.setText(null);
        } else {
            JOptionPane.showMessageDialog(null, "REGISTRO PERDIDO O EXISTE",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
        }
        else{
            JOptionPane.showMessageDialog(null,"FALTAN DATOS POR INGRESAR",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       ventana_ingresar_unidad_vecinal=false;//la variable vuelve a su estado inicial, al cerrar la ventana
    }//GEN-LAST:event_formWindowClosed

    /**
     */
    public void ingresar_unidad_Vecinal() {
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
            java.util.logging.Logger.getLogger(Ingresar_Unidad_Vecinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad_Vecinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad_Vecinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Unidad_Vecinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Unidad_Vecinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCodSector;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField textCodUni;
    private javax.swing.JTextField textNomUni;
    private javax.swing.JTextField text_sector;
    // End of variables declaration//GEN-END:variables
}
