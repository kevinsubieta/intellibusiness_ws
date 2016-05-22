package com.intellisoft.intellibusinessws.data.adm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.adm.Cliente;

public class DCliente<T> extends Data<T> {

	public DCliente(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public boolean saveGCMClient(int id, String gcm){
		String query = String.format("INSERT INTO %s (id,gcm) VALUES (%s, %s)",this.tableName,id,gcm);
		return this.execute(query);
	}
	
	public boolean updateGCMClient(int id, String gcm){
		String query = String.format("UPDATE %s SET gcm = '%s' WHERE id = %s",this.tableName,gcm,id);
		return this.execute(query);
	}
	
	public boolean updateGCMClient2(Cliente cliente){
		return this.guardar(cliente);
	}
	
	
	public Cliente getClient(int id){
		String query = String.format("SELECT * from %s Where id = %s","adm_cliente",id);
		DCliente<Cliente> dCliente = new DCliente<Cliente>(Cliente.class,connection);
		List<Cliente> lst = (List<Cliente>) this.list(query);	
		return lst.size()>0 ? lst.get(0) : null;
	}
	
}


