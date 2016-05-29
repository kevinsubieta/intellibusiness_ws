package com.intellisoft.intellibusinessws.entities.inv;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Numerica extends Entity {
	@KeyField
	private int id;
	private String nombre;
	private String sufijo;
	private String abreviatura;
	
	public Numerica() {
		super();
	}

	public Numerica(int id, String nombre, String sufijo, String abreviatura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sufijo = sufijo;
		this.abreviatura = abreviatura;
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

	public String getSufijo() {
		return sufijo;
	}

	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	
	
}
