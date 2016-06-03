package com.intellisoft.intellibusinessws.data;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp.BasicDataSource;

import com.intellisoft.intellibusinessws.realstateapp.Constantes;


public class Pool {
	private static BasicDataSource dataSource = null;
	private transient static Connection connection = null;

//	public static Connection getConnection() throws Exception {
//		Configuration config = new Configuration();
//		String strUrl = "jdbc:mysql://" + config.get("db.server") + ":" + config.get("db.port") + "/" + config.get("db.name");
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		connection = DriverManager.getConnection(strUrl, config.get("db.user"), config.get("db.password"));
//		return connection;
//	}
	
	
	public static Connection getConnectionSQL() {
		  Connection conexionRemota = null;
		//  String strUrl = "jdbc:sqlserver://SERVER_DB\\DESARROLLO2012:49182; databaseName=bd_CruzimexBASE; user=sa; password=Desarrollo2012.;";
		   String strUrl = "jdbc:sqlserver://" + Constantes.DataBaseInfo.INSTANCE_NAME + ":" + Constantes.DataBaseInfo.DATABASE_PORT + 
				   "; databaseName=" + Constantes.DataBaseInfo.DATABASE_NAME + "; user="+ 
				   Constantes.DataBaseInfo.DATABASE_USER + "; password=" + Constantes.DataBaseInfo.DATABASE_PASSWORD;
		  

		  try {
		   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		   DriverManager.setLoginTimeout(10);
		   conexionRemota = DriverManager.getConnection(strUrl);

		  } catch (Exception e) {

		   e.printStackTrace();

		   return null;
		  }

		  return conexionRemota;
		 }

	public synchronized static Connection getConnectionPool() throws Exception {
		if (connection == null) {
			connection = dataSource.getConnection();
		} else {
			if (connection.isClosed()) {
				connection = dataSource.getConnection();
			}
		}
		return connection;
	}

}
