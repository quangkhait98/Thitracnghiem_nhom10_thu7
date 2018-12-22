package controller.student;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.bodef;
import function.cauhoif;
import model.cauhoi;
import model.nguoidung;
import model.pagehome;

@WebServlet("/XuLyBaiThi")
public class XuLyBaiThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyBaiThi() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String url = "";
		if (session != null) {
			nguoidung nd = (nguoidung) session.getAttribute("login");
			if (nd != null) {
				String quyen = nd.getQuyen();
				if (quyen.equals("student")) {

					url = "student";
				}
				if (quyen.equals("questionmanager")) {

					url = "questionmanager";
				}
				if (quyen.equals("exammanager")) {

					url = "exammanager";
				}
				if (quyen.equals("classmanager")) {
					url = "classmanager";
				}

			} else {
				url = "login.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession cauhoi = request.getSession(false);
		String maBode = (String)request.getParameter("mabd");
		cauhoi.setAttribute("mabode", maBode);
		cauhoif chf = new cauhoif();
		ArrayList<cauhoi> ch = chf.getquestionfrombode(maBode);
		bodef bdf = new bodef();
		pagehome pg = bdf.getdetails(maBode);
		cauhoi.setAttribute("questions", ch);
		cauhoi.setAttribute("clock", pg.getThoigianlambai());
		request.getRequestDispatcher("studentview.jsp").forward(request, response);	
	}
}
