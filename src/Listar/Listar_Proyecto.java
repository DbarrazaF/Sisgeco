/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listar;

import Control.TProyecto;
import Validacion.Validar;
import Registros.archivoLog;
import Ver.Ver_Proyecto;
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
import javax.swing.JTable;
import javax.swing.ImageIcon;
/**
 *
 * @author Daniel Barraza
 */
public class Listar_Proyecto extends javax.swing.JFrame {

    TProyecto tproyecto;
    static int user=0;
    Validar validar=new Validar();
    //se crea tipos de letras
    private Font fuenteBold =new Font(Font.FontFamily.COURIER,26,Font.BOLD);
    private Font fuenteNormal =new Font(Font.FontFamily.COURIER,13,Font.BOLD);
    private Font fuentehora =new Font(Font.FontFamily.COURIER,6,Font.BOLD);
    
    archivoLog archi=new archivoLog();
    

    public Listar_Proyecto() {

        tproyecto = new TProyecto();
        initComponents();
        this.setLocationRelativeTo(null);
        FiltroProyectoAno("");//se muestra tabla con el filtro vacio
        //se asigna valor a jtextfield segun la cantidad de filas de la tabl
        text_total_proyectos.setText(String.valueOf(lista_proyecto.getRowCount()));
        //se validan los campos
        validar.validarSoloLetras(text_tipo_filtro);

         tamano_Tabla();

    }
    //se crean metodos para los filtros
    private void FiltroProyectoTipoProyecto(String tipo) {
        tproyecto.listarProyectoFiltroTipo(lista_proyecto, tipo);
    }
  
