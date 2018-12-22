package controller.student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showmark")
public class showmark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public showmark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File("C:\\Users\\QuangKha\\Desktop\\ketquathi.pdf");
		byte[] fileData = new byte[(int)file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(fileData);
		response.reset();
        response.setContentType("application/pdf");
        response.setContentLength(fileData.length);
        response.setHeader("Content-Disposition", "inline;filename=example.pdf");
       
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(fileData); 
        outputStream.flush();
        outputStream.close();

        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
