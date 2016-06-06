package com.intellisoft.intellibusinessws.data.ven;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intellisoft.intellibusinessws.App;
import com.intellisoft.intellibusinessws.business.ven.BCarritoProducto;
import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.data.inv.DProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.mrk.Inbox;
import com.intellisoft.intellibusinessws.entities.mrk.Notificacion;
import com.intellisoft.intellibusinessws.entities.ven.CarritoProducto;

public class DCarritoProducto<T> extends Data<T> {

	public DCarritoProducto(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public List<CarritoProducto> getShopCart(int id){
		String query = String.format("select * from %s", this.tableName);
		List<CarritoProducto> lstCarrito = (List<CarritoProducto>)this.list(query);
		loadRelations(lstCarrito, new String[]{CarritoProducto.Relaciones.ProductoEmpresa.name()});
		return lstCarrito;
	}
	
	public void loadRelations(List<CarritoProducto> lstCarrito, String[] relations){
		List<ProductoEmpresa> lstProductEmp = new ArrayList<ProductoEmpresa>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(CarritoProducto.Relaciones.ProductoEmpresa.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstCarrito, (Object) on(CarritoProducto.class).getIdp());
			
				lstProductEmp = getProductosEmpresas(llaves,relations);
			}
		i++;
		}
		
		if(relations.length > 0){
			if(lstProductEmp.size()>0){
				for(CarritoProducto carrito : lstCarrito ){
					carrito.setProductoEmpresa((ProductoEmpresa) selectFirst(lstProductEmp, having(on(ProductoEmpresa.class).getId(), equalTo(carrito.getIdp()))));
				}
			}	
		}
	}
	
	public List<ProductoEmpresa> getProductosEmpresas(List<Object> llaves, String[] relations){
		DProductoEmpresa<ProductoEmpresa> data = new DProductoEmpresa<ProductoEmpresa>(ProductoEmpresa.class, connection);
		List<ProductoEmpresa> lstProductoEmpresas = data.listarLlave(llaves, "id");
		data.loadRelations(lstProductoEmpresas, new String[]{ProductoEmpresa.Relaciones.ImagenProducto.name()});
		return lstProductoEmpresas;
	}
	
	public List<CarritoProducto> deleteNotifications(List<CarritoProducto> newLstShop){
		List<CarritoProducto> newList = new ArrayList<CarritoProducto>();
		for (CarritoProducto carrito : newLstShop){
			String query = String.format("delete %s where idc=%s and idp=%s",this.tableName, carrito.getIdc(), carrito.getIdp());
			if(this.execute(query)){
				newList.add(carrito);
				}
		}
		return newList;
	}
	
	public boolean saveProductShopCart(int idc,int idp){
		String query = String.format("INSERT INTO %s VALUES ('%s',%s, %s)",this.tableName,Integer.toString(idc),
																						  Integer.toString(idp),
																						  App.getCurrentTime());
		return this.execute(query);
	}

}
