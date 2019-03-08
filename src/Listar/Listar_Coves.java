/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listar;

import Control.TCoves;
import Validacion.Validar;
import Registros.archivoLog;
import Ver.Ver_Coves;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;



/**
 *
 * @author Daniel Barraza
 */
public class Listar_Coves extends javax.swing.JFrame {
    //se crea tipos de letras
    private Font fuenteBold =new Font(Font.FontFamily.COURIER,26,Font.BOLD);
    private Font fuenteNormal =new Font(Font.FontFamily.COURIER,11,Font.BOLD);
    private Font fuenteChica =new Font(Font.FontFamily.COURIER,7,Font.BOLD);
    private Font fuentehora =new Font(Font.FontFamily.COURIER,6,Font.BOLD);
    DefaultTableModel modelo=new DefaultTableModel();//se crea una default table
    static int user=0;
    TCoves  tcoves;
    Validar validar=new Validar();
    archivoLog archi=new archivoLog();
    public Listar_Coves() {
        tcoves=new TCoves();
        initComponents();
        this.setLocationRelativeTo(null);
       Listar_todos();
       //se asigna valor a jtextfield segun la cantidad de filas de la tabla
       text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
       //se validan los campos
       validar.validarSoloLetras(text_filtro_estado);
       validar.limitarCaracteres(text_filtro_estado,10);
       //se define el tamano de las columnas
       tamano_Tabla();
       
       
        
         
       
        
    }

