package com.intellisoft.intellibusinessws.data.inv;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.inv.ImagenProducto;
import com.intellisoft.intellibusinessws.entities.inv.Producto;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEscalar;
import com.intellisoft.intellibusinessws.entities.inv.ProductoNumerica;

public class DProducto<T> extends Data<T> {

	public DProducto(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public void loadRelations(List<Producto> lstProducto, String[] relations){
		List<Object> llaves = new ArrayList<Object>();
		List<ProductoEscalar> lsProductoEscalars = new ArrayList<ProductoEscalar>();
		List<ProductoNumerica> lstProductoNumerica = new ArrayList<ProductoNumerica>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(Producto.Relaciones.ProductoEscalar.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProducto, (Object) on(Producto.class).getId());	
				lsProductoEscalars = getProductoEscalar(llaves,relations);
			}else if (clase.equals(Producto.Relaciones.ProductoNumerica.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProducto, (Object) on(Producto.class).getId());	
				lstProductoNumerica = getProductoNumerica(llaves,relations);
			}
			if(relations.length>0){
				if (clase.equals(Producto.Relaciones.ProductoEscalar.name())) {
					if(lsProductoEscalars.size()>0){
						for(Producto producto : lstProducto){
							producto.setLstProductoEscalar((List<ProductoEscalar>) select(lsProductoEscalars, 
									having(on(ProductoEscalar.class).getProducto(), equalTo(producto.getId()))));
						}	
					}
				}else if (clase.equals(Producto.Relaciones.ProductoNumerica.name())) {
					if(lstProductoNumerica.size()>0){
						for(Producto producto : lstProducto){
							producto.setLstProductoNumerica((List<ProductoNumerica>) select(lstProductoNumerica, 
									having(on(ProductoNumerica.class).getProducto(), equalTo(producto.getId()))));
						}
					}
				}
			}
			i++;
		}
	}
	
	public List<ProductoEscalar> getProductoEscalar(List<Object> llaves,String[] relations){
		DProductoEscalar<ProductoEscalar> data = new DProductoEscalar<>(ProductoEscalar.class, connection);
		List<ProductoEscalar> lstProdEscalar = data.listarLlave(llaves, "producto");
		data.loadRelations(lstProdEscalar, new String[]{ProductoEscalar.Relaciones.ValorEscalar.name()});
		return lstProdEscalar;
	}
	
	public List<ProductoNumerica> getProductoNumerica(List<Object> llaves,String[] relations){
		DProductoNumerica<ProductoNumerica> data = new DProductoNumerica<>(ProductoNumerica.class, connection);
		List<ProductoNumerica> lstProdNum = data.listarLlave(llaves, "producto");
		data.loadRelations(lstProdNum, relations);
		return lstProdNum;
		
		
	}

}
