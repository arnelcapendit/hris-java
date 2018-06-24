package com.asdi.hris.shiftandschedule;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asdi.hris.exception.JSONToStringException;
import com.asdi.hris.shiftandschedule.dao.ShiftAndScheduleDao;
import com.asdi.hris.shiftandschedule.dao.impl.ShiftAndScheduleDaoImpl;
import com.asdi.hris.shiftandschedule.exceptions.DaysNullException;
import com.asdi.hris.shiftandschedule.model.JsonResponse;
import com.asdi.hris.shiftandschedule.model.ShiftAndScheduleObj;
import com.asdi.hris.shiftandschedule.process.Process;
import com.asdi.hris.util.JSONUtil;

/**
 * Servlet implementation class ShiftAndSchedule
 */
@WebServlet("/shifts_and_schedules/file")
public class ShiftAndSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShiftAndSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JSONToStringException {

		String schedules = request.getParameter("schedules");
		String times = request.getParameter("times");
		String id = request.getParameter("id");
		
		String resp = "";
		
		if (null == schedules || null == times || null == id) {
			resp = JSONUtil.toJSONString(new JsonResponse("FAILED"));
			response.getWriter().append(resp);
			throw new DaysNullException("SOME PARAMETERS CANNOT BE NULL");
		}
		
		String arrSchedules[] = schedules.split(",");
		String arrTimesp[] = times.split(",");
		String temp = "";
		String startSched = "";
		String endSched = "";
		String startTime = "";
		String endTime = "";
		String sDaysVal = "";
		

		ShiftAndScheduleDao sasd = ShiftAndScheduleDaoImpl.getInstance();
		ShiftAndScheduleObj saso = new ShiftAndScheduleObj();
		int iId = Integer.parseInt(id);
		saso.setUserId(iId);
		sasd.delete(saso);
		Process p = new Process();
		for (int i = 0; i < arrSchedules.length; i++) {
			temp = request.getParameter("day" + i);
			if (null == temp) {
				resp = JSONUtil.toJSONString(new JsonResponse("FAILED"));
				response.getWriter().append(resp);
				throw new DaysNullException("DAYS CANNOT BE NULL");
			}
			startSched = p.value(arrSchedules, 0, i, " - ");
			endSched = p.value(arrSchedules, 1, i, " - ");
			startTime = p.value(arrTimesp, 0, i, " - ");
			endTime = p.value(arrTimesp, 1, i, " - ");
			System.out.println(temp);
			sDaysVal = p.dayValue(temp);
			System.out.println("count[" + i + "] " + id + ", " + startSched + " - " + endSched + "," + startTime + " - "
					+ endTime + " " + sDaysVal);
			ShiftAndScheduleObj sas = new ShiftAndScheduleObj(iId, startSched, endSched, startTime, endTime, sDaysVal);
			sasd.insert(sas);
		}

		resp = JSONUtil.toJSONString(new JsonResponse("SUCCESS"));
		response.getWriter().append(resp);
	}

}
