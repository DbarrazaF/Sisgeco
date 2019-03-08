/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresar;

import Control.TCoves;
import Control.TFuncionario;
import Control.TActividad;
import Control.TTipo_Actividad;
import Datos.Conexion;

import Listar.Listar_Actividad;
import Negocio.Actividad;
import Validacion.Validar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Barraza
 */
public class Ingresar_Actividad extends javax.swing.JFrame {

    Statement orden = null;
    ResultSet resul = null;

    Conexion conex = new Conexion();

    private final DefaultComboBoxModel funcicombo;
    private final DefaultComboBoxModel tiposucombo;
    private final DefaultComboBoxModel combocodre;

    TActividad tsuceso;
    Validar validar = new Validar();
    static String rut_coves = "";
    static int control = 0;
    public static boolean ventana_ingresar_suceso = false;

    public Ingresar_Actividad() {

        funcicombo = new DefaultComboBoxModel(new String[]{});
        tiposucombo = new DefaultComboBoxModel(new String[]{});
        combocodre = new DefaultComboBoxModel(new String[]{});

        initComponents();
        combocod.setVisible(false);
        this.setLocationRelativeTo(null);
        Select_Tipo_Actividad();
        Select_Funcionario();
        Select_Ultimo();
        tsuceso = new TActividad();
        textrut.setText(rut_coves);
        text_control.setText(Integer.toString(control));
        validar.validarSoloNumeros(nro_participantes);
        validar.limitarCaracteres(nro_participantes, 4);
        Mostrar_Datos_Coves();

    }

