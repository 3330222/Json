package Servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

import DAO.RequestManage;
import DTO.RequestModel;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public RequestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    ArrayList<JSONObject> jsonObject = new ArrayList<JSONObject>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestManage requestManage=new RequestManage();
		String uid=request.getParameter("uid");
		String reqid = request.getParameter("reqid");
		String status = request.getParameter("status");
		
		
		if(reqid==null&&status==null){
			
		jsonObject=requestManage.selectByuserid(uid);
		}
		else if(uid==null){		
		jsonObject=requestManage.selectByrequestid(reqid);
		}else if(reqid==null){
		jsonObject=requestManage.selectByuseridstatus(uid,status);
			
		}
		
		response.getOutputStream().write(jsonObject.toString().getBytes("UTF-8"));  
		response.setContentType("text/json; charset=UTF-8");
	/********************************************************************************/
	
		

	}

	
	
	
	
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String json = readJSONString(request);
		JSONObject jsonObject = null;
		String responseText = null;
		
		try {
			jsonObject = new JSONObject(json);
	
			RequestManage requestManage=new RequestManage();
			String uid =jsonObject.getString("uid");
			String subject =jsonObject.getString("subject");
			String status = jsonObject.getString("status");
			String url = jsonObject.getString("url");
			String detail = jsonObject.getString("detail");
			String type = jsonObject.getString("type");
			RequestModel h = new RequestModel();
			h.setUserid(Integer.parseInt(uid)); 
			h.setSubject(subject);
			h.setStatus(status);
			h.setUrl(url);
			h.setDetail(detail);
			h.setType(type);		
			java.util.Date date = new java.util.Date();	
			
			System.out.println(date.toString());
			Date d= new Date(date.getTime());
			System.out.println(d.toString());
			h.setDate(d);
			System.out.println(h.getDate());
			requestManage.insert(h);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
/*		RequestManage requestManage=new RequestManage();
		String uid =request.getParameter("uid");
		String subject =request.getParameter("subject");
		String status = request.getParameter("status");
		String url = request.getParameter("url");
		String detail = request.getParameter("detail");
		String type = request.getParameter("type");
		//String date = request.getParameter("date");
		
		RequestModel h = new RequestModel();
		h.setUserid(Integer.parseInt(uid)); 
		h.setSubject(subject);
		h.setStatus(status);
		h.setUrl(url);
		h.setDetail(detail);
		h.setType(type);		
		java.util.Date date = new java.util.Date();	
		
		System.out.println(date.toString());
		Date d= new Date(date.getTime());
		System.out.println(d.toString());
		h.setDate(d);
		System.out.println(h.getDate());
		requestManage.insert(h);*/
		
	}
	
	private String readJSONString(HttpServletRequest request){
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
		BufferedReader reader = request.getReader();
		while((line = reader.readLine()) != null) {
		json.append(line);
		}
		}
		catch(Exception e) {
		System.out.println(e.toString());
		}
		return json.toString();	
	}

}
