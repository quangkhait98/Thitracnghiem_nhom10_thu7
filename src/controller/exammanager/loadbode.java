package controller.exammanager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.bodef;
import model.bode;
import model.nguoidung;

/**
 * Servlet implementation class loadbode
 */
@WebServlet("/loadbode")
public class loadbode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 bodef bdf = new bodef();
    public loadbode() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classid = request.getParameter("classID");
		boolean err = false;
		if(classid==null||classid.length()==0)
		{
			err=true;
		}
		if(!err)
		{
			java.util.List<bode> ng = bdf.getbodekhongthuoclop(classid);
		
			if(ng !=null && ng.size()>0)
			{
				request.setAttribute("chonbd", ng);
			}
			request.getRequestDispatcher("listbodekolop.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classid = request.getParameter("classID");
		boolean err = false;
		if(classid==null||classid.length()==0)
		{
			err=true;
		}
		if(!err)
		{
			java.util.List<bode> ltbdl = bdf.getbodeclass(classid);
		
			if(ltbdl !=null && ltbdl.size()>0)
			{
				request.setAttribute("listbd", ltbdl);
			}
			request.getRequestDispatcher("bodeofclass.jsp").forward(request, response);
		}
	}

}
