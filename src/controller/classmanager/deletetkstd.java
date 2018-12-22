package controller.classmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.nguoidungf;

/**
 * Servlet implementation class deletetkstd
 */
@WebServlet("/deletetkstd")
public class deletetkstd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	nguoidungf ngf = new nguoidungf();
    public deletetkstd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String studentid = request.getParameter("ID");
		System.out.println(studentid);
		boolean isError = false;
		StringBuilder errors = new StringBuilder();
		if(studentid == null || studentid.trim().isEmpty()) {
			isError = true;
			errors.append("Không tìm thấy mã sinh viên");
		}
		if(!isError) {
			
			if(ngf.deletestudent(studentid)>0) {
				request.setAttribute("success", 
						String.format("\u2713\u2713 Xóa thành công.", studentid));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			} else {
				errors.append(String.format(">Xóa thất bại.<br />", studentid));
				request.setAttribute("errors", errors);
			}
		} else {
			request.setAttribute("errors", errors);
		}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}

}
