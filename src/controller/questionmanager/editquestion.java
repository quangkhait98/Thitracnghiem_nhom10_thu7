package controller.questionmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.cauhoif;
import model.cauhoi;


@WebServlet("/editquestion")
public class editquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
     cauhoif chf = new cauhoif();  

    public editquestion() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idquestion = request.getParameter("idq");
		String editnd = request.getParameter("noidung");
		String editda1 = request.getParameter("dapan1");
		String editda2= request.getParameter("dapan2");
		String editda3= request.getParameter("dapan3");
		String editda4= request.getParameter("dapan4");
		String editdad = request.getParameter("dapandung");
		Boolean err =false;
		StringBuilder errors = new StringBuilder();
		if(idquestion == null || idquestion.trim().isEmpty() )
		{
			err = true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(editnd==null||editnd.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(editda1==null||editda1.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(editda2==null||editda2.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(editda3==null||editda3.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(editda4==null||editda4.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(editdad == null || editdad.trim().isEmpty() )
		{
			err = true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		int editdadung=0;
		int idch=0;
		try {
			editdadung=Integer.parseInt(editdad);
			idch=Integer.parseInt(idquestion);		
		} catch (Exception e) {
			// TODO: handle exception
			err=true;
			e.printStackTrace();
		}
		if(!err)
		{
			if(chf.editquestion(idch, editnd, editda1, editda2, editda3, editda4, editdadung))
			{
				request.setAttribute("success", 
						String.format("\u2713\u2713 Sửa câu hỏi thành công.", idch));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			}else {
				errors.append(String.format(">Sửa câu hỏi thất bại.<br />", idch));
				request.setAttribute("errors", errors);
			}
		} else {
			request.setAttribute("errors", errors);
		
				
	}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}
}
