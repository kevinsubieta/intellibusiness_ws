package com.intellisoft.intellibusinessws.business.adm;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.adm.DCliente;
import com.intellisoft.intellibusinessws.data.adm.DUsuario;
import com.intellisoft.intellibusinessws.entities.adm.Cliente;
import com.intellisoft.intellibusinessws.entities.adm.Usuario;

public class BUsuario extends Business {

	public BUsuario() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public enum relaciones {
		cliente
	}
	
	public int saveUsuario(Usuario usuario){
		DUsuario<Usuario> dUsuario = new DUsuario<Usuario>(Usuario.class, connection);	
		return dUsuario.registerUsuario(usuario);
	}
	
	public Usuario validateUser(String userName, String password){
		DUsuario<Usuario> dUsuario = new DUsuario<Usuario>(Usuario.class, connection);	
		DCliente<Cliente> dCliente = new DCliente<Cliente>(Cliente.class, connection);
		Usuario usuario = dUsuario.validateUser(userName, password);
		if(usuario!=null){
			usuario.setCliente(dCliente.getClient(usuario.getId()));
			return usuario;	
		}
		return null;
		
		
	}

}
