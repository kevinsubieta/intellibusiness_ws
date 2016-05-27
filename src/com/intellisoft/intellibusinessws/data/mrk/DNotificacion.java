package com.intellisoft.intellibusinessws.data.mrk;

import java.sql.Connection;
import java.util.List;

import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.mrk.Inbox;
import com.intellisoft.intellibusinessws.entities.mrk.Notificacion;

public class DNotificacion<T> extends Data<T> {

	public DNotificacion(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public Notificacion getNotifications(int id){
		String query = String.format("select * from %s where id=%s" ,this.tableName,id);
		List<Notificacion> lstNotification = (List<Notificacion>)this.list(query);
		return lstNotification.size()>0 ? lstNotification.get(0) : null; 
	}

}
