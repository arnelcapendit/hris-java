package com.asdi.hris.leave.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.AbstractEntity;
import com.asdi.hris.leave.constant.Action;
import com.asdi.hris.leave.constant.Type;
import com.asdi.hris.leave.exception.LeaveApplicationException;
import com.asdi.hris.leave.manager.LeaveTypesManager;
import com.asdi.hris.util.DateUtil;

public class LeaveApplication extends AbstractEntity {

	private int typeId;

	private String type;

	private String reasonForLeave;

	private Status status;

	private String reasonForCancelation;

	private String reasonForDisapproval;

	private String filedDate;

	private String startDate;

	private String endDate;

	private Action action;

	public LeaveApplication(int id, int userId) throws InvalidIDException {
		super(id, userId);

	}

	public LeaveApplication(String userId) throws InvalidIDException {
		super(userId);
	}

	public LeaveApplication(int userId) throws InvalidIDException {
		super(userId);
	}

	public LeaveApplication(String userId, String leaveTypeId,
			String reasonForLeave, String startDate, String endDate)
			throws InvalidIDException, LeaveApplicationException,
			ParseException {
		super(userId);

		if (leaveTypeId == null || leaveTypeId.isEmpty())
			throw new LeaveApplicationException("Error : null leaveTypeId.");

		if (reasonForLeave == null || reasonForLeave.isEmpty())
			throw new LeaveApplicationException(
					"Error : null reason For Leave.");

		if (startDate == null || startDate.isEmpty())
			throw new LeaveApplicationException("Error : null start date.");

		if (endDate == null || endDate.isEmpty())
			throw new LeaveApplicationException("Error : null end date.");

		try {
			this.typeId = Integer.parseInt(leaveTypeId);
		} catch (Exception e) {
			throw new LeaveApplicationException("Error : Invalid leavetypeId. "
					+ leaveTypeId);
		}

		LeaveType leaveType = LeaveTypesManager.getInstance().getType(
				this.typeId);

		if (null == leaveType)
			throw new LeaveApplicationException("Error : Invalid leavetype "
					+ leaveTypeId);

		this.reasonForLeave = reasonForLeave;
		this.startDate = DateUtil.reformatDate(startDate);
		this.endDate = DateUtil.reformatDate(endDate);
		this.type = leaveType.getType();
	}

	public LeaveApplication(String id, String userId, String reason,
			Action action) throws InvalidIDException {
		super(id, userId);

		if (action == Action.DISAPPROVE) {
			this.reasonForDisapproval = reason;
			this.status = Status.DISAPPROVED;
		} else if (action == Action.CANCEL) {
			this.reasonForCancelation = reason;
			this.status = Status.CANCELED;
		} else {
			this.status = Status.APPROVED;
		}
		this.action = action;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReasonForLeave() {
		return reasonForLeave;
	}

	public void setReasonForLeave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getReasonForCancelation() {
		if (this.reasonForCancelation == null)
			return "";
		return reasonForCancelation;
	}

	public void setReasonForCancelation(String reasonForCancelation) {
		this.reasonForCancelation = reasonForCancelation;
	}

	public String getReasonForDisapproval() {
		if (this.reasonForDisapproval == null)
			return "";
		return reasonForDisapproval;
	}

	public void setReasonForDisapproval(String reasonForDisapproval) {

		this.reasonForDisapproval = reasonForDisapproval;
	}

	public String getFiledDate() {
		return filedDate;
	}

	public void setFiledDate(String filedDate) {
		this.filedDate = filedDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int computeNumberOfDaysAbsence() throws ParseException,
			IllegalArgumentException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = df.parse(this.startDate);
		Date endDate = df.parse(this.endDate);
		if (startDate.after(endDate)) {
			throw new IllegalArgumentException(
					"End date should be grater or equals to start date");
		}

		long startDateTime = startDate.getTime();
		long endDateTime = endDate.getTime();
		long milPerDay = 1000 * 60 * 60 * 24;

		int numOfDays = (int) ((endDateTime - startDateTime) / milPerDay);

		return (numOfDays + 1);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LeaveApplication [typeId=");
		builder.append(typeId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", reasonForLeave=");
		builder.append(reasonForLeave);
		builder.append(", status=");
		builder.append(status);
		builder.append(", reasonForCancelation=");
		builder.append(reasonForCancelation);
		builder.append(", reasonForDisapproval=");
		builder.append(reasonForDisapproval);
		builder.append(", filedDate=");
		builder.append(filedDate);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", action=");
		builder.append(action);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
