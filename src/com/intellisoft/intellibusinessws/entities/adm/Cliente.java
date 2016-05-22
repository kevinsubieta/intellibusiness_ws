package com.intellisoft.intellibusinessws.entities.adm;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Cliente extends Entity{
	@KeyField
	private int id;
	private String gcm;
	
	

	public Cliente() {
		super();
	}



	public Cliente(int id, String gcm) {
		super();
		this.id = id;
		this.gcm = gcm;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getGcm() {
		return gcm;
	}



	public void setGcm(String gcm) {
		this.gcm = gcm;
	}

	
	
	

}
