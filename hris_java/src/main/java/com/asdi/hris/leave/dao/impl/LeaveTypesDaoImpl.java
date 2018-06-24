package com.asdi.hris.leave.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;

import com.asdi.hris.db.DBManager;
import com.asdi.hris.leave.dao.LeaveTypesDao;
import com.asdi.hris.leave.model.LeaveType;
import com.asdi.hris.leave.model.Leaves;

public class LeaveTypesDaoImpl implements LeaveTypesDao {

	private static final String TABLENAME = "tbl_leave_types";

	private DBManager dbManager;

	public LeaveTypesDaoImpl() {
		dbManager = DBManager.getInstance();
	}

	@Override
	public Map<Integer, LeaveType> getLeaveTypes() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, LeaveType> map = new Hashtable<>();
		StringBuilder sql = new StringBuilder("Select * from ");
		sql.append(TABLENAME);
		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				LeaveType types = new LeaveType(rs.getInt("id"),
						rs.getString("leave_type"),
						rs.getInt("leaves_per_user"));

				map.put(rs.getInt("id"), types);
			}
		} catch (Exception e) {
			System.out.println("LeaveTypesDaoImpl getLeaveTypes() error : " + e
					+ " : " + ps);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}

}
