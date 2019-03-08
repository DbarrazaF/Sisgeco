/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listar;

import Control.TCoves;
import Control.TActividad;
import Ingresar.Ingresar_Actividad;
import Negocio.Actividad;
import Ver.Ver_Coves;
import Ver.Ver_Actividad;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Listar_Actividad extends javax.swing.JFrame {
    static String rut_coves="";
    static int user=0;
    static int control=0;
    
 
  
    
    TActividad tactividad;
    
    public Listar_Actividad() {
        
        
        tactividad=new TActividad();
        initComponents();
        this.setLocationRelativeTo(null);
        //asigna valores a jtextfield
        text_rut.setText(rut_coves);
        text_control.setText(Integer.toString(control));
        Mostrar_Datos_Coves();
        Listar_Actividad();
        if(user==8){
            //usuario solo visualizar
            boton_ingres_suce.setVisible(false);
        }
        
    }
   //Carga los datos en la jtabla
   private void Listar_Actividad(){
    DefaultTableModel modelo= (DefaultTableModel) table_actividad.getModel();
        modelo.addColumn("Nro Registro Actividad");
        modelo.addColumn("Fecha De Actividad");
        modelo.addColumn("Codigo de Tipo de Actividad");
        modelo.addColumn("Rut funcionario que la realizó");
        for(Actividad actividad : tactividad.listarActividad(text_rut.getText())){
          Object rowData[]={actividad.getCod_suceso(),actividad.getFecha_suceso(),actividad.getCod_tipo_suceso(),actividad.getRut_funcionario()};
          ((DefaultTableModel)table_actividad.getModel()).addRow(rowData);
        
    
   
    
    }

    }
   //muestra infomacion del coves
   private void Mostrar_Datos_Coves() {
       TCoves tcoves=new TCoves();
        String[] vector = new String[1];
        vector = tcoves.buscarCoves(text_rut.getText());
        
        text_orga.setText(vector[1]);
        
        
        
    }     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_actividad = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton1 = new javax.swing.JButton();
        text_orga = new javax.swing.JTextField();
        text_rut = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boton_ingres_suce = new javax.swing.JButton();
        text_control = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Actividad");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Actividades");

        table_actividad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_actividad.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_actividad.getTableHeader().setResizingAllowed(false);
        table_actividad.getTableHeader().setReorderingAllowed(false);
        table_actividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_actividadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_actividad);

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        text_orga.setEditable(false);

        text_rut.setEditable(false);

        jLabel3.setText("Rut:");

        jLabel2.setText("Organizacion:");

        boton_ingres_suce.setText("Ingresar nueva Actividad");
        boton_ingres_suce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ingres_suceActionPerformed(evt);
            }
        });

        text_control.setEditable(false);
        text_control.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_orga, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_ingres_suce)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_orga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(boton_ingres_suce))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_ingres_suceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ingres_suceActionPerformed
        //Verifica si ventana se encuentra abierta
        if(Ingresar_Actividad.ventana_ingresar_suceso==false){
        Ingresar_Actividad ingresar_suceso = new Ingresar_Actividad();
        ingresar_suceso.ingresar_Suceso(text_rut.getText(),Integer.parseInt(text_control.getText()));
        Ingresar_Actividad.ventana_ingresar_suceso=true;//cambia el valor de la variable, en la siguente ventana
        dispose();
        }else {
            JOptionPane.showMessageDialog(null,"VENTANA LISTAR SUCESO ESTA ABIERTA",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_boton_ingres_suceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        Ver_Coves ver_coves= new Ver_Coves();
       ver_coves.ver_coves(text_rut.getText(), user,Integer.parseInt(text_control.getText()));
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table_actividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_actividadMouseClicked
         Ver_Actividad ver_suceso=new Ver_Actividad();
         //verifica si se hizo deoble click
         if (evt.getClickCount() == 2) {
            String nro_suceso=String.valueOf(table_actividad.getValueAt(table_actividad.getSelectedRow(),0));
            
            ver_suceso.ver_actividad(nro_suceso,text_rut.getText(), user,Integer.parseInt(text_control.getText()));
            
            this.setVisible(false);
        
        
        
        
        
         }
    }//GEN-LAST:event_table_actividadMouseClicked
/**
 * 
 * @param rut_coves
 * @param user
 * @param control 
 */
   
    public void listar_sucesos(String rut_coves, int user, int control) {
        this.rut_coves=rut_coves;
        this.user=user;
        this.control=control;
        
   


        java.awt.EventQueue.invokeLater(() -> {
            new Listar_Actividad().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_ingres_suce;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table_actividad;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField text_orga;
    private javax.swing.JTextField text_rut;
    // End of variables declaration//GEN-END:variables

}