   //se crean metodos para los filtros
    private void Listar_Coves_Filtro_Sector(String sector){
        tcoves.listarCovesFiltroSector(lista_coves, sector);   
    }
    private void Listar_Coves_Filtro_Unidad(String unidad){
    tcoves.listarCovesFiltroUnidad(lista_coves, unidad);
}
    private void Listar_Coves_Filtro_Estado(String estado){
        tcoves.listarCovesFiltroEstado(lista_coves, estado);  
    }
    private void Listar_Coves_Filtro_Unidad_Estado(String unidad, String estado){
        tcoves.listarCovesFiltroUnidadyEstado(lista_coves, unidad, estado);
}
    private void Listar_Coves_Filtro_Sector_Estado(String sector, String estado){
        tcoves.listarCovesFiltroSectoryEstado(lista_coves, sector, estado);
    }
    private void Listar_Coves_Filtro_Ano(String ano){
        tcoves.listarCovesFiltroAno(lista_coves, ano);
    }
    private void Listar_todos(){
        tcoves.listarCovesFiltroTodos(lista_coves);
    }
    private void Listar_Coves_Filtro_Ano_y_Estado(String ano, String estado){
        tcoves.listarCovesFiltroAnoyEstado(lista_coves, ano, estado);   
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
    private Paragraph getChica(String chica){
        Paragraph paragraph=new Paragraph();
        Chunk chunk=new Chunk();
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        chunk.append(chica);
        chunk.setFont(fuenteChica);
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
    private void GenerarPdf(String titulo, String cantidad, String chica, String hora){  
        try{
        //se cuentan las cantidad de filas de la tabla
        int count=lista_coves.getRowCount();
        //se asigan el tipo de hoja y los margenes al documento pdf
        Document document=new Document(PageSize.LETTER,45,36,30,30);
        // se crea la ruta, si no existe crea la ruta completa
        File backup = new File("c:/archivos_pdfs");
        backup.mkdirs();
        
   
          //preparamos el backupfile con la ruta
          PdfWriter.getInstance(document,new FileOutputStream("c:/archivos_pdfs/Lista_Coves.pdf"));
          Paragraph saltolinea = new Paragraph();
          
          saltolinea.add("\n");//se agrega el salto de linea
          //se crea un nuevo archivo pdf en la direccion selecionada
          File archivo= new File("c:/archivos_pdfs/Lista_Coves.pdf");
          document.open();//se abre el documento
          // se crea la instancia de la imagen
          Image imagen= Image.getInstance("lib/Imagen/imagen.jpg");
          imagen.scaleAbsolute(50, 50);//se asigna un tamaño a la imagen
          imagen.setAlignment(Element.ALIGN_LEFT);//se alinea la imagen
          document.add(imagen);//se agrega al documento pdf
          document.add(getHeader(titulo));//se agrega un titulo al documento pdf
          document.add(saltolinea);//se agrega un salto de linea
          
                  
          

         
          
          
          //crea tabla dentro del pdf
          PdfPTable tab=new PdfPTable(6);
         
          tab.setWidthPercentage(100f);//se asigna el porcentaje de la tabla
          tab.setWidths(new float[] {1.9f, 0.9f, 0.7f, 1.6f, 0.9f,0.4f});//se asgina el ancho a las columnas
          tab.setHorizontalAlignment(Element.ALIGN_LEFT);//se alinea
          tab.getDefaultCell().setBorderWidth(0.8f);//Se da un borde a las celdas
            
         //se agregan los titulos de las columnas
        PdfPCell columna1 =new PdfPCell (new Paragraph("Nombre",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna1.setColspan(1);//union de celdas
        columna1.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna1.setPadding (5.0f);   // añadimos un espaciado
        columna1.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna1); //se añade a la tabla
          
        PdfPCell columna2 =new PdfPCell (new Paragraph("Telefono",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna2.setColspan(1);//union de celdas
        columna2.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna2.setPadding (5.0f);   // añadimos un espaciado
        columna2.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna2); //se añade a la tabla
        
        
        PdfPCell columna3 =new PdfPCell (new Paragraph("Estado",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna3.setColspan(1);//union de celdas
        columna3.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna3.setPadding (5.0f);   // añadimos un espaciado
        columna3.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna3); //se añade a la tabla
          
        PdfPCell columna4 =new PdfPCell (new Paragraph("Direccion",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna4.setColspan(1);//union de celdas
        columna4.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna4.setPadding (5.0f);   // añadimos un espaciado
        columna4.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna4); //se añade a la tabla 
        
         PdfPCell columna5 =new PdfPCell (new Paragraph("Sector",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna5.setColspan(1);//union de celdas
        columna5.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna5.setPadding (5.0f);   // añadimos un espaciado
        columna5.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna5); //se añade a la tabla
        
        PdfPCell columna6 =new PdfPCell (new Paragraph("UV",
        FontFactory.getFont("arial",14,Font.BOLD,BaseColor.BLACK)));             
        columna6.setColspan(1);//union de celdas
        columna6.setHorizontalAlignment(Element.ALIGN_CENTER); //alineamos el contenido al centro
        columna6.setPadding (5.0f);   // añadimos un espaciado
        columna6.setBackgroundColor(BaseColor.GRAY); //colocamos un color de fondo
        tab.addCell(columna6); //se añade a la tabla
    //se genera la tabla      
   for(int i=0;i<count;i++){
   Object obj1 = GetData(lista_coves, i, 0);
   Object obj2 = GetData(lista_coves, i, 7);
   Object obj3 = GetData(lista_coves, i, 2);
   Object obj4 = GetData(lista_coves, i, 6);
   Object obj5 = GetData(lista_coves, i, 4);
   Object obj6 = GetData(lista_coves, i, 3);
   String value1=obj1.toString();
   String value2=obj2.toString();
   String value3=obj3.toString();
   String value4=obj4.toString();
   String value5=obj5.toString();
   String value6=obj6.toString();
   // se da estilo a las letras de cada celda del documento pdf
   tab.addCell(new Phrase(value1, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value2, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value3, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value4, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value5, FontFactory.getFont(FontFactory.HELVETICA, 10)));
   tab.addCell(new Phrase(value6, FontFactory.getFont(FontFactory.HELVETICA, 10)));
            
   }
   document.add(tab);//se agrega la tabla
   document.addTitle("Lista de Coves");//se agrega un titulo al documento pdf
   document.add(getChica(chica));//se agrega un mensaje 
   document.add(getInfo("\n"+cantidad)); //se agrega la cantidad de columnas
   document.add(getHorita(hora));//se agrega la fecha de emision
   document.close();//se cierra el documento generado 
   Desktop.getDesktop().open(archivo);//se abre el documento generado
   Desktop.getDesktop().print(archivo);//imprime el documento generado
  
   
   //Para mas infomacion sobre itext visitar http://itextpdf.com/
       }
        //se trabajan las excepciones
       catch(DocumentException | IOException e){
           System.out.println("Falla al crear pdf Coves "+e.getMessage());
            try {
                archi.crearLog("Falla al crear pdf Coves "+e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(Listar_Coves.class.getName()).log(Level.SEVERE, null, ex);
            }
           
       
       }
       
  
    }
    //carga los index de la tabla y retorna un objeto
    public Object GetData(JTable table, int row_index, int col_index){
        return table.getModel().getValueAt(row_index, col_index);
    }
    //metodo para definir el tamaño de la tabla
    public void tamano_Tabla(){
         lista_coves.getColumnModel().getColumn(0).setPreferredWidth(250);
         lista_coves.getColumnModel().getColumn(3).setPreferredWidth(75);
         lista_coves.getColumnModel().getColumn(6).setPreferredWidth(150);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_coves = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }

        };
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo_filtro = new javax.swing.JComboBox<>();
        text_filtro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        text_total_coves = new javax.swing.JTextField();
        text_filtro_estado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Coves");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Listar coves");

        lista_coves.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lista_coves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        lista_coves.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        lista_coves.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lista_coves.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_coves.getTableHeader().setResizingAllowed(false);
        lista_coves.getTableHeader().setReorderingAllowed(false);
        lista_coves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_covesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista_coves);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filtrar por:");

        combo_filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Unidad Vecinal", "Sector", "Estado", "Año" }));
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

        jLabel6.setText("Total de COVES:");

        text_total_coves.setEditable(false);

        text_filtro_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_filtro_estadoKeyReleased(evt);
            }
        });

        jLabel3.setText("Estado:");

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel4.setText("Coves con año 2000, no regitra su año");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1011, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(combo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(text_filtro)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(text_filtro_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(68, 68, 68)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(text_total_coves, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(414, 414, 414)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_filtro_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel6)
                    .addComponent(text_total_coves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lista_covesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_covesMouseClicked
        // aqui evento para ir desde aqui a VER coves presionado doble click
        Ver_Coves ver_coves=new Ver_Coves();
        if (evt.getClickCount() == 2) {
            int control=3;
            String rut=String.valueOf(lista_coves.getValueAt(lista_coves.getSelectedRow(),1));
            ver_coves.ver_coves(rut,user,control);
            
            dispose();
            
           
            
            
            
    }//GEN-LAST:event_lista_covesMouseClicked
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //evento para que el text filtro inicie desactivado
        if("Todos".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
           text_filtro.setEnabled(false);
           text_filtro_estado.setEnabled(false);
           
       }
    }//GEN-LAST:event_formWindowActivated

    private void combo_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_filtroActionPerformed
        //condiciones sobre los jtexfield y columnas de la tabla dependiendo de lo seleccionado en el combobox
        if(null != combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))switch (combo_filtro.getItemAt(combo_filtro.getSelectedIndex())) {
            case "Todos":
                text_filtro.setEnabled(false);
                text_filtro_estado.setEnabled(false);
                
                text_filtro.setText(null);
                text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
                Listar_todos();
                tamano_Tabla();
                break;
            case "Estado":
                text_filtro_estado.setEnabled(false);
                text_filtro.setEnabled(true);
                text_filtro_estado.setText(null);
                tamano_Tabla();
                break;
            case "Año":
                text_filtro_estado.setEnabled(true);
                text_filtro.setEnabled(true);
                text_filtro_estado.setText(null);
                tamano_Tabla();
                break;
            case "Unidad Vecinal":
                text_filtro.setEnabled(true);
                text_filtro_estado.setEnabled(true);
                text_filtro_estado.setText(null);
                tamano_Tabla();
                break;
            case "Sector":
                text_filtro.setEnabled(true);
                text_filtro_estado.setEnabled(true);
                text_filtro_estado.setText(null);
                tamano_Tabla();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_combo_filtroActionPerformed

    private void text_filtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_filtroKeyReleased
         //condiciones sobre los jtexfield y columnas de la tabla
        if("Sector".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
        Listar_Coves_Filtro_Sector(text_filtro.getText());
        text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
        lista_coves.getColumnModel().getColumn(0).setPreferredWidth(250);
                tamano_Tabla();
    
      }
      if("Unidad Vecinal".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
          Listar_Coves_Filtro_Unidad(text_filtro.getText());
          text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
         tamano_Tabla();
         
          
      }
      if("Estado".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
          Listar_Coves_Filtro_Estado(text_filtro.getText());
          text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
          tamano_Tabla();
      
      }if("Año".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
          Listar_Coves_Filtro_Ano(text_filtro.getText());
          text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
          tamano_Tabla();
      }
    }//GEN-LAST:event_text_filtroKeyReleased

    private void text_filtro_estadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_filtro_estadoKeyReleased
         //condiciones sobre los jtexfield y columnas de la tabla
        if("Unidad Vecinal".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
        Listar_Coves_Filtro_Unidad_Estado(text_filtro.getText(),text_filtro_estado.getText());
        text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
        tamano_Tabla();
      }
      if("Sector".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
          Listar_Coves_Filtro_Sector_Estado(text_filtro.getText(),text_filtro_estado.getText());
          text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
          tamano_Tabla();
      }
      if("Año".equals(combo_filtro.getItemAt(combo_filtro.getSelectedIndex()))){
          Listar_Coves_Filtro_Ano_y_Estado(text_filtro.getText(),text_filtro_estado.getText());
          text_total_coves.setText(String.valueOf(lista_coves.getRowCount()));
          tamano_Tabla();
      }
      
    }//GEN-LAST:event_text_filtro_estadoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Se agregan los textos que desea agregar al archivo pdf
        String contenido="Lista de COVES";
        String cantidad="La Cantidad de COVES en la lista es de: "+text_total_coves.getText()+"";
        String chica="UV = Unidad Vecinal";
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
      GenerarPdf(contenido,cantidad,chica,horat);
       
        
    }//GEN-LAST:event_jButton2ActionPerformed
   
    /**
     * @param user
     */
    public  void listar_coves(int user) {
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
            java.util.logging.Logger.getLogger(Listar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Coves.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Listar_Coves().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable lista_coves;
    private javax.swing.JTextField text_filtro;
    private javax.swing.JTextField text_filtro_estado;
    private javax.swing.JTextField text_total_coves;
    // End of variables declaration//GEN-END:variables

  
}
