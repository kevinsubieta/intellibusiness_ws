package com.intellisoft.intellibusinessws.entities.ven;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;

public class CarritoProducto extends Entity{
	@KeyField
	private int idc;
	@KeyField
	private int idp;
	private long fecha;
	@Ignored
	private ProductoEmpresa productoEmpresa;
	
	
	public enum Relaciones {
		ProductoEmpresa
	}
	
	
	public CarritoProducto() {
		super();
	}


	public CarritoProducto(int idc, int idp, long fecha, ProductoEmpresa productoEmpresa) {
		super();
		this.idc = idc;
		this.idp = idp;
		this.fecha = fecha;
		this.productoEmpresa = productoEmpresa;
	}


	public int getIdc() {
		return idc;
	}


	public void setIdc(int idc) {
		this.idc = idc;
	}


	public int getIdp() {
		return idp;
	}


	public void setIdp(int idp) {
		this.idp = idp;
	}


	public long getFecha() {
		return fecha;
	}


	public void setFecha(long fecha) {
		this.fecha = fecha;
	}


	public ProductoEmpresa getProductoEmpresa() {
		return productoEmpresa;
	}


	public void setProductoEmpresa(ProductoEmpresa productoEmpresa) {
		this.productoEmpresa = productoEmpresa;
	}
	
	
	
	

}
