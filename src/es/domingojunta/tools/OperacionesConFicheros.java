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


	public File[] renumerarFicheros(File[] oldFiles) {
		
		
		
		int numeroElementos = oldFiles.length;
		String numeroElementosString = ""+numeroElementos;
		int longitud = numeroElementosString.length();
		String path ="";
		
		if (longitud == 0) {
			return oldFiles;
		} else {
			path = oldFiles[0].getParent();
		}
		
//		System.out.println("La longitud es: "+ longitud);
//		System.out.println("El directorio de trabajo es: "+ path);
		
			
		if (longitud < 2) {
			
			longitud =2;
		}
		
		try {
			
			//ficherosOrdenados = ordenarFicherosPorNombre(oldFiles);
			//System.out.println("El número de ficheros ordenados es: "+ficherosOrdenados.length);
			
			int indice = 1;
			for (File item : oldFiles) {
			
				//String pathi = item.getParent();
				//System.out.println("El path del fichero "+item.getAbsolutePath()+" es: "+ pathi);
				String nombre = item.getName().trim();
				nombre = nombre.replaceAll(".pdf", "");
				nombre = nombre.trim();
				int indiceEspacio = nombre.indexOf(" ");
				//System.out.println("El índice espacio es: "+indiceEspacio);
				String numeroString = null;
				String restoNombre = null;
				int id;
				numeroString = nombre.substring(0, indiceEspacio).trim();
				
				
				int numero = convertirEnNumero(numeroString);
				id = indice;
				numeroString = ""+id;
				
				if (numero < 0) {
					 
					 restoNombre = nombre.trim();
				} else {
					restoNombre = nombre.substring(indiceEspacio+1,nombre.length()).trim();
				}
				
				
				
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
				String nombreNormalizado = path+separador+prefijo+" "+restoNombre+".pdf";
				
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

	private int convertirEnNumero(String numeroString) {
		
		
		try {
			
			int numero = Integer.parseInt(numeroString);
			return numero;
			
		} catch (Exception e) {
			
			return -1;
		}
	}

	public File[] seleccionarFicherosEnDirectorio(String path) {
		
		File archivosEnDirectorio = new File(path);
		File[] files = archivosEnDirectorio.listFiles(new PdfFileFilter());
		File[] filesOrdered = ordenarFicherosPorNombre(files);
		return files;
	}
	
	public boolean crearDirectorio(String path) {
		
		try {
			
			File directorio = new File(path);
			
			if (directorio.exists()) {
				
				return true;
			} else {
				
				boolean resultado = directorio.mkdir();
				//System.out.println("El resultado de crear el directorio "+path+", ha sido: "+resultado);
				return resultado;
				
			}
			
			
		} catch (Exception e) {
			return false;
		}
		
	}

	public List<FicheroEntity> leerDirectorioYGenerarListaFicherosEntity(String directorioDeTrabajo) {
		
		File[] ficherosOrdenadosEnDirectorio = seleccionarFicherosEnDirectorio(directorioDeTrabajo);
		File[] ficherosNormalizados = renumerarFicheros(ficherosOrdenadosEnDirectorio);
		
		List<FicheroEntity> ficherosEntity = new ArrayList<FicheroEntity>();
		int paginaInicial = 0;
		int paginalFinal = 0;
		int acumuladoPaginas = 0;
		
		for (File item : ficherosNormalizados) {
			
			FicheroEntity entity = new FicheroEntity();
			entity.setFile(item);
			
			String nombreLargoConExtension = item.getName().trim();
			String nombreLargoSinExtension = nombreLargoConExtension.replace(".pdf", "").trim();
			int indiceDelPrimerEspacio = nombreLargoSinExtension.indexOf(" ");
			int indiceFichero = Integer.parseInt(nombreLargoSinExtension.substring(0, indiceDelPrimerEspacio).trim());
			
			entity.setId(indiceFichero);
			
			int indiceDelComentario = nombreLargoSinExtension.indexOf("#");
			
			if (indiceDelComentario < 0) {
				
				entity.setNombreCorto(nombreLargoSinExtension);
				entity.setComentarios("");
			} else {
				entity.setNombreCorto(nombreLargoSinExtension.substring(0,indiceDelComentario).trim());
				entity.setComentarios(nombreLargoSinExtension.substring(indiceDelComentario+1,nombreLargoSinExtension.length()));
			}
			
			OperacionesConPdf operacionesConPdf = new OperacionesConPdf();
			
			int numeroPaginasFichero = operacionesConPdf.obtenerNumeroPaginas(item);
			
			
			paginaInicial = paginalFinal+1;
			paginalFinal = paginalFinal+numeroPaginasFichero;
			
			entity.setNumeroPaginas(numeroPaginasFichero);
			entity.setPaginaInicial(paginaInicial);
			entity.setPaginaFinal(paginalFinal);
			
			ficherosEntity.add(entity);
//			System.out.println("==============================================================");
//			System.out.println("Fichero: "+ entity.getNombreCorto());
//			System.out.println("Número de páginas del fichero: "+ numeroPaginasFichero);
//			System.out.println("Página inicial del fichero: "+ entity.getPaginaInicial());
//			System.out.println("Página final del fichero: "+entity.getPaginaFinal());
//			System.out.println("==============================================================");
			
		}
		
		return ficherosEntity;
	}

	
	
}

