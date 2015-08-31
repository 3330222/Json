package DTO;

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestModel {
	private Integer userid;
	private Integer requestid;
	private String subject;
	private Date date;
	private String status;
	private String detail;
	private String type;
	private String url;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRequestid() {
		return requestid;
	}
	public void setRequestid(Integer requestid) {
		this.requestid = requestid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public JSONObject transferJson() throws JSONException
	{
		JSONObject j=new JSONObject();
		j.put("userid", userid);
		j.put("requestid", requestid);
		j.put("subject", subject);
		j.put("date",date);
		j.put("status",status);
		j.put("detail", detail);
		j.put("type", type);
		j.put("url",url);
		
		return j;
	}
	
}
