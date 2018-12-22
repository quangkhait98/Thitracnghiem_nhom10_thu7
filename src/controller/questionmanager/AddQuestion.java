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


@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	cauhoif chf= new cauhoif();
    public AddQuestion() {
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
		String cauhoi = request.getParameter("cauhoi");
		String chonmon = request.getParameter("chonmon");
		String chonloai =request.getParameter("chonloai");
		String dapan1 = request.getParameter("dapan1");
		String dapan2 = request.getParameter("dapan2");
		String dapan3 = request.getParameter("dapan3");
		String dapan4 = request.getParameter("dapan4");
		int dapandung =Integer.parseInt(request.getParameter("dapandung"));
		String err="";
		if(chonmon == null || chonmon.trim().length() == 0) {
			err="Chưa chọn môn!";
		}
		if(chonloai == null || chonloai.trim().length() == 0) {
			err="Chưa chọn loại!";
		}
		if(cauhoi == null || cauhoi.trim().length() == 0) {
			err="Chưa nhập câu hỏi!";
		}		
		request.setAttribute("cauhoi", cauhoi);
		request.setAttribute("dapan1", dapan1);
		request.setAttribute("dapan2", dapan2);
		request.setAttribute("dapan3", dapan3);
		request.setAttribute("dapan4", dapan4);
		if(err.length()==0)
		{   
			model.cauhoi ch = new model.cauhoi();
			ch.setNoidung(cauhoi);
			ch.setLoaicauhoi(chonloai);
			ch.setDapan1(dapan1);
			ch.setDapan2(dapan2);
			ch.setDapan3(dapan3);
			ch.setDapan4(dapan4);
			ch.setMamon(chonmon);
			ch.setDapandung(dapandung);
			int dem =chf.themcauhoi(ch);
			if(dem>0)
			{
				err="Thêm câu hỏi thành công!";
			}
			else
			{
				err="Thêm câu hỏi thất bại!";
			}
			request.setAttribute("err", err);
		}else
		{
			request.setAttribute("err", err);
		}
		this.doGet(request, response);
	}

}
