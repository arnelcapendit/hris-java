package com.asdi.hris.claims.reimbursement.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asdi.hris.claims.reimbursement.model.Application;
import com.asdi.hris.claims.reimbursement.model.ItemizedExpense;
import com.asdi.hris.claims.reimbursement.process.ApplicationProcess;
import com.asdi.hris.claims.reimbursement.process.factory.ClaimsAndReimbursementProcessFactory;
import com.asdi.hris.commons.constant.Process;
import com.asdi.hris.commons.constant.Status;
import com.asdi.hris.commons.exception.HRISException;
import com.asdi.hris.commons.exception.InvalidIDException;
import com.asdi.hris.commons.model.JSONResponse;
import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.util.JSONUtil;

/**
 * Servlet implementation class ClaimsAndReimbursementServlet
 */
@WebServlet("/claims_and_reimbursement/file")
public class ClaimsAndReimbursementApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClaimsAndReimbursementApplicationServlet() {
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

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			JSONToStringException {
		String applicationType = request.getParameter("application_type");
		String type = request.getParameter("type");
		String userId = request.getParameter("user_id");
		String purpose = request.getParameter("purpose_of_expense");
		String periodStart = request.getParameter("period_start");
		String periodEnd = request.getParameter("period_end");

		String[] dateArr = request.getParameterValues("expense_date");
		String[] descriptionArr = request.getParameterValues("description");
		String[] categoryArr = request.getParameterValues("category");
		String[] costArr = request.getParameterValues("cost");

		ArrayList<ItemizedExpense> itemizedExpenses = new ArrayList<>();

		for (int i = 0; i < dateArr.length; i++) {

			System.out.println(dateArr[i] + "," + descriptionArr[i] + ","
					+ categoryArr[i] + "," + costArr[i]);
			ItemizedExpense itemizedExpense = new ItemizedExpense(dateArr[i],
					descriptionArr[i], categoryArr[i], costArr[i]);
			itemizedExpenses.add(itemizedExpense);
		}

		String resp;
		String respMessage;
		int respCode;
		try {
			Application application = new Application(userId, applicationType,
					type, purpose, periodStart, periodEnd, itemizedExpenses);

			resp = ClaimsAndReimbursementProcessFactory.getProcess(
					Process.FILE, application).processRequest();

			response.getWriter().append(resp);
			return;

		} catch (InvalidIDException e) {
			respCode = 501;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (JSONToStringException e) {
			respCode = 502;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		} catch (HRISException e) {
			respCode = 503;
			respMessage = e.getMessage();
			System.out.println(e.getMessage());
		}

		resp = JSONUtil.toJSONString(new JSONResponse(respCode, respMessage,
				Status.FAILED));
		response.getWriter().append(resp);

	}

}
