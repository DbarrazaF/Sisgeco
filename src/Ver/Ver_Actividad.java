/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ver;

import Control.TCoves;
import Control.TFuncionario;
import Control.TActividad;
import Control.TTipo_Actividad;
import Listar.Listar_Actividad;
import Modificar.Modificar_Actividad;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Ver_Actividad extends javax.swing.JFrame {

    static String nro_actividad = "";
    static String rut_cov = "";
    static int control = 0;
    static int user = 0;
    TActividad tsuceso;
    TFuncionario tfuncionario;
    TTipo_Actividad ttipo_actividad;


    public Ver_Actividad() {

        initComponents();
        this.setLocationRelativeTo(null);//centra la ventana
        tsuceso = new TActividad();
        tfuncionario = new TFuncionario();
        ttipo_actividad = new TTipo_Actividad();
        //asigna valor
        text_rut_coves.setText(rut_cov);
        nro_ingreso.setText(nro_actividad);
        text_control.setText(Integer.toString(control));
        //valida usuario
        if (user == 8) {
            boton_modi_suce.setVisible(false);
        }
        Mostrar_Proyecto();
        Mostrar_Funcionario();
        Mostrar_Tipo_Actividad();
        Mostrar_Datos_Coves();

    }
    //Muestra infomacion del coves

    private void Mostrar_Datos_Coves() {
        TCoves tcoves = new TCoves();
        String[] vector = new String[1];
        vector = tcoves.buscarCoves(text_rut_coves.getText());

        text_nombre_orga.setText(vector[1]);

    }

    private void Mostrar_Proyecto() {
        //muestra informacion de proyecto
        String[] vectorsu = new String[8];
        vectorsu = tsuceso.buscarActividad(nro_actividad);
        text_fecha_suceso.setText(vectorsu[1]);
        area_descrip.setText(vectorsu[2]);
        textafiche.setText(vectorsu[3]);
        text_rut_funcionario.setText(vectorsu[5]);
        text_cod_tipo_suceso.setText(vectorsu[6]);
        text_nro_participantes.setText(vectorsu[7]);
    }

    private void Mostrar_Funcionario() {
        // Muestra informacion de funcionario
        String[] vector_funcionario = new String[2];
        vector_funcionario = tfuncionario.buscarFuncionarios(text_rut_funcionario.getText());
        text_nombre_funcionario.setText(vector_funcionario[1]);
        text_ap_paterno.setText(vector_funcionario[2]);
    }

    private void Mostrar_Tipo_Actividad() {
        // Muestra informacion de tipo Suceso
        String[] vectortipoactivi = new String[1];
        vectortipoactivi = ttipo_actividad.buscarTipoActividad(text_cod_tipo_suceso.getText());
        text_nombre_tipo_proy.setText(vectortipoactivi[1]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        text_rut_coves = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        text_nombre_organ = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_fecha_suceso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_descrip = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        textafiche = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        text_rut_funcionario = new javax.swing.JTextField();
        text_nombre_funcionario = new javax.swing.JTextField();
        text_ap_paterno = new javax.swing.JTextField();
        text_cod_tipo_suceso = new javax.swing.JTextField();
        text_nombre_tipo_proy = new javax.swing.JTextField();
        text_nro_participantes = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        boton_modi_suce = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        nro_ingreso = new javax.swing.JTextField();
        text_control = new javax.swing.JTextField();
        text_nombre_orga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Actividad");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Informacion sobre la Actividad");

        jLabel2.setText("Rut Coves:");

        text_rut_coves.setEditable(false);

        jLabel3.setText("Nombre organizacion:");

        text_nombre_organ.setEditable(false);

        jLabel4.setText("Fecha del Actividad:");

        text_fecha_suceso.setEditable(false);

        jLabel5.setText("Descripcion:");

        area_descrip.setEditable(false);
        area_descrip.setColumns(20);
        area_descrip.setRows(5);
        area_descrip.setMaximumSize(new java.awt.Dimension(90, 20));
        jScrollPane1.setViewportView(area_descrip);

        jLabel6.setText("Se entrega de afiche");

        textafiche.setEditable(false);

        jLabel7.setText("Funcionario responzable:");

        jLabel8.setText("Tipo de Actividad:");

        jLabel9.setText("Nro de Participantes:");

        text_rut_funcionario.setEditable(false);

        text_nombre_funcionario.setEditable(false);

        text_ap_paterno.setEditable(false);

        text_cod_tipo_suceso.setEditable(false);

        text_nombre_tipo_proy.setEditable(false);

        text_nro_participantes.setEditable(false);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boton_modi_suce.setText("Modificar");
        boton_modi_suce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modi_suceActionPerformed(evt);
            }
        });

        jLabel10.setText("Nro ingreso:");

        nro_ingreso.setEditable(false);

        text_control.setEditable(false);
        text_control.setEnabled(false);

        text_nombre_orga.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(120, 120, 120)
                .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_rut_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_nombre_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(text_ap_paterno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textafiche, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(text_cod_tipo_suceso, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(text_nro_participantes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(text_nombre_tipo_proy, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_nombre_orga, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_nombre_organ, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_fecha_suceso, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(text_rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nro_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_modi_suce)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(text_nombre_orga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(text_nombre_organ, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel10)
                        .addComponent(nro_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(text_rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(text_fecha_suceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textafiche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(text_rut_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nombre_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_ap_paterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(text_cod_tipo_suceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nombre_tipo_proy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(text_nro_participantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(boton_modi_suce))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Listar_Actividad listar_suceso = new Listar_Actividad();
        listar_suceso.listar_sucesos(text_rut_coves.getText(), user, Integer.parseInt(text_control.getText()));
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_modi_suceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modi_suceActionPerformed
        if (Modificar_Actividad.ventana_modificar_suceso == false) {//verifica que ventana se encuentre abierta
            Modificar_Actividad modificar_suceso = new Modificar_Actividad();
            modificar_suceso.modificar_suceso(text_rut_coves.getText(), text_nombre_orga.getText(), nro_ingreso.getText(), Integer.parseInt(text_control.getText()));
            Modificar_Actividad.ventana_modificar_suceso = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA MODIFICAR ACTIVIDAD SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_boton_modi_suceActionPerformed

    /**
     * @param nro_actividad
     * @param rut_cov
     * @param user
     * @param control
     */
    public void ver_actividad(String nro_actividad, String rut_cov, int user, int control) {
        this.nro_actividad = nro_actividad;
        this.rut_cov = rut_cov;
        this.user = user;
        this.control = control;

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
            java.util.logging.Logger.getLogger(Ver_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Actividad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_descrip;
    private javax.swing.JButton boton_modi_suce;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nro_ingreso;
    private javax.swing.JTextField text_ap_paterno;
    private javax.swing.JTextField text_cod_tipo_suceso;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField text_fecha_suceso;
    private javax.swing.JTextField text_nombre_funcionario;
    private javax.swing.JTextField text_nombre_orga;
    private javax.swing.JTextField text_nombre_organ;
    private javax.swing.JTextField text_nombre_tipo_proy;
    private javax.swing.JTextField text_nro_participantes;
    private javax.swing.JTextField text_rut_coves;
    private javax.swing.JTextField text_rut_funcionario;
    private javax.swing.JTextField textafiche;
    // End of variables declaration//GEN-END:variables
}
