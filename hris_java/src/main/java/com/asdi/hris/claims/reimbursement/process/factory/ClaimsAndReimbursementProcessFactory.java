package com.asdi.hris.claims.reimbursement.process.factory;

import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.claims.reimbursement.process.ApplicationProcess;
import com.asdi.hris.claims.reimbursement.process.ClaimsAndReimbursementProcess;
import com.asdi.hris.claims.reimbursement.process.ManageProcess;
import com.asdi.hris.claims.reimbursement.process.ViewExpenseProcess;
import com.asdi.hris.claims.reimbursement.process.ViewProcess;
import com.asdi.hris.commons.constant.Process;

public class ClaimsAndReimbursementProcessFactory {

	public static ClaimsAndReimbursementProcess getProcess(Process process,
			Application application) {

		switch (process) {

		case VIEW:
			return new ViewProcess(application);

		case VIEW_EXPENSE:
			return new ViewExpenseProcess(application);

		case FILE:
			return new ApplicationProcess(application);

		case MANAGE:
			return new ManageProcess(application);

		default:
			return null;
		}
	}

}
