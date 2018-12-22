package controller.exammanager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.bodef;
import function.lophocf;
import model.bode;
import model.lophoc;
import model.nguoidung;

/**
 * Servlet implementation class ganbode_lop
 */
@WebServlet("/ganbode_lop")
public class ganbode_lop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       bodef bdf = new bodef();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ganbode_lop() {
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

					url = "student";
				}
				if (quyen.equals("questionmanager")) {

					url = "questionmanager";
				}
				if (quyen.equals("exammanager")) {
					url = "bodelop.jsp";
				}
				if (quyen.equals("classmanager")) {
					url = "classmanager";
				}

			} else {
				url = "login.jsp";
			}
		}
		lophocf lhf = new  lophocf();
		ArrayList<lophoc> lh= lhf.getclass();
		if(lh != null || lh.size()>0)	
		{	java.util.List<bode> nga = bdf.getbodekhongthuoclop(lh.get(0).getMalop());
			java.util.List<bode> ltbdl = bdf.getbodeclass(lh.get(0).getMalop());	
			if(nga !=null || nga.size()>0)
			{
				request.setAttribute("chonbd", nga);
			}
			request.setAttribute("chonlop", lh);
			request.setAttribute("listbd", ltbdl);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);	
	}

}
