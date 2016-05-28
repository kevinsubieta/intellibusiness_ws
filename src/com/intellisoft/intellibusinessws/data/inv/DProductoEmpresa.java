package com.intellisoft.intellibusinessws.data.inv;

import java.sql.Connection;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.inv.ProductoEmpresa;

public class DProductoEmpresa<T> extends Data<T>{

	public DProductoEmpresa(Class type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public List<ProductoEmpresa> prueba(String query){
		return (List<ProductoEmpresa>) this.list(query);	
		}

}
