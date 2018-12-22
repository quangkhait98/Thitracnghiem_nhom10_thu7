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
 * Servlet implementation class deleteclass
 */
@WebServlet("/deleteclass")
public class deleteclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       lophocf lhf =new lophocf();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteclass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String classid = request.getParameter("ID");
		boolean isError = false;
		StringBuilder errors = new StringBuilder();
		if(classid == null || classid.trim().isEmpty()) {
			isError = true;
			errors.append("Không tìm thấy mã lớp");
		}
		if(!isError) {
			
			if(lhf.deleteclass(classid)>0) {
				request.setAttribute("success", 
						String.format("\u2713\u2713 Xóa thành công.", classid));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			} else {
				errors.append(String.format(">Xóa thất bại.<br />", classid));
				request.setAttribute("errors", errors);
			}
		} else {
			request.setAttribute("errors", errors);
		}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}

}
