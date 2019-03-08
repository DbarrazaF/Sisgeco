/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresar;

import Control.TDirectiva;
import Datos.Conexion;
import Negocio.Directiva;
import Ver.Ver_Directiva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Ingresar_Directiva extends javax.swing.JFrame {

    TDirectiva tdirectiva;
    static String rut_coves="";
    static int control=0;
    public static boolean ventana_ingresar_directiva=false;
   private DefaultComboBoxModel combo_dirigente;//se crea un default combobox
    public Ingresar_Directiva() {
         combo_dirigente = new DefaultComboBoxModel(new String [] {});//se inicializa el default combobox
        initComponents();
        this.setLocationRelativeTo(null);
        tdirectiva=new TDirectiva();
        //se asigna valor a los jtextfield
      textrutcoves.setText(rut_coves);
      text_control.setText(Integer.toString(control));
        Select_Dirigente();


    }
    //carga la infomacion del dirigente en un combobox
     private void Select_Dirigente(){
        Statement   orden=null;
        ResultSet   resul=null;
 
      Conexion    conex=new Conexion(); 
        try {
         orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT * FROM dirigente");
       
            while(resul.next()){
           combo_dirigente.addElement(resul.getString(1));
              }
    } catch (SQLException ex) {Logger.getLogger(Ingresar_Directiva.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cargocombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textrutcoves = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        combo_dirige = new javax.swing.JComboBox<>();
        text_control = new javax.swing.JTextField();
        text_dirigente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Directiva");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton2.setText("Asignar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Cargo del Dirigente");

        cargocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presidente", "Secretario", "Tesorero" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Asignar Directiva");

        jLabel2.setText("Rut COVES:");

        textrutcoves.setEditable(false);

        jLabel3.setText("Rut Dirigente:");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combo_dirige.setModel(combo_dirigente);
        combo_dirige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_dirigeActionPerformed(evt);
            }
        });

        text_control.setEditable(false);
        text_control.setEnabled(false);

        text_dirigente.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textrutcoves)
                            .addComponent(cargocombo, 0, 174, Short.MAX_VALUE)
                            .addComponent(combo_dirige, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(text_dirigente, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(156, 156, 156)
                                .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(134, 134, 134)
                                .addComponent(jButton2)
                                .addGap(152, 152, 152)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textrutcoves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(combo_dirige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_dirigente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cargocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean ins=false;
        Ver_Directiva ver_dire=new Ver_Directiva();
        ins=tdirectiva.insertarDirectiva(new Directiva(combo_dirige.getItemAt(combo_dirige.getSelectedIndex()),textrutcoves.getText(),cargocombo.getItemAt(cargocombo.getSelectedIndex())));
        if(ins){ JOptionPane.showMessageDialog(null,"REGISTRO INGRESADO A BD",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            ver_dire.ver_directiva(textrutcoves.getText(),9, Integer.parseInt(text_control.getText()));
        dispose();}

        else     JOptionPane.showMessageDialog(null,"REGISTRO PERDIDO O EXISTE",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ver_Directiva ver_directiva=new Ver_Directiva();
        ver_directiva.ver_directiva(textrutcoves.getText(),9,Integer.parseInt(text_control.getText()));
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventana_ingresar_directiva=false;//vuel la variable a su valor inicial el cerrar la ventana
    }//GEN-LAST:event_formWindowClosed

    private void combo_dirigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_dirigeActionPerformed
       
       
        //asigna valor a jtextfield segun lo seleciona en el combobox
        String[] vector = new String[4];
         vector=tdirectiva.buscarDirigenteDirectiva(combo_dirige.getItemAt(combo_dirige.getSelectedIndex()));
        text_dirigente.setText(vector[0]+" "+vector[1]+" "+vector[2]);
        
    }//GEN-LAST:event_combo_dirigeActionPerformed

    /**
     * @param rut_coves 
     * @param control
     */
    public void ingresar_directiva(String rut_coves,int control) {
        this.rut_coves=rut_coves;
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
            java.util.logging.Logger.getLogger(Ingresar_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingresar_Directiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cargocombo;
    private javax.swing.JComboBox<String> combo_dirige;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField text_dirigente;
    private javax.swing.JTextField textrutcoves;
    // End of variables declaration//GEN-END:variables
}