    private void FiltroProyectoAno(String ano){
         tproyecto.listarProyectoFiltroAno(lista_proyecto, ano);
        
    }
    private void FiltroProyectoAnoyTipo(String ano, String tipo){
    tproyecto.listarProyectoFiltroAnoyTipo(lista_proyecto, ano, tipo);
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
     private Paragraph getInfo(String cantidad){
        Paragraph paragraph=new Paragraph();
        Chunk chunk=new Chunk();
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        chunk.append(cantidad);
        chunk.setFont(fuenteNormal);
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
    private void GenerarPdf(String titulo, String cantidad, String hora){  
        try{
   //se cuentan las cantidad de filas de la tabla      
   int count=lista_proyecto.getRowCount();
   //se asigan el tipo de hoja y los margenes al documento pdf
   Document document=new Document(PageSize.LETTER,45,36,30,20);
   // se crea la ruta, si no existe crea la ruta completa
           File backup = new File("c:/archivos_pdfs");
           backup.mkdirs();
          //preparamos el backupfile con la ruta
          PdfWriter.getInstance(document,new FileOutputStream("c:/archivos_pdfs/Lista_Proyectos.pdf"));
          Paragraph saltolinea = new Paragraph();
          File archivo= new File("c:/archivos_pdfs/Lista_Proyectos.pdf");
          document.open();//se abre el documento
          saltolinea.add("\n");//se agrega el salto de linea
          // se crea la instancia de la imagen
          Image imagen= Image.getInstance("lib/Imagen/imagen.jpg");
          imagen.scaleAbsolute(50, 50);//se asigna un tamaño a la imagen
          imagen.setAlignment(Element.ALIGN_LEFT);//se alinea la imagen
          
          document.add(imagen);//se agrega al documento pdf
          document.add(getHeader(titulo));//se agrega un titulo al documento pdf
          document.add(saltolinea);//se agrega un salto de linea

         
          
          
          //crea tabla dentro del pdf
          PdfPTable tab=new PdfPTable(4);
          tab.setWidthPercentage(100f);//se asigna el porcentaje de la tabla
          tab.setWidths(new float[] {0.8f, 0.8f, 1.6f, 1.5f});//se asgina el ancho a las columnas
          tab.setHorizontalAlignment(Element.ALIGN_LEFT);//se alinea
          tab.getDefaultCell().setBorderWidth(0.8f);//Se da un borde a las celdas
          
         //se agregan los titulos de las columnas
        PdfPCell columna1 =new PdfPCell (new Paragraph("Año Postulacion",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna1.setColspan(1);//union de celdas
        columna1.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna1.setPadding (5.0f);   // añadimos un espaciado
        columna1.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna1); //se añade a la tabla
          
        PdfPCell columna2 =new PdfPCell (new Paragraph("Nro Ingreso",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna2.setColspan(1);//union de celdas
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna2.setPadding (5.0f);   // añadimos un espaciado
        columna2.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna2); //se añade a la tabla
        
        
        PdfPCell columna3 =new PdfPCell (new Paragraph("Tipo Proyecto",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna3.setColspan(1);//union de celdas
        columna3.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna3.setPadding (5.0f);   // añadimos un espaciado
        columna3.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna3); //se añade a la tabla
          
        PdfPCell columna4 =new PdfPCell (new Paragraph("Nombre COVES",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna4.setColspan(1);//union de celdas
        columna4.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna4.setPadding (5.0f);   // añadimos un espaciado
        columna4.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna4); //se añade a la tabla 
        
          
   //se genera la tabla      
   for(int i=0;i<count;i++){
   Object obj1 = GetData(lista_proyecto, i, 0);
   Object obj2 = GetData(lista_proyecto, i, 1);
   Object obj3 = GetData(lista_proyecto, i, 2);
   Object obj4 = GetData(lista_proyecto, i, 4);
   String value1=obj1.toString();
   String value2=obj2.toString();
   String value3=obj3.toString();
   String value4=obj4.toString();
    // se da estilo a las letras de cada celda del documento pdf
   tab.addCell(new Phrase(value1, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value2, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value3, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value4, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   }
   
   
   document.add(tab);//se agrega la tabla
   document.addTitle("Lista de Proyecto");//se agrega un titulo al documento pdf
   document.add(getInfo("\n"+cantidad));//se agrega la cantidad de columnas 
   document.add(getHorita(hora));//se agrega la fecha de emision
   document.close();//se cierra el documento generado 
   Desktop.getDesktop().open(archivo);//se abre el documento generado
   Desktop.getDesktop().print(archivo);//imprime el documento generado
   //Para mas infomacion sobre itext visitar http://itextpdf.com/
       }
       catch(DocumentException | IOException e){
      System.out.println("Falla al crear pdf proyecto "+e.getMessage());
            try {
                archi.crearLog("Falla al crear pdf proyecto "+e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Listar_Proyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
  
    }
     //carga los index de la tabla y retorna un objeto
    public Object GetData(JTable table, int row_index, int col_index){
        return table.getModel().getValueAt(row_index, col_index);
    }
    //metodo para definir el tamaño de las columnas de la tabla
    public void tamano_Tabla(){
         lista_proyecto.getColumnModel().getColumn(4).setPreferredWidth(250);
         lista_proyecto.getColumnModel().getColumn(3).setPreferredWidth(100);
         lista_proyecto.getColumnModel().getColumn(2).setPreferredWidth(200);
         lista_proyecto.getColumnModel().getColumn(1).setPreferredWidth(100);
         lista_proyecto.getColumnModel().getColumn(0).setPreferredWidth(125);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_proyecto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }};
            jSeparator1 = new javax.swing.JSeparator();
            jButton1 = new javax.swing.JButton();
            jLabel2 = new javax.swing.JLabel();
            combo_filtro = new javax.swing.JComboBox<>();
            text_filtro = new javax.swing.JTextField();
            text_tipo_filtro = new javax.swing.JTextField();
            text_pro_filtro = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            text_total_proyectos = new javax.swing.JTextField();
            jButton2 = new javax.swing.JButton();

            jLabel3.setText("jLabel3");

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Listar Proyectos");
            setResizable(false);
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowActivated(java.awt.event.WindowEvent evt) {
                    formWindowActivated(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
            jLabel1.setText("Listar Proyectos");

            lista_proyecto.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
            lista_proyecto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            lista_proyecto.getTableHeader().setResizingAllowed(false);
            lista_proyecto.getTableHeader().setReorderingAllowed(false);
            lista_proyecto.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lista_proyectoMouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(lista_proyecto);

            jButton1.setText("Salir");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jLabel2.setText("Filtrar:");

            combo_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Año Postulacion", "Tipo Proyecto" }));
            combo_filtro.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    combo_filtroActionPerformed(evt);
                }
            });

            text_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    text_filtroKeyReleased(evt);
                }
            });

            text_tipo_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    text_tipo_filtroKeyReleased(evt);
                }
            });

            text_pro_filtro.setText("Tipo Proyecto:");

            jLabel4.setText("Total de Proyectos:");

            jButton2.setText("Imprimir");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1)
                .addGroup(layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(48, 48, 48)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(text_total_proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(42, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(combo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(text_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(text_pro_filtro)
                    .addGap(18, 18, 18)
                    .addComponent(text_tipo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29))
                .addGroup(layout.createSequentialGroup()
                    .addGap(275, 275, 275)
                    .addComponent(jLabel1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_tipo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_pro_filtro)
                        .addComponent(jLabel2)
                        .addComponent(combo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel4)
                        .addComponent(text_total_proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void lista_proyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_proyectoMouseClicked
        Ver_Proyecto ver_proyecto = new Ver_Proyecto();
          // aqui evento para ir desde aqui a VER Proyecto presionado doble click
        if (evt.getClickCount() == 2) {
            String ano_postula = String.valueOf(lista_proyecto.getValueAt(lista_proyecto.getSelectedRow(), 0));
            String nro_registro = String.valueOf(lista_proyecto.getValueAt(lista_proyecto.getSelectedRow(), 1));
            String rut_coves = String.valueOf(lista_proyecto.getValueAt(lista_proyecto.getSelectedRow(), 3));
                int control=4;
                ver_proyecto.ver_proyecto(ano_postula, nro_registro,user,control,rut_coves);
               
                this.dispose();
        }
            
        


    }//GEN-LAST:event_lista_proyectoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_filtroActionPerformed
        //condiciones sobre los jtexfield y columnas de la tabla dependiendo de lo seleccionado en el combobox
        if (null != combo_filtro.getItemAt(combo_filtro.getSelectedIndex())) switch (combo_filtro.getItemAt(combo_filtro.getSelectedIndex())) {
            case "Todos":
                text_filtro.setEnabled(false);
                text_pro_filtro.setEnabled(false);
                text_tipo_filtro.setEnabled(false);
                text_filtro.setText(null);
                text_tipo_filtro.setText(null);
                text_total_proyectos.setText(String.valueOf(lista_proyecto.getRowCount()));

                 FiltroProyectoAno("");
                 lista_proyecto.getColumnModel().getColumn(4).setPreferredWidth(250);
                 tamano_Tabla();

                break;
            case "Año Postulacion":
                
               text_filtro.setEnabled(true);
               text_pro_filtro.setEnabled(true);
               text_tipo_filtro.setEnabled(true);
               tamano_Tabla();
                break;
            case "Tipo Proyecto":
                
                text_pro_filtro.setEnabled(false);
                text_tipo_filtro.setEnabled(false);
                text_filtro.setEnabled(true);
                text_tipo_filtro.setText(null);
                tamano_Tabla();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_combo_filtroActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //evento para que el text filtro inicie desactivado
        if ("Todos".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))) {
            text_filtro.setEnabled(false);
            text_pro_filtro.setEnabled(false);
            text_tipo_filtro.setEnabled(false);
            tamano_Tabla();
            
        }
        
    }//GEN-LAST:event_formWindowActivated

    private void text_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_filtroKeyReleased
        //Filtro para el text_filtro sobre la tabla segun lo elegido en el jcombobox
        if ("Año Postulacion".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))) {
         FiltroProyectoAno(text_filtro.getText());
          text_total_proyectos.setText(String.valueOf(lista_proyecto.getRowCount()));
            tamano_Tabla();
        }
        
        if ("Tipo Proyecto".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))) {
         FiltroProyectoTipoProyecto(text_filtro.getText()); 
         text_total_proyectos.setText(String.valueOf(lista_proyecto.getRowCount()));
            tamano_Tabla();
       }
        
    }//GEN-LAST:event_text_filtroKeyReleased

