package controller.questionmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.cauhoif;
import model.nguoidung;


@WebServlet("/deletequestion")
public class deletequestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       cauhoif chf = new cauhoif();

    public deletequestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String questionID = request.getParameter("ID");
		boolean isError = false;
		StringBuilder errors = new StringBuilder();
		if(questionID == null || questionID.trim().isEmpty()) {
			isError = true;
			errors.append("Không tìm thấy câu hỏi");
		}
		if(!isError) {
			
			if(chf.deletequestion(Integer.parseInt(questionID))>0) {
				request.setAttribute("success", 
						String.format("\u2713\u2713 Xóa thành công.", questionID));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			} else {
				errors.append(String.format(">Xóa thất bại.<br />", questionID));
				request.setAttribute("errors", errors);
			}
		} else {
			request.setAttribute("errors", errors);
		}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}
	

}
