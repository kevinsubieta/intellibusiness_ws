package com.intellisoft.intellibusinessws.entities.inv;

import java.util.List;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class ProductoEscalar extends Entity{
	@KeyField
	private int producto;
	@KeyField
	private int escalar;
	@KeyField
	private int valorEscalar;
	@Ignored
	private List<ValorEscalar> insValorEscalar;
	
	
	public enum Relaciones{
		ValorEscalar
	}
	
	public ProductoEscalar() {
		super();
	}

	public ProductoEscalar(int producto, int escalar, int valorEscalar, List<ValorEscalar> insValorEscalar) {
		super();
		this.producto = producto;
		this.escalar = escalar;
		this.valorEscalar = valorEscalar;
		this.insValorEscalar = insValorEscalar;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getEscalar() {
		return escalar;
	}

	public void setEscalar(int escalar) {
		this.escalar = escalar;
	}

	public int getValorEscalar() {
		return valorEscalar;
	}

	public void setValorEscalar(int valorEscalar) {
		this.valorEscalar = valorEscalar;
	}

	public List<ValorEscalar> getInsValorEscalar() {
		return insValorEscalar;
	}

	public void setInsValorEscalar(List<ValorEscalar> insValorEscalar) {
		this.insValorEscalar = insValorEscalar;
	}

	

	
	
	
}
