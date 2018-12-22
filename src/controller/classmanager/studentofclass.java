package controller.classmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import function.lophocf;
import function.nguoidungf;
import model.lophoc;
import model.nguoidung;


@WebServlet("/studentofclass")
public class studentofclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       nguoidungf ngf = new nguoidungf();
 
    public studentofclass() {
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
					url = "studentmanage.jsp";
				}

			} else {
				url = "login.jsp";
			}
		}


		lophocf lhf = new  lophocf();
		ArrayList<lophoc> lh= lhf.getclass();
		if(lh != null || lh.size()>0)
			
		{	java.util.List<nguoidung> nga = ngf.getstudent(lh.get(0).getMalop());
			java.util.List<nguoidung> ng = ngf.svkothuoclop(lh.get(0).getMalop());
			
			if(ng !=null || ng.size()>0)
			{
				request.setAttribute("chonsv", ng);
			}
			request.setAttribute("chonlop", lh);
			request.setAttribute("studenta", nga);
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idclass = request.getParameter("classID");
		Boolean err=false;
		StringBuilder errors = new StringBuilder();
		if(idclass == null || idclass.length()==0)
		{
			err=true;
			errors.append("Không tìm thấy lớp");
		}
		if(!err)
		{
			List<nguoidung> ng = ngf.getstudent(idclass);
			request.setAttribute("student", ng);
		}
		request.getRequestDispatcher("studenttable.jsp").forward(request, response);
	}

}
