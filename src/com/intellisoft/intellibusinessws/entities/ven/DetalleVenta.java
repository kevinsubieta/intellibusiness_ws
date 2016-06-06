package com.intellisoft.intellibusinessws.entities.ven;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class DetalleVenta extends Entity{
	@KeyField
	private long venta;
	@KeyField
	private int producto;
	private int cantidad;
	
	
	
	
	public DetalleVenta() {
		super();
	}

	public DetalleVenta(long venta, int producto, int cantidad) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public long getVenta() {
		return venta;
	}

	public void setVenta(long venta) {
		this.venta = venta;
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
	
}
