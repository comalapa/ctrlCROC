/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Conexion.conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Garcia
 */
public class imprimirPedido {
        
        private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        private static Date date = new Date();
        private static String fecha = dateFormat.format(date);
        private static String FILE = "ticket-" + fecha + ".pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
	
	static int noPedido = 0;
	public static double cantidad = 0.00;
	public static String vencimiento = "";
	public static String duenio = "";
	public static int pInicial = 0;
	
	public static String nombreCliente = "";
	public static String direccionCliente = "";
	public static String lugarCliente = "";
	public static String nombreEstado = "";
	
	public imprimirPedido(){
		try {
//			Document document = new Docum   7ent();
			Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
//			Instancia del PDF
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
//			Obtenemos la instancia para el fondo
//			PdfContentByte background = writer.getDirectContentUnder();
//			Obtenemos la instancia de los elementos
//			PdfContentByte elements = writer.getDirectContent();
			
			document.open();
			addMetaData(document);
//			addTitlePage(document);
//			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void imprimirPedido(int id_pedido){
		try {
			
			noPedido = id_pedido;
			
//			Document document = new Document();
			Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
//			Instancia del PDF
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE + "Remision" + id_pedido + ".pdf"));
//			Abrimos el documento
			document.open();
//			Obtenemos la instancia para el fondo
			PdfContentByte background = writer.getDirectContentUnder();
//			Obtenemos la instancia de los elementos
			PdfContentByte elements = writer.getDirectContent();
			
//			addMetaData(document);
			addTitlePage(document,background,elements);
//			addContent(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void addMetaData(Document document) {
	    document.addTitle("Nota de Pedido");
	    document.addSubject("CTRL-CROC");
	    document.addAuthor("PCDoctor");
	    document.addCreator("PCDoctor");
	  }
	
