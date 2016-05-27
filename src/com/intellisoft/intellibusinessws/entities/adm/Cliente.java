package com.intellisoft.intellibusinessws.entities.adm;

import java.util.List;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;
import com.intellisoft.intellibusinessws.entities.mrk.Notificacion;

public class Cliente extends Entity{
	@KeyField
	private int id;
	private String gcm;
	@Ignored
	private List<Notificacion> lstNotifications;
	
	

	public Cliente() {
		super();
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



	public List<Notificacion> getLstNotifications() {
		return lstNotifications;
	}



	public void setLstNotifications(List<Notificacion> lstNotifications) {
		this.lstNotifications = lstNotifications;
	}


	
	
	
	

}
