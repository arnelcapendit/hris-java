package com.asdi.hris.leave.dao;

import java.util.Map;

import com.asdi.hris.leave.model.LeaveType;

public interface LeaveTypesDao {

	public Map<Integer, LeaveType> getLeaveTypes(); 
}
