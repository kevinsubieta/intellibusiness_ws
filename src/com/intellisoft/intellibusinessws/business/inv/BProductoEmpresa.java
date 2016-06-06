package com.intellisoft.intellibusinessws.business.inv;

import java.util.List;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.inv.DProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;

public class BProductoEmpresa extends Business{

	public BProductoEmpresa() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<ProductoEmpresa> getListNews(List<Integer> lstIndex){
		DProductoEmpresa<ProductoEmpresa> data = new DProductoEmpresa<ProductoEmpresa>(ProductoEmpresa.class,connection);
		return data.getProducts(lstIndex);
	}
	
	public ProductoEmpresa getListNews(int id){
		DProductoEmpresa<ProductoEmpresa> data = new DProductoEmpresa<ProductoEmpresa>(ProductoEmpresa.class,connection);
		return data.getProductByID(id);
	}
	
	public List<ProductoEmpresa> getListSuggestions(String name){
		DProductoEmpresa<ProductoEmpresa> data = new DProductoEmpresa<ProductoEmpresa>(ProductoEmpresa.class,connection);
		return data.getProductSuggestions(name);
	}

}
