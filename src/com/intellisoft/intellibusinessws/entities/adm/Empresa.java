package com.intellisoft.intellibusinessws.entities.adm;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Empresa extends Entity{
	@KeyField
	private int id;
	private String nombre;
	private String pais;
	private String correo;
	private String logo;
	
	
	
	public Empresa() {
		super();
	}

	public Empresa(int id, String nombre, String pais, String correo, String logo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.correo = correo;
		this.logo = logo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
	

}
