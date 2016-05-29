package com.intellisoft.intellibusinessws.entities.inv;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class ValorEscalar extends Entity {
	@KeyField
	private int id;
	@KeyField
	private int escalar;
	private String valor;
	@Ignored
	private Escalar insEscalar;
	
	public enum Relaciones{
		Escalar
	}
	
	public ValorEscalar() {
		super();
	}
	public ValorEscalar(int id, int escalar, String valor, Escalar insEscalar) {
		super();
		this.id = id;
		this.escalar = escalar;
		this.valor = valor;
		this.insEscalar = insEscalar;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEscalar() {
		return escalar;
	}
	public void setEscalar(int escalar) {
		this.escalar = escalar;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Escalar getInsEscalar() {
		return insEscalar;
	}
	public void setInsEscalar(Escalar insEscalar) {
		this.insEscalar = insEscalar;
	}
	
	
	
	
}
