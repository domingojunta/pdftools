package es.domingojunta.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import es.domingojunta.entities.ExpedienteEntity;

public class Configuracion {
	
	private String nombreFicheroPropiedades = "configuration.properties";
	private FileOutputStream out;
	private FileInputStream in;
	
	public ExpedienteEntity cargarConfiguracion() {
		
		Properties propiedades = new Properties();
		
		
		
		
		
		try {
			
			in = new FileInputStream(nombreFicheroPropiedades);
			
			if (in != null) {
				
				propiedades.load(in);
			} else {
				
				propiedades = inicializar();
				out = new FileOutputStream(nombreFicheroPropiedades);
				propiedades.store(out, nombreFicheroPropiedades);
			
			}
			
			return generarExpedienteEntityFromProperties(propiedades);
			
		} catch (Exception e) {
			
			propiedades = inicializar();
			try {
				out = new FileOutputStream(nombreFicheroPropiedades);
				propiedades.store(out, nombreFicheroPropiedades);
			} catch (Exception e2) {
				return generarExpedienteEntityFromProperties(propiedades);
			}
			
			return generarExpedienteEntityFromProperties(propiedades);
		}
	}
	
	public Properties inicializar() {
		
		Properties propiedades = new Properties();
		propiedades.put("rue","RECLAMAR EH1401 2021");
		propiedades.put("declarante", "");
		propiedades.put("consejeria", "Consejería de Hacienda y Financiación Europea");
		propiedades.put("organismo", "Agencia Tributaria de Andalucía");
		propiedades.put("unidad", "Gerencia Provincial de Córdoba");
		propiedades.put("logo", "images/logo.png");
		propiedades.put("unidadFirmante", "El Gerente Provincial");
		propiedades.put("nombreFirmante", "Domingo José Orta Pacheco");
		return propiedades;
	}
	
	public ExpedienteEntity generarExpedienteEntityFromProperties (Properties configuracionInicial) {
		
		ExpedienteEntity expedienteEntity = new ExpedienteEntity();
		expedienteEntity.setRue(configuracionInicial.getProperty("rue"));
		expedienteEntity.setConsejeria(configuracionInicial.getProperty("consejeria"));
		expedienteEntity.setUnidad(configuracionInicial.getProperty("unidad"));
		expedienteEntity.setOrganismo(configuracionInicial.getProperty("organismo"));
		expedienteEntity.setDeclarante(configuracionInicial.getProperty("declarante"));
		expedienteEntity.setLogo(configuracionInicial.getProperty("logo"));
		expedienteEntity.setUnidadFirmante(configuracionInicial.getProperty("unidadFirmante"));
		expedienteEntity.setNombreFirmante(configuracionInicial.getProperty("nombreFirmante"));
		
		return expedienteEntity;
	}
	
	public Properties generarPropertiesFromExpedienteEntity(ExpedienteEntity expedienteEntity) {
		
		Properties propiedades = new Properties();
		propiedades.put("rue",expedienteEntity.getRue());
		propiedades.put("declarante", expedienteEntity.getDeclarante());
		propiedades.put("consejeria", expedienteEntity.getConsejeria());
		propiedades.put("organismo", expedienteEntity.getOrganismo());
		propiedades.put("unidad", expedienteEntity.getUnidad());
		propiedades.put("logo", expedienteEntity.getLogo());
		propiedades.put("unidadFirmante", expedienteEntity.getUnidadFirmante());
		propiedades.put("nombreFirmante", expedienteEntity.getNombreFirmante());
		
		
		return propiedades;
	}
	
	public boolean actualizarArchivoProperties(Properties propiedades) {
		
		try {
			out = new FileOutputStream(nombreFicheroPropiedades);
			propiedades.store(out, nombreFicheroPropiedades);
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean actualizarArchivoProperties(ExpedienteEntity expedienteEntity) {
		
		Properties propiedades = generarPropertiesFromExpedienteEntity(expedienteEntity);
		boolean resultado = actualizarArchivoProperties(propiedades);
		return resultado;
		
	}
	
	

}
