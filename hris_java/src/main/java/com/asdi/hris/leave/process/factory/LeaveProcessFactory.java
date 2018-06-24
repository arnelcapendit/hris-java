package com.asdi.hris.leave.process.factory;

import com.asdi.hris.commons.constant.Process;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.process.FileProcess;
import com.asdi.hris.leave.process.LeaveProcess;
import com.asdi.hris.leave.process.ManageProcess;
import com.asdi.hris.leave.process.ViewProcess;

public class LeaveProcessFactory {
	public LeaveProcessFactory() {
		// TODO Auto-generated constructor stub
	}

	public static LeaveProcess getProcess(Process process,
			LeaveApplication leaveApplication) {

		if (process == Process.FILE)
			return new FileProcess(leaveApplication);

		else if (process == Process.MANAGE)
			return new ManageProcess(leaveApplication);

		else if (process == Process.VIEW)
			return new ViewProcess(leaveApplication);

		else
			return null;
	}
}
