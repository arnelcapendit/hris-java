package com.asdi.hris.leave.model;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.asdi.hris.commons.exception.InvalidIDException;

public class LeaveApplicationTest {

	@Test
	public void test_getNumberOfDaysAbsence() throws InvalidIDException,
			ParseException {
		LeaveApplication leaveApplication = new LeaveApplication(1, 1);
		leaveApplication.setStartDate("2017-08-26");
		leaveApplication.setEndDate("2017-08-28");

		assertEquals(3, leaveApplication.computeNumberOfDaysAbsence());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getNumberOfDaysAbsence_exception() throws IllegalArgumentException, ParseException, InvalidIDException {
		LeaveApplication leaveApplication = new LeaveApplication(1, 1);
		leaveApplication.setStartDate("2017-08-29");
		leaveApplication.setEndDate("2017-08-28");

		leaveApplication.computeNumberOfDaysAbsence();
	}

}
