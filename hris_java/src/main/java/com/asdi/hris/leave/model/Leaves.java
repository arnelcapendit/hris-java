package com.asdi.hris.leave.model;

import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.AbstractEntity;
import com.asdi.hris.leave.constant.Action;

public class Leaves extends AbstractEntity {

	private int leaveTypeId;

	private int remaining;

	public Leaves(String id, String userId) throws InvalidIDException {
		super(id, userId);
	}

	public Leaves(int id, int userId) throws InvalidIDException {
		super(id, userId);
	}

	public Leaves(int userId) throws InvalidIDException {
		super(userId);
		// TODO Auto-generated constructor stub
	}

	public Leaves(String userId) throws InvalidIDException {
		super(userId);
		// TODO Auto-generated constructor stub
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public boolean isSufficient(int numberOfDaysAbsence) {
		if (this.remaining < numberOfDaysAbsence)
			return false;
		return true;
	}

	public void updateRemainingLeaves(int numberOfDaysAbsence, Action action) {
		if(action == Action.CANCEL || action == Action.DISAPPROVE) {
			this.remaining = remaining + numberOfDaysAbsence;
		} else {
			this.remaining = remaining - numberOfDaysAbsence;
		}
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Leaves [leaveTypeId=");
		builder.append(leaveTypeId);
		builder.append(", remaining=");
		builder.append(remaining);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
