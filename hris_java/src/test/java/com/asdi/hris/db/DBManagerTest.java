package com.asdi.hris.db;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DBManagerTest {

	@Test
	public void test() {
		Connection conn = DBManager.getInstance().getPooledConnection();
		assertTrue(conn != null);
	}

}
