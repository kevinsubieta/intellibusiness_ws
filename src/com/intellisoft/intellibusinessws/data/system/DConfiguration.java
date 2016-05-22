package com.intellisoft.intellibusinessws.data.system;

import java.sql.Connection;

import com.intellisoft.intellibusinessws.data.Data;

public class DConfiguration<T> extends Data<T> {

	public DConfiguration(Class<T> type, Connection connection) {
		super(type, connection);
	}
}
