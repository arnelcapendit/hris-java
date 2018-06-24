package com.asdi.hris.claims.reimbursement.process;

import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.util.JSONUtil;

public class ManageProcess extends ClaimsAndReimbursementProcess {

	public ManageProcess(Application application) {
		super(application);
	}

	@Override
	public String processRequest() throws JSONToStringException, HRISException {

		Application application = claimsAndReimbursementApplicationDao
				.find(this.application);

		if (null == application)
			throw new NoDataFoundException("No data found. cr id : "
					+ this.application.getId());

		application.setStatus(this.application.getStatus());

		claimsAndReimbursementApplicationDao.update(application);

		JSONResponse jsonResponse = new JSONResponse(200,
				"Updated Successfully", Status.SUCCESS);

		return JSONUtil.toJSONString(jsonResponse);
	}

}
