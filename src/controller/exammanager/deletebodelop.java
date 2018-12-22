package controller.exammanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.bodef;

/**
 * Servlet implementation class deletebodelop
 */
@WebServlet("/deletebodelop")
public class deletebodelop extends HttpServlet {
	private static final long serialVersionUID = 1L;
     bodef bdf = new bodef();  
   
    public deletebodelop() {
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
		String bodeid = request.getParameter("bodeid");
		String classid = request.getParameter("classid");
		System.out.println(bodeid);
		System.out.println(classid);
		boolean isError = false;
		StringBuilder errors = new StringBuilder();
		if(bodeid == null || bodeid.trim().isEmpty()||classid == null || classid.trim().isEmpty()) {
			isError = true;
			errors.append("Không tìm thấy sinh viên hoặc lớp học");
		}
		if(!isError)
		{
			if(bdf.deletebodeclass(classid, bodeid)>0)
			{
				request.setAttribute("success", 
						String.format("\u2713\u2713 Xóa thành công."));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			}
			else{
				errors.append(String.format(">Xóa thất bại<br />"));
				request.setAttribute("errors", errors);
			}
		}else {
			request.setAttribute("errors", errors);
		}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}

}
