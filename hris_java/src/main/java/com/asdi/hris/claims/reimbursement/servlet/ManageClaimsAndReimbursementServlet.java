package com.asdi.hris.claims.reimbursement.servlet;

import static com.asdi.hris.commons.constant.Process.MANAGE;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.claims.reimbursement.process.factory.ClaimsAndReimbursementProcessFactory;
import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.util.JSONUtil;

/**
 * Servlet implementation class ManageClaimsAndReimbursementServlet
 */
@WebServlet("/claims_and_reimbursement/manage")
public class ManageClaimsAndReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageClaimsAndReimbursementServlet() {
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
		String id = request.getParameter("cr_id");
		String userId = request.getParameter("user_id");
		String status = request.getParameter("status");
		String respMessage;
		int respCode;
		String resp;
		try {
			Application application = new Application(id, userId, status);

			resp = ClaimsAndReimbursementProcessFactory.getProcess(MANAGE,
					application).processRequest();

			response.getWriter().append(resp);

			return;
		} catch (InvalidIDException e) {
			respCode = 601;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (JSONToStringException e) {
			respCode = 602;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (HRISException e) {
			respCode = 603;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		}

		resp = JSONUtil.toJSONString(new JSONResponse(respCode, respMessage,
				Status.FAILED));
		response.getWriter().append(resp);
	}
}
