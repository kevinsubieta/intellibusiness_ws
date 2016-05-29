package com.intellisoft.intellibusinessws.entities.inv;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class ImagenProducto extends Entity {
	@KeyField
	private int id;
	@KeyField
	private int producto;
	private String url;
	

	
	public ImagenProducto() {
		super();
	}
	public ImagenProducto(int id, int producto, String url) {
		super();
		this.id = id;
		this.producto = producto;
		this.url = url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
