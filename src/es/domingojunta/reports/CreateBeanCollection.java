package es.domingojunta.reports;

import java.util.List;

import es.domingojunta.entities.FicheroEntity;
import es.domingojunta.tools.OperacionesConFicheros;

public class CreateBeanCollection {

	public static List<FicheroEntity> createBeanCollection() {
		
		String directorioDeTrabajo="C:\\Users\\domingo\\Documents\\pdf - copia";
		OperacionesConFicheros operacionesConFicheros = new OperacionesConFicheros();
		
		List<FicheroEntity> ficheros = operacionesConFicheros.leerDirectorioYGenerarListaFicherosEntity(directorioDeTrabajo);
		
		
		return ficheros;
	}
}
