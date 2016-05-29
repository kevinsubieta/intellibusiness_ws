package com.intellisoft.intellibusinessws.data.inv;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.select;
import static ch.lambdaj.Lambda.selectFirst;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.inv.Producto;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEscalar;
import com.intellisoft.intellibusinessws.entities.inv.ValorEscalar;
import com.intellisoft.intellibusinessws.entities.ven.CarritoProducto;

public class DProductoEscalar<T> extends Data<T> {

	public DProductoEscalar(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public void loadRelations(List<ProductoEscalar> lstProducto, String[] relations){
		List<ValorEscalar> lstValorEscalar = new ArrayList<ValorEscalar>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(ProductoEscalar.Relaciones.ValorEscalar.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProducto, (Object) on(ProductoEscalar.class).getProducto());			
				lstValorEscalar = getValoresEscalares(llaves,relations);
			}
		i++;
		}
		
		if(relations.length > 0){
			if(lstValorEscalar.size()>0){
				for(ProductoEscalar productoEscalar : lstProducto ){
					productoEscalar.setInsValorEscalar((List<ValorEscalar>) select(lstValorEscalar, having(on(ValorEscalar.class).getId(), equalTo(productoEscalar.getProducto()))));
				}
			}	
		}
	}
	
	public List<ValorEscalar> getValoresEscalares (List<Object> llaves,String[] relations){
		DValorEscalar<ValorEscalar> data = new DValorEscalar<>(ValorEscalar.class, connection);
		List<ValorEscalar> lstValorEscalar = data.listarLlave(llaves, "id");
		data.loadRelations(lstValorEscalar, new String[]{ValorEscalar.Relaciones.Escalar.name()});
		return lstValorEscalar;
	}

}
