package com.asdi.hris.claims.reimbursement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.asdi.hris.claims.reimbursement.dao.ClaimsAndReimbursementApplicationDao;
import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.db.DBManager;

public class ClaimsAndReimbursementDaoImpl implements
		ClaimsAndReimbursementApplicationDao {

	private static final String TABLENAME = "tbl_claims_and_reimbursements";

	private DBManager dbManager;

	public ClaimsAndReimbursementDaoImpl() {
		dbManager = DBManager.getInstance();
	}

	@Override
	public Application find(Application obj) throws HRISException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Application application = null;
		StringBuilder sql = new StringBuilder("Select * from ").append(
				TABLENAME).append(" WHERE 1=1 ");

		if (0 != obj.getUserId())
			sql.append(" and userid = ?");

		else if (0 != obj.getId())
			sql.append(" and id = ?");

		try {
			con = dbManager.getPooledConnection();

			ps = con.prepareStatement(sql.toString());

			if (0 != obj.getUserId())
				ps.setInt(1, obj.getUserId());

			else if (0 != obj.getId())
				ps.setInt(1, obj.getId());

			rs = ps.executeQuery();

			if (rs.next()) {
				application = new Application(rs.getInt("id"),
						rs.getInt("userid"));
				application
						.setApplicationType(rs.getString("application_type"));
				application.setCrType(rs.getString("cr_type"));
				application.setPurpose(rs.getString("purpose_of_expense"));
				application.setDateFiled(rs.getString("date_filed"));
				application.setPeriodStart(rs.getString("period_start"));
				application.setPeriodEnd(rs.getString("period_end"));
				application.setStatus(rs.getString("cr_status"));
			}
			System.out
					.println("ClaimsAndReimbursementDaoImpl find(Application obj) "
							+ ps);
		} catch (Exception e) {
			System.out
					.println("ClaimsAndReimbursement find(Application obj) error : "
							+ e + " : " + ps);

			throw new ClaimsAndReimbursementException("Error : " + e + " : "
					+ ps);
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
		return application;
	}

	@Override
	public Collection<Application> list(Application obj) throws HRISException {
		ArrayList<Application> arr = new ArrayList<Application>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Application application = null;
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
				application = new Application(rs.getInt("id"),
						rs.getInt("userid"));
				application
						.setApplicationType(rs.getString("application_type"));
				application.setCrType(rs.getString("cr_type"));
				application.setPurpose(rs.getString("purpose_of_expense"));
				application.setDateFiled(rs.getString("date_filed"));
				application.setPeriodStart(rs.getString("period_start"));
				application.setPeriodEnd(rs.getString("period_end"));
				application.setStatus(rs.getString("cr_status"));
				arr.add(application);
			}
			System.out
					.println("ClaimsAndReimbursementDaoImpl list(Application obj) "
							+ ps);
		} catch (Exception e) {
			System.out
					.println("ClaimsAndReimbursement list(Application obj) error : "
							+ e + " : " + ps);

			throw new ClaimsAndReimbursementException("Error : " + e + " : "
					+ ps);
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

	@Override
	public void update(Application obj) throws HRISException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("UPDATE ").append(TABLENAME)
				.append(" SET ");
		sql.append("application_type = ?, cr_type = ?, purpose_of_expense = ?, date_filed = ?");
		sql.append(",period_start = ?, period_end = ?, cr_status = ?");
		sql.append(" WHERE id = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setString(1, obj.getApplicationType());
			ps.setString(2, obj.getCrType());
			ps.setString(3, obj.getPurpose());
			ps.setString(4, obj.getDateFiled());
			ps.setString(5, obj.getPeriodStart());
			ps.setString(6, obj.getPeriodEnd());
			ps.setString(7, obj.getStatus());
			ps.setInt(8, obj.getId());
			ps.executeUpdate();

			System.out
					.println("ClaimsAndReimbursementDaoImpl update(Application obj) "
							+ ps);
		} catch (Exception e) {
			System.out
					.println("ClaimsAndReimbursement update(Application obj) error : "
							+ e + " : " + ps);
			throw new ClaimsAndReimbursementException("Error : " + e + " : "
					+ ps);

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

	@Override
	public int insert(Application obj) throws HRISException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(TABLENAME);
		sql.append("(userid, application_type, cr_type, purpose_of_expense, date_filed");
		sql.append(",period_start, period_end, cr_status)");
		sql.append(" VALUES(?,?,?,?,?");
		sql.append(",?,?,?)");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, obj.getUserId());
			ps.setString(2, obj.getApplicationType());
			ps.setString(3, obj.getCrType());
			ps.setString(4, obj.getPurpose());
			ps.setString(5, obj.getDateFiled());
			ps.setString(6, obj.getPeriodStart());
			ps.setString(7, obj.getPeriodEnd());
			ps.setString(8, obj.getStatus());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				System.out
						.println("ClaimsAndReimbursement insert(Application obj)  : "
								+ ps);
				return rs.getInt(1);
			}

			return -1;
		} catch (Exception e) {
			System.out
					.println("ClaimsAndReimbursement insert(Application obj) error : "
							+ e + " : " + ps);

			throw new ClaimsAndReimbursementException("Error : " + e + " : "
					+ ps);
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

	@Override
	public void delete(Application obj) {
		// TODO Auto-generated method stub

	}

}
