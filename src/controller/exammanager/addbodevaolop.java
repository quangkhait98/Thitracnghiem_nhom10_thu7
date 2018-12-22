package controller.exammanager;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import function.bodef;
import model.bode;

/**
 * Servlet implementation class addbodevaolop
 */
@WebServlet("/addbodevaolop")
public class addbodevaolop extends HttpServlet {
	private static final long serialVersionUID = 1L;
bodef bdf = new  bodef();

    public addbodevaolop() {
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
		String mabode = request.getParameter("bodeID");
		String malop =  request.getParameter("classID");
		String solanlambai = request.getParameter("solannop");
		String tgbatdau = request.getParameter("tgbd");
		String tgketthuc = request.getParameter("tgkt");
		String giolambai = request.getParameter("giolambai");
		String phutlambai = request.getParameter("phutlambai");
		Boolean err=false;
		StringBuilder errors = new StringBuilder();
		bode bd= new bode();
		if(mabode ==null || malop ==null||solanlambai==null||tgbatdau==null||tgketthuc==null)
		{
			err=true;
			errors.append("Nhập chưa đầy đủ thông tin");
		}
		else
		{	
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
				Timestamp tgbd = new java.sql.Timestamp(formatter.parse(tgbatdau).getTime());
				Timestamp tgkt = new java.sql.Timestamp(formatter.parse(tgketthuc).getTime());
				java.sql.Time thoiGianLamBai = new java.sql.Time(
						Long.valueOf(new SimpleDateFormat("HH:mm").parse(giolambai + ":" + phutlambai).getTime()));
				bd.setMaBode(mabode);
				bd.setMaLop(malop);
				bd.setSoLanNopToiDa(Integer.parseInt(solanlambai));
				bd.setThoiGianBatDau(tgbd);
				bd.setThoiGianKetThuc(tgkt);
				bd.setThoiGianLamBai(thoiGianLamBai);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		if(!err)
		{
			if(bdf.addbodevaolop(bd) > 0)
			{
				request.setAttribute("success", 
						String.format("\u2713\u2713 Thêm thành công."));
				request.getRequestDispatcher("Success.jsp").forward(request, response);
				return;
			}
			else
			{
				errors.append(String.format(">Thêm thất bại.<br />"));
				request.setAttribute("errors", errors);
			}
		}
		else {
			request.setAttribute("errors", errors);
		}
		request.getRequestDispatcher("Errors.jsp").forward(request, response);
	}

}
