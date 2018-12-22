package controller.questionmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.cauhoif;
import function.monhocf;
import model.cauhoi;
import model.monhoc;
import model.nguoidung;


@WebServlet("/questionmanage")
public class questionmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	cauhoif chf = new cauhoif();
	monhocf mhf = new monhocf();
    public questionmanage() {
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

					url = "questionmanage.jsp";
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
		List<monhoc> mh = mhf.getmonhoc();
		if(mh != null && mh.size()>0)
		{
			request.setAttribute("chonmon", mh);
			java.util.List<cauhoi> ch;
			ch = chf.getquestion("", mh.get(0).getMamon(), "kho", 10, 0);
			request.setAttribute("danhsach", ch);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chonmon = request.getParameter("chonmon");
		String search = request.getParameter("search");
		String chonloai = request.getParameter("chonloai");
		String strOffset = request.getParameter("offset");
		String strLength =  request.getParameter("length");
		int offset = 0;
		int length = 0;
		Boolean err =false;
		if(chonmon ==null || chonmon.length()==0)
		{
			err=true;
		}
		if(chonloai==null||chonloai.length()==0)
		{
			err=true;
		}
		if(strOffset==null||strOffset.trim().isEmpty())
		{
			err=true;
		}
		if(strLength==null||strLength.trim().isEmpty())
		{
			err=true;
		}
		try {
			offset = Integer.parseInt(strOffset);
			length = Integer.parseInt(strLength);
		} catch (Exception e) {
			// TODO: handle exception
			err=true;
			e.printStackTrace();
		}
		if(!err)
		{	
			java.util.List<cauhoi> ch;
			ch = chf.getquestion(search, chonmon, chonloai, length, offset);
			request.setAttribute("chonmon", ch);		
		}
		request.getRequestDispatcher("tablequestion.jsp").forward(request, response);
	}
	
	
}
