package com.intellisoft.intellibusinessws.business.ven;

import java.math.BigDecimal;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.ven.DVenta;
import com.intellisoft.intellibusinessws.entities.ven.Venta;

public class BVenta extends Business {

	public BVenta() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long saveSale(int cliente, BigDecimal monto){
		DVenta<Venta> dventa = new DVenta<Venta>(Venta.class, connection);
		return dventa.saveSale(cliente,monto);	
	}

}
