package com.intellisoft.intellibusinessws.business;


import java.sql.Connection;
import java.sql.SQLException;

import com.intellisoft.intellibusinessws.data.Pool;

public class Business {

	protected Connection connection;

	public Business() throws Exception {
		this.connection = Pool.getConnectionSQL();
	}

	public Business(Connection conection) throws Exception {
		this.connection = conection;
	}

	public Connection getConexion() {
		return connection;
	}

	public void setConexion(Connection connection) {
		this.connection = connection;
	}

	public void openTransaction() throws SQLException {
		this.connection.setAutoCommit(false);
	}

	public void commitTransaction() throws SQLException {
		this.connection.commit();
	}

	public void rollBackTransaction() throws SQLException {
		this.connection.rollback();
	}

	public void destroy() throws SQLException {
		this.connection.close();
	}

}