    private void text_tipo_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_tipo_filtroKeyReleased
        //Filtro para el text_tipo_filtro en caso de filtrar por año de postulacion
        FiltroProyectoAnoyTipo(text_filtro.getText(),text_tipo_filtro.getText());
        text_total_proyectos.setText(String.valueOf(lista_proyecto.getRowCount()));
        tamano_Tabla();
    }//GEN-LAST:event_text_tipo_filtroKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Se agregan los textos que desea agregar al archivo pdf
        String contenido="Lista de Proyectos";
        String cantidad="La Cantidad de Proyectos en la Lista es de "+text_total_proyectos.getText()+"";
         //Se carga la hora del sistema
        Calendar calendario = Calendar.getInstance();
         int   dia=calendario.get(Calendar.DAY_OF_MONTH);
          int   mes=calendario.get(Calendar.MONTH)+1;
          int   ano=calendario.get(Calendar.YEAR);      
          int  hora =calendario.get(Calendar.HOUR_OF_DAY);
          int  minutos = calendario.get(Calendar.MINUTE);
          int  segundos = calendario.get(Calendar.SECOND);
          
      String horat="Fecha de emision:"+dia+"-"+mes+"-"+ano+" "+hora + ":" + minutos + ":" + segundos;
        GenerarPdf(contenido,cantidad,horat);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param user
     */
    public void listar_proyecto(int user) {
        this.user=user;
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
            java.util.logging.Logger.getLogger(Listar_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Listar_Proyecto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_filtro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable lista_proyecto;
    private javax.swing.JTextField text_filtro;
    private javax.swing.JLabel text_pro_filtro;
    private javax.swing.JTextField text_tipo_filtro;
    private javax.swing.JTextField text_total_proyectos;
    // End of variables declaration//GEN-END:variables
}
