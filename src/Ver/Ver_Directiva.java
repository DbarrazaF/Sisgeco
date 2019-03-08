/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ver;

import Control.TCoves;
import Control.TDirectiva;
import Ingresar.Ingresar_Directiva;
import Ingresar.Ingresar_Dirigente;
import Listar.Listar_Coves;
import Modificar.Modificar_Directiva;
import Negocio.Control_Directiva;
import Registros.archivoLog;
import static Ver.Ver_Coves.rut_buscar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Barraza
 */
public class Ver_Directiva extends javax.swing.JFrame {
    
    static String rut_coves="";
    static int user=0;
    static int control=0;
    TDirectiva tdirectiva;
    private Font fuenteBold =new Font(Font.FontFamily.COURIER,24,Font.BOLD);
    private Font fuentehora =new Font(Font.FontFamily.COURIER,6,Font.BOLD);
    archivoLog archi=new archivoLog();
    
    Ingresar_Dirigente ingresar_dirigente;
    public Ver_Directiva() {
        initComponents();
        this.setLocationRelativeTo(null);
        tdirectiva=new TDirectiva();
        ingresar_dirigente=new Ingresar_Dirigente();
        //asigna valores
        textrut_coves.setText(rut_coves);
        text_control.setText(Integer.toString(control));
         Listar_Directiva();
         Mostrar_Datos_Coves();
        if(user==8){//valida usuario
            boton_retirar_diri.setVisible(false);
            boton_modi_diri.setVisible(false);
            boton_asignar_diri.setVisible(false);
        }
    }
    //muestra infomacion de coves
     private void Mostrar_Datos_Coves() {
         TCoves tcoves=new TCoves();
        String[] vector = new String[1];
        vector = tcoves.buscarCoves(textrut_coves.getText());
        
        textnom_coves.setText(vector[1]);
        
        
        
    }
     //Muestra la lista de la directiva
   private void Listar_Directiva(){
        DefaultTableModel modelo= (DefaultTableModel) table_directiva.getModel();
        modelo.addColumn("Rut ");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Cargo");
        modelo.addColumn("Telefono");
        for(Control_Directiva directiva : tdirectiva.listarDirectivaDirigente(rut_buscar)){
          Object rowData[]={directiva.getRut_dirigente(), directiva.getNombre_dirigente(),directiva.getApellido_paterno(),directiva.getCargo(),directiva.getTelefono()};
          ((DefaultTableModel)table_directiva.getModel()).addRow(rowData);
         };
   }
   // se crean Paragraph para el pdf
    private Paragraph getHeader(String titulo){
        Paragraph paragraph=new Paragraph();
        Chunk chunk=new Chunk();
        paragraph.setAlignment(Element.ALIGN_CENTER);
        chunk.append(titulo);
        chunk.setFont(fuenteBold);
        paragraph.add(chunk);
        
        return paragraph;
    }
     private Paragraph getHorita(String hora){
        Paragraph paragraph=new Paragraph();
        Chunk chunk=new Chunk();
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        chunk.append(hora);
        chunk.setFont(fuentehora);
        paragraph.add(chunk);
        
        return paragraph;
    }
   
     
    
    
    
