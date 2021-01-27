package com.nt.database;

import java.util.HashMap;
import java.util.Map;

import com.nt.model.Message;
import com.nt.model.Profile;

public class DatabaseClass {
	
	private static Map<Long,Message> messages= new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	
	
	public static Map<Long,Message> getMsg(){
		return messages;
	}
	
	public static Map<String,Profile> getProf(){
		return profiles;
	}

}
