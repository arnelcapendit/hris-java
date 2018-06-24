package com.asdi.hris.claims.reimbursement.model;

import java.util.ArrayList;

import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.AbstractEntity;

public class Application extends AbstractEntity {

	private String applicationType;

	private String crType;

	private String status;

	private String purpose;

	private String dateFiled;

	private String periodStart;

	private String periodEnd;

	private ArrayList<ItemizedExpense> itemizedExpenses;

	public Application(int id, int userId) throws InvalidIDException {
		super(id, userId);
	}

	public Application(int userId) throws InvalidIDException {
		super(userId);
	}

	public Application(String id, String userId) throws InvalidIDException {
		super(id, userId);
	}

	public Application(String id, String userId, String status)
			throws InvalidIDException, ClaimsAndReimbursementException {
		super(id, userId);

		if (null == status || status.isEmpty())
			throw new ClaimsAndReimbursementException("crId : " + id
					+ " uid : " + userId + " Error : Null status");

		this.status = status.toUpperCase();
	}

	public Application(String userId) throws InvalidIDException {
		super(userId);
	}

	public Application(String userId, String applicationType, String crType,
			String purpose, String periodStart, String periodEnd,
			ArrayList<ItemizedExpense> itemizedExpenses)
			throws InvalidIDException {
		super(userId);
		this.applicationType = applicationType;
		this.crType = crType;
		this.purpose = purpose;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		this.itemizedExpenses = itemizedExpenses;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(String periodStart) {
		this.periodStart = periodStart;
	}

	public String getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(String periodEnd) {
		this.periodEnd = periodEnd;
	}

	public ArrayList<ItemizedExpense> getItemizedExpenses() {
		return itemizedExpenses;
	}

	public void setItemizedExpenses(ArrayList<ItemizedExpense> itemizedExpenses) {
		this.itemizedExpenses = itemizedExpenses;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getCrType() {
		return crType;
	}

	public void setCrType(String crType) {
		this.crType = crType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateFiled() {
		return dateFiled;
	}

	public void setDateFiled(String dateFiled) {
		this.dateFiled = dateFiled;
	}

}
