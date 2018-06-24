package com.asdi.hris.db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	private static DBManager dbManager;

	private static final String HOST = "asdidb.c7nlxjndftrf.ap-southeast-1.rds.amazonaws.com";

	private static final String DB = "db_asdi";

	private static final String USER = "asdi_db";

	private static final String PASSWORD = "asDI_1nstanc3";

	public DBManager() {
	}

	public static DBManager getInstance() {
		if (dbManager == null)
			dbManager = new DBManager();
		return dbManager;
	}

	public Connection getPooledConnection() {
		Connection con = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			// con =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/hris_module_3?user=burger&password=burgerP@55w0rd3");
			con = DriverManager.getConnection("jdbc:mysql://" + HOST + "/" + DB
					+ "?user=" + USER + "&password=" + PASSWORD);

		} catch (Exception e) {
			System.out.println("getConnection Not Connected : " + e);
		}
		return con;
	}
}
