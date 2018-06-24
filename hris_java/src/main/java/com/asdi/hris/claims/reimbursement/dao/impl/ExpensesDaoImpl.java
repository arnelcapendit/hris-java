package com.asdi.hris.claims.reimbursement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.asdi.hris.claims.reimbursement.dao.ExpensesDao;
import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.claims.reimbursement.exception.ItemizedExpenseException;
import com.asdi.hris.claims.reimbursement.model.ItemizedExpense;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.db.DBManager;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;

public class ExpensesDaoImpl implements ExpensesDao {

	private static final String TABLENAME = "tbl_expenses";

	private DBManager dbManager;

	public ExpensesDaoImpl() {
		dbManager = DBManager.getInstance();
	}

	@Override
	public ItemizedExpense find(ItemizedExpense obj) throws HRISException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemizedExpense expense = null;
		StringBuilder sql = new StringBuilder("Select * from ");
		sql.append(TABLENAME).append(" WHERE cr_id = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getCrId());
			rs = ps.executeQuery();
			if (rs.next()) {
				expense = new ItemizedExpense();
				expense.setId(rs.getInt("id"));
				expense.setCrId(rs.getInt("cr_id"));
				expense.setDate(rs.getString("expense_date"));
				expense.setDescription(rs.getString("description"));
				expense.setCategory(rs.getString("category"));
				expense.setCost(rs.getBigDecimal("cost"));
			}

		} catch (Exception e) {
			System.out.println("ItemizedExpense find(Application obj) error : "
					+ e + " : " + ps);

			throw new ItemizedExpenseException("Error : " + e + " : " + ps);
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
		return expense;
	}

	@Override
	public Collection<ItemizedExpense> list(ItemizedExpense obj)
			throws HRISException {
		ArrayList<ItemizedExpense> arr = new ArrayList<ItemizedExpense>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemizedExpense expense = null;
		StringBuilder sql = new StringBuilder("Select * from ");
		sql.append(TABLENAME).append(" WHERE cr_id = ?");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getCrId());
			rs = ps.executeQuery();
			if (rs.next()) {
				expense = new ItemizedExpense();
				expense.setId(rs.getInt("id"));
				expense.setCrId(rs.getInt("cr_id"));
				expense.setDate(rs.getString("expense_date"));
				expense.setDescription(rs.getString("description"));
				expense.setCategory(rs.getString("category"));
				expense.setCost(rs.getBigDecimal("cost"));
				arr.add(expense);
			}

		} catch (Exception e) {
			System.out.println("ItemizedExpense list(Application obj) error : "
					+ e + " : " + ps);

			throw new ItemizedExpenseException("Error : " + e + " : " + ps);
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
	public void update(ItemizedExpense obj)
			throws LeaveApplicationSQLException,
			ClaimsAndReimbursementException {
		// TODO Auto-generated method stub

	}

	@Override
	public int insert(ItemizedExpense obj) throws HRISException {
		Connection con = null;
		PreparedStatement ps = null;
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(TABLENAME);
		sql.append("(cr_id, expense_date, description, category, cost)");
		sql.append(" VALUES(?,?,?,?,?)");

		try {
			con = dbManager.getPooledConnection();
			ps = con.prepareStatement(sql.toString());
			ps.setInt(1, obj.getCrId());
			ps.setString(2, obj.getDate());
			ps.setString(3, obj.getDescription());
			ps.setString(4, obj.getCategory());
			ps.setBigDecimal(5, obj.getCost());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out
					.println("ItemizedExpense insert(ItemizedExpense obj) error : "
							+ e + " : " + ps);

			throw new ItemizedExpenseException("Error : " + e + " : "
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
	public void delete(ItemizedExpense obj)
			throws LeaveApplicationSQLException,
			ClaimsAndReimbursementException {
		// TODO Auto-generated method stub

	}

}
