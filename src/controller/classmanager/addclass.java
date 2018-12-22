package controller.classmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.lophocf;
import model.nguoidung;

/**
 * Servlet implementation class addclass
 */
@WebServlet("/addclass")
public class addclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       lophocf lhf = new lophocf();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addclass() {
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
					url = "classmanager";
				}

			} else {
				url = "login.jsp";
			}
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String malop = request.getParameter("malop");
		String tenlop = request.getParameter("tenlop");
		Boolean err=false;
		StringBuilder errors = new StringBuilder();
		if(malop==null || malop.length()==0 || tenlop==null ||tenlop.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(!err)
		{
			if(lhf.addclass(malop, tenlop)>0)
			{
				request.setAttribute("success", 
						String.format("\u2713\u2713 Thêm thành công."));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			} 
			else {
				errors.append(String.format(">Thêm thất bại.<br />"));
				request.setAttribute("errors", errors);
			}
		}else {
			request.setAttribute("errors", errors);
		}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}

}
