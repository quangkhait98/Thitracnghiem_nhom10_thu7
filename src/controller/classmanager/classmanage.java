package controller.classmanager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.lophocf;
import model.lophoc;
import model.nguoidung;

/**
 * Servlet implementation class classmanage
 */
@WebServlet("/classmanage")
public class classmanage extends HttpServlet {
	private static final long serialVersionUID = 1L;

      
  
    public classmanage() {
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
	      lophocf lhf = new lophocf();
		List<lophoc> getclass=lhf.getttlophoc();
		if(getclass!= null)
		{
			request.setAttribute("layclass", getclass);
		}
		request.getRequestDispatcher("tableclass.jsp").forward(request, response);
	}

}
