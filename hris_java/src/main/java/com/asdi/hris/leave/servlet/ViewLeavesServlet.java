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
import com.asdi.hris.leave.exception.InsufficientLeaveException;
import com.asdi.hris.leave.exception.LeaveApplicationException;
import com.asdi.hris.leave.exception.LeaveApplicationSQLException;
import com.asdi.hris.leave.exception.NoDataFoundException;
import com.asdi.hris.leave.model.LeaveApplication;
import com.asdi.hris.leave.process.LeaveProcess;
import com.asdi.hris.leave.process.ViewProcess;
import com.asdi.hris.leave.process.factory.LeaveProcessFactory;
import com.asdi.hris.util.JSONUtil;

/**
 * Servlet implementation class ViewLeavesServlet
 */
@WebServlet("/leaves/view")
public class ViewLeavesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewLeavesServlet() {
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
		String userId = request.getParameter("user_id");
		String respMessage = "";
		int respCode = 0;
		String resp = "";
		try {
			LeaveApplication leaveApplication = new LeaveApplication(userId);
			LeaveProcess leaveProcess = LeaveProcessFactory.getProcess(
					Process.VIEW, leaveApplication);
			resp = leaveProcess.processRequest();
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
		} catch (NoDataFoundException e) {
			respCode = 406;
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