    //Genera el pdf con la tabla 
    private void GenerarPdf(String titulo,String rut, String hora){  
        try{
        //se cuentan las cantidad de filas de la tabla
        int count=table_directiva.getRowCount();
        //se asigan el tipo de hoja y los margenes al documento pdf
        Document document=new Document(PageSize.LETTER,45,36,30,30);
        // se crea la ruta, si no existe crea la ruta completa
        File backup = new File("c:/archivos_pdfs");
        backup.mkdirs();
        
   
          //preparamos el backupfile con la ruta
          PdfWriter.getInstance(document,new FileOutputStream("c:/archivos_pdfs/Lista_Directiva.pdf"));
          Paragraph saltolinea = new Paragraph();
          
          saltolinea.add("\n");//se agrega el salto de linea
          //se crea un nuevo archivo pdf en la direccion selecionada
          File archivo= new File("c:/archivos_pdfs/Lista_Directiva.pdf");
          document.open();//se abre el documento
          // se crea la instancia de la imagen
          Image imagen= Image.getInstance("lib/Imagen/imagen.jpg");
          imagen.scaleAbsolute(50, 50);//se asigna un tamaño a la imagen
          imagen.setAlignment(Element.ALIGN_LEFT);//se alinea la imagen
          document.add(imagen);//se agrega al documento pdf
          document.add(saltolinea);//se agrega un salto de linea
          document.add(getHeader(titulo));//se agrega un titulo al documento pdf
          document.add(saltolinea);//se agrega un salto de linea
          document.add(getHeader(rut));//se agrega un titulo al documento pdf
          document.add(saltolinea);//se agrega un salto de linea
          
          //crea tabla dentro del pdf
          PdfPTable tab=new PdfPTable(5);
         
          tab.setWidthPercentage(100f);//se asigna el porcentaje de la tabla
          tab.setHorizontalAlignment(Element.ALIGN_LEFT);//se alinea
          tab.getDefaultCell().setBorderWidth(0.8f);//Se da un borde a las celdas
            
         //se agregan los titulos de las columnas
        PdfPCell columna1 =new PdfPCell (new Paragraph("Rut",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna1.setColspan(1);//union de celdas
        columna1.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna1.setPadding (5.0f);   // añadimos un espaciado
        columna1.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna1); //se añade a la tabla
          
        PdfPCell columna2 =new PdfPCell (new Paragraph("Nombre",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna2.setColspan(1);//union de celdas
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna2.setPadding (5.0f);   // añadimos un espaciado
        columna2.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna2); //se añade a la tabla
        
        
        PdfPCell columna3 =new PdfPCell (new Paragraph("Apellido Paterno",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna3.setColspan(1);//union de celdas
        columna3.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna3.setPadding (5.0f);   // añadimos un espaciado
        columna3.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna3); //se añade a la tabla
          
        PdfPCell columna4 =new PdfPCell (new Paragraph("Cargo",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna4.setColspan(1);//union de celdas
        columna4.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna4.setPadding (5.0f);   // añadimos un espaciado
        columna4.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna4); //se añade a la tabla 
        
        PdfPCell columna5 =new PdfPCell (new Paragraph("Telefono",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna5.setColspan(1);//union de celdas
        columna5.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna5.setPadding (5.0f);   // añadimos un espaciado
        columna5.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna5); //se añade a la tabla
        
    //se genera la tabla      
   for(int i=0;i<count;i++){
   Object obj1 = GetData(table_directiva, i, 0);
   Object obj2 = GetData(table_directiva, i, 1);
   Object obj3 = GetData(table_directiva, i, 2);
   Object obj4 = GetData(table_directiva, i, 3);
   Object obj5 = GetData(table_directiva, i, 4);

   String value1=obj1.toString();
   String value2=obj2.toString();
   String value3=obj3.toString();
   String value4=obj4.toString();
   String value5=obj5.toString();

   // se da estilo a las letras de cada celda del documento pdf
   tab.addCell(new Phrase(value1, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value2, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value3, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value4, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value5, FontFactory.getFont(FontFactory.HELVETICA, 10)));

            
   }
   document.add(tab);//se agrega la tabla
   document.addTitle("Directiva del Coves");//se agrega un titulo al documento pdf
   
   document.add(getHorita(hora));//se agrega la fecha de emision
  
   document.close();//se cierra el documento generado 
   Desktop.getDesktop().open(archivo);//se abre el documento generado
   Desktop.getDesktop().print(archivo);//imprime el documento generado
   
   //Para mas infomacion sobre itext visitar http://itextpdf.com/
       }
        //se trabajan las excepciones
       catch(DocumentException | IOException e){
           System.out.println("Falla al crear pdf Directiva "+e.getMessage());
            try {
                archi.crearLog("Falla al crear pdf Directiva "+e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Listar_Coves.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       
       }
       
  
    }
    //carga los index de la tabla y retorna un objeto
    public Object GetData(JTable table, int row_index, int col_index){
        return table.getModel().getValueAt(row_index, col_index);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textnom_coves = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textrut_coves = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_directiva = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        boton_asignar_diri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boton_modi_diri = new javax.swing.JButton();
        boton_retirar_diri = new javax.swing.JButton();
        text_control = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Directiva");
        setResizable(false);

        textnom_coves.setEditable(false);

        jLabel3.setText("Rut COVES:");

        textrut_coves.setEditable(false);

        table_directiva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_directiva.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_directiva.getTableHeader().setResizingAllowed(false);
        table_directiva.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_directiva);

        jButton1.setText("Ver Dirigente Selecionado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        boton_asignar_diri.setText("Asignar Dirigente");
        boton_asignar_diri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_asignar_diriActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Informacion de Directiva");

        jLabel2.setText("Nombre COVES:");

        boton_modi_diri.setText("Modificar Cargo Dirigente");
        boton_modi_diri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modi_diriActionPerformed(evt);
            }
        });

        boton_retirar_diri.setText("Retirar  Dirigente");
        boton_retirar_diri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_retirar_diriActionPerformed(evt);
            }
        });

        text_control.setEditable(false);
        text_control.setEnabled(false);

        jButton2.setText("Imprimir Directiva");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boton_retirar_diri)
                                .addGap(18, 18, 18)
                                .addComponent(boton_modi_diri)
                                .addGap(18, 18, 18)
                                .addComponent(boton_asignar_diri)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textnom_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textrut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(text_control, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textnom_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(textrut_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(boton_asignar_diri)
                    .addComponent(boton_modi_diri)
                    .addComponent(boton_retirar_diri))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_asignar_diriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_asignar_diriActionPerformed
      
       if(Ingresar_Directiva.ventana_ingresar_directiva==false){//valida que ventana no se encuentre abierta
       Ingresar_Directiva ingresar_directiva=new Ingresar_Directiva();
       ingresar_directiva.ingresar_directiva(textrut_coves.getText(),Integer.parseInt(text_control.getText()));
       Ingresar_Directiva.ventana_ingresar_directiva=true;//cambia valor de la varieble en la siguente ventana
       this.setVisible(false);
    }
    else{
            JOptionPane.showMessageDialog(null,"VENTANA INGRESAR DIRECTIVA SE ENCUENTRA ABIERTA",
                "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    
            
       
    }//GEN-LAST:event_boton_asignar_diriActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Ver_Coves ver_coves =new Ver_Coves();
        ver_coves.ver_coves(textrut_coves.getText(), user,Integer.parseInt(text_control.getText()));
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
 

   
    
    private void boton_modi_diriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modi_diriActionPerformed
        if(table_directiva.getSelectedRow()>=0) {//verifica que se selecciono una fila
         if(Modificar_Directiva.ventana_modificar_directiva==false){//valida que ventana no se encuentre abierta
         Modificar_Directiva modificar_directiva=new Modificar_Directiva();
         String rut_dirigente=String.valueOf(table_directiva.getValueAt(table_directiva.getSelectedRow(),0));
         String cargo_dirigente=String.valueOf(table_directiva.getValueAt(table_directiva.getSelectedRow(),3));
         
         modificar_directiva.modificar_directiva(rut_dirigente, textrut_coves.getText(),cargo_dirigente,Integer.parseInt(text_control.getText()));
        Modificar_Directiva.ventana_modificar_directiva=true;//cambia valor de la varieble en la siguente ventana
         this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null,"VENTANA MODIFICAR DIRECTIVA YA SE ENCUENTRA ABIERTA",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
            }
        } 
         else {
         JOptionPane.showMessageDialog(null,"PORFAVOR SELECCIONE UN DIRIGENTE",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
         
    }//GEN-LAST:event_boton_modi_diriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ver_Dirigente ver_dirigente=new Ver_Dirigente();
        
        if(table_directiva.getSelectedRow()>=0) {//verifica que se selecciono una fila
            String rut_dirigente=String.valueOf(table_directiva.getValueAt(table_directiva.getSelectedRow(),0));
            
            
            ver_dirigente.ver_dirigente(rut_dirigente,textrut_coves.getText(),Integer.parseInt(text_control.getText()),user);
            this.setVisible(false);
            
            
        }
        else {
         JOptionPane.showMessageDialog(null,"PORFAVOR SELECCIONE UN DIRIGENTE",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_retirar_diriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_retirar_diriActionPerformed
         if(table_directiva.getSelectedRow()>=0) {//verifica que se selecciono una fila
              String rut_dirigente=String.valueOf(table_directiva.getValueAt(table_directiva.getSelectedRow(),0));
              int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea Retirar a '"+rut_dirigente+"' de la Directiva?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if (resp == 0) {
                      boolean elim=false;
                      
                       elim=tdirectiva.Retirar_dirigente(textrut_coves.getText(),rut_dirigente);
                      
                        if (elim){
                        JOptionPane.showMessageDialog(null,"Dirigente RETIRADO",
                        "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
                        Ver_Directiva ver_directiva=new Ver_Directiva();
                        ver_directiva.ver_directiva(textrut_coves.getText(), user, Integer.parseInt(text_control.getText()));
                        dispose();
                        
                        }else     JOptionPane.showMessageDialog(null,"ERROR AL RETIRAR DIRIGENTE",
                            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);  
        }
                
         }else {
         JOptionPane.showMessageDialog(null,"PORFAVOR SELECCIONE UN DIRIGENTE",
            "AVISO DE SISTEMA", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_boton_retirar_diriActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Se agregan los textos que desea agregar al archivo pdf
        String titulo="Directiva del Coves: "+textnom_coves.getText();
        String rut="Rut: "+textrut_coves.getText();
        //Se carga la hora del sistema
        Calendar calendario = Calendar.getInstance();
          int   dia=calendario.get(Calendar.DAY_OF_MONTH);
          int   mes=calendario.get(Calendar.MONTH)+1;
          int   ano=calendario.get(Calendar.YEAR);      
          int  hora =calendario.get(Calendar.HOUR_OF_DAY);
          int  minutos = calendario.get(Calendar.MINUTE);
          int  segundos = calendario.get(Calendar.SECOND);
          
      String horat="Fecha de emision:"+dia+"-"+mes+"-"+ano+" "+hora + ":" + minutos + ":" + segundos;
      //Se carga el metodo y se envian los datos
      GenerarPdf(titulo,rut,horat);
    }//GEN-LAST:event_jButton2ActionPerformed



/**
 * 
 * @param rut_coves
 * @param user
 * @param control 
 */
    public void ver_directiva(String rut_coves, int user, int control ) {
        this.rut_coves=rut_coves;
        this.user=user;
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
            java.util.logging.Logger.getLogger(Ver_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ver_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ver_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ver_Directiva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ver_Directiva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_asignar_diri;
    private javax.swing.JButton boton_modi_diri;
    private javax.swing.JButton boton_retirar_diri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_directiva;
    private javax.swing.JTextField text_control;
    private javax.swing.JTextField textnom_coves;
    private javax.swing.JTextField textrut_coves;
    // End of variables declaration//GEN-END:variables
}
