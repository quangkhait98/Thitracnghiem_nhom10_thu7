package controller.questionmanager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.cauhoif;
import function.monhocf;
import model.monhoc;
import model.nguoidung;

/**
 * Servlet implementation class questionmanager
 */
@WebServlet("/questionmanager")
public class questionmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public questionmanager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String url = "";
		if (session != null) {
			nguoidung nd = (nguoidung) session.getAttribute("login");
			if (nd != null) {
				String quyen = nd.getQuyen();
				if (quyen.equals("student")) {

					url = "student-exam.jsp";
				}
				if (quyen.equals("questionmanager")) {

					url = "addquestion.jsp";
				}
				if (quyen.equals("exammanager")) {

					url = "exammanage.jsp";
				}
				if (quyen.equals("classmanager")) {
					url = "classmanage.jsp";
				}

			} else {
				url = "login.jsp";
			}
		}
		monhocf mhf = new monhocf();
		List<monhoc> mh = mhf.getmonhoc();
		if(mh != null && mh.size()>0)
		{
			request.setAttribute("chonmon", mh);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
