package com.asdi.hris.leave.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asdi.hris.commons.constant.Process;
import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.leave.constant.Action;
import com.asdi.hris.leave.exception.InsufficientLeaveException;
import com.asdi.hris.leave.exception.LeaveApplicationException;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.process.LeaveProcess;
import com.asdi.hris.leave.process.factory.LeaveProcessFactory;
import com.asdi.hris.util.JSONUtil;

/**
 * Servlet implementation class LeaveManagementServlet
 */
@WebServlet("/leaves/manage")
public class LeaveManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (JSONToStringException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			JSONToStringException {
		String action = request.getParameter("action");
		String reason = request.getParameter("reason");
		String leaveId = request.getParameter("leave_id");
		String userId = request.getParameter("user_id");
		String resp = "";
		String respMessage = "";
		int respCode = 0;
		try {
			LeaveApplication leaveApplication = new LeaveApplication(leaveId,
					userId, reason, Action.valueOf(action.toUpperCase()));

			resp = LeaveProcessFactory.getProcess(Process.MANAGE,
					leaveApplication).processRequest();
			response.getWriter().append(resp);
			return;
		} catch (InsufficientLeaveException e) {
			respCode = 401;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (LeaveApplicationSQLException e) {
			respCode = 402;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (InvalidIDException e) {
			respCode = 403;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			respCode = 405;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		}

		resp = JSONUtil.toJSONString(new JSONResponse(respCode, respMessage,
				Status.FAILED));
		response.getWriter().append(resp);

	}

}
