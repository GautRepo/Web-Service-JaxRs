package com.nt.model;

import java.util.Date;

public class ErrorMsg {

	private Date timestamp ;
	private String msg;
	
	public ErrorMsg() {
		
	}
	
	public ErrorMsg(Date timestamp, String msg) {
		this.timestamp = timestamp;
		this.msg = msg;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
