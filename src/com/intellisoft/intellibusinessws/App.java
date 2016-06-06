package com.intellisoft.intellibusinessws;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public class App {

	public static String name = "DVentos";
	public static String version = "1.0.2";

	//CONSTANTE PARA EL FORMATO DE FECHA
	public static final String FORMATO_DE_FECHA="dd-MM-yyyy";
	//CONSTANTE PARA EL FORMATO DE LA HORA
	public static final String FORMATO_DE_HORA="HH:mm:ss";
	public static String TIME_ZONE="GMT-4";
				
//	private static final Logger Log = Logger.getLogger(App.class);  ----
	
    //public static String urlConfiguracion = "/home/ec2-user/conf/configuration.properties";  
//	public static String urlConfiguracion = "C://dualbiz/checkIn/configuration.properties";
//	public static String urlConfiguracion = "/Users/alcidesleanos/Documents/Dualbiz/CheckIn/configuration.properties";
    public static String urlConfiguracion = "D://Config_IntelliBusiness";
	/**
	 * Metodo que carga los datos del archivo de configuracion de la aplicacion.
	 * @return Properties
	 */
//	private static Properties Configuracion() {
//		InputStream stream = null;
//		Properties properties = new Properties();
//		try {
//			stream = new FileInputStream(urlConfiguracion);
//			properties.load(stream);
//		} catch (IOException e) {
//			Log.error("No se pudo cargar el archivo properties en direccion:" + urlConfiguracion, e);
//		} finally {
//			if (stream != null) {
//				try {
//					stream.close();
//				} catch (IOException e) {
//					Log.error(e.getMessage(), e);
//				}
//			}
//		}
//		return properties;
//	}
//	
	public static Long getCurrentTime(){
		return Calendar.getInstance(TimeZone.getTimeZone(App.TIME_ZONE)).getTimeInMillis();
	}
	
	public static Date getCurrentDate(){
		return Calendar.getInstance(TimeZone.getTimeZone(App.TIME_ZONE)).getTime();
	}
//
//	private static Properties properties = App.Configuracion();
//
//	// PROPIEDADES DE LA BASE DE DATOS
//	public static String DATABASE_SERVER = properties.getProperty("db.server");
//	public static String DATABASE_PORT = properties.getProperty("db.port");
//	public static String DATABASE_NAME = properties.getProperty("db.name");
//	public static String DATABASE_USER = properties.getProperty("db.user");
//	public static String DATABASE_PASSWORD = properties.getProperty("db.password");
//
//	// PARAMETROS DE LA APP
//	public static Integer RADIOUS_COMPANY 			= Integer.parseInt(properties.getProperty("enterprise.radious"));
//	public static Integer RADIOUS_CLIENT 			= Integer.parseInt(properties.getProperty("client.radious"));
//	public static Integer TIME_CLIENT_DISCONNECT 	= Integer.parseInt(properties.getProperty("client.disconnect"));
//	
//	// PARA OBTENER LAS RUTAS DE LAS IMAGENES
//	public static String path_images_read = properties.getProperty("images.folder");
//	public static String path_images_write = properties.getProperty("images.folder");
//	public static String TIME_ZONE="GMT-4";
//	
//	public static String reloadConfigurations(){
//		InputStream stream = null;
//		Properties properties_aux = new Properties();
//		try {
//			stream = new FileInputStream(urlConfiguracion);
//			properties_aux.load(stream);
//			properties = properties_aux;
//			DATABASE_SERVER = properties.getProperty("db.server");
//			DATABASE_PORT = properties.getProperty("db.port");
//			DATABASE_NAME = properties.getProperty("db.name");
//			DATABASE_USER = properties.getProperty("db.user");
//			DATABASE_PASSWORD = properties.getProperty("db.password");
//
//			// PARAMETROS DE LA APP
//			RADIOUS_COMPANY 			= Integer.parseInt(properties.getProperty("enterprise.radious"));
//			RADIOUS_CLIENT 				= Integer.parseInt(properties.getProperty("client.radious"));
//			TIME_CLIENT_DISCONNECT 		= Integer.parseInt(properties.getProperty("client.disconnect"));
//			
//			return "Recarga de configuraciones exitosa.";
//		} catch (Exception e) {
//			Log.error("No se pudo cargar el archivo properties en direccion:" + urlConfiguracion, e);
//		} finally {
//			if (stream != null) {
//				try {
//					stream.close();
//				} catch (IOException e) {
//					Log.error(e.getMessage(), e);
//				}
//			}
//		}
//		return "Ocurrio un problema al recargar la configuraci�n.";
//	}
	
	
}