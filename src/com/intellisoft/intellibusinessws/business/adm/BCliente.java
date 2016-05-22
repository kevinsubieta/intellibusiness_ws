package com.intellisoft.intellibusinessws.business.adm;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.adm.DCliente;
import com.intellisoft.intellibusinessws.entities.adm.Cliente;

public class BCliente extends Business {

	public BCliente() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Boolean registerClient(int id, String gcm){
		DCliente<Cliente> dCliente = new DCliente<Cliente>(Cliente.class,connection);
		return	dCliente.saveGCMClient(id, gcm);
	}
	
	public Boolean updateClient(Cliente cliente){
		DCliente<Cliente> dCliente = new DCliente<Cliente>(Cliente.class,connection);
		return	dCliente.updateGCMClient(cliente.getId(), cliente.getGcm());
	}
	
	public Boolean updateClient2(Cliente cliente){
		DCliente<Cliente> dCliente = new DCliente<Cliente>(Cliente.class,connection);
		return	dCliente.updateGCMClient2(cliente);
	}

}
