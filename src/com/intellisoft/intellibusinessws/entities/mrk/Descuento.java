package com.intellisoft.intellibusinessws.entities.mrk;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Descuento extends Entity {
	@KeyField
	private int id;
	private String descripcion;
	private long inicio;
	private long fin;
	private byte porcentaje;
	private boolean baja;
	
	
	
	public Descuento() {
		super();
	}

	public Descuento(int id, String descripcion, long inicio, long fin, byte porcentaje, boolean baja) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.inicio = inicio;
		this.fin = fin;
		this.porcentaje = porcentaje;
		this.baja = baja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getInicio() {
		return inicio;
	}

	public void setInicio(long inicio) {
		this.inicio = inicio;
	}

	public long getFin() {
		return fin;
	}

	public void setFin(long fin) {
		this.fin = fin;
	}

	public byte getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(byte porcentaje) {
		this.porcentaje = porcentaje;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	
	
	

}
