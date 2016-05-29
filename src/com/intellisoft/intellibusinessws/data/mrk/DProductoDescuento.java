package com.intellisoft.intellibusinessws.data.mrk;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.mrk.Descuento;
import com.intellisoft.intellibusinessws.entities.mrk.ProductoDescuento;
import com.intellisoft.intellibusinessws.entities.ven.CarritoProducto;

import sun.security.krb5.internal.crypto.Des;

public class DProductoDescuento<T> extends Data<T> {

	public DProductoDescuento(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public void loadRelations(List<ProductoDescuento>lstProdDesc, String[] relations){
		List<Descuento> lstDesc = new ArrayList<Descuento>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(ProductoDescuento.Relaciones.Descuento.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProdDesc, (Object) on(ProductoDescuento.class).getDescuento());
				lstDesc = getDescuentos(llaves,relations);
			}
		i++;
		}
		
		if(relations.length > 0){
			if(lstDesc.size()>0){
				for(ProductoDescuento prodDesc : lstProdDesc ){
					prodDesc.setInsDescuento(((Descuento) selectFirst(lstDesc, having(on(Descuento.class).getId(), equalTo(prodDesc.getDescuento())))));
				}
			}	
		}
	}
	
	public List<Descuento> getDescuentos(List<Object> llaves, String[] relations){
		DDescuento<Descuento> data = new DDescuento<>(Descuento.class, connection);
		return data.listarLlave(llaves, "id");
	}

}
