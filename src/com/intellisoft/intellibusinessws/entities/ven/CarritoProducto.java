package com.intellisoft.intellibusinessws.entities.ven;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;

public class CarritoProducto extends Entity{
	@KeyField
	private int cliente;
	@KeyField
	private int producto;
	private int cantidad;
	@Ignored
	private ProductoEmpresa productoEmpresa;
	
	
	public enum Relaciones {
		ProductoEmpresa
	}
	
	
	public CarritoProducto() {
		super();
	}

	

	public CarritoProducto(int cliente, int producto, int cantidad, ProductoEmpresa productoEmpresa) {
		super();
		this.cliente = cliente;
		this.producto = producto;
		this.cantidad = cantidad;
		this.productoEmpresa = productoEmpresa;
	}



	public int getCliente() {
		return cliente;
	}


	public void setCliente(int cliente) {
		this.cliente = cliente;
	}


	public int getProducto() {
		return producto;
	}


	public void setProducto(int producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public ProductoEmpresa getProductoEmpresa() {
		return productoEmpresa;
	}


	public void setProductoEmpresa(ProductoEmpresa productoEmpresa) {
		this.productoEmpresa = productoEmpresa;
	}

	
		

}
