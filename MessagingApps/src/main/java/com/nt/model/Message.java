package com.nt.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Message {
	
	private long id;
	private String msg;
	private Date created;
	private String auther;
	
	
	
	public Message() {
	
	}
	public Message(int id, String msg, String auther) {
		
		this.id = id;
		this.msg = msg;
		this.auther = auther;
		this.created= new Date();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	
	

}
