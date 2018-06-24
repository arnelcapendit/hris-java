package com.asdi.hris.commons.model;

import com.asdi.hris.commons.constant.Status;

public class JSONResponse {

	private final int responseCode;

	private final Object response;

	private final Status status;

	public JSONResponse(int responseCode, Object response, Status status) {
		super();
		this.responseCode = responseCode;
		this.response = response;
		this.status = status;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public Object getResponse() {
		return response;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JSONResponse [responseCode=");
		builder.append(responseCode);
		builder.append(", response=");
		builder.append(response);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
}
