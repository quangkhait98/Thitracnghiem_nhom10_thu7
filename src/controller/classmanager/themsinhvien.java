package controller.classmanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.nguoidungf;
import jdk.nashorn.internal.ir.TernaryNode;

/**
 * Servlet implementation class themsinhvien
 */
@WebServlet("/themsinhvien")
public class themsinhvien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       nguoidungf ngf = new nguoidungf();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themsinhvien() {
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
		String masv = request.getParameter("masv");
		String tensv = request.getParameter("tensv");
		String matkhau = request.getParameter("matkhau");
		System.out.println(masv);
		System.out.println(tensv);
		System.out.println(matkhau);
		Boolean err=false;
		StringBuilder errors = new StringBuilder();
		if(masv==null || masv.length()==0 || tensv==null ||tensv.length()==0|| matkhau==null ||matkhau.length()==0)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		if(!err)
		{
			if(ngf.addsv(masv, tensv, matkhau)>0)
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
