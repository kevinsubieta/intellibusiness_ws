package com.intellisoft.intellibusinessws.ws;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.intellisoft.intellibusinessws.App;
import com.intellisoft.intellibusinessws.business.adm.BCliente;
import com.intellisoft.intellibusinessws.business.adm.BUsuario;
import com.intellisoft.intellibusinessws.business.mrk.BInbox;
import com.intellisoft.intellibusinessws.entities.Action;
import com.intellisoft.intellibusinessws.entities.adm.Cliente;
import com.intellisoft.intellibusinessws.entities.adm.Usuario;
import com.intellisoft.intellibusinessws.entities.mrk.Inbox;
import com.intellisoft.intellibusinessws.util.Log;

@Path("/Services")
public class Services {

	@GET()
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response services() {
		Log.info("Services");
		return Helper.response("Hola MODIFICADO, el servicio de " + App.name + " - " + App.version);
	}
			
	
	
	@POST()
	@Path("/Adm/Cliente/guardar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED + "; charset=UTF-8")
	public Response usertSave(@FormParam("user") String clienteNew) {
		Log.info("Registro de usuarios");
		BUsuario bUsuario = null;
		BCliente bCliente = null;
		try {
			bUsuario = new BUsuario();
			bCliente = new BCliente();
			Usuario usuario = new Usuario();
			Cliente cliente = new Cliente();
			usuario = new Gson().fromJson(clienteNew, Usuario.class);
			cliente= usuario.getCliente();
			usuario.setAction(Action.Insert);
			int id = bUsuario.saveUsuario(usuario);
			bCliente.registerClient(id, cliente.getGcm());
			usuario.setId(id);
			usuario.getCliente().setId(id);
			return Helper.response(usuario);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (bUsuario != null) {
				try {
					bUsuario.destroy();
				} catch (java.sql.SQLException e) {
					Log.error(e.getMessage());
				}
			}
		}
		return Helper.noResponse();	
	}
	
	
	@POST()
	@Path("/Adm/Cliente/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED + "; charset=UTF-8")
	public Response usertUpdateGCM(@FormParam("cliente") String clienteUpdate) {
		Log.info("Actualizacion de usuarios");
		BCliente bCliente = null;
		try {
			bCliente = new BCliente();
			Cliente cliente = new Cliente();
			cliente = new Gson().fromJson(clienteUpdate, Cliente.class);
			cliente.setAction(Action.Update);
			boolean notification =	bCliente.updateClient(cliente);
			return Helper.response(cliente);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (bCliente != null) {
				try {
					bCliente.destroy();
				} catch (java.sql.SQLException e) {
					Log.error(e.getMessage());
				}
			}
		}
		return Helper.noResponse();	
	}
	
	
	@GET()
	@Path("/Adm/Cliente/Validate/{userName}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response askUserRegister(@PathParam("userName") String userName,
									@PathParam("password") String password) {
		Log.info("Loggin users");
		BUsuario bUsuario = null;
		try {
			bUsuario = new BUsuario();
			Usuario notification = bUsuario.validateUser(userName, password);
			return Helper.response(notification);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		} finally {
			if (bUsuario != null) {
				try {
					bUsuario.destroy();
				} catch (SQLException e) {
					Log.error(e.getMessage());
				}
			}
		}
		return Helper.noResponse();
	}
	
	@GET()
	@Path("/Adm/Cliente/Notifications/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response askUserRegister(@PathParam("userId") int userId) {
		Log.info("Loggin users");
		BInbox bInbox = null;
		try {
			bInbox = new BInbox();
			List<Inbox> notification = bInbox.getInbox(userId);
			return Helper.response(notification);
		} catch (Exception e) {
			e.printStackTrace();
			Log.error(e.getMessage());
		} finally {
			if (bInbox != null) {
				try {
					bInbox.destroy();
				} catch (SQLException e) {
					Log.error(e.getMessage());
				}
			}
		}
		return Helper.noResponse();
	}
	
	
	
	@POST()
	@Path("/Adm/Cliente/DeleteNotifications")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED + "; charset=UTF-8")
	public Response deleteNotifications (@FormParam("lstInbox") String lstInbox) {
		Log.info("Actualizacion de usuarios");
		BInbox bInbox = null;
		try {
			bInbox = new BInbox();
			List<Inbox> newLstInbox = new ArrayList<Inbox>();
			newLstInbox = new Gson().fromJson(lstInbox, new TypeToken<ArrayList<Inbox>>(){}.getType());
			List<Inbox> notification =	bInbox.deleteNotifications(newLstInbox);
			return Helper.response(notification);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (bInbox != null) {
				try {
					bInbox.destroy();
				} catch (java.sql.SQLException e) {
					Log.error(e.getMessage());
				}
			}
		}
		return Helper.noResponse();	
	}



//	@GET()
//	@Path("/LoadConfigurations")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response loadConfigurations() {
//		Log.info("LoadConfigurations");
//		return Helper.response(App.reloadConfigurations());
//	}


}