package controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.bodef;
import function.ketquathif;
import function.lophocf;
import model.ketquathi;
import model.lophoc;
import model.nguoidung;
import model.pagehome;

/**
 * Servlet implementation class hienketquathisv
 */
@WebServlet("/hienketquathisv")
public class hienketquathisv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ketquathif kqt = new ketquathif();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hienketquathisv() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		bodef bdf = new bodef();
		lophocf lh = new lophocf();
		String url = "";
		if (session != null) {
			nguoidung nd = (nguoidung) session.getAttribute("login");
			if (nd != null) {
				String quyen = nd.getQuyen();
				if (quyen.equals("student")) {
					List<ketquathi> kqthi = kqt.getketqua(nd.getManguoidung());
					if(kqthi!=null)
					{
						request.setAttribute("kqthi", kqthi);
					}
					url = "ketquathisv.jsp";
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

		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
