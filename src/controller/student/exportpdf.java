package controller.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import function.bodef;
import model.nguoidung;
import model.pagehome;

@WebServlet("/exportpdf")
public class exportpdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exportpdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		HttpSession cauhoi = request.getSession(false);
		bodef bdf = new bodef();
		nguoidung nd = (nguoidung) session.getAttribute("login");
		String stuName = nd.getTennguoidung();
		String mabd =(String) session.getAttribute("mabode");
		String tenbd = bdf.getdetails(mabd).getTenbode();
		String tgbatdau = (String) cauhoi.getAttribute("starttime");
		String tgketthuc = (String) cauhoi.getAttribute("time");
		String diem = (String) cauhoi.getAttribute("diem");
		ExportPdf(stuName, tenbd, tgbatdau, tgketthuc, diem);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void ExportPdf(String nameStudent, String examName, String timeStart, String timeSubmit, String mark)
	{
		String FILE = "C:/Users/QuangKha/Desktop/ketquathi.pdf";
		  
		try {
			Font catFont = new Font(BaseFont.createFont("E:\\Năm 3\\web\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
			catFont.setSize(20);
			catFont.setStyle(Font.BOLD);
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			PdfPTable table = new PdfPTable(2);
			table.setTotalWidth(500);
			table.setLockedWidth(true);
			table.setWidths(new float[] { 4, 6 });
			document.open();

			Image image1 = Image.getInstance("C:/Users/QuangKha/Desktop/abc.jpg");
			image1.scaleAbsolute(540, 370);			
			document.add(image1);
			
			PdfContentByte canvas = writer.getDirectContent();
			PdfPCell c1 = new PdfPCell(new Phrase("Thí sinh", catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			c1.setFixedHeight(35f);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(nameStudent, catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Bài thi", catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			c1.setFixedHeight(35f);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(examName, catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Thời gian bắt đầu", catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			c1.setFixedHeight(35f);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(timeStart, catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Thời gian nộp bài", catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			c1.setFixedHeight(35f);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase(timeSubmit, catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Điểm", catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			c1.setFixedHeight(35f);
			table.addCell(c1);
			
			c1 = new PdfPCell(new Phrase(mark, catFont));
			c1.setHorizontalAlignment(Element.ALIGN_LEFT);
			c1.setBorder(Rectangle.NO_BORDER);
			table.addCell(c1);
			
			table.writeSelectedRows(0, -1, 100, 690, canvas);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
