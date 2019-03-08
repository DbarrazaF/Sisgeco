/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ver;

import Buscar.Buscar_Coves;
import Buscar.Buscar_Coves_Nombre;
import Control.TCoves;
import Ingresar.Ingresar_Proyecto;
import Listar.Listar_Coves;
import Listar.Listar_Actividad;
import Modificar.Modificar_Coves;
import Negocio.Proyecto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Ver_Coves extends javax.swing.JFrame {

    TCoves tcoves;
   

    static String rut_buscar = "";
    static int user=0;
    static int control=0;
   
    
    
    
    

    public Ver_Coves() {

        initComponents();
        
         
        
        this.setLocationRelativeTo(null);
        tcoves = new TCoves();
       
        text_rut.setText(rut_buscar);
        Listar_Proyecto();
         Mostrar_Datos_Coves();
        text_control.setText(Integer.toString(control));
        if(user==8){
            boton_ingresar_proye.setVisible(false);
            boton_modificar_coves.setVisible(false);
        }
        

    }
    //Lista la infomacion de los proyecto del coves
    private void Listar_Proyecto() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_proy_cov.getModel();
        modelo.addColumn("Año Postulacion");
        modelo.addColumn("Nro ingreso");
        modelo.addColumn("Nombre Proyecto");
        for (Proyecto proye : tcoves.listarProyectoCoves(text_rut.getText())) {
            Object rowData[] = {proye.getAno_postulacion_proyecto(), proye.getNro_ingreso_proyecto(), proye.getNombre_proyecto()};
            ((DefaultTableModel) tabla_proy_cov.getModel()).addRow(rowData);
        };
       

    }
    //muestra infomacion del coves
    private void Mostrar_Datos_Coves() {
        String[] vector = new String[7];
        vector = tcoves.buscarCoves(text_rut.getText());
        text_estado.setText(vector[2]);
        text_orga.setText(vector[1]);
        text_cod_unidad.setText(vector[3]);
        text_telefono.setText(vector[6]);
        if(!"2000".equals(vector[4])){
        text_ano_creacion.setText(vector[4]);
        }
        else{
            text_ano_creacion.setText("No registra");
        }
        
        text_poblacion.setText(vector[5]);
        
        
    }
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_modificar_coves = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_proy_cov = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        text_orga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_rut = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_estado = new javax.swing.JTextField();
        text_control = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        text_telefono = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        boton_ingresar_proye = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        text_poblacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        text_ano_creacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        text_cod_unidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Coves");
        setResizable(false);

        boton_modificar_coves.setText("Modificar Coves");
        boton_modificar_coves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificar_covesActionPerformed(evt);
            }
        });

        tabla_proy_cov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_proy_cov.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla_proy_cov.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla_proy_cov.getTableHeader().setResizingAllowed(false);
        tabla_proy_cov.getTableHeader().setReorderingAllowed(false);
        tabla_proy_cov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_proy_covMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_proy_cov);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ver informacion de COVES");

        text_orga.setEditable(false);

        jLabel1.setText("Organizacion:");

        jLabel3.setText("Rut:");

        text_rut.setEditable(false);

        jLabel4.setText("Estado:");

        text_estado.setEditable(false);

        text_control.setEditable(false);
        text_control.setEnabled(false);

        jLabel8.setText("Telefono:");

        text_telefono.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_orga)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(text_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(text_telefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(text_orga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        jButton1.setText("Listar Actividades");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Directiva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        boton_ingresar_proye.setText("Ingresar nuevo Proyecto");
        boton_ingresar_proye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ingresar_proyeActionPerformed(evt);
            }
        });

        jLabel7.setText("Direccion:");

        text_poblacion.setEditable(false);

        jLabel6.setText("Año creacion:");

        text_ano_creacion.setEditable(false);

        jLabel5.setText("Unidad Vecinal:");

        text_cod_unidad.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7)
                                .addGap(35, 35, 35)
                                .addComponent(text_poblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_ano_creacion, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(text_cod_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(boton_ingresar_proye)
                        .addGap(29, 29, 29)
                        .addComponent(boton_modificar_coves)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_poblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(text_ano_creacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(text_cod_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(boton_ingresar_proye)
                    .addComponent(boton_modificar_coves)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        Listar_Actividad listar_sucesos = new Listar_Actividad();
        listar_sucesos.listar_sucesos(text_rut.getText(),user,Integer.parseInt(text_control.getText()));
        this.setVisible(false);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        Ver_Directiva ver_directiva = new Ver_Directiva();
        ver_directiva.ver_directiva(text_rut.getText(),user,Integer.parseInt(text_control.getText()));
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(Integer.parseInt(text_control.getText())==1){//valida ventana de procedencia
             
             Buscar_Coves buscar_coves=new Buscar_Coves();
             buscar_coves.buscar_coves(user);
             dispose();
         }
         if(Integer.parseInt(text_control.getText())==2){
             Buscar_Coves_Nombre buscar_coves_nombre=new Buscar_Coves_Nombre();
             buscar_coves_nombre.buscar_coves_nombre(user);
             dispose();
         }
         if(Integer.parseInt(text_control.getText())==3){
             Listar_Coves listar_coves=new Listar_Coves();
             listar_coves.listar_coves(user);
             dispose();
         }
             
    
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabla_proy_covMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_proy_covMouseClicked
        Ver_Proyecto ver_proyecto = new Ver_Proyecto();
        
        if (evt.getClickCount() == 2) {//carga siguiente ventana haciendo doble click
            String ano_postula = String.valueOf(tabla_proy_cov.getValueAt(tabla_proy_cov.getSelectedRow(), 0));
            String nro_registro = String.valueOf(tabla_proy_cov.getValueAt(tabla_proy_cov.getSelectedRow(), 1));
            
            
               
                ver_proyecto.ver_proyecto(ano_postula, nro_registro,user,Integer.parseInt(text_control.getText()),text_rut.getText());
                
                this.setVisible(false);
        
           
        }
    }//GEN-LAST:event_tabla_proy_covMouseClicked

    private void boton_ingresar_proyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ingresar_proyeActionPerformed
        
        if(Ingresar_Proyecto.ventana_ingresar_proyecto==false){//valida que ventana no se encuentre abierta
        Ingresar_Proyecto ingresar_proyecto = new Ingresar_Proyecto();
        ingresar_proyecto.ingresar_Proyecto(text_rut.getText(), Integer.parseInt(text_control.getText()));
        Ingresar_Proyecto.ventana_ingresar_proyecto=true;//cambia valor de la varieble en la siguente ventana
        this.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR PROYECTO SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_boton_ingresar_proyeActionPerformed

    private void boton_modificar_covesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificar_covesActionPerformed
        if(Modificar_Coves.ventana_modificar_coves==false){//valida que ventana no se encuentre abierta
        Modificar_Coves modificar_coves=new Modificar_Coves();
        modificar_coves.modificar_coves(rut_buscar,text_estado.getText(),Integer.parseInt(text_control.getText()));
        Modificar_Coves.ventana_modificar_coves=true;//cambia valor de la varieble en la siguente ventana
        this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "VENTANA MODIFICAR COVES SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
        
    }//GEN-LAST:event_boton_modificar_covesActionPerformed

    /**
     * @param rut_buscar
     * @param user
     * @param control
     */
    public void ver_coves(String rut_buscar, int user, int control) {
        this.rut_buscar = rut_buscar;
        this.user=user;
        this.control=control;
        
       
       
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" dSesc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(Ver_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ver_Coves().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_ingresar_proye;
    private javax.swing.JButton boton_modificar_coves;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabla_proy_cov;
    private javax.swing.JTextField text_ano_creacion;
    private javax.swing.JTextField text_cod_unidad;
    private javax.swing.JTextField text_control;
    public javax.swing.JTextField text_estado;
    public javax.swing.JTextField text_orga;
    private javax.swing.JTextField text_poblacion;
    private javax.swing.JTextField text_rut;
    private javax.swing.JTextField text_telefono;
    // End of variables declaration//GEN-END:variables
}
