package com.intellisoft.intellibusinessws.data.adm;

import java.sql.Connection;
import java.util.List;

import com.intellisoft.intellibusinessws.business.adm.BUsuario;
import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.adm.Cliente;
import com.intellisoft.intellibusinessws.entities.adm.Usuario;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public class DUsuario<T> extends Data<T> {

	public DUsuario(Class<T> type, Connection connection) {
		super(type, connection);
	}
	
	public int registerUsuario(Usuario usuario){
		this.guardar(usuario);
		String query = String.format("SELECT TOP 1  id from adm_usuario order by id desc");
		List<Usuario> lst = (List<Usuario>) this.list(query);
		return lst.size()>0 ?	lst.get(0).getId() : null;
	}
	
	public Usuario validateUser(String userName, String password){
		//SELECT * from adm_usuario Where loggin = 'Kevin Subieta' and pass = '123'
		String query = String.format("SELECT * from %s Where loggin = '%s' and pass = '%s'",this.tableName,userName,password);
		List<Usuario> lst = (List<Usuario>) this.list(query);
		if(lst.size() >0){
			return lst.get(0);
		}
		return null;
	}
	
	


}
