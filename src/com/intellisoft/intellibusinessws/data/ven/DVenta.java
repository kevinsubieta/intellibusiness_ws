package com.intellisoft.intellibusinessws.data.ven;

import java.math.BigDecimal;
import java.sql.Connection;

import com.intellisoft.intellibusinessws.App;
import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.ven.Venta;

public class DVenta<T> extends Data<T> {

	public DVenta(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public long saveSale(int cliente, BigDecimal monto){
		String query = String.format("INSERT INTO %s VALUES(%s,%s,%s,0)", 
				this.tableName,cliente,App.getCurrentTime(),monto);
		if(this.execute(query)){
			String query2 = String.format("SELECT * FROM ven_venta ORDER BY(nro) desc");
			Venta venta =(Venta)this.list(query2).get(0);
			return venta.getNro();
		}
		return -1;
		
	}

}
