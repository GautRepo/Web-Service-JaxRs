package com.nt.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.nt.database.DatabaseClass;
import com.nt.model.Message;

public class MsgService {
	
	private Map<Long,Message> messages= DatabaseClass.getMsg();
	
	public MsgService() {
		messages.put(1L, new Message(1,"Hello","Gautam"));
		messages.put(2L, new Message(2,"Hi","Gautam"));
		messages.put(3L, new Message(3,"vola","Gautam"));
	}
	
	public List<Message> getAllMsg(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMsgForYear(int year){
		List<Message> listMsg = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message msg : messages.values()) {
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				listMsg.add(msg);
			}
		}
		return listMsg;
	}
	
	public List<Message> getMsgByInter(int start,int size){
		List<Message> listMsg = (ArrayList<Message>) new MsgService().getAllMsg();
		if(start+size>listMsg.size())
			return listMsg;
		return listMsg.subList(start, size);
	}
	
	
	public Message getMsgById(long id) {
		return messages.get(id);
	}
	
	public Message addMsg(Message msg) {
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
	}
	
	public Message updateMsg(Message msg) {
		if(msg.getId()<=0) {
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public void deleteMsg(long id) {
		messages.remove(id);
	}

}