	private static void addTitlePage(Document document, PdfContentByte background, PdfContentByte elements)
			throws DocumentException, MalformedURLException, IOException {
		Paragraph preface = new Paragraph();
//                
//		
//    	System.out.println("Nombre del Cliente: " + nombreCliente);
   	    	
                conexion conectar= new conexion();
                Statement st = conectar.conectar();
                
                if(st != null){
                    ResultSet rs = conectar.ejecutarSQLSelect("SELECT a.chofer_id,a.camion_id,a.material_id,a.fecha_creado, b.nombre,b.apellido_p,b.apellido_m,b.camion_id, c.estado,c.ciudad,c.colonia,c.direccion,c.contacto,c.telefono,c.celular,c.referencia,c.pedido_id, d.no_control, e.nombre AS nombreM,e.precio,e.descuento,e.iva FROM tb_pedidos a,tb_chofer b,tb_destino c,tb_camion d,tb_materiales e WHERE a.id="+noPedido+" AND a.id = c.pedido_id AND a.chofer_id=b.id AND a.camion_id=d.id AND a.material_id=e.id;");
                    try {
                        if(rs.next()){
                        
                                      
                
    	
    //		Logo
                    Image image1 = Image.getInstance( "imagenes\\croc2.png");
                    image1.scaleAbsolute(120f, 80f);
                    image1.setAbsolutePosition(70, 660);
                    preface.add(image1);

    //		Nombre Empresa
                    BaseFont bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(250, 730);
                    elements.setFontAndSize(bf, 13);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("CTRL-CROC");
                    elements.endText();
                    elements.restoreState();

    //		Nombre Empresa
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(75, 660);
                    elements.setFontAndSize(bf, 6);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("¡ LO NECESARIO PARA LA CONSTRUCCION !");
                    elements.endText();
                    elements.restoreState();
                    
                    //DATOS DEL CHOFER
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(25, 630);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("CHOFER: "+rs.getString("nombre")+" "+rs.getString("apellido_p")+" "+rs.getString("apellido_m"));
                    elements.endText();
                    elements.restoreState();
                    
                    //DATOS DEL CAMION
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(25, 620);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("NUMERO DE CAMION: "+rs.getString("camion_id"));
                    elements.endText();
                    elements.restoreState();
                    

    //		Dueño
//                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
//                    elements.saveState();
//                    elements.beginText();
//                    elements.moveText(215, 715);
//                    elements.setFontAndSize(bf, 10);
//                    elements.setColorFill(BaseColor.BLACK);
//                    elements.showText("AVIDAI");
//                    elements.endText();
//                    elements.restoreState();

    //		RFC		
//                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
//                    elements.saveState();
//                    elements.beginText();
//                    elements.moveText(263, 700);
//                    elements.setFontAndSize(bf, 10);
//                    elements.setColorFill(BaseColor.BLACK);
//                    elements.showText("");
//                    elements.endText();
//                    elements.restoreState();

    //		Direccion
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(205, 715);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("COMITAN DE DOMINGEZ, CHIAPAS");
                    elements.endText();
                    elements.restoreState();

    //		Lugar
//                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
//                    elements.saveState();
//                    elements.beginText();
//                    elements.moveText(230, 670);
//                    elements.setFontAndSize(bf, 10);
//                    elements.setColorFill(BaseColor.BLACK);
//                    elements.showText("CHIAPAS");
//                    elements.endText();
//                    elements.restoreState();

    //		Codigo Postal
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(218,700);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("C.P. 30000  TEL: 9631212345");
                    elements.endText();
                    elements.restoreState();

    //		Tipo Documento
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(495, 743);
                    elements.setFontAndSize(bf, 7);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("NOTA DE PEDIDO");
                    elements.endText();
                    elements.restoreState();

    //		Cuadro No. Folio
                    background.setColorFill(new BaseColor(235,235,235));
    //		rectangle x,y,w,h
                    background.rectangle(460,710,110,30);
                    background.fill();

    //		Numero de Folio
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(500, 720);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("" + noPedido);
                    elements.endText();
                    elements.restoreState();

    //		Fecha de Impresion
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(500, 693);
                    elements.setFontAndSize(bf, 7);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("FECHA CREACION");
                    elements.endText();
                    elements.restoreState();

    //		Cuadro Fecha de Impresion
                    background.setColorFill(new BaseColor(235,235,235));
    //		rectangle x,y,w,h
                    background.rectangle(460,660,110,30);
                    background.fill();

    //		Fecha
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(480, 670);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(""+ rs.getString("fecha_creado").substring(0,10));
                    elements.endText();
                    elements.restoreState();


    //		======================================================================================================================================
    //		CUADRO PARA EL CLIENTE
    //		======================================================================================================================================

    //		Cuadro Datos Cliente
                    background.setColorFill(new BaseColor(190,190,190));
    //		rectangle x,y,w,h
                    background.rectangle(20,585,560,20);
                    background.fill();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(280, 593);
                    elements.setFontAndSize(bf, 10);
                    elements.setColorFill(BaseColor.WHITE);
                    elements.showText("CLIENTE");
                    elements.endText();
                    elements.restoreState();

    //		Cuadro Datos Cliente
                    background.setColorFill(new BaseColor(235,235,235));
    //		rectangle x,y,w,h
                    background.rectangle(20,530,560,60);
                    background.fill();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(25, 575);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("NOMBRE: ");
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(80, 575);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(rs.getString("contacto"));
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(25, 560);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("DIRECCIÓN: ");
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(80, 560);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(rs.getString("direccion")+", "+rs.getString("colonia")+", "+rs.getString("ciudad")+".");
                    elements.endText();
                    elements.restoreState();
                    
                    
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(25, 545);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("REFERENCIA: ");
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(80, 545);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(rs.getString("referencia"));
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(25, 530);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("TELEFONO: ");
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(80, 530);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(rs.getString("telefono")+",    Celular: "+rs.getString("celular"));
                    elements.endText();
                    elements.restoreState();
                    

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(80, 545);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(lugarCliente);
                    elements.endText();
                    elements.restoreState();

    //		======================================================================================================================================
    //		ENCABEZADOS PRODUCTOS
    //		======================================================================================================================================

                    background.setColorFill(new BaseColor(200,200,200));
                    background.rectangle(20,505,60,18);
                    background.fill();
                    // Texto - Cantidad
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(35, 510);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("CANTIDAD");
                    elements.endText();
                    elements.restoreState();
                    // Fondo - Unidad de Medida
                    background.setColorFill(new BaseColor(200,200,200));
                    background.rectangle(81,505,338,18);
                    background.fill();
                    // Texto - Unidad de Medida
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(240, 510);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("MATERIAL");
                    elements.endText();
                    elements.restoreState();
                    // Fondo - Descripcion del Producto
                    background.setColorFill(new BaseColor(200,200,200));
                    background.rectangle(420,505,80,18);
                    background.fill();
                    // Texto - Unidad de Medida
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(440, 510);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("PRECIO");
                    elements.endText();
                    elements.restoreState();
                    // Fondo - Importe
                    background.setColorFill(new BaseColor(200,200,200));
                    background.rectangle(501,505,80,18);
                    background.fill();
                    // Texto - Importe
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(520, 510);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("IMPORTE");
                    elements.endText();
                    elements.restoreState();


                    // Variables de Control
                    // Fondo Inicial
                    String fActual="255";
                    // Posicion Inicial
                    pInicial=490;
                    int pTextSpace=6;
                    int pTextAlignCantidad=24;
                    int pTextAlignUMedida=88;
                    int pTextDescProducto=193;
                    int pTextPrecioUnit = 425;
                    int pTextImporte=507;
                    int pTextSubTotal=464;
                    int pTextIva=482;
                    int pTextTotal=467;
                    int pTextoTpagoFpago=34;

                    // Imprimimos el Detalle de la Factura
//                    for (int i=0;i<5;i++){

                            // Fondo - Cantidad
                            if (fActual.equalsIgnoreCase("255")){background.setColorFill(new BaseColor(255,255,255));}else{background.setColorFill(new BaseColor(235,235,235));}
                            background.rectangle(20,pInicial,60,18);
                            background.fill();

                            // Texto - Cantidad
                            bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                            elements.saveState();
                            elements.beginText();
                            elements.moveText(pTextAlignCantidad,pInicial+pTextSpace);
                            elements.setFontAndSize(bf, 8);
                            elements.setColorFill(BaseColor.BLACK);
                            elements.showText("1");
                            elements.endText();
                            elements.restoreState();

                            // Fondo - Unidad de Medida
                            if (fActual.equalsIgnoreCase("255")){background.setColorFill(new BaseColor(255,255,255));}else{background.setColorFill(new BaseColor(235,235,235));}
                            background.rectangle(81,pInicial,338,18);
                            background.fill();

                            // Texto - Unidad de Medida
                            bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                            elements.saveState();
                            elements.beginText();
                            elements.moveText(pTextAlignUMedida,pInicial+pTextSpace);
                            elements.setFontAndSize(bf, 8);
                            elements.setColorFill(BaseColor.BLACK);
                            elements.showText(rs.getString("nombreM"));
                            elements.endText();
                            elements.restoreState();

                            // Fondo - Importe
                            if (fActual.equalsIgnoreCase("255")){background.setColorFill(new BaseColor(255,255,255));}else{background.setColorFill(new BaseColor(235,235,235));}
                            background.rectangle(420,pInicial,80,18);
                            background.fill();

                            // Texto - Subtotal
                            bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                            elements.saveState();
                            elements.beginText();
                            elements.moveText(pTextPrecioUnit,pInicial+pTextSpace);
                            elements.setFontAndSize(bf, 8);
                            elements.setColorFill(BaseColor.BLACK);
                            elements.showText(rs.getString("precio"));
                            elements.endText();
                            elements.restoreState();

                            // Fondo - Descripcion del Producto
                            if (fActual.equalsIgnoreCase("255")){background.setColorFill(new BaseColor(255,255,255));}else{background.setColorFill(new BaseColor(235,235,235));}
                            background.rectangle(501,pInicial,80,18);
                            background.fill();

                            // Texto - Descripcion del Producto
                            bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                            elements.saveState();
                            elements.beginText();
                            elements.moveText(pTextImporte,pInicial+pTextSpace);
                            elements.setFontAndSize(bf, 8);
                            elements.setColorFill(BaseColor.BLACK);
                            elements.showText(rs.getString("precio"));
                            elements.endText();
                            elements.restoreState();

                            // Cambiamos el Color
                            if (fActual.equalsIgnoreCase("255")){fActual="235";}else{fActual="255";}
                            // Cambiamos Posicion PInicial
                            pInicial=pInicial-20;
//                    }

    //		========================================================================================================================0


                    background.setColorFill(new BaseColor(200,200,200));
                    background.rectangle(30,105,400,40);
                    background.fill();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(35, 135);
                    elements.setFontAndSize(bf, 5);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("");
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(35, 125);
                    elements.setFontAndSize(bf, 6);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("");
                    elements.endText();
                    elements.restoreState();

    //		========================================================================================================================0
                    // Fondo - Subtotal
                    background.setColorFill(new BaseColor(200,200,200));
                    background.rectangle(501,115,80,18);
                    background.fill();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(453, 120);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("TOTAL");
                    elements.endText();
                    elements.restoreState();

                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(505, 120);
                    elements.setFontAndSize(bf, 8);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("$"+rs.getString("precio"));
                    elements.endText();
                    elements.restoreState();
                    
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(300, 47);
                    elements.setFontAndSize(bf, 6);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("_____________________________________");
                    elements.endText();
                    elements.restoreState();
                    
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(300, 47);
                    elements.setFontAndSize(bf, 6);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText(rs.getString("contacto"));
                    elements.endText();
                    elements.restoreState();
                    
                    bf=BaseFont.createFont(BaseFont.HELVETICA,BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
                    elements.saveState();
                    elements.beginText();
                    elements.moveText(310, 40);
                    elements.setFontAndSize(bf, 6);
                    elements.setColorFill(BaseColor.BLACK);
                    elements.showText("NOMBRE Y FIRMA DEL CLIENTE");
                    elements.endText();
                    elements.restoreState();
               
                 
                    document.add(preface);

                    File path=new File(FILE + "Remision" + noPedido + ".pdf");
                    Desktop.getDesktop().open(path);
                    }else{
                            System.out.println("No se encontraron registros...");
                        }
                } catch (SQLException ex) {
                Logger.getLogger(imprimirPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
    
}
