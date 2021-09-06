package es.domingojunta.filters;

import java.io.File;
import java.io.FileFilter;

public class PdfFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		
		String extension ="";
		String nombre = pathname.getName();
		//System.out.println("Analizando: "+ nombre);
		int dotInd = nombre.lastIndexOf('.');
		//System.out.println("El índice con el punto está en "+dotInd);
		extension = nombre.substring(dotInd+1).toUpperCase();
		//System.out.println("Extensión: "+ extension+"devuelvo???");
		
		
		if (dotInd == -1 || !extension.equals("PDF")) {
			//System.out.println("dotInd=" + dotInd);
			//System.out.println("Extensión: "+ extension + "devuelvo false");
			return false;
		} else {
			//System.out.println("Extensión: "+ extension + "devuelvo true.");
			return true;
			}
		}
		

}
