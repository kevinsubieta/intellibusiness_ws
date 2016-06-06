package com.intellisoft.intellibusinessws.data.inv;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static ch.lambdaj.Lambda.select;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.data.mrk.DProductoDescuento;
import com.intellisoft.intellibusinessws.entities.inv.ImagenProducto;
import com.intellisoft.intellibusinessws.entities.inv.Producto;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.mrk.ProductoDescuento;
import com.intellisoft.intellibusinessws.entities.ven.CarritoProducto;
import com.sun.org.apache.bcel.internal.generic.Select;

public class DProductoEmpresa<T> extends Data<T>{

	public DProductoEmpresa(Class type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<ProductoEmpresa> getProducts(List<Integer> lstIndex){
		String index = lstIndex.toString();
		String query = String.format("select * from %s order by id desc",this.tableName);
		List<ProductoEmpresa> lstProductEmp = (List<ProductoEmpresa>)this.list(query);
		loadRelations(lstProductEmp, new String[]{ProductoEmpresa.Relaciones.ImagenProducto.name(),
												  ProductoEmpresa.Relaciones.ProductoDescuento.name(),
												  ProductoEmpresa.Relaciones.Producto.name()});
		return lstProductEmp;
		
	}
	
	public ProductoEmpresa getProductByID(int id){
		String query = String.format("select * from %s where id=%s",this.tableName,id);
		List<ProductoEmpresa> lstProductEmp = (List<ProductoEmpresa>)this.list(query);
		loadRelations(lstProductEmp, new String[]{ProductoEmpresa.Relaciones.ImagenProducto.name(),
												  ProductoEmpresa.Relaciones.ProductoDescuento.name(),
												  ProductoEmpresa.Relaciones.Producto.name()});
		return lstProductEmp.get(0);
		
	}
	
	public List<ProductoEmpresa> getProductSuggestions(String name){
		String query = String.format("SELECT TOP(5)* FROM %s WHERE nombre LIKE %s",this.tableName,"'"+name+"%'");
		return (List<ProductoEmpresa>) this.list(query);
	}
	
	
	public void loadRelations(List<ProductoEmpresa> lstProductoEmpresas, String[] relations){
		List<ImagenProducto> lstImagenProductos = new ArrayList<ImagenProducto>();
		List<ProductoDescuento> lstProductoDesc = new ArrayList<ProductoDescuento>();
		List<Producto> lstProducto = new ArrayList<Producto>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(ProductoEmpresa.Relaciones.ImagenProducto.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProductoEmpresas, (Object) on(ProductoEmpresa.class).getProducto());			
				lstImagenProductos = getImagenProductos(llaves,relations);
			} else if(clase.equals(ProductoEmpresa.Relaciones.ProductoDescuento.name())){
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProductoEmpresas, (Object) on(ProductoEmpresa.class).getProducto());
				lstProductoDesc = getProductosDesc(llaves,relations);
			}else if(clase.equals(ProductoEmpresa.Relaciones.Producto.name())){
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProductoEmpresas, (Object) on(ProductoEmpresa.class).getProducto());
				lstProducto = getProductos(llaves, relations);
			}
			i++;
			if(relations.length>0){
				if(clase.equals(ProductoEmpresa.Relaciones.ImagenProducto.name())){
					if(lstImagenProductos.size()>0){
						for(ProductoEmpresa productoEmpresa : lstProductoEmpresas ){
						productoEmpresa.setLstImgProducto((List<ImagenProducto>) select(lstImagenProductos, having(on(ImagenProducto.class).getProducto(), equalTo(productoEmpresa.getId()))));
					}
					}
				} else if(clase.equals(ProductoEmpresa.Relaciones.ProductoDescuento.name())){
					if(lstProductoDesc.size() > 0){
						for(ProductoEmpresa productoEmpresa : lstProductoEmpresas ){
							productoEmpresa.setLstProductoDes((List<ProductoDescuento>)select(lstProductoDesc, having(on(ProductoDescuento.class).getProducto(), equalTo(productoEmpresa.getId()))) );
						}
					}
				}else if(clase.equals(ProductoEmpresa.Relaciones.Producto.name())){
					if(lstProducto.size() > 0){
						for(ProductoEmpresa productoEmpresa : lstProductoEmpresas ){
							productoEmpresa.setInsProducto(((Producto)selectFirst(lstProducto, having(on(Producto.class).getId(), equalTo(productoEmpresa.getId())))));
						}
					}
				}
			}
		
		}
	}
	
	public List<ImagenProducto> getImagenProductos(List<Object> llaves,String[] relations){
		DImagenProducto<ImagenProducto> data = new DImagenProducto<ImagenProducto>(ImagenProducto.class, connection);
		return data.listarLlave(llaves,"producto");
	}
	
	public List<ProductoDescuento> getProductosDesc(List<Object> llaves,String[] relations){
		DProductoDescuento<ProductoDescuento> data = new DProductoDescuento<ProductoDescuento>(ProductoDescuento.class, connection);
		List<ProductoDescuento> lstProDesc = data.listarLlave(llaves,"producto");
		data.loadRelations(lstProDesc,new String[]{ProductoDescuento.Relaciones.Descuento.name()});
		return lstProDesc;
	}
	
	public List<Producto> getProductos(List<Object> llaves,String[] relations){
		DProducto<Producto> data = new DProducto<Producto>(Producto.class, connection);
		List<Producto> lstProductos = data.listarLlave(llaves, "id");
		data.loadRelations(lstProductos, new String[]{Producto.Relaciones.ProductoEscalar.name(),
														Producto.Relaciones.ProductoNumerica.name()});
		return lstProductos;
	}

}
