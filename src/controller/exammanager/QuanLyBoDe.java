package controller.exammanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.bodef;
import function.cauhoif;
import function.monhocf;
import model.bode;
import model.cauhoi;
import model.monhoc;
import model.nguoidung;

@WebServlet("/QuanLyBoDe")

public class QuanLyBoDe extends HttpServlet {
	bodef bdf = new bodef();
	private static final long serialVersionUID = 1L;

	public QuanLyBoDe() {
		super();
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String maBoDe = "";
		for (int i = 0; i < 10; i++)
			maBoDe += ThreadLocalRandom.current().nextInt(1, 10);
		String tenBoDe = request.getParameter("tenbode");
		String url = "exammanager";
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		java.sql.Time thoiGianLamBai = null;
		java.sql.Timestamp ngayMoDe = null;
		java.sql.Timestamp ngayDongDe = null;
		int slDe = 0, slTBinh = 0, slKho = 0;
		String gioLamBai = request.getParameter("giolambai");
		String phutLamBai = request.getParameter("phutlambai");
		int soLanLamBai = Integer.parseInt(request.getParameter("solanlambai"));
		try {
			thoiGianLamBai = new java.sql.Time(
					Long.valueOf(new SimpleDateFormat("HH:mm").parse(gioLamBai + ":" + phutLamBai).getTime()));
			ngayDongDe = new java.sql.Timestamp(formatter.parse(request.getParameter("ngaydongde")).getTime());
			ngayMoDe = new java.sql.Timestamp(formatter.parse(request.getParameter("ngaymode")).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String lopGiaoDe = request.getParameter("lopgiaode");
		String mon = request.getParameter("mon");
		String[] doKho = new String[3];
		int[] soluong = new int[3];
		for (int i = 0; i < 3; i++) {
			doKho[i] = "a";
			soluong[i] = 0;
			try {
				doKho[i] = request.getParameter("dokho-" + i);
				soluong[i] = Integer.parseInt(request.getParameter("soluong-" + i));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 3; i++) {
			if (doKho[i] != null) {
				if (doKho[i].equals("Dễ"))
					slDe = soluong[i];
				else if (doKho[i].equals("Trung Bình"))
					slTBinh = soluong[i];
				else if (doKho[i].equals("Khó"))
					slKho = soluong[i];
			}
		}
		String err = "";
		if (gioLamBai.equals("0") && phutLamBai.equals("0")) {
			err = "Chưa thêm thời gian làm bài!";
		}
		if (slDe + slTBinh + slKho == 0) {
			err = "Chưa thêm câu hỏi!";
		}
		if (err.length() == 0) {
			bode bode = new bode(maBoDe, tenBoDe, slDe, slTBinh, slKho, mon, soLanLamBai, ngayMoDe, ngayDongDe,
					thoiGianLamBai, lopGiaoDe);
			HttpSession cauhoi = request.getSession(false);
			cauhoif chf = new cauhoif();
			ArrayList<cauhoi> ch = chf.getquestion(mon, slDe, slTBinh, slKho);
			cauhoi.setAttribute("monhoc", mon);
			cauhoi.setAttribute("bode", bode);
			cauhoi.setAttribute("sluong", slDe + slTBinh + slKho);
			cauhoi.setAttribute("mabode", maBoDe);
			cauhoi.setAttribute("listcauhoi", ch);
			url = "TaoDeThi";
		} else {
			request.setAttribute("err", err);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
