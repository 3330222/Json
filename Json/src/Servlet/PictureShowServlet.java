package Servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PictureServlet
 */
@WebServlet("/PictureShowServlet")
public class PictureShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PictureShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		FileInputStream hFile = new FileInputStream("/Users/bohanzhang/Desktop/Stonehenge.jpg");
		int i = hFile.available();
		byte data[] = new byte[i];
		hFile.read(data);
		hFile.close();
		response.setContentType("image/jpg");
//		FileOutputStream fo = new FileOutputStream("/Users/bohanzhang/Desktop/image/MyOut.jpg");
//		fo.write(data);
//		fo.flush();
//		fo.close();
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html;charset=utf-8");
//		pw.write("load the picture!");
//		pw.close();
		OutputStream toStream = response.getOutputStream();
		toStream.write(data);
		toStream.close();
	}catch(IOException e){
		e.printStackTrace();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		pw.write("can not load the picture!");
		pw.close();
	}

//		try{
//		FileInputStream hFile = new FileInputStream("/Users/bohanzhang/Desktop/Stonehenge.jpg");
//		int i = hFile.available();
//		byte data[] = new byte[i];
//		hFile.read(data);
//		hFile.close();
//		response.setContentType("image/jpg");
//		FileOutputStream fo = new FileOutputStream("/Users/bohanzhang/Desktop/image/MyOut.jpg");
//		fo.write(data);
//		fo.flush();
//		fo.close();
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html;charset=utf-8");
//		pw.write("load the picture!");
//		pw.close();
////		OutputStream toStream = response.getOutputStream();
////		toStream.write(data);
////		toStream.close();
//	}catch(IOException e){
//		e.printStackTrace();
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/html;charset=utf-8");
//		pw.write("can not load the picture!");
//		pw.close();
//	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
