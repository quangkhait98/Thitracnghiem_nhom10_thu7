package controller.exammanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.bodef;
import function.cauhoif;
import model.bode;
import model.cauhoi;
import model.nguoidung;

@WebServlet("/XuLyDeThi")
public class XuLyDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public XuLyDeThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
					url = "questionlist.jsp";
				}
				if (quyen.equals("classmanager")) { 
					url = "classmanager";
				}

			} else {
				url = "login.jsp";
			}
		}
		HttpSession cauhoi = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<cauhoi> ch = (ArrayList<cauhoi>) cauhoi.getAttribute("listcauhoi");
		String q = request.getParameter("cauhoi");
		int thutu = Integer.parseInt(request.getParameter("thutu"));
		cauhoif chf = new cauhoif();
		cauhoi c = chf.getquestionfromid(q);
		ch.set(thutu, c);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession cauhoi = request.getSession();
		String maBoDe = (String) cauhoi.getAttribute("mabode");
		int sluong = (int) cauhoi.getAttribute("sluong");
		@SuppressWarnings("unchecked")
		ArrayList<cauhoi> ch = (ArrayList<cauhoi>) cauhoi.getAttribute("listcauhoi");
		bode bode = (bode) cauhoi.getAttribute("bode");
		bodef bdf = new bodef();
		bdf.TaoBoDe(bode);

		for (int i = 0; i < sluong; i++) {
			int maCauHoi = ch.get(i).getMacauhoi();
			bdf.BoDe_CauHoi(maBoDe, maCauHoi);
		}
		request.getRequestDispatcher("exammanager").forward(request, response);
	}

}
