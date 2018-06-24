package com.asdi.hris.leave.process;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.dao.LeaveApplicationDao;
import com.asdi.hris.leave.dao.LeavesDao;
import com.asdi.hris.leave.dao.impl.LeaveAppplicationDaoImpl;
import com.asdi.hris.leave.dao.impl.LeavesDaoImpl;
import com.asdi.hris.leave.exception.InsufficientLeaveException;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class LeaveProcess {

	protected final LeaveApplication leaveApplication;

	protected LeavesDao leavesDao;

	protected LeaveApplicationDao leaveApplicationDao;

	public LeaveProcess(LeaveApplication leaveApplication) {
		super();
		this.leaveApplication = leaveApplication;

		leavesDao = new LeavesDaoImpl();

		leaveApplicationDao = new LeaveAppplicationDaoImpl();
	}

	public abstract String processRequest() throws IllegalArgumentException,
			ParseException, InvalidIDException, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, JsonProcessingException,
			JSONToStringException, HRISException;
}
