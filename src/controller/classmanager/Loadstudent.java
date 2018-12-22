package controller.classmanager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import function.nguoidungf;
import model.nguoidung;

/**
 * Servlet implementation class Loadstudent
 */
@WebServlet("/Loadstudent")
public class Loadstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       nguoidungf ngf = new nguoidungf();
 
    public Loadstudent() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idclass = request.getParameter("classID");
			boolean err = false;
			System.out.println(idclass);
			if(idclass==null||idclass.length()==0)
			{
				err=true;
			}
			if(!err)
			{
				java.util.List<nguoidung> ng = ngf.svkothuoclop(idclass);
				for (nguoidung nguoidung : ng) {
					System.out.println(nguoidung.getManguoidung()+" "+ nguoidung.getTennguoidung());
				}
				if(ng !=null && ng.size()>0)
				{
					request.setAttribute("chonsv", ng);
				}
				request.getRequestDispatcher("studentlist.jsp").forward(request, response);
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
