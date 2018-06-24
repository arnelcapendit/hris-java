package com.asdi.hris.leave.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import com.asdi.hris.db.DBManager;
import com.asdi.hris.leave.dao.LeavesDao;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.model.Leaves;

public class LeavesDaoImpl implements LeavesDao {

	private static final String TABLENAME = "tbl_leaves";

	private DBManager dbManager;

	public LeavesDaoImpl() {
		dbManager = DBManager.getInstance();
	}

	public Leaves find(Leaves obj) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Leaves leaves = null;
		StringBuilder sql = new StringBuilder("Select * from ");
		sql.append(TABLENAME).append(" WHERE userid = ? and leave_type_id = ?");
		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getUserId());
			ps.setInt(2, obj.getLeaveTypeId());

			rs = ps.executeQuery();
			if (rs.next()) {
				leaves = new Leaves(rs.getInt("userid"));
				leaves.setLeaveTypeId(rs.getInt("leave_type_id"));
				leaves.setRemaining(rs.getInt("remaining_leaves"));
			}
		} catch (Exception e) {
			System.out.println("LeavesDaoImpl find(Leaves obj) error : " + e
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
		return leaves;
	}

	public Collection<Leaves> list(Leaves obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Leaves obj) {
		// TODO Auto-generated method stub

	}

	public void update(Leaves obj) {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("UPDATE ").append(TABLENAME)
				.append(" SET ");
		sql.append("remaining_leaves = ?");
		sql.append(" WHERE userid = ? and leave_type_id = ? ");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getRemaining());
			ps.setInt(2, obj.getUserId());
			ps.setInt(3, obj.getLeaveTypeId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("LeavesDaoImpl update(Leaves obj) error : " + e
					+ " : " + ps);
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

	public int insert(Leaves obj) {
		return 0;

	}

	public void delete(Leaves obj) {
		// TODO Auto-generated method stub

	}

}
