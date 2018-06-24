package com.asdi.hris.leave.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.db.DBManager;
import com.asdi.hris.leave.constant.Type;
import com.asdi.hris.leave.dao.LeaveApplicationDao;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;
import com.asdi.hris.leave.model.LeaveApplication;

public class LeaveAppplicationDaoImpl implements LeaveApplicationDao {

	private static final String TABLENAME = "tbl_leave_applications";

	private DBManager dbManager;

	public LeaveAppplicationDaoImpl() {
		dbManager = DBManager.getInstance();
	}

	public LeaveApplication find(LeaveApplication obj) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		LeaveApplication leaveApplication = null;
		StringBuilder sql = new StringBuilder("Select * from ");
		sql.append(TABLENAME).append(" WHERE id = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				leaveApplication = new LeaveApplication(rs.getInt("id"),
						rs.getInt("userid"));
				leaveApplication.setEndDate(rs.getString("leave_end_date"));
				leaveApplication.setFiledDate(rs.getString("leave_filed_date"));
				leaveApplication.setStartDate(rs.getString("leave_start_date"));
				leaveApplication.setReasonForCancelation(rs
						.getString("reason_for_cancelation"));
				leaveApplication.setReasonForDisapproval(rs
						.getString("reason_for_disapproval"));
				leaveApplication.setReasonForLeave(rs
						.getString("reason_for_leave"));
				leaveApplication.setStatus(Status.valueOf(rs.getString(
						"leave_status").toUpperCase()));
				//leaveApplication.setType(rs.getString("leave_type"));
				leaveApplication.setTypeId(rs.getInt("leave_type_id"));
			}

		} catch (Exception e) {
			System.out
					.println("LeaveAppplicationDaoImpl find(LeaveApplication obj) error : "
							+ e + " : " + ps);
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
		return leaveApplication;
	}

	public Collection<LeaveApplication> list(LeaveApplication obj) {
		ArrayList<LeaveApplication> arr = new ArrayList<LeaveApplication>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		StringBuilder sql = new StringBuilder("Select * from ").append(
				TABLENAME).append(" WHERE 1=1 ");

		if (0 != obj.getUserId())
			sql.append(" and userid = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			if (0 != obj.getUserId())
				ps.setInt(1, obj.getUserId());
			rs = ps.executeQuery();
			while (rs.next()) {
				LeaveApplication leaveApplication = new LeaveApplication(
						rs.getInt("id"), rs.getInt("userid"));
				leaveApplication.setEndDate(rs.getString("leave_end_date"));
				leaveApplication.setFiledDate(rs.getString("leave_filed_date"));
				leaveApplication.setStartDate(rs.getString("leave_start_date"));
				leaveApplication.setReasonForCancelation(rs
						.getString("reason_for_cancelation"));
				leaveApplication.setReasonForDisapproval(rs
						.getString("reason_for_disapproval"));
				leaveApplication.setReasonForLeave(rs
						.getString("reason_for_leave"));
				leaveApplication.setStatus(Status.valueOf(rs.getString(
						"leave_status").toUpperCase()));
				//leaveApplication.setType(rs.getString("leave_type"));
				leaveApplication.setTypeId(rs.getInt("leave_type_id"));
				arr.add(leaveApplication);
			}

		} catch (Exception e) {
			System.out
					.println("LeaveAppplicationDaoImpl list(LeaveApplication obj) error : "
							+ e + " : " + ps);
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
		return arr;
	}

	public void update(LeaveApplication obj) {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("UPDATE ").append(TABLENAME)
				.append(" SET ");
		sql.append("userid = ?, leave_type_id = ?, reason_for_leave = ?, leave_status = ?, reason_for_cancelation = ?");
		sql.append(",reason_for_disapproval = ?, leave_filed_date = ?, leave_start_date = ?, leave_end_date = ?");
		sql.append(" WHERE id = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getUserId());
			ps.setInt(2, obj.getTypeId());
			ps.setString(3, obj.getReasonForLeave());
			ps.setString(4, obj.getStatus().toString());
			ps.setString(5, obj.getReasonForCancelation());
			ps.setString(6, obj.getReasonForDisapproval());
			ps.setString(7, obj.getFiledDate());
			ps.setString(8, obj.getStartDate());
			ps.setString(9, obj.getEndDate());
			ps.setInt(10, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out
					.println("LeaveAppplicationDaoImpl update(LeaveApplication obj) error : "
							+ e + " : " + ps);
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

	public int insert(LeaveApplication obj) throws LeaveApplicationSQLException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(TABLENAME);
		sql.append("(userid, leave_type_id, reason_for_leave, leave_status, reason_for_cancelation");
		sql.append(",reason_for_disapproval, leave_filed_date, leave_start_date, leave_end_date)");
		sql.append(" VALUES(?,?,?,?,?");
		sql.append(",?,?,?,?)");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getUserId());
			ps.setInt(2, obj.getTypeId());
			ps.setString(3, obj.getReasonForLeave());
			ps.setString(4, obj.getStatus().toString());
			ps.setString(5, obj.getReasonForCancelation());
			ps.setString(6, obj.getReasonForDisapproval());
			ps.setString(7, obj.getFiledDate());
			ps.setString(8, obj.getStartDate());
			ps.setString(9, obj.getEndDate());
			return ps.executeUpdate();
		} catch (Exception e) {
			throw new LeaveApplicationSQLException(
					"LeaveAppplicationDaoImpl insert(LeaveApplication obj) error : "
							+ e + " : " + ps);
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

	public void delete(LeaveApplication obj) {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("DELETE FROM ").append(TABLENAME);

		sql.append(" WHERE id = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			System.out
					.println("LeaveAppplicationDaoImpl delete(LeaveApplication obj) error : "
							+ e + " : " + ps);
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
