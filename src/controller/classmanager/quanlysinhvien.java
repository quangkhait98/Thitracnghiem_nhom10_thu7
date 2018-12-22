package controller.classmanager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.nguoidungf;
import model.lophoc;
import model.nguoidung;

/**
 * Servlet implementation class quanlysinhvien
 */
@WebServlet("/quanlysinhvien")
public class quanlysinhvien extends HttpServlet {
	private static final long serialVersionUID = 1L;
      nguoidungf ngf = new nguoidungf(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlysinhvien() {
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
					url = "exammanager";
				}
				if (quyen.equals("classmanager")) {
					url = "quanlysv.jsp";
				}

			} else {
				url = "login.jsp";
			}
		}

		List<nguoidung> getstd=ngf.getallstudent();
		if(getstd!= null)
		{
			request.setAttribute("getstd", getstd);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<nguoidung> getstd=ngf.getallstudent();
		if(getstd!= null || getstd.size()>0)
		{
			request.setAttribute("getstdtable", getstd);
		}
		request.getRequestDispatcher("tablestudent.jsp").forward(request, response);
	}

}
