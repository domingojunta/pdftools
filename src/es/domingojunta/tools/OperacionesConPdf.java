package es.domingojunta.tools;

import java.io.File;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

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
}
