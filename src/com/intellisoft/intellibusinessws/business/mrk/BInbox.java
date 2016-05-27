package com.intellisoft.intellibusinessws.business.mrk;

import java.util.List;

import com.intellisoft.intellibusinessws.business.Business;
import com.intellisoft.intellibusinessws.data.mrk.DInbox;
import com.intellisoft.intellibusinessws.entities.mrk.Inbox;
import com.intellisoft.intellibusinessws.entities.mrk.Notificacion;

public class BInbox extends Business {

	public BInbox() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Inbox> getInbox(int idc){
		DInbox<Inbox> data = new DInbox<>(Inbox.class, connection);
		return data.getInbox(idc);
	}
	
	public List<Inbox> deleteNotifications(List<Inbox> lstInboxForDel){
		DInbox<Inbox> data = new DInbox<>(Inbox.class, connection);
		return data.deleteNotifications(lstInboxForDel);
	}
	

}
