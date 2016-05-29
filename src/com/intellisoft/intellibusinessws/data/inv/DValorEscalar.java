package com.intellisoft.intellibusinessws.data.inv;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.inv.Escalar;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEscalar;
import com.intellisoft.intellibusinessws.entities.inv.ValorEscalar;
import com.intellisoft.intellibusinessws.entities.mrk.Descuento;
import com.intellisoft.intellibusinessws.entities.mrk.ProductoDescuento;

public class DValorEscalar<T> extends Data<T> {

	public DValorEscalar(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}

	public void loadRelations(List<ValorEscalar> lstValorEscalar, String[] relations){
		List<Escalar> lstEscalar = new ArrayList<Escalar>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(ValorEscalar.Relaciones.Escalar.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstValorEscalar, (Object) on(ValorEscalar.class).getEscalar());
				lstEscalar = getEscalar(llaves,relations);
			}
		i++;
		}
		
		if(relations.length > 0){
			if(lstEscalar.size()>0){
				for(ValorEscalar valorEscalar : lstValorEscalar ){
					valorEscalar.setInsEscalar(((Escalar) selectFirst(lstEscalar, having(on(Escalar.class).getId(), equalTo(valorEscalar.getEscalar())))));
				}
			}	
		}
	}
	
	public List<Escalar> getEscalar(List<Object> llaves, String[] relations){
		DEscalar<Escalar> data = new DEscalar<>(Escalar.class, connection);
		return data.listarLlave(llaves, "id");
	}
	
}
