package es.domingojunta.entities;

public class ExpedienteEntity {

	private String rue;
	private String declarante;
	private String unidadFirmante;
	private String nombreFirmante;
	private String consejeria;
	private String organismo;
	private String unidad;
	private String logo;
	
	public ExpedienteEntity() {
	
		this.rue ="";
		this.declarante="";
		this.unidadFirmante="";
		this.nombreFirmante="";
		this.consejeria="";
		this.organismo="";
		this.unidad="";
		this.logo ="";
	}
	
	
	public String getRue() {
		return rue ;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getDeclarante() {
		return declarante;
	}
	public void setDeclarante(String declarante) {
		this.declarante = declarante;
	}
	public String getUnidadFirmante() {
		return unidadFirmante;
	}
	public void setUnidadFirmante(String unidadFirmante) {
		this.unidadFirmante = unidadFirmante;
	}
	public String getNombreFirmante() {
		return nombreFirmante;
	}
	public void setNombreFirmante(String nombreFirmante) {
		this.nombreFirmante = nombreFirmante;
	}


	public String getConsejeria() {
		return consejeria;
	}


	public void setConsejeria(String consejeria) {
		this.consejeria = consejeria;
	}
	
	


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	public String getOrganismo() {
		return organismo;
	}


	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	
}
