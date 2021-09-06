package es.domingojunta.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.kernel.log.SystemOutCounter;

import es.domingojunta.entities.FicheroEntity;
import es.domingojunta.filters.PdfFileFilter;

public class OperacionesConFicheros {

	public File[] ordenarFicherosPorNombre(File[] ficherosSinOrdenar) {
		
		File[] ficherosOrdenados = new File[ficherosSinOrdenar.length];
		List<FicheroEntity> ficherosEntity = new ArrayList<>();
		FicheroEntity ficheroEntity;
		
		try {
			
			
			for (File item : ficherosSinOrdenar) {
				
				ficheroEntity = new FicheroEntity();
				
				String nombre = item.getName();
				int indiceEspacio = nombre.indexOf(" ");
				String numeroString = nombre.substring(0, indiceEspacio);
				int id = Integer.parseInt(numeroString);
				ficheroEntity.setId(id);
				ficheroEntity.setNombre(item.getName());
				ficheroEntity.setFile(item);
				ficherosEntity.add(ficheroEntity);
				
			}
			
			ficherosEntity.sort(new ComparatorOrdenarFicherosEntityPorId());
			
			int indice = 0;
			for (FicheroEntity item : ficherosEntity) {
				
				ficherosOrdenados[indice] = item.getFile();
				indice++;
				
			}
			
			return ficherosOrdenados;
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "No se han podido ordenar los ficheros, problablemente porque alguno no empieza por un número...", "Ordenar ficheros", JOptionPane.ERROR_MESSAGE);
			return ficherosSinOrdenar;
		}
	}

	public boolean borrarFichero(File archivoABorrar) {
		
		try {
			return archivoABorrar.delete();
			
		} catch (Exception e) {
			
			return false;
		}
	}
	
	
	public boolean renombrarFichero(File oldFile, String nuevoNombre) {
		
		try {
			
			File archivoConNuevoNombre = new File(nuevoNombre);
			boolean resultado = oldFile.renameTo(archivoConNuevoNombre);
			
			return resultado;
			
		} catch (Exception e) {
			return false;
		}
		
	}


	public File[] renumerarFicheros(File[] oldFiles, int longitud, String path) {
		
		if (longitud < 2) {
			
			longitud =2;
		}
		
		try {
			
			//ficherosOrdenados = ordenarFicherosPorNombre(oldFiles);
			//System.out.println("El número de ficheros ordenados es: "+ficherosOrdenados.length);
			
			int indice = 1;
			for (File item : oldFiles) {
			
				String nombre = item.getName();
				int indiceEspacio = nombre.indexOf(" ");
				String numeroString = nombre.substring(0, indiceEspacio);
				//System.out.println("El número string es: "+numeroString);
				String restoNombre = nombre.substring(indiceEspacio+1).trim();
				//System.out.println("El resto del nombre es: "+restoNombre);
				int id = Integer.parseInt(numeroString);
				//System.out.println("El id es: "+id);
				String prefijo ="";
				
				
				prefijo = ""+indice;
				int longitudString = prefijo.length();
				
				if (longitudString < longitud) {
					
					
					
					for (int i = longitudString; i < longitud; i++) {
						//System.out.println("Prefijo antes: "+prefijo);
						prefijo = "0"+prefijo;
						//System.out.println("Prefijo después: "+prefijo);
					}
				}
				
				String separador = File.separator;
				String nombreNormalizado = path+separador+prefijo+" "+restoNombre;
				
				File nuevoFicheroNormalizado = new File(nombreNormalizado);
				//System.out.println("Fichero antiguo: "+ item.getName());
				boolean resultado = item.renameTo(nuevoFicheroNormalizado);
				//System.out.println("Fichero nuevo: "+ nuevoFicheroNormalizado);
			
				indice++;
			}
			
			
			return oldFiles;
		} catch (Exception e) {
			
			String mensaje = "No se ha podido renumerar ficheros probablemente porque algún fichero no empieza por número...";
//			JOptionPane.showMessageDialog(null, mensaje, "Renumerar ficheros", JOptionPane.ERROR_MESSAGE);
			return oldFiles;
		}
	}

	public File[] seleccionarFicherosEnDirectorio(String path) {
		
		File archivosEnDirectorio = new File(path);
		File[] files = archivosEnDirectorio.listFiles(new PdfFileFilter());
		File[] filesOrdered = ordenarFicherosPorNombre(files);
		return files;
	}
}

