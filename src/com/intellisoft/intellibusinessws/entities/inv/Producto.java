package com.intellisoft.intellibusinessws.entities.inv;

import java.util.List;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;
import com.intellisoft.intellibusinessws.entities.mrk.ProductoDescuento;

public class Producto extends Entity {
	@KeyField
	private int id;
	private String nombre;
	@Ignored
	private List<ProductoEscalar> lstProductoEscalar;	
	@Ignored
	private List<ProductoNumerica> lstProductoNumerica;

	public enum Relaciones{
		ProductoEscalar, ProductoNumerica
	}
	
	public Producto() {
		super();
	}

	public Producto(int id, String nombre, List<ProductoEscalar> lstProductoEscalar,
			List<ProductoNumerica> lstProductoNumerica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lstProductoEscalar = lstProductoEscalar;
		this.lstProductoNumerica = lstProductoNumerica;
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

	public List<ProductoEscalar> getLstProductoEscalar() {
		return lstProductoEscalar;
	}

	public void setLstProductoEscalar(List<ProductoEscalar> lstProductoEscalar) {
		this.lstProductoEscalar = lstProductoEscalar;
	}

	public List<ProductoNumerica> getLstProductoNumerica() {
		return lstProductoNumerica;
	}

	public void setLstProductoNumerica(List<ProductoNumerica> lstProductoNumerica) {
		this.lstProductoNumerica = lstProductoNumerica;
	}

	

}
