package com.intellisoft.intellibusinessws.entities.mrk;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class ProductoDescuento extends Entity{
	@KeyField
	private int producto;
	@KeyField
	private int descuento;
	@Ignored
	private Descuento insDescuento;
	
	public enum Relaciones{
		Descuento
	}
	
	public ProductoDescuento() {
		super();
	}

	public ProductoDescuento(int producto, int descuento, Descuento insDescuento) {
		super();
		this.producto = producto;
		this.descuento = descuento;
		this.insDescuento = insDescuento;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public Descuento getInsDescuento() {
		return insDescuento;
	}

	public void setInsDescuento(Descuento insDescuento) {
		this.insDescuento = insDescuento;
	}
	
	

}
