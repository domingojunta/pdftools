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
		//System.out.println("El �ndice con el punto est� en "+dotInd);
		extension = nombre.substring(dotInd+1).toUpperCase();
		//System.out.println("Extensi�n: "+ extension+"devuelvo???");
		
		
		if (dotInd == -1 || !extension.equals("PDF")) {
			//System.out.println("dotInd=" + dotInd);
			//System.out.println("Extensi�n: "+ extension + "devuelvo false");
			return false;
		} else {
			//System.out.println("Extensi�n: "+ extension + "devuelvo true.");
			return true;
			}
		}
		

}
