package com.intellisoft.intellibusinessws.business.ven;

import java.math.BigDecimal;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.ven.DDetalleVenta;
import com.intellisoft.intellibusinessws.entities.ven.DetalleVenta;

public class BDetalleVenta extends Business {

	public BDetalleVenta() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean saveDetailSale(long venta,int producto,int cantidad,BigDecimal precio,BigDecimal costo){
		DDetalleVenta<DetalleVenta> dDetalleVenta = new DDetalleVenta<DetalleVenta>(DetalleVenta.class, connection);
		return dDetalleVenta.saveDetailSale(venta, producto,cantidad,precio,costo);
		
	}

}
