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
import com.intellisoft.intellibusinessws.entities.inv.Numerica;
import com.intellisoft.intellibusinessws.entities.inv.ProductoNumerica;
import com.intellisoft.intellibusinessws.entities.inv.ValorEscalar;

public class DProductoNumerica <T> extends Data<T> {

	public DProductoNumerica(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public void loadRelations(List<ProductoNumerica> lstProdNumerica, String[] relations){
		List<Numerica> lstNumerica = new ArrayList<Numerica>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(ProductoNumerica.Relaciones.Numerica)) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstProdNumerica, (Object) on(ProductoNumerica.class).getNumerica());
				lstNumerica = getNumerica(llaves,relations);
			}
		i++;
		}
		
		if(relations.length > 0){
			if(lstNumerica.size()>0){
				for(ProductoNumerica productoNumerica : lstProdNumerica ){
					 productoNumerica.setNumerica((Numerica) selectFirst(lstNumerica,
							 having(on(Numerica.class).getId(), equalTo(productoNumerica.getNumerica()))));
				}
			}	
		}
	}
	
	public List<Numerica> getNumerica(List<Object> llaves,String[] relations){
		DNumerica<Numerica> data = new DNumerica<>(Numerica.class, connection);
		return data.listarLlave(llaves, "id");
	}
}