    //Carga la infomacion del tipo de actividad en el combobox
    private void Select_Tipo_Actividad() {

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM Tipo_suceso");
            while (resul.next()) {
                tiposucombo.addElement(resul.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ingresar_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    //Carga la infomacion del Funcionario que esten activos en el combobox

    private void Select_Funcionario() {

        String estado = "Activo";
        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT * FROM funcionario WHERE estado_funcionario='" + estado + "'");
            while (resul.next()) {
                funcicombo.addElement(resul.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ingresar_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    //carga el ultimo registro que se encuentra en la base de datos

    private void Select_Ultimo() {

        try {

            orden = conex.abrirConexionURL().createStatement();
            resul = orden.executeQuery("SELECT MAX(cod_suceso) AS cod_suceso FROM suceso");
            while (resul.next()) {

                combocodre.addElement(resul.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(JComboBox.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                orden.close();
                resul.close();
            } catch (SQLException ex) {
                Logger.getLogger(Ingresar_Actividad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    //Muestra la informacion del Coves

    private void Mostrar_Datos_Coves() {
        TCoves tcoves = new TCoves();
        String[] vector = new String[1];
        vector = tcoves.buscarCoves(textrut.getText());

        textorga.setText(vector[1]);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areadescrip = new javax.swing.JTextArea();
        textorga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        funcionacombo = new javax.swing.JComboBox<>();
        textrut = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechasu = new com.toedter.calendar.JDateChooser();
        tipo_suce = new javax.swing.JComboBox<>();
        afichecombo = new javax.swing.JComboBox<>();
        combocod = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        nro_participantes = new javax.swing.JTextField();
        text_control = new javax.swing.JTextField();
        text_tipo_suceso = new javax.swing.JTextField();
        text_funcionario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Actividad");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel9.setText("Funcionario:");

        jLabel10.setText("Descripcion");

        jLabel1.setText("Organización");

        areadescrip.setColumns(20);
        areadescrip.setLineWrap(true);
        areadescrip.setRows(5);
        areadescrip.setWrapStyleWord(true);
        areadescrip.setMaximumSize(new java.awt.Dimension(90, 10));
        areadescrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areadescripKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(areadescrip);

        textorga.setEditable(false);

        jLabel2.setText("Rut:");

        funcionacombo.setModel(funcicombo);
        funcionacombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionacomboActionPerformed(evt);
            }
        });

        textrut.setEditable(false);

        jLabel5.setText("Tipo Actividad");

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

        jLabel7.setText("Fecha Actividad");

        jLabel4.setText("Realizo entrega de afiches:");

        fechasu.setMaxSelectableDate(new java.util.Date(253370779297000L));
        fechasu.setMinSelectableDate(new java.util.Date(315547297000L));

        tipo_suce.setModel(tiposucombo);
        tipo_suce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_suceActionPerformed(evt);
            }
        });

        afichecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));
        afichecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afichecomboActionPerformed(evt);
            }
        });

        combocod.setModel(combocodre);
        combocod.setEnabled(false);

        jLabel6.setText("Nro participantes:");

        text_control.setEditable(false);
        text_control.setEnabled(false);

        text_tipo_suceso.setEditable(false);

        text_funcionario.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nro_participantes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 23, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipo_suce, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechasu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(funcionacombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(text_tipo_suceso, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(combocod, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(text_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(textorga, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textrut, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(248, 248, 248))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(afichecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textorga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(textrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tipo_suce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tipo_suceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combocod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(funcionacombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(fechasu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nro_participantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(afichecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(41, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String fecha_suceso = new SimpleDateFormat("yyyy-MM-dd").format(fechasu.getDate());
        //pregunta si que existe registro en la base de datos, en caso que si exista lo agrega
        if (combocod.getItemAt(combocod.getSelectedIndex()) != null) {
            Integer ulti = Integer.parseInt(combocod.getItemAt(combocod.getSelectedIndex())) + 1;
            boolean ins = false;
            if (fechasu.getDate() != null && nro_participantes.getText().length() != 0) {//valida el ingreso de datos
                ins = tsuceso.insertarActividad(new Actividad(ulti, fecha_suceso, areadescrip.getText(), afichecombo.getItemAt(afichecombo.getSelectedIndex()), textrut.getText(), funcionacombo.getItemAt(funcionacombo.getSelectedIndex()),
                        tipo_suce.getItemAt(tipo_suce.getSelectedIndex()), nro_participantes.getText()));
                System.out.println(ins);
                if (ins) {
                    JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO A BD",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);

                    Listar_Actividad listar_suceso = new Listar_Actividad();
                    listar_suceso.listar_sucesos(textrut.getText(), 9, Integer.parseInt(text_control.getText()));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "REGISTRO PERDIDO O EXISTE",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                }

                

            } else {
                JOptionPane.showMessageDialog(null, "FALTAN DATOS POR INGRESAR",
                        "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            }
        } //fin if
        else {//en caso de que no exista registro, al numero de registro se asigna 1
            boolean ins = false;
            if (fechasu.getDate() != null && nro_participantes.getText().length() != 0) {// valida el ingreso de datos
                ins = tsuceso.insertarActividad(new Actividad(1, fecha_suceso, areadescrip.getText(), afichecombo.getItemAt(afichecombo.getSelectedIndex()), textrut.getText(), funcionacombo.getItemAt(funcionacombo.getSelectedIndex()),
                        tipo_suce.getItemAt(tipo_suce.getSelectedIndex()), nro_participantes.getText()));
                if (ins) {
                    JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO A BD",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);

                    Listar_Actividad listar_suceso = new Listar_Actividad();
                    listar_suceso.listar_sucesos(textrut.getText(), 9, Integer.parseInt(text_control.getText()));
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "REGISTRO PERDIDO O EXISTE",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                }


            } else {
                JOptionPane.showMessageDialog(null, "FALTAN DATOS POR INGRESAR",
                        "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            }
        }//fin else

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Listar_Actividad listar_suceso = new Listar_Actividad();
        listar_suceso.listar_sucesos(textrut.getText(), 9, Integer.parseInt(text_control.getText()));
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void afichecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afichecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afichecomboActionPerformed

    private void areadescripKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areadescripKeyTyped
        //restringe la cantidad de caracteres
        areadescrip.addKeyListener((new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int tam = areadescrip.getText().length();
                if (tam >= 500) {
                    e.consume();
                }
            }
        }));
    }//GEN-LAST:event_areadescripKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventana_ingresar_suceso = false;
    }//GEN-LAST:event_formWindowClosed

    private void tipo_suceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_suceActionPerformed
        //muestra infomacion de la actividad en un jtextfield, segun lo seleccionado en el combobox
        TTipo_Actividad ttipo_actividad = new TTipo_Actividad();
        String[] vector = new String[4];
        vector = ttipo_actividad.buscarTipoActividad(tipo_suce.getItemAt(tipo_suce.getSelectedIndex()));
        text_tipo_suceso.setText(vector[1]);


    }//GEN-LAST:event_tipo_suceActionPerformed

    private void funcionacomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionacomboActionPerformed
        //muestra infomacion del Funcionario en un jtextfield, segun lo seleccionado en el combobox
        TFuncionario tfuncionario = new TFuncionario();
        String[] vector = new String[4];
        vector = tfuncionario.buscarFuncionarios(funcionacombo.getItemAt(funcionacombo.getSelectedIndex()));
        text_funcionario.setText(vector[1] + " " + vector[2] + " " + vector[3]);
    }//GEN-LAST:event_funcionacomboActionPerformed

    /**
     * @param rut_coves
     * @param control
     */
    public void ingresar_Suceso(String rut_coves, int control) {
        this.rut_coves = rut_coves;
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
            java.util.logging.Logger.getLogger(Ingresar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingresar_Actividad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ingresar_Actividad().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> afichecombo;
    private javax.swing.JTextArea areadescrip;
    private javax.swing.JComboBox<String> combocod;
    private com.toedter.calendar.JDateChooser fechasu;
    private javax.swing.JComboBox<String> funcionacombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nro_participantes;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField text_funcionario;
    private javax.swing.JTextField text_tipo_suceso;
    private javax.swing.JTextField textorga;
    private javax.swing.JTextField textrut;
    private javax.swing.JComboBox<String> tipo_suce;
    // End of variables declaration//GEN-END:variables
}
