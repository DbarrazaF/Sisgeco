/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ver;

import Buscar.Buscar_Proyecto;
import Control.TCoves;
import Control.TDecreto;
import Control.TProyecto;
import Control.TTipo_Proyecto;
import Ingresar.Ingresar_Decreto;
import Listar.Listar_Proyecto;
import Modificar.Modificar_Decreto;
import Modificar.Modificar_Proyecto;
import Negocio.Decreto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */




public class Ver_Proyecto extends javax.swing.JFrame {
     TProyecto tproyecto;
     TDecreto tdecreto;
     TCoves tcoves;
     TTipo_Proyecto ttipo_proyecto;
      static String ano_postula_pro="";
      static String nro_incripcion="";
      static String rut_coves="";
      static int control=0;
      static int user=0;
      
      
      
      
    
     public Ver_Proyecto() {
        
        
         initComponents();
         this.setLocationRelativeTo(null);
         tcoves=new TCoves();
        tdecreto=new TDecreto();
        tproyecto=new TProyecto();
        ttipo_proyecto=new TTipo_Proyecto();
        //asigna valor
        text_ano_postula.setText(ano_postula_pro);
        text_nro_ingreso.setText(nro_incripcion);
        text_control.setText(Integer.toString(control));
        text_rut_coves.setText(rut_coves);
        if(user==8){//verifica usuario
            boton_modi_proye.setVisible(false);
            boton_modi_decre.setVisible(false);
            boton_agre_decre.setVisible(false);
        }
  
        Mostrar_Proyecto();
        Listar_Descreto();
        Mostrar_Datos_Tipo_proye();
        Mostrar_Datos_Coves();
        
    
       
    }
 private void Mostrar_Datos_Tipo_proye(){
    //muestra informacion del tipo proyecto
        String[] vectortipopro=new String[4];
        vectortipopro=ttipo_proyecto.buscarTipo_Proyecto(text_nro_tipo_proy.getText());
        text_nom_tipo_proye.setText(vectortipopro[1]);
}
 private void Mostrar_Datos_Coves(){     
   // muestra informacion de coves
        String[] vectorcove=new String[4];
        vectorcove=tcoves.buscarCoves(text_rut_coves.getText());
        text_orga.setText(vectorcove[1]);
 }
     
    
  private void Mostrar_Proyecto(){
    //muestra informacion de proyecto
        String[] vectorpro=new String[18];
        vectorpro=tproyecto.buscarProyecto(text_ano_postula.getText(),text_nro_ingreso.getText());
        area_objetivo.setText(vectorpro[2]);
        text_nro_partici.setText(vectorpro[3]);
        text_fecha_ingre.setText(vectorpro[4]);
        text_duraci.setText(vectorpro[5]);
        text_calle_refe.setText(vectorpro[6]);
        text_aport_otra_orga.setText(vectorpro[7]);
        text_monto_solici.setText(vectorpro[8]);
        text_aport_muni.setText(vectorpro[9]);
        area_comenta.setText(vectorpro[10]);
        text_aport_organi.setText(vectorpro[11]);
        text_monto_apro.setText(vectorpro[12]);
        text_nro_matriz.setText(vectorpro[13]);
        text_nro_apro.setText(vectorpro[14]);
        text_ano_matriz.setText(vectorpro[15]);
        text_ano_decre.setText(vectorpro[16]);
        text_ano_aproba.setText(vectorpro[17]);
        text_nombre.setText(vectorpro[18]);
        text_nro_tipo_proy.setText(vectorpro[19]);
  }


private void Listar_Descreto(){     
 // listas los decretos de ese proyecto
        
        DefaultTableModel modelo= (DefaultTableModel) tabla_decreto.getModel();
        
        modelo.addColumn("Nro decreto");
        modelo.addColumn("Fecha de Decreto");
        modelo.addColumn("Fecha retiro cheque");
        modelo.addColumn("Quien retira Cheque");
        modelo.addColumn("Estado");
       
        for(Decreto decreto : tdecreto.listarDecreto(text_ano_postula.getText(),text_nro_ingreso.getText())){
            if(!"0001-01-01".equals(decreto.getFecha_retiro_cheque_decreto())){
                String fecha_decreto=decreto.getFecha_retiro_cheque_decreto();
                Object rowData[]={decreto.getNro_decreto(),decreto.getFecha_decreto(),fecha_decreto,
                    decreto.getRetira_cheque_decreto(),decreto.getEstado_decreto()};
                ((DefaultTableModel)tabla_decreto.getModel()).addRow(rowData);
            }
            else{
                String fecha_decreto="Cheque un no es retirado";
                Object rowData[]={decreto.getNro_decreto(),decreto.getFecha_decreto(),fecha_decreto,
                    decreto.getRetira_cheque_decreto(),decreto.getEstado_decreto()};
                ((DefaultTableModel)tabla_decreto.getModel()).addRow(rowData);
                
            }
           
           }
}



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        text_orga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        text_rut_coves = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        boton_modi_proye = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        text_nombre = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        area_objetivo = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        text_nro_partici = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        text_fecha_ingre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        text_duraci = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        text_nro_tipo_proy = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        text_ano_postula = new javax.swing.JTextField();
        text_nro_ingreso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        text_nom_tipo_proye = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        text_calle_refe = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        text_monto_solici = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        text_aport_muni = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        text_aport_organi = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        text_aport_otra_orga = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        text_ano_aproba = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        text_ano_decre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        text_ano_matriz = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_decreto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        text_nro_matriz = new javax.swing.JTextField();
        text_nro_apro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        text_monto_apro = new javax.swing.JTextField();
        boton_agre_decre = new javax.swing.JButton();
        boton_modi_decre = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_comenta = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        text_control = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Proyecto");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Ver informacion de Proyecto");

        text_orga.setEditable(false);

        jLabel1.setText("Organizacion:");

        jLabel3.setText("Rut:");

        text_rut_coves.setEditable(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        boton_modi_proye.setText("Modificar");
        boton_modi_proye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modi_proyeActionPerformed(evt);
            }
        });

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setText("Nombre:");

        text_nombre.setEditable(false);

        jLabel29.setText("Objetivo del proyecto:");

        area_objetivo.setEditable(false);
        area_objetivo.setColumns(20);
        area_objetivo.setRows(5);
        jScrollPane3.setViewportView(area_objetivo);

        jLabel32.setText("N° de Participantes:");

        text_nro_partici.setEditable(false);

        jLabel33.setText("Fecha de ingreso:");

        text_fecha_ingre.setEditable(false);

        jLabel12.setText("Tipo proyecto:");

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setText("Duracion de proyecto");

        text_duraci.setEditable(false);

        jLabel36.setText("Meses:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_duraci, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel34)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_duraci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        text_nro_tipo_proy.setEditable(false);

        jLabel4.setText("Año Postulacion:");

        text_ano_postula.setEditable(false);

        text_nro_ingreso.setEditable(false);

        jLabel5.setText("Numero Ingreso: ");

        text_nom_tipo_proye.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(text_nombre))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_nro_partici, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_fecha_ingre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_ano_postula, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_nro_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(text_nro_tipo_proy, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text_nom_tipo_proye, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(text_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(text_fecha_ingre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_nro_partici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(text_ano_postula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(text_nro_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(text_nro_tipo_proy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nom_tipo_proye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Antecedentes", jPanel3);

        jLabel20.setText("Calle de referencia:");

        text_calle_refe.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(text_calle_refe, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(text_calle_refe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ubicacion", jPanel4);

        jLabel39.setText("Monto solicitado:");

        text_monto_solici.setEditable(false);

        jLabel26.setText("Aporte municipal:");

        text_aport_muni.setEditable(false);

        jLabel27.setText("Aporte de la organizacion:");

        text_aport_organi.setEditable(false);

        jLabel40.setText("Aporte de otras organizaciones:");

        text_aport_otra_orga.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(78, 78, 78)
                        .addComponent(text_aport_organi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(50, 50, 50)
                        .addComponent(text_aport_otra_orga, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel39))
                        .addGap(121, 121, 121)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_monto_solici, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_aport_muni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(text_monto_solici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(text_aport_muni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_aport_organi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_aport_otra_orga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Financiamiento", jPanel5);

        text_ano_aproba.setEditable(false);

        jLabel9.setText("Año de Aprobacion:");

        jLabel10.setText("Año decreto:");

        text_ano_decre.setEditable(false);

        jLabel11.setText("Año matriz");

        text_ano_matriz.setEditable(false);

        tabla_decreto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_decreto.setAutoscrolls(false);
        tabla_decreto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla_decreto.getTableHeader().setResizingAllowed(false);
        tabla_decreto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla_decreto);

        text_nro_matriz.setEditable(false);

        text_nro_apro.setEditable(false);

        jLabel13.setText("Numero de Aprobacion:");

        jLabel15.setText("Numero de matriz:");

        jLabel16.setText("Monto aprobado:");

        text_monto_apro.setEditable(false);

        boton_agre_decre.setText("Agregar Decreto");
        boton_agre_decre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_agre_decreActionPerformed(evt);
            }
        });

        boton_modi_decre.setText("Modificar decreto seleccionado");
        boton_modi_decre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modi_decreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(boton_modi_decre)
                .addGap(103, 103, 103)
                .addComponent(boton_agre_decre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_ano_matriz, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(text_ano_aproba)
                    .addComponent(text_ano_decre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_monto_apro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(text_nro_matriz, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addComponent(text_nro_apro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(text_nro_apro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_ano_aproba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(text_ano_decre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(text_monto_apro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel15)
                        .addComponent(text_nro_matriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(text_ano_matriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_agre_decre)
                    .addComponent(boton_modi_decre))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tramitacion de Subvencion", jPanel6);

        area_comenta.setEditable(false);
        area_comenta.setColumns(20);
        area_comenta.setRows(5);
        jScrollPane1.setViewportView(area_comenta);

        jLabel6.setText("Ingrese comentario si es necesario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(0, 548, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
        );

        jTabbedPane1.addTab("Comentario", jPanel1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_modi_proye)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)))
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_modi_proye)
                .addGap(119, 119, 119)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
        );

        text_control.setEditable(false);
        text_control.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_orga, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_orga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text_rut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_modi_proyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modi_proyeActionPerformed
        Modificar_Proyecto  modificar_proyecto=new Modificar_Proyecto();
        if(Modificar_Proyecto.ventana_modificar_proyecto==false){//valida que ventana no se encuentre abierta
        modificar_proyecto.modificar_proyecto(text_ano_postula.getText(),text_nro_ingreso.getText(),Integer.parseInt(text_control.getText()));
        Modificar_Proyecto.ventana_modificar_proyecto=true;//cambia valor de la varieble en la siguente ventana
        this.setVisible(false);
        }
        else{
             JOptionPane.showMessageDialog(null,"VENTANA MODIFICAR PROYECTO SE ENCUENTRA ABIERTA",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_boton_modi_proyeActionPerformed

    private void boton_agre_decreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_agre_decreActionPerformed
       Ingresar_Decreto ingresar_decreto=new Ingresar_Decreto();
       ingresar_decreto.ingresar_decreto(text_nro_ingreso.getText(), text_ano_postula.getText(),Integer.parseInt(text_control.getText()),text_rut_coves.getText());
       this.setVisible(false);
    }//GEN-LAST:event_boton_agre_decreActionPerformed

    private void boton_modi_decreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modi_decreActionPerformed
        if(tabla_decreto.getSelectedRow()>=0) {//verifica que se selecciono una fila
         if(Modificar_Decreto.ventana_modificar_decreto==false){//valida que ventana no se encuentre abierta
         Modificar_Decreto modificar_decreto=new Modificar_Decreto();
         String nro_decreto=String.valueOf(tabla_decreto.getValueAt(tabla_decreto.getSelectedRow(),0));
         String fecha_retiro=String.valueOf(tabla_decreto.getValueAt(tabla_decreto.getSelectedRow(),2));
         String rut_retira=String.valueOf(tabla_decreto.getValueAt(tabla_decreto.getSelectedRow(),3));
         modificar_decreto.modificar_decreto(text_ano_postula.getText(), text_nro_ingreso.getText(), nro_decreto,fecha_retiro,rut_retira,text_rut_coves.getText(),Integer.parseInt(text_control.getText()));
         Modificar_Decreto.ventana_modificar_decreto=true;//cambia valor de la varieble en la siguente ventana
         this.setVisible(false);
            }
            else{
                 JOptionPane.showMessageDialog(null,"VENTANA MODIFICAR DECRETO SE ENCUENTRA ABIERTA",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"PORFAVOR SELECCIONE UN DECRETO",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
        
        
        
        
        
    }//GEN-LAST:event_boton_modi_decreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //verifica el camino
        if(Integer.parseInt(text_control.getText())==5){
           new Buscar_Proyecto().setVisible(true);
        dispose();
       }
       if(Integer.parseInt(text_control.getText())==4){
           new Listar_Proyecto().setVisible(true);
        dispose();
       }
       if(Integer.parseInt(text_control.getText())==1 || Integer.parseInt(text_control.getText())==2 || Integer.parseInt(text_control.getText())==3){
           Ver_Coves ver_coves=new Ver_Coves();
           ver_coves.ver_coves(text_rut_coves.getText(), user, Integer.parseInt(text_control.getText()));
        dispose();
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * 
     * @param ano_postula_pro
     * @param nro_incripcion
     * @param user
     * @param control
     * @param rut_coves 
     */
    public void ver_proyecto(String ano_postula_pro, String nro_incripcion,int user,int control,String rut_coves) {
        this.ano_postula_pro=ano_postula_pro;
        this.nro_incripcion=nro_incripcion;
        this.user=user;
        this.control=control;
        this.rut_coves=rut_coves;
        
                
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
            java.util.logging.Logger.getLogger(Ver_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_comenta;
    private javax.swing.JTextArea area_objetivo;
    private javax.swing.JButton boton_agre_decre;
    private javax.swing.JButton boton_modi_decre;
    private javax.swing.JButton boton_modi_proye;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla_decreto;
    private javax.swing.JTextField text_ano_aproba;
    private javax.swing.JTextField text_ano_decre;
    private javax.swing.JTextField text_ano_matriz;
    private javax.swing.JTextField text_ano_postula;
    private javax.swing.JTextField text_aport_muni;
    private javax.swing.JTextField text_aport_organi;
    private javax.swing.JTextField text_aport_otra_orga;
    private javax.swing.JTextField text_calle_refe;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField text_duraci;
    private javax.swing.JTextField text_fecha_ingre;
    private javax.swing.JTextField text_monto_apro;
    private javax.swing.JTextField text_monto_solici;
    private javax.swing.JTextField text_nom_tipo_proye;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JTextField text_nro_apro;
    private javax.swing.JTextField text_nro_ingreso;
    private javax.swing.JTextField text_nro_matriz;
    private javax.swing.JTextField text_nro_partici;
    private javax.swing.JTextField text_nro_tipo_proy;
    private javax.swing.JTextField text_orga;
    private javax.swing.JTextField text_rut_coves;
    // End of variables declaration//GEN-END:variables
}
