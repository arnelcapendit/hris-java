package com.asdi.hris.shiftandschedule.model;

public class ShiftAndScheduleObj {

	private int userId;

	private String startDate;

	private String endDate;

	private String startTime;

	private String endTime;

	private String days;

	public ShiftAndScheduleObj() {
		super();
	}

	public ShiftAndScheduleObj(int userId, String startDate, String endDate, String startTime, String endTime,
			String days) {
		super();
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.days = days;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "ShiftAndSchedule [userId=" + userId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", days=" + days + "]";
	}

}
