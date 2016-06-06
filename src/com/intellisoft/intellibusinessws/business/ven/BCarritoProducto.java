package com.intellisoft.intellibusinessws.business.ven;


import java.util.List;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.ven.DCarritoProducto;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.ven.CarritoProducto;

public class BCarritoProducto extends Business {

	public BCarritoProducto() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<CarritoProducto> getShopCart(int id){
		DCarritoProducto<CarritoProducto> dCarritoProducto = new DCarritoProducto<CarritoProducto>(CarritoProducto.class, connection);
		return dCarritoProducto.getShopCart(id);
	}
	
	public List<CarritoProducto> deleteNotifications(List<CarritoProducto> newLstShop){
		DCarritoProducto<CarritoProducto> dCarritoProducto = new DCarritoProducto<CarritoProducto>(CarritoProducto.class, connection);
		return dCarritoProducto.deleteNotifications(newLstShop);
	}
	
	public boolean addShopCart(int idc, int idp){
		DCarritoProducto<CarritoProducto> dCarritoProducto = new DCarritoProducto<CarritoProducto>(CarritoProducto.class, connection);
		return dCarritoProducto.saveProductShopCart(idc,idp);
	}
	


}
