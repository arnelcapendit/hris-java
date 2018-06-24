package com.asdi.hris.leave.manager;

import java.util.Map;

import com.asdi.hris.leave.dao.LeaveTypesDao;
import com.asdi.hris.leave.dao.impl.LeaveTypesDaoImpl;
import com.asdi.hris.leave.model.LeaveType;

public class LeaveTypesManager {

	private static LeaveTypesManager manager;

	private Map<Integer, LeaveType> map;

	public LeaveTypesManager() {
		initialize();
	}

	public static LeaveTypesManager getInstance() {
		if (manager == null)
			manager = new LeaveTypesManager();

		return manager;
	}

	public void initialize() {
		LeaveTypesDao dao = new LeaveTypesDaoImpl();
		this.map = dao.getLeaveTypes();
	}

	public Map<Integer, LeaveType> getMap() {
		return map;
	}

	public void setMap(Map<Integer, LeaveType> map) {
		this.map = map;
	}

	public LeaveType getType(int id) {
		return this.map.get(id);
	}

	public LeaveType getType(String type) {
		for (Map.Entry<Integer, LeaveType> entry : map.entrySet()) {
			if (entry.getValue().getType().equalsIgnoreCase(type))
				return entry.getValue();
		}
		
		return null;
	}
}
