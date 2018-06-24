package com.asdi.hris.leave.exception;

import com.asdi.hris.commons.exception.HRISException;

@SuppressWarnings("serial")
public class InsufficientLeaveException extends HRISException {

	public InsufficientLeaveException() {
		// TODO Auto-generated constructor stub
	}

	public InsufficientLeaveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InsufficientLeaveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InsufficientLeaveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InsufficientLeaveException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
