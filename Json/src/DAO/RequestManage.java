package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

import DTO.RequestModel;
public class RequestManage {

	private Connection conn;
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private String url="jdbc:mysql://localhost/Test";
	private String user="root";
	private String password="password";
	
	public RequestManage()
	{
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<JSONObject> selectByuserid(String userid)
	{
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		try {
			Statement statement=conn.createStatement();
			String sql;
		      sql = "SELECT * FROM Test.table where userid='"+userid+"';";
		      ResultSet rs = statement.executeQuery(sql);
		      while(rs.next())
		      {
		    	  RequestModel h=new RequestModel();
		    	  h.setUserid(rs.getInt(1));
		    	  h.setRequestid(rs.getInt(2));
		    	  h.setSubject(rs.getString(3));
		    	  h.setStatus(rs.getString(4));
		    	  h.setUrl(rs.getString(5));
		    	  h.setDetail(rs.getString(6));
		    	  h.setType(rs.getString(7));
		    	  h.setDate(rs.getDate(8));
		    	  
		    	  list.add(h.transferJson());
		      }
		      rs.close();
		      statement.close();
		      conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<JSONObject> selectByrequestid(String requestid)
	{
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		try {
			Statement statement=conn.createStatement();
			String sql;
		      sql = "SELECT * FROM Test.table where requestid='"+requestid+"';";
		      ResultSet rs = statement.executeQuery(sql);
		      while(rs.next())
		      {
		    	  RequestModel h=new RequestModel();
		    	  h.setUserid(rs.getInt(1));
		    	  h.setRequestid(rs.getInt(2));
		    	  h.setSubject(rs.getString(3));
		    	  h.setStatus(rs.getString(4));
		    	  h.setUrl(rs.getString(5));
		    	  h.setDetail(rs.getString(6));
		    	  h.setType(rs.getString(7));
		    	  h.setDate(rs.getDate(8));
		    	  
		    	  list.add(h.transferJson());
		      }
		      rs.close();
		      statement.close();
		      conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<JSONObject> selectByuseridstatus(String userid,String status)
	{
		ArrayList<JSONObject> list=new ArrayList<JSONObject>();
		try {
			Statement statement=conn.createStatement();
			String sql;
		      sql = "SELECT * FROM Test.table where userid='"+userid+"' and status='"+status+"';";
		      ResultSet rs = statement.executeQuery(sql);
		      while(rs.next())
		      {
		    	  RequestModel h=new RequestModel();
		    	  h.setUserid(rs.getInt(1));
		    	  h.setRequestid(rs.getInt(2));
		    	  h.setSubject(rs.getString(3));
		    	  h.setStatus(rs.getString(4));
		    	  h.setUrl(rs.getString(5));
		    	  h.setDetail(rs.getString(6));
		    	  h.setType(rs.getString(7));
		    	  h.setDate(rs.getDate(8));
		    	  
		    	  list.add(h.transferJson());
		      }
		      rs.close();
		      statement.close();
		      conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(RequestModel h){
		try{
			Statement statement = conn.createStatement();
			String sql;
			
			sql ="INSERT INTO Test.`table` (Userid, `Subject`, `Status`, Url, Detail, `Type`, `Date`)VALUES("+h.getUserid()+",'"+h.getSubject()+"','"+h.getStatus()+"','"+h.getUrl()+"','"+h.getDetail()+"','"+h.getType()+"','"+h.getDate()+"');";
			statement.execute(sql);
			statement.close();
		    conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
