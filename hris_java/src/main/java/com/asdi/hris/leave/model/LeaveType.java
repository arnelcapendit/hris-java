package com.asdi.hris.leave.model;


public class LeaveType {

	private final int id;

	private final String type;
	
	private final int leavePerUser;

	public LeaveType(int id, String type, int leavePerUser) {
		super();
		this.id = id;
		this.type = type;
		this.leavePerUser = leavePerUser;
	}

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public int getLeavePerUser() {
		return leavePerUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeaveTypes [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", leavePerUser=");
		builder.append(leavePerUser);
		builder.append("]");
		return builder.toString();
	}

}
