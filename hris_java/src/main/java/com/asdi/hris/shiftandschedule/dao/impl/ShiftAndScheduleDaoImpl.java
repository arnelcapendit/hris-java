package com.asdi.hris.shiftandschedule.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.asdi.hris.db.DBManager;
import com.asdi.hris.shiftandschedule.dao.ShiftAndScheduleDao;
import com.asdi.hris.shiftandschedule.model.ShiftAndScheduleObj;

public class ShiftAndScheduleDaoImpl  implements ShiftAndScheduleDao  {
	
	private static final String TABLENAME = "tbl_shifts_and_schedules";

	private DBManager dbManager;

	private static ShiftAndScheduleDaoImpl sasdi;

	public ShiftAndScheduleDaoImpl() {
		dbManager = DBManager.getInstance();
	}
	
	public static ShiftAndScheduleDaoImpl getInstance(){
		if (null==sasdi){
			sasdi = new ShiftAndScheduleDaoImpl();
		}
		return sasdi;
	}
	
	public void insert(ShiftAndScheduleObj obj) {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(TABLENAME);
		sql.append("(userid, start_date, end_date, start_time, end_time, days)");
		sql.append(" VALUES(?,?,?,?,?,?)");
		

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getUserId());
			ps.setString(2, obj.getStartDate());
			ps.setString(3, obj.getEndDate());
			ps.setString(4, obj.getStartTime());
			ps.setString(5, obj.getEndTime());
			ps.setString(6, obj.getDays());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR : "+ e + " : " + ps);
		} finally {
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
	}

	public void delete(ShiftAndScheduleObj obj) {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("DELETE FROM ").append(TABLENAME);

		sql.append(" WHERE userid = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getUserId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR : "+ e + " : " + ps);
		} finally {
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
	}
}
