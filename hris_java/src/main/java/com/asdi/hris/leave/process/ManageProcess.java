package com.asdi.hris.leave.process;

import java.text.ParseException;

import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.constant.Action;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.model.Leaves;
import com.asdi.hris.util.JSONUtil;

public class ManageProcess extends LeaveProcess {

	public ManageProcess(LeaveApplication leaveApplication) {
		super(leaveApplication);
	}

	@Override
	public String processRequest() throws JSONToStringException,
			NoDataFoundException, HRISException, InvalidIDException,
			IllegalArgumentException, ParseException {

		LeaveApplication l = leaveApplicationDao.find(leaveApplication);
		
		if (l == null)
			throw new NoDataFoundException("No data found. employeeid : "
					+ leaveApplication.getUserId() + ", leave id : "
					+ leaveApplication.getId());
		
		System.out.println("ManageProcess : " + l.toString());

		if (leaveApplication.getAction() == Action.CANCEL
				|| leaveApplication.getAction() == Action.DISAPPROVE) {
			Leaves leaves = new Leaves(l.getUserId());
			leaves.setLeaveTypeId(l.getTypeId());
			leaves = leavesDao.find(leaves);
			System.out.println("ManageProcess : " + leaves.toString());
			leaves.updateRemainingLeaves(
					l.computeNumberOfDaysAbsence(),
					leaveApplication.getAction());
			leavesDao.update(leaves);
		}

		l.setReasonForCancelation(leaveApplication.getReasonForCancelation());

		l.setReasonForDisapproval(leaveApplication.getReasonForDisapproval());

		l.setStatus(leaveApplication.getStatus());

		leaveApplicationDao.update(l);

		JSONResponse jsonResponse = new JSONResponse(200, "SUCCESS",
				Status.SUCCESS);

		return JSONUtil.toJSONString(jsonResponse);
	}
}
