package controller.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import function.bodef;
import function.fullcalendarf;
import function.lophocf;
import function.nguoidungf;
import model.fullcalendar;
import model.lophoc;
import model.nguoidung;
import model.pagehome;

/**
 * Servlet implementation class calendar
 */
@WebServlet("/calendar")
public class calendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	nguoidungf ngf = new nguoidungf();
	bodef bdf = new bodef();
	lophocf lh = new lophocf();
	fullcalendarf clf = new fullcalendarf();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	public calendar() {
		super();	// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		nguoidung nd = (nguoidung) session.getAttribute("login");
		java.util.List<lophoc> lhp = lh.getclassstd(nd.getManguoidung());
		java.util.List<pagehome> ph = bdf.loadhomepage(lhp);
		ArrayList<fullcalendar> cld = clf.getcalendar(ph);
		response.setCharacterEncoding("UTF8");
		response.setContentType("application/json");
		// Import gson-2.2.2.jar
		Gson gson = new Gson();
		String objectToReturn = gson.toJson(cld); // Convert List -> Json

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(objectToReturn);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
