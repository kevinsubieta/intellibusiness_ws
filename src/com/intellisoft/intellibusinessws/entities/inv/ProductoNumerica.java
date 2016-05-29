package com.intellisoft.intellibusinessws.entities.inv;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class ProductoNumerica extends Entity {
	@KeyField
	private int producto;
	@KeyField
	private int propiedadnumerica;
	private double valor;
	@Ignored
	private Numerica numerica;
	
	public enum Relaciones{
		Numerica
	}
	
	public ProductoNumerica() {
		super();
	}

	public ProductoNumerica(int producto, int propiedadnumerica, double valor, Numerica numerica) {
		super();
		this.producto = producto;
		this.propiedadnumerica = propiedadnumerica;
		this.valor = valor;
		this.numerica = numerica;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getPropiedadnumerica() {
		return propiedadnumerica;
	}

	public void setPropiedadnumerica(int propiedadnumerica) {
		this.propiedadnumerica = propiedadnumerica;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Numerica getNumerica() {
		return numerica;
	}

	public void setNumerica(Numerica numerica) {
		this.numerica = numerica;
	}
	
	
	
	

}
