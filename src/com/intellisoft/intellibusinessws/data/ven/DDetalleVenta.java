package com.intellisoft.intellibusinessws.data.ven;

import java.math.BigDecimal;
import java.sql.Connection;

import com.intellisoft.intellibusinessws.App;
import com.intellisoft.intellibusinessws.data.Data;

public class DDetalleVenta<T> extends Data<T> {

	public DDetalleVenta(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public boolean saveDetailSale(long venta, int producto,int cantidad,BigDecimal precio,BigDecimal costo){
		String query = String.format("INSERT INTO %s VALUES(%s,%s,%s,%s,%s)", 
				this.tableName,venta,producto,cantidad,precio,costo);
		return this.execute(query);
	}
	


}
