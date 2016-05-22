package com.intellisoft.intellibusinessws.business.system;


import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.system.DConfiguration;
import com.intellisoft.intellibusinessws.entities.system.Configuration;

public class BConfiguration extends Business {

	public BConfiguration() throws Exception {
		super();
	}

	public boolean save(Configuration entity) {
		DConfiguration<Configuration> data = new DConfiguration<Configuration>(Configuration.class, connection);
		return data.guardar(entity);
	}

}
