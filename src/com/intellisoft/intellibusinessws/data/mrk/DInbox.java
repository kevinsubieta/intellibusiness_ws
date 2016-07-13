package com.intellisoft.intellibusinessws.data.mrk;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static org.hamcrest.Matchers.equalTo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;



import com.intellisoft.intellibusinessws.data.Data;
import com.intellisoft.intellibusinessws.entities.mrk.Inbox;
import com.intellisoft.intellibusinessws.entities.mrk.Notificacion;

public class DInbox <T> extends Data<T> {

	public DInbox(Class<T> type, Connection connection) {
		super(type, connection);
		// TODO Auto-generated constructor stub
	}
	
	public List<Inbox> getInbox(int idc){
		DNotificacion<T> dNotification = new DNotificacion<T>(type, connection);
		String query = String.format("select * from %s where idc = %s" , this.tableName, idc);
		List<Inbox> lstInbox = (List<Inbox>)this.list(query);
		loadRelations(lstInbox, new String[]{Inbox.relaciones.Notificaciones.name()});
		return lstInbox;
	} 
	
	public List<Inbox> deleteNotifications(List<Inbox> lstInbox){
		List<Inbox> newList = new ArrayList<Inbox>();
		for(Inbox inbox : lstInbox){
			String query = String.format("delete %s where idc=%s and idn=%s",this.tableName, inbox.getIdc(), inbox.getIdn());
			if(this.execute(query)){
				newList.add(inbox);
			}
		}
		return newList;
		
	}
	
	public void loadRelations(List<Inbox> lstInbox, String[] relations){
		List<Notificacion> lstnotif = new ArrayList<Notificacion>();
		List<Object> llaves = new ArrayList<Object>();
		int i = 0;
		for (String clase : relations) {
			if (clase.equals(Inbox.relaciones.Notificaciones.name())) {
				relations[i] = "";
				llaves.clear();
				llaves = extract(lstInbox, (Object) on(Inbox.class).getIdn());
			
				lstnotif = getNotifications(llaves,relations);
			}
		i++;
		}
		
		if(relations.length > 0){
			if(lstnotif.size()>0){
				for(Inbox inbox : lstInbox ){
					inbox.setNotification((Notificacion) selectFirst(lstnotif, having(on(Notificacion.class).getId(), equalTo(inbox.getIdn()))));
				}
			}
			
		}
		}
	
	public List<Notificacion> getNotifications(List<Object> llaves, String[] relations){
		DNotificacion <Notificacion> dNotification = new DNotificacion<Notificacion>(Notificacion.class,connection);
		return (List<Notificacion>) dNotification.listarLlave(llaves,"id");
	}
		
		
	

}
