package com.asdi.hris.leave.process;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ViewProcessTest {

	@Test
	public void test_processRequest_view() throws JsonProcessingException,
			InvalidIDException, JSONToStringException, HRISException {
		String response = new ViewProcess(new LeaveApplication(10, 1))
				.processRequest();
		System.out.println(response);
		assertTrue(!"".equals(response));
	}
}
