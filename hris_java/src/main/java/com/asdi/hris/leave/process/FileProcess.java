package com.asdi.hris.leave.process;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.constant.Action;
import com.asdi.hris.leave.exception.InsufficientLeaveException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.model.Leaves;
import com.asdi.hris.util.DateUtil;
import com.asdi.hris.util.JSONUtil;

public class FileProcess extends LeaveProcess {

	public FileProcess(LeaveApplication leaveApplication) {
		super(leaveApplication);
	}

	@Override
	public String processRequest() throws IllegalArgumentException,
			ParseException, InvalidIDException, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, JSONToStringException, HRISException {

		System.out.println("FileProcess : " + leaveApplication.toString());
		int userId = leaveApplication.getUserId();
		int numberOfDaysAbsence = leaveApplication.computeNumberOfDaysAbsence();
		int leaveTypeId = leaveApplication.getTypeId();
		Leaves leaves = new Leaves(userId);
		leaves.setLeaveTypeId(leaveTypeId);
		leaves = leavesDao.find(leaves);
		if (leaves == null)
			throw new NoDataFoundException(
					"No data found in tbl_leaves. userid : " + userId
							+ " leaveTypeId : " + leaveTypeId);

		System.out.println("FileProcess : " + leaves.toString());
		if (leaves.isSufficient(numberOfDaysAbsence)) {
			this.leaveApplication.setReasonForCancelation("");
			this.leaveApplication.setReasonForDisapproval("");
			this.leaveApplication.setStatus(Status.PENDING);
			this.leaveApplication.setFiledDate(DateUtil.getDateToday());
			leaveApplicationDao.insert(this.leaveApplication);
			leaves.updateRemainingLeaves(numberOfDaysAbsence, Action.APPROVE);
			leavesDao.update(leaves);

		} else {
			throw new InsufficientLeaveException("Insufficient leave.");
		}

		JSONResponse jsonResponse = new JSONResponse(200, "SUCCESS",
				Status.SUCCESS);

		return JSONUtil.toJSONString(jsonResponse);
	}
}
