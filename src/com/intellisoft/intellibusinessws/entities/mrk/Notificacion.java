package com.intellisoft.intellibusinessws.entities.mrk;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Notificacion extends Entity {

	@KeyField
	private int id;
	private String texto;
	private String imagen;
	
	
	
	public Notificacion() {
		super();
	}



	public Notificacion(int id, String texto, String imagen) {
		super();
		this.id = id;
		this.texto = texto;
		this.imagen = imagen;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
	
	
	
}
