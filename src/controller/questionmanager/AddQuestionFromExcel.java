package controller.questionmanager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import function.cauhoif;
import function.monhocf;
import model.cauhoi;
import model.monhoc;
import model.nguoidung;


@WebServlet("/AddQuestionFromExcel")
@MultipartConfig
public class AddQuestionFromExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       cauhoif chf = new cauhoif();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionFromExcel() {
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
		request.setCharacterEncoding("utf-8");
		Part excelpart = request.getPart("fileexcel");
		StringBuilder err = new StringBuilder("");
		boolean error = false;
		if(excelpart==null)
		{
			error = true;
			err.append("Không nhận được file excel");
		}
		if(!error)
		{
			try(InputStream excelInp = excelpart.getInputStream();)
			{
				
				List<cauhoi> questions = chf.getquestionsFromExcel(excelInp);
				if(questions !=  null)
				{
					int leng = questions.size();
					if(leng >0)
					{
						if(chf.addquestionfromexcel(questions))
						{
							request.setAttribute("err", String.format("Đã thêm câu hỏi", leng));
						}
						else {
							err.append("> Thêm câu hỏi thất bại.<br />");
							request.setAttribute("err", err);
						}
					}
				} else {
					err.append("> Không lấy được câu hỏi trong file Excel.<br />");
					request.setAttribute("err", err);
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		else {
			request.setAttribute("err", err);
}
		this.doGet(request, response);
	}
	
}
