/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion_Principal;

import Registros.Respaldo_DB;
import Buscar.*;
import Ingresar.*;
import Listar.*;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Gestion_Principal extends javax.swing.JFrame {
    
    static int user = 0;
    public Gestion_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        if (user == 8)//usuario comun limitado solo a consultas
        {
            menu_ingre_coves.setVisible(false);
            menu_ingre_proye.setVisible(false);
            menuadministrar.setVisible(false);
            jMenu8.setText("Consultar COVES");
            Menu_Proyecto.setText("Consultar Proyecto");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        Panel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        COVES = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        Menu_Coves1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menu_ingre_coves = new javax.swing.JMenuItem();
        Proyecto = new javax.swing.JMenu();
        Menu_Proyecto = new javax.swing.JMenu();
        Menu_Proyecto1 = new javax.swing.JMenuItem();
        menu_ingre_proye = new javax.swing.JMenuItem();
        Consultas = new javax.swing.JMenu();
        Consulta1 = new javax.swing.JMenuItem();
        Consulta2 = new javax.swing.JMenuItem();
        menuadministrar = new javax.swing.JMenu();
        Menu_sector = new javax.swing.JMenu();
        Menu_sector1 = new javax.swing.JMenuItem();
        Menu_sector3 = new javax.swing.JMenuItem();
        Menu_unidad_vecinal = new javax.swing.JMenu();
        Menu_unidad_vecinal1 = new javax.swing.JMenuItem();
        Menu_unidad_vecinal3 = new javax.swing.JMenuItem();
        Menu_funcionarios = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Menu_tipo_suceso = new javax.swing.JMenu();
        Menu_tipo_suceso1 = new javax.swing.JMenuItem();
        Menu_tipo_suceso2 = new javax.swing.JMenuItem();
        Menu_tipo_proyecto1 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        Menu_tipo_proyecto2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Acerca = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sisgeco Gestion Principal");

        Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 655, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        COVES.setText("COVES");

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        jMenu8.setText("Gestionar COVES");

        Menu_Coves1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/search.png"))); // NOI18N
        Menu_Coves1.setText("Buscar COVES por Rut");
        Menu_Coves1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Coves1ActionPerformed(evt);
            }
        });
        jMenu8.add(Menu_Coves1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/search.png"))); // NOI18N
        jMenuItem4.setText("Buscar Coves por Nombre");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem4);

        menu_ingre_coves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        menu_ingre_coves.setText("Ingresar nuevo COVES");
        menu_ingre_coves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ingre_covesActionPerformed(evt);
            }
        });
        jMenu8.add(menu_ingre_coves);

        COVES.add(jMenu8);

        jMenuBar1.add(COVES);

        Proyecto.setText("Proyecto");

        Menu_Proyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        Menu_Proyecto.setText("Gestionar Proyecto");

        Menu_Proyecto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/search.png"))); // NOI18N
        Menu_Proyecto1.setText("Buscar Proyecto");
        Menu_Proyecto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Proyecto1ActionPerformed(evt);
            }
        });
        Menu_Proyecto.add(Menu_Proyecto1);

        menu_ingre_proye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        menu_ingre_proye.setText("Ingresar nuevo proyecto");
        menu_ingre_proye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_ingre_proyeActionPerformed(evt);
            }
        });
        Menu_Proyecto.add(menu_ingre_proye);

        Proyecto.add(Menu_Proyecto);

        jMenuBar1.add(Proyecto);

        Consultas.setText("Consultas");

        Consulta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        Consulta1.setText("Listar Coves");
        Consulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consulta1ActionPerformed(evt);
            }
        });
        Consultas.add(Consulta1);

        Consulta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        Consulta2.setText("Listar Proyectos");
        Consulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Consulta2ActionPerformed(evt);
            }
        });
        Consultas.add(Consulta2);

        jMenuBar1.add(Consultas);

        menuadministrar.setText("Administrar");

        Menu_sector.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        Menu_sector.setText("Gestionar Sector");

        Menu_sector1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        Menu_sector1.setText("Listar Sectores");
        Menu_sector1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_sector1ActionPerformed(evt);
            }
        });
        Menu_sector.add(Menu_sector1);

        Menu_sector3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        Menu_sector3.setText("Ingresar Nuevo sector");
        Menu_sector3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_sector3ActionPerformed(evt);
            }
        });
        Menu_sector.add(Menu_sector3);

        menuadministrar.add(Menu_sector);

        Menu_unidad_vecinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        Menu_unidad_vecinal.setText("Gestionar Unidad Vecinal");

        Menu_unidad_vecinal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        Menu_unidad_vecinal1.setText("Listar Unidades vecinales");
        Menu_unidad_vecinal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_unidad_vecinal1ActionPerformed(evt);
            }
        });
        Menu_unidad_vecinal.add(Menu_unidad_vecinal1);

        Menu_unidad_vecinal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        Menu_unidad_vecinal3.setText("Ingresar Nueva Unidad vecinal");
        Menu_unidad_vecinal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_unidad_vecinal3ActionPerformed(evt);
            }
        });
        Menu_unidad_vecinal.add(Menu_unidad_vecinal3);

        menuadministrar.add(Menu_unidad_vecinal);

        Menu_funcionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        Menu_funcionarios.setText("Gestionar Funcionarios");

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        jMenuItem18.setText("Listar Funcionarios");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        Menu_funcionarios.add(jMenuItem18);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        jMenuItem5.setText("Ingresar Nuevo Funcionario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Menu_funcionarios.add(jMenuItem5);

        menuadministrar.add(Menu_funcionarios);

        Menu_tipo_suceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        Menu_tipo_suceso.setText("Gestionar Tipo Actividad");

        Menu_tipo_suceso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        Menu_tipo_suceso1.setText("Listar Tipo Actividad");
        Menu_tipo_suceso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_tipo_suceso1ActionPerformed(evt);
            }
        });
        Menu_tipo_suceso.add(Menu_tipo_suceso1);

        Menu_tipo_suceso2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        Menu_tipo_suceso2.setText("Ingresar Nuevo Tipo Actividad");
        Menu_tipo_suceso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_tipo_suceso2ActionPerformed(evt);
            }
        });
        Menu_tipo_suceso.add(Menu_tipo_suceso2);

        menuadministrar.add(Menu_tipo_suceso);

        Menu_tipo_proyecto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        Menu_tipo_proyecto1.setText("Gestionar Tipo Proyecto");

        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        jMenuItem22.setText("Listar Tipo Proyecto");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        Menu_tipo_proyecto1.add(jMenuItem22);

        Menu_tipo_proyecto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        Menu_tipo_proyecto2.setText("Ingresar Nuevo Tipo Proyecto");
        Menu_tipo_proyecto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_tipo_proyecto2ActionPerformed(evt);
            }
        });
        Menu_tipo_proyecto1.add(Menu_tipo_proyecto2);

        menuadministrar.add(Menu_tipo_proyecto1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/arrows.png"))); // NOI18N
        jMenu2.setText("Gestionar Dirigente");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/list.png"))); // NOI18N
        jMenuItem2.setText("Listar Dirigentes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/insert.png"))); // NOI18N
        jMenuItem3.setText("Ingresar nuevo Dirigente");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        menuadministrar.add(jMenu2);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/save.png"))); // NOI18N
        jMenuItem6.setText("Respaldar Base de Datos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuadministrar.add(jMenuItem6);

        jMenuBar1.add(menuadministrar);

        Acerca.setText("Acerca de..");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/info.png"))); // NOI18N
        jMenuItem1.setText("Informacion del Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Acerca.add(jMenuItem1);

        jMenuBar1.add(Acerca);

        Salir.setText("Salir");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/card.png"))); // NOI18N
        jMenuItem9.setText("Salir sistema");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Salir.add(jMenuItem9);

        jMenuBar1.add(Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Consulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consulta1ActionPerformed
            
       
            Listar_Coves listar_coves = new Listar_Coves();
            
            
            listar_coves.listar_coves(user);
        


    }//GEN-LAST:event_Consulta1ActionPerformed

    private void Menu_unidad_vecinal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_unidad_vecinal3ActionPerformed
        //Verificamos si la ventana se encuentra abierta
        if(Ingresar_Unidad_Vecinal.ventana_ingresar_unidad_vecinal==false){
            Ingresar_Unidad_Vecinal ingresar_unidad_vecinal = new Ingresar_Unidad_Vecinal();
            ingresar_unidad_vecinal.ingresar_unidad_Vecinal();
            Ingresar_Unidad_Vecinal.ventana_ingresar_unidad_vecinal= true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR UNIDAD VECINAL SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_Menu_unidad_vecinal3ActionPerformed

    private void menu_ingre_proyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ingre_proyeActionPerformed

       
            Ingresar_Nuevo_Proyecto ingresar_nuevo_proyecto = new Ingresar_Nuevo_Proyecto();
            ingresar_nuevo_proyecto.ingresar_nuevo_proyecto();
           
        


    }//GEN-LAST:event_menu_ingre_proyeActionPerformed

    private void Menu_Coves1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Coves1ActionPerformed

        
            Buscar_Coves buscar_coves = new Buscar_Coves();
            
            buscar_coves.buscar_coves(user);
              
    }//GEN-LAST:event_Menu_Coves1ActionPerformed

    private void Menu_Proyecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Proyecto1ActionPerformed

       
            Buscar_Proyecto buscar_proyecto = new Buscar_Proyecto();
            buscar_proyecto.buscar_proyecto(user);
            

    }//GEN-LAST:event_Menu_Proyecto1ActionPerformed

    private void menu_ingre_covesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_ingre_covesActionPerformed
        //Verificamos si la ventana se encuentra abierta
        if(Ingresar_Coves.ventana_ingresar_coves==false){
            Ingresar_Coves ingresar_coves = new Ingresar_Coves();
            ingresar_coves.ingresar_Coves();
            Ingresar_Coves.ventana_ingresar_coves = true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR COVES SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_menu_ingre_covesActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir del sistema?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (resp == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void Menu_sector3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_sector3ActionPerformed
            //Verificamos si la ventana se encuentra abierta
            if(Ingresar_Sector.ventana_ingresar_sector==false){
            Ingresar_Sector ingresar_sector = new Ingresar_Sector();
            ingresar_sector.ingresar_Sector();
            Ingresar_Sector.ventana_ingresar_sector = true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR SECTOR SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }


    }//GEN-LAST:event_Menu_sector3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
            //Verificamos si la ventana se encuentra abierta
            if(Ingresar_Funcionario.ventana_ingresar_funcionario==false){
            Ingresar_Funcionario ingresar_funcionario = new Ingresar_Funcionario();
            ingresar_funcionario.ingresar_Funcionario();
            Ingresar_Funcionario.ventana_ingresar_funcionario = true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR FUNCIONARIO SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void Menu_tipo_suceso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_tipo_suceso2ActionPerformed
        //Verificamos si la ventana se encuentra abierta
        if(Ingresar_Tipo_Actividad.ventana_ingresar_tipo_suceso==false){
            Ingresar_Tipo_Actividad ingresar_tipo_suceso = new Ingresar_Tipo_Actividad();
            ingresar_tipo_suceso.ingresar_tipo_Suceso();
            Ingresar_Tipo_Actividad.ventana_ingresar_tipo_suceso = true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR TIPO SUCESO SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_Menu_tipo_suceso2ActionPerformed

    private void Menu_tipo_proyecto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_tipo_proyecto2ActionPerformed
            //Verificamos si la ventana se encuentra abierta
            if(Ingresar_Tipo_Proyecto.ventana_ingresar_tipo_proyecto==false){
            Ingresar_Tipo_Proyecto ingresar_tipo_proyecto = new Ingresar_Tipo_Proyecto();
            ingresar_tipo_proyecto.ingresar_tipo_Proyecto();
            Ingresar_Tipo_Proyecto.ventana_ingresar_tipo_proyecto = true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR TIPO PROYECTO SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }


    }//GEN-LAST:event_Menu_tipo_proyecto2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      
            //Verificamos si la ventana se encuentra abierta
            if(Ingresar_Dirigente.ventana_ingresar_dirigente==false){
            Ingresar_Dirigente ingresar_dirigente = new Ingresar_Dirigente();
            ingresar_dirigente.ingresar_dirigente();
            Ingresar_Dirigente.ventana_ingresar_dirigente = true;//cambiamos el Valor de la variable de la siguiente ventana
        } else {
            JOptionPane.showMessageDialog(null, "VENTANA INGRESAR DIRIGENTE SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void Consulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Consulta2ActionPerformed

        
            Listar_Proyecto listar_proyecto = new Listar_Proyecto();
            listar_proyecto.listar_proyecto(user);
       


    }//GEN-LAST:event_Consulta2ActionPerformed

    private void Menu_sector1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_sector1ActionPerformed

        
            Listar_Sector listar_sector = new Listar_Sector();
            listar_sector.listar_sector();
            
//       

    }//GEN-LAST:event_Menu_sector1ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed

        
            Listar_Funcionario listar_funcionario = new Listar_Funcionario();
            listar_funcionario.listar_funcionario();
            

    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed

       
            Listar_Tipo_Proyecto listar_tipo_proyecto = new Listar_Tipo_Proyecto();
            listar_tipo_proyecto.listar_tipo_proyecto();

    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void Menu_tipo_suceso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_tipo_suceso1ActionPerformed

       
            Listar_Tipo_Actividad listar_tipo_suceso = new Listar_Tipo_Actividad();
            listar_tipo_suceso.listar_tipo_suceso();
           
    }//GEN-LAST:event_Menu_tipo_suceso1ActionPerformed

    private void Menu_unidad_vecinal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_unidad_vecinal1ActionPerformed

        
            Listar_Unidad_Vecinal unidad_vecinal = new Listar_Unidad_Vecinal();
            unidad_vecinal.listar_unidad_vecinal();
             
    }//GEN-LAST:event_Menu_unidad_vecinal1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        
            Listar_Dirigente listar_dirigente = new Listar_Dirigente();
            listar_dirigente.listar_dirigente();
            

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Buscar_Coves_Nombre buscar_coves_nombre=new Buscar_Coves_Nombre();
        buscar_coves_nombre.buscar_coves_nombre(user);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       new Acerca().acerca();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
       Respaldo_DB respaldo=new Respaldo_DB();
       //Verificamos si la ventana se encuentra abierta
       if(Respaldo_DB.ventana_respaldo==false){
           respaldo.respaldo_db();
           Respaldo_DB.ventana_respaldo=true;//cambiamos el Valor de la variable de la siguiente ventana
       }
       else{
           JOptionPane.showMessageDialog(null, "VENTANA RESPALDO DB SE ENCUENTRA ABIERTA",
                    "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
       }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param user
     */
    public void gestion_principal(int user) {
        this.user = user;
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
            java.util.logging.Logger.getLogger(Gestion_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Acerca;
    private javax.swing.JMenu COVES;
    private javax.swing.JMenuItem Consulta1;
    private javax.swing.JMenuItem Consulta2;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem Menu_Coves1;
    private javax.swing.JMenu Menu_Proyecto;
    private javax.swing.JMenuItem Menu_Proyecto1;
    private javax.swing.JMenu Menu_funcionarios;
    private javax.swing.JMenu Menu_sector;
    private javax.swing.JMenuItem Menu_sector1;
    private javax.swing.JMenuItem Menu_sector3;
    private javax.swing.JMenu Menu_tipo_proyecto1;
    private javax.swing.JMenuItem Menu_tipo_proyecto2;
    private javax.swing.JMenu Menu_tipo_suceso;
    private javax.swing.JMenuItem Menu_tipo_suceso1;
    private javax.swing.JMenuItem Menu_tipo_suceso2;
    private javax.swing.JMenu Menu_unidad_vecinal;
    private javax.swing.JMenuItem Menu_unidad_vecinal1;
    private javax.swing.JMenuItem Menu_unidad_vecinal3;
    public static javax.swing.JDesktopPane Panel;
    private javax.swing.JMenu Proyecto;
    private javax.swing.JMenu Salir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JMenuItem menu_ingre_coves;
    private javax.swing.JMenuItem menu_ingre_proye;
    private javax.swing.JMenu menuadministrar;
    // End of variables declaration//GEN-END:variables
}
