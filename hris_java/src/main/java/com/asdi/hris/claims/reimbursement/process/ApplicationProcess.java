package com.asdi.hris.claims.reimbursement.process;

import java.util.ArrayList;

import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.claims.reimbursement.model.ItemizedExpense;
import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.util.DateUtil;
import com.asdi.hris.util.JSONUtil;

public class ApplicationProcess extends ClaimsAndReimbursementProcess {

	public ApplicationProcess(Application application) {
		super(application);
		// TODO Auto-generated constructor stub
	}

	public String processRequest() throws JSONToStringException, HRISException {

		if (this.application.getUserId() <= 0)
			throw new ClaimsAndReimbursementException("Invalid userId : "
					+ this.application.getUserId());

		this.application.setStatus(Status.PENDING.toString());

		this.application.setDateFiled(DateUtil.getDateToday());

		int crId = claimsAndReimbursementApplicationDao
				.insert(this.application);

		System.out.println("crId : " + crId);

		ArrayList<ItemizedExpense> arr = this.application.getItemizedExpenses();

		for (ItemizedExpense expense : arr) {
			expense.setCrId(crId);
			expensesDao.insert(expense);
		}

		JSONResponse jsonResponse = new JSONResponse(200, "SUCCESS",
				Status.SUCCESS);

		return JSONUtil.toJSONString(jsonResponse);
	}
}
