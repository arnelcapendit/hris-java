package com.asdi.hris.claims.reimbursement.process;

import java.util.ArrayList;

import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.util.JSONUtil;

public class ViewProcess extends ClaimsAndReimbursementProcess {

	public ViewProcess(Application application) {
		super(application);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String processRequest() throws JSONToStringException, HRISException {

		ArrayList<Application> arr = (ArrayList<Application>) claimsAndReimbursementApplicationDao
				.list(this.application);

		if (arr.isEmpty())
			throw new NoDataFoundException("No data found. userId : "
					+ application.getUserId());

		JSONResponse jsonResponse = new JSONResponse(200, arr, Status.SUCCESS);

		return JSONUtil.toJSONString(jsonResponse);
	}

}
