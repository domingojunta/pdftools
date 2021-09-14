package es.domingojunta.tools;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import es.domingojunta.entities.FicheroEntity;

public class OperacionesConPdf {
	
	public boolean unirficheros(File[] ficherosAUnir, String nombreNuevoFichero) {
		
		PdfWriter pdfWriterSalida = null;
		PdfDocument pdfDocumentSalida = null;
		PdfReader pdfReaderEntrada = null;
		PdfDocument pdfDocumentEntrada = null;
		
		
		try {
			//System.out.println("Nombre del nuevo Archivo: "+ nombreNuevoFichero);
			pdfWriterSalida = new PdfWriter(nombreNuevoFichero);
			pdfDocumentSalida = new PdfDocument(pdfWriterSalida);
			
			for (File item : ficherosAUnir) {
				
				//System.out.println("Trabajando con el fichero: "+ item.getAbsolutePath());
				pdfReaderEntrada = new PdfReader(item);
				pdfDocumentEntrada = new PdfDocument(pdfReaderEntrada);
				//int numeroPaginas = pdfDocumentEntrada.getNumberOfPages();
				//System.out.println("El número de páginas del fichero es: "+ numeroPaginas);
				
				int numeroPaginas = obtenerNumeroPaginas(item);
				
				if (numeroPaginas > 0) {
				pdfDocumentEntrada.copyPagesTo(1, numeroPaginas, pdfDocumentSalida);
				} else {
					
					String mensaje ="El fichero: "+item.getName()+" tiene 0 páginas y no se ha copiado.";
					JOptionPane.showMessageDialog(null, mensaje, "Unir ficheros", JOptionPane.ERROR_MESSAGE);
				}

				
				pdfDocumentEntrada.close();
				pdfReaderEntrada.close();
				
			}
			
			pdfDocumentSalida.close();
			pdfWriterSalida.close();
			
			JOptionPane.showMessageDialog(null, "Fichero creado correctamente...", "Unir ficheros", JOptionPane.INFORMATION_MESSAGE);
			
			return true;
		} catch (Exception e) {
			
			
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Unir ficheros", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		
		
		
		
		
	}

	public int obtenerNumeroPaginas(File ficheroPdf) {
		
		PdfReader pdfReaderEntrada = null;
		PdfDocument pdfDocumentEntrada = null;
		int numeroPaginas;
		
		try {
			
			pdfReaderEntrada = new PdfReader(ficheroPdf);
			pdfDocumentEntrada = new PdfDocument(pdfReaderEntrada);
			numeroPaginas = pdfDocumentEntrada.getNumberOfPages();
			return numeroPaginas;
			
			
		} catch (Exception e) {
			
			return 0;
		}
		
	}


	public boolean dividirFichero(File ficheroADividir, int[] paginasDeCorte, String directorioTrabajo, String nombreBase) {
		
		int numeroFicherosSalida = paginasDeCorte.length-1;
		
		try {
			
			PdfReader pdfReader = new PdfReader(ficheroADividir);
			PdfDocument pdfEntradaDocument = new PdfDocument(pdfReader);
			
			
			List<File> ficherosSalida = new ArrayList<>();
			String separador = File.separator;
			String nombreArchivo;
			int proximo = 0;
			
			for (int i=0; i< numeroFicherosSalida; i++) {
				int numeroSecuencial = 90000+i;
				nombreArchivo = directorioTrabajo+separador+numeroSecuencial+" "+nombreBase+".pdf";
				
				//File fichero = new File(nombreArchivo);
				PdfWriter pdfWriter = new PdfWriter(nombreArchivo);
				PdfDocument pdfDocumentSalida = new PdfDocument(pdfWriter);
				
				pdfEntradaDocument.copyPagesTo(paginasDeCorte[i]+proximo, paginasDeCorte[i+1], pdfDocumentSalida);
				
				proximo = 1;
				pdfDocumentSalida.close();
				pdfWriter.close();
				
			}
			
			pdfEntradaDocument.close();
			pdfReader.close();
			
			return true;
			
		} catch (Exception e2) {
			
			
			return false;
		} 
	}

	public boolean paginar(List<FicheroEntity> listadoFicheroEntities, String directorioDeSalida) {
		
		PdfReader pdfReaderEntrada;
		PdfWriter pdfWriterSalida;
		PdfDocument pdfDocument;
		Document documento;
		
		try {
		
			int numeroTotalPaginas = listadoFicheroEntities.get(listadoFicheroEntities.size()-1).getPaginaFinal();
			String directorioEntrada = listadoFicheroEntities.get(0).getFile().getParent();
			String directorioSalida = directorioDeSalida;
			String separador = File.separator;
			String extension = ".pdf";
			
			if (directorioSalida == null) {
				
				directorioSalida = directorioEntrada+separador+"SALIDA";
			}
			
			
			for (FicheroEntity item : listadoFicheroEntities) {
				
				String nombreFicheroEntrada = item.getFile().getAbsolutePath();
				//System.out.println("El nombre del fichero a leer es: "+nombreFicheroEntrada);
				pdfReaderEntrada = new PdfReader(nombreFicheroEntrada);
				
				String comentario = item.getComentarios().trim();
				String nombreCorto = "02"+item.getNombreCorto().trim();
				String nombreFicheroSalida;
				
				if (comentario.equals("")) {
					
					nombreFicheroSalida = directorioSalida+separador+nombreCorto+extension;
				} else {
					
					nombreFicheroSalida = directorioSalida+separador+nombreCorto+" # "+comentario+extension;
				}
				
				pdfWriterSalida = new PdfWriter(nombreFicheroSalida);
				
				pdfDocument = new PdfDocument(pdfReaderEntrada, pdfWriterSalida);
				
				
				documento = new Document(pdfDocument, PageSize.A4);
				documento.setMargins(25, 25, 30, 25);
				PdfFont fuente = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
				
				int contadorInternoDePaginas = 0;
				
				for (int i = 1; i <= item.getNumeroPaginas(); i++) {
					
					PdfPage pagina = pdfDocument.getPage(i);
					int paginaActualDelDocumento = item.getPaginaInicial()+contadorInternoDePaginas;
					String pieDePagina = "Página "+ paginaActualDelDocumento+" de "+numeroTotalPaginas;
					Text textoPieDePagina = new Text(pieDePagina);
					//textoPieDePagina.setFontColor(new Color(Color.BLUE));
					textoPieDePagina.setFontSize(14);
					Paragraph parrafoPieDePagina = new Paragraph(textoPieDePagina);
					//parrafoPieDePagina.setFontColor(new Color(0, 0, 255));
					float posicionX = pdfDocument.getPage(i).getPageSize().getWidth() / 2;
					float posicionY = pdfDocument.getPage(i).getPageSize().getBottom()+25;
					
					documento.showTextAligned(parrafoPieDePagina, posicionX, posicionY, i ,TextAlignment.CENTER,VerticalAlignment.TOP,0);
					
					
				
					pagina.flush();
					//documento.flush();
					
					
					parrafoPieDePagina = null;
					textoPieDePagina = null;
					pagina = null;
					
					//pdfWriterSalida.flush();
					contadorInternoDePaginas++;
				}
				
				
				
							
				documento.close();
				pdfDocument.close();
				pdfWriterSalida.close();
				pdfReaderEntrada.close();
				
				
				
			
				
				
			}
			
					
			
			return true;
		
		} catch (Exception e) {
			
			//e.printStackTrace();
			return false;
		}
	}

	

}
