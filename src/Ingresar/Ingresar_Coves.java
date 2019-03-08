/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresar;

import Control.TCoves;
import Control.TUnidad_Vecinal;
import Datos.Conexion;
import javax.swing.ImageIcon;
import Negocio.Coves;
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
public class Ingresar_Coves extends javax.swing.JFrame {
   
       private DefaultComboBoxModel unidadCombo;//creas un default combobox
        TCoves tcoves;
        Validar validar=new Validar();
        TUnidad_Vecinal tunidad_vecinal=new TUnidad_Vecinal();
        public static boolean ventana_ingresar_coves=false;
        public Ingresar_Coves() {
            unidadCombo = new DefaultComboBoxModel(new String [] {});//se inicializa
            initComponents();
            Select_Unidad();
            tcoves=new TCoves();
            this.setLocationRelativeTo(null);
            //validacion de campos
            validar.validarSoloRut(textrutco);
            validar.limitarCaracteres(textrutco, 11);
            validar.limitarCaracteres(textnomco,50);
            validar.validarTelefono(text_telefono);
            validar.limitarCaracteres(text_telefono, 23);
            
        
}

 //muestra la infomacion de la unidad vecinal en el combobox, la cual luego es ordenada       
private void Select_Unidad(){
    
    Statement   orden=null;
    ResultSet   resul=null;
 
    Conexion    conex=new Conexion(); 
        try {
             orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT cod_unidad FROM unidad_vecinal ORDER BY CAST(cod_unidad AS INT) ASC ");
            
            while(resul.next()){
                unidadCombo.addElement(resul.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) { 
            Logger.getLogger(Ingresar_Coves.class.getName()).log(Level.SEVERE, null, ex);
        } 
       

}
}
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_unidad_vecinal = new javax.swing.JTextField();
        textrutco = new javax.swing.JTextField();
        textnomco = new javax.swing.JTextField();
        estadocombo = new javax.swing.JComboBox<>();
        unidadcombo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        year_ano_coves = new com.toedter.calendar.JYearChooser();
        jLabel8 = new javax.swing.JLabel();
        text_pobla = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        text_telefono = new javax.swing.JTextField();

        text_unidad_vecinal.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Nuevo Coves");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        estadocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vigente", "No vigente" }));

        unidadcombo.setModel(unidadCombo);
        unidadcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadcomboActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ingresar Nuevo COVES");

        jLabel2.setText("Porfavor ingresar informacion requerida");

        jLabel3.setText("Rut:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Unidad vecinal:");

        jLabel7.setText("Año de Ingreso:");

        year_ano_coves.setMinimum(1980);

        jLabel8.setText("Direccion:");

        jLabel9.setText("Telefono:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textrutco, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textnomco, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(year_ano_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estadocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(unidadcombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(text_pobla, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1)
                        .addGap(139, 139, 139)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textrutco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textnomco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(text_pobla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(unidadcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(year_ano_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unidadcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadcomboActionPerformed
      //muestra infomacion de la unidad vecinal en un jtextfield, segun lo selecionado en el combobox
        String[] vector = new String[4];
         vector=tunidad_vecinal.buscarUnidad_Vecinal(unidadcombo.getItemAt(unidadcombo.getSelectedIndex()));
        text_unidad_vecinal.setText(vector[1]);
    }//GEN-LAST:event_unidadcomboActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        boolean ins=false;
        if(textrutco.getText().length()!=0 && textnomco.getText().length()!=0 && text_telefono.getText().length()!=0 && text_pobla.getText().length()!=0){//valida que los campos no estan vacios
            String year_coves = Integer.toString(year_ano_coves.getYear());
            ins=tcoves.insertarCoves(new Coves(textrutco.getText(),textnomco.getText(),estadocombo.getItemAt(estadocombo.getSelectedIndex()),unidadcombo.getItemAt(unidadcombo.getSelectedIndex()),year_coves,text_pobla.getText(), text_telefono.getText()));
            if(ins){ JOptionPane.showMessageDialog(null,"REGISTRO INGRESADO A BD",
                "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                //vuelve los jtextfield a vacios, una vez ingresado el coves
                textrutco.setText(null);
                textnomco.setText(null);
                text_pobla.setText(null);
                text_telefono.setText(null);
            }

             else     JOptionPane.showMessageDialog(null,"REGISTRO PERDIDO O EXISTE",
                "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"FALTAN CAMPOS POR LLENAR O AÑO MAL INGRESADO",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       ventana_ingresar_coves=false;//vuelve a asignar valor falso, en caso que la ventana se cierre
    }//GEN-LAST:event_formWindowClosed

    /**
     */
    public  void ingresar_Coves() {
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
            java.util.logging.Logger.getLogger(Ingresar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ingresar_Coves().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> estadocombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField text_pobla;
    private javax.swing.JTextField text_telefono;
    private javax.swing.JTextField text_unidad_vecinal;
    private javax.swing.JTextField textnomco;
    private javax.swing.JTextField textrutco;
    private javax.swing.JComboBox<String> unidadcombo;
    private com.toedter.calendar.JYearChooser year_ano_coves;
    // End of variables declaration//GEN-END:variables
}
