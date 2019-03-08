/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modificar;

import Control.TCoves;
import Control.TActividad;
import Datos.Conexion;
import Ingresar.Ingresar_Actividad;
import Negocio.Actividad;
import Validacion.Validar;
import Ver.Ver_Actividad;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class Modificar_Actividad extends javax.swing.JFrame {
    Validar validar=new Validar();
    Statement   orden=null;
    ResultSet   resul=null;
    Conexion    conex=new Conexion();
    private final DefaultComboBoxModel funcicombo;//creamos un default combobox
    private final DefaultComboBoxModel tiposucombo;//creamos un default combobox
    static String rut_coves="";
    static String nombre_orga="";
    static String nro_suceso="";
    static int control =0;
    public static boolean ventana_modificar_suceso=false;
    TActividad tsuceso;
    public Modificar_Actividad() {
        funcicombo = new DefaultComboBoxModel(new String [] {});//iniciamos el combobox
        tiposucombo=new DefaultComboBoxModel(new String [] {});//iniciamos el combobox
        tsuceso=new TActividad();
        initComponents();
        this.setLocationRelativeTo(null);//carga ventana al centro
        //Asigna valores a los jtextfield
        textrutcoves.setText(rut_coves);
        nro_ingreso.setText(nro_suceso);
        text_control.setText(Integer.toString(control));
        //valida los campos
        validar.limitarCaracteres(nro_participantes, 4);
        validar.validarSoloNumeros(nro_participantes);
        
        
        
        
        Mostrar_Datos_Coves();
        Select_Tipo_Actividad();
        Select_Funcionario();
        
        //muestra informacion de Actividad
        String[] vectoractivi=new String[8];
        vectoractivi=tsuceso.buscarActividad(nro_suceso);
        nro_ingreso.setText(vectoractivi[0]);
        areadescrip.setText(vectoractivi[2]);
        afichecombo.setSelectedItem(vectoractivi[3]);
        funcionacombo.setSelectedItem(vectoractivi[5]);
        tipo_suce.setSelectedItem(vectoractivi[6]);
        nro_participantes.setText(vectoractivi[7]);
        
       
    
    }
     
    //carga la infomacion del tipo de actividad en un combobox
     private void Select_Tipo_Actividad(){
      
        try {
            
      
             orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT * FROM Tipo_suceso");
            while(resul.next()){
            tiposucombo.addElement(resul.getString(1));
              }
    } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Modificar_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
   
    }
    }    
    //carga la infomacion del funcionario en un combobox
     private void Select_Funcionario(){
        
         String estado="Activo";
        try {
        
            orden=conex.abrirConexionURL().createStatement();
                  resul=orden.executeQuery("SELECT * FROM funcionario WHERE estado_funcionario='"+estado+"'");
            while(resul.next()){
            funcicombo.addElement(resul.getString(1));
              }
    } catch (SQLException ex) {Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ingresar_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }
   
     }
}   
     //Muestra la infomacion del coves y la carga en un jtextfield
     private void Mostrar_Datos_Coves() {
         TCoves tcoves=new TCoves();
        String[] vector = new String[1];
        vector = tcoves.buscarCoves(textrutcoves.getText());
        
        textorga.setText(vector[1]);
        
        
        
    }     

    
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nro_participantes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areadescrip = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        textorga = new javax.swing.JTextField();
        tipo_suce = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        afichecombo = new javax.swing.JComboBox<>();
        funcionacombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textrutcoves = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nro_ingreso = new javax.swing.JTextField();
        text_control = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar Actividad");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel6.setText("Nro participantes:");

        jLabel5.setText("Tipo Actividad");

        jLabel9.setText("Funcionario:");

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Descripcion");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Organización");

        areadescrip.setColumns(20);
        areadescrip.setRows(5);
        areadescrip.setMaximumSize(new java.awt.Dimension(100, 10));
        areadescrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areadescripKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(areadescrip);

        jLabel4.setText("Realizo entrega de afiches:");

        textorga.setEditable(false);

        tipo_suce.setModel(tiposucombo);

        jLabel2.setText("Rut:");

        afichecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        funcionacombo.setModel(funcicombo);

        jLabel3.setText("Numero de Ingreso");

        textrutcoves.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Modificar Actividad");

        nro_ingreso.setEditable(false);

        text_control.setEditable(false);
        text_control.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(textorga, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textrutcoves, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tipo_suce, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nro_participantes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(192, 192, 192)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(funcionacombo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nro_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(afichecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(170, 170, 170)
                        .addComponent(jButton1)
                        .addGap(248, 248, 248))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(287, 287, 287)
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textorga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textrutcoves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tipo_suce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nro_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(funcionacombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(nro_participantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(afichecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         boolean modi=false;
         String no="";
         if(nro_participantes.getText().length()!=0){//valida los campos vacios
        modi=tsuceso.modificarActividad(new Actividad (Integer.parseInt(nro_ingreso.getText()),no,areadescrip.getText(),afichecombo.getItemAt(afichecombo.getSelectedIndex()),
                no,funcionacombo.getItemAt(funcionacombo.getSelectedIndex()),tipo_suce.getItemAt(tipo_suce.getSelectedIndex()),nro_participantes.getText()));
        if(modi){ 
                JOptionPane.showMessageDialog(null,"REGISTRO MODIFICADO",
                "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                 Ver_Actividad ver_Actividad= new Ver_Actividad();
       ver_Actividad.ver_actividad(nro_ingreso.getText(),textrutcoves.getText(),9,Integer.parseInt(text_control.getText()));
        dispose();
        }
        else     JOptionPane.showMessageDialog(null,"REGISTRO PERDIDO",
                 "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);        
       
         }
         else{
              JOptionPane.showMessageDialog(null,"FALTAN DATOS POR INGRESAR",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Ver_Actividad ver_suceso= new Ver_Actividad();
       ver_suceso.ver_actividad(nro_ingreso.getText(),textrutcoves.getText(),9,Integer.parseInt(text_control.getText()));
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void areadescripKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areadescripKeyTyped
       //valida la cantidad de caracteres en el textarea
        areadescrip.addKeyListener((new KeyAdapter(){
         @Override
         public void keyTyped(KeyEvent e){
             int tam=areadescrip.getText().length();
             if(tam>=500){
                 e.consume();
             }
         }
     }));
    }//GEN-LAST:event_areadescripKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       ventana_modificar_suceso=false;//vuelve la variable a su estado inicial, al cerrar la ventana
    }//GEN-LAST:event_formWindowClosed

    /**
     * 
     * @param rut_coves
     * @param nombre_orga
     * @param nro_suceso
     * @param control 
     */
    public void modificar_suceso(String rut_coves,String nombre_orga, String nro_suceso,int control ) {
        this.rut_coves=rut_coves;
        this.nombre_orga=nombre_orga;
        this.nro_suceso=nro_suceso;
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
            java.util.logging.Logger.getLogger(Modificar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Modificar_Actividad().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> afichecombo;
    private javax.swing.JTextArea areadescrip;
    private javax.swing.JComboBox<String> funcionacombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nro_ingreso;
    private javax.swing.JTextField nro_participantes;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField textorga;
    private javax.swing.JTextField textrutcoves;
    private javax.swing.JComboBox<String> tipo_suce;
    // End of variables declaration//GEN-END:variables
}
