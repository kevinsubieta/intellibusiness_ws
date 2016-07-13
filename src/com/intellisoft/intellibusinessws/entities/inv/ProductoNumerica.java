package com.intellisoft.intellibusinessws.entities.inv;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class ProductoNumerica extends Entity {
	@KeyField
	private int producto;
	@KeyField
	private int numerica;
	private double valor;
	@Ignored
	private Numerica insNumerica;
	
	public enum Relaciones{
		Numerica
	}
	
	public ProductoNumerica() {
		super();
	}

	public ProductoNumerica(int producto, int numerica, double valor, Numerica insNumerica) {
		super();
		this.producto = producto;
		this.numerica = numerica;
		this.valor = valor;
		this.insNumerica = insNumerica;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getNumerica() {
		return numerica;
	}

	public void setNumerica(int numerica) {
		this.numerica = numerica;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Numerica getInsNumerica() {
		return insNumerica;
	}

	public void setInsNumerica(Numerica insNumerica) {
		this.insNumerica = insNumerica;
	}

	

}
