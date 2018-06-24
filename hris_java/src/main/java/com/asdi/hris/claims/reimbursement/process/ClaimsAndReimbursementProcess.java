package com.asdi.hris.claims.reimbursement.process;

import com.asdi.hris.claims.reimbursement.dao.ClaimsAndReimbursementApplicationDao;
import com.asdi.hris.claims.reimbursement.dao.ExpensesDao;
import com.asdi.hris.claims.reimbursement.dao.impl.ClaimsAndReimbursementDaoImpl;
import com.asdi.hris.claims.reimbursement.dao.impl.ExpensesDaoImpl;
import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.exception.JSONToStringException;

public abstract class ClaimsAndReimbursementProcess {

	protected Application application;

	protected ClaimsAndReimbursementApplicationDao claimsAndReimbursementApplicationDao;

	protected ExpensesDao expensesDao;

	public ClaimsAndReimbursementProcess(Application application) {
		this.application = application;

		claimsAndReimbursementApplicationDao = new ClaimsAndReimbursementDaoImpl();

		expensesDao = new ExpensesDaoImpl();
	}

	public abstract String processRequest() throws JSONToStringException,
			HRISException;

}
