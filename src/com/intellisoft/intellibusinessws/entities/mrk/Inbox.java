package com.intellisoft.intellibusinessws.entities.mrk;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.Ignored;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Inbox extends Entity{
	@KeyField
	private int idc;
	@KeyField
	private int idn;
	@Ignored
	private Notificacion notification;
	
	
	public enum relaciones{
		Notificaciones
	}
	
	
	public Inbox() {
		super();
	}


	public Inbox(int idc, int idn, Notificacion notification) {
		super();
		this.idc = idc;
		this.idn = idn;
		this.notification = notification;
	}


	public int getIdc() {
		return idc;
	}


	public void setIdc(int idc) {
		this.idc = idc;
	}


	public int getIdn() {
		return idn;
	}


	public void setIdn(int idn) {
		this.idn = idn;
	}


	public Notificacion getNotification() {
		return notification;
	}


	public void setNotification(Notificacion notification) {
		this.notification = notification;
	}
	
	
}
