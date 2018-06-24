package com.asdi.hris.leave.process;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.junit.Test;

import com.asdi.hris.claims.reimbursement.exception.ClaimsAndReimbursementException;
import com.asdi.hris.commons.constant.Process;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.exception.InsufficientLeaveException;
import com.asdi.hris.leave.exception.LeaveApplicationException;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.process.factory.LeaveProcessFactory;
import com.fasterxml.jackson.core.JsonProcessingException;

public class FileProcessTest {

	@Test(expected = LeaveApplicationException.class)
	public void test_file_leave_invalid_input_processRequest()
			throws InvalidIDException, LeaveApplicationException,
			IllegalArgumentException, NoSuchMethodException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			JsonProcessingException, ParseException,
			InsufficientLeaveException, LeaveApplicationSQLException {

		new LeaveApplication("1", "", "gala", "2017-10-28", "2017-10-29");
	}

	@Test
	public void test_file_leave_processRequest() throws InvalidIDException,
			IllegalArgumentException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			InvocationTargetException, JsonProcessingException, ParseException,
			JSONToStringException, HRISException {

		LeaveApplication leaveApplication = new LeaveApplication("1",
				"Vacation Leave", "gala", "2017-10-28", "2017-10-29");
		String response = LeaveProcessFactory.getProcess(Process.FILE,
				leaveApplication).processRequest();

		assertEquals("OK", response);
	}

	@Test(expected = InsufficientLeaveException.class)
	public void test_file_leave_insufficient_processRequest()
			throws InvalidIDException, IllegalArgumentException, NoSuchMethodException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			JsonProcessingException, ParseException,
			JSONToStringException, HRISException {

		LeaveApplication leaveApplication = new LeaveApplication("1",
				"Vacation Leave", "gala", "2017-10-28", "2017-11-29");
		String response = LeaveProcessFactory.getProcess(Process.FILE,
				leaveApplication).processRequest();
		System.out.println(response);
	}

	@Test(expected = LeaveApplicationSQLException.class)
	public void test_file_leave_duplicate_entry_processRequest()
			throws InvalidIDException, IllegalArgumentException, NoSuchMethodException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			JsonProcessingException, ParseException,
			JSONToStringException, HRISException {

		LeaveApplication leaveApplication = new LeaveApplication("1",
				"Vacation Leave", "gala", "2017-10-28", "2017-10-29");
		String response = LeaveProcessFactory.getProcess(Process.FILE,
				leaveApplication).processRequest();
		System.out.println(response);
	}

}
