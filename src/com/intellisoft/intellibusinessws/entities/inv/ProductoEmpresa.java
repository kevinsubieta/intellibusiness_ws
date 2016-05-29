package com.intellisoft.intellibusinessws.entities.inv;

import java.math.BigDecimal;
import java.util.List;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;
import com.intellisoft.intellibusinessws.entities.mrk.ProductoDescuento;

public class ProductoEmpresa extends Entity {
	@KeyField
	private int id;
	private int producto;
	private int empresa;
	private String nombre;
	private int cantidad;
	private BigDecimal precio;
	private int estado;
	private String detalle;
	private boolean oferta;
	
	@Ignored
	private List<ImagenProducto> lstImgProducto;
	@Ignored
	private List<ProductoDescuento> lstProductoDes;
	@Ignored
	private Producto insProducto;
	
	
	public ProductoEmpresa() {
		super();
	}

	public enum Relaciones{
		ImagenProducto, ProductoDescuento, Producto
	}

	public ProductoEmpresa(int id, int producto, int empresa, String nombre, int cantidad, BigDecimal precio,
			int estado, String detalle, boolean oferta, List<ImagenProducto> lstImgProducto,
			List<ProductoDescuento> lstProductoDes, Producto insProducto) {
		super();
		this.id = id;
		this.producto = producto;
		this.empresa = empresa;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.estado = estado;
		this.detalle = detalle;
		this.oferta = oferta;
		this.lstImgProducto = lstImgProducto;
		this.lstProductoDes = lstProductoDes;
		this.insProducto = insProducto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public boolean isOferta() {
		return oferta;
	}

	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}

	public List<ImagenProducto> getLstImgProducto() {
		return lstImgProducto;
	}

	public void setLstImgProducto(List<ImagenProducto> lstImgProducto) {
		this.lstImgProducto = lstImgProducto;
	}

	public List<ProductoDescuento> getLstProductoDes() {
		return lstProductoDes;
	}

	public void setLstProductoDes(List<ProductoDescuento> lstProductoDes) {
		this.lstProductoDes = lstProductoDes;
	}

	public Producto getInsProducto() {
		return insProducto;
	}

	public void setInsProducto(Producto insProducto) {
		this.insProducto = insProducto;
	}

	

}
