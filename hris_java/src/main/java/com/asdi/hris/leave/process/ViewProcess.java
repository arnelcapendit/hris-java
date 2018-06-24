package com.asdi.hris.leave.process;

import java.util.ArrayList;

import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.util.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ViewProcess extends LeaveProcess {

	public ViewProcess(LeaveApplication leaveApplication) {
		super(leaveApplication);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String processRequest() throws JsonProcessingException,
			InvalidIDException, JSONToStringException, HRISException {
		ArrayList<LeaveApplication> arr = (ArrayList<LeaveApplication>) leaveApplicationDao
				.list(this.leaveApplication);

		if (arr.isEmpty())
			throw new NoDataFoundException("No data found. employeeid : "
					+ leaveApplication.getUserId());

		JSONResponse jsonResponse = new JSONResponse(200, arr, Status.SUCCESS);

		return JSONUtil.toJSONString(jsonResponse);
	}
}
