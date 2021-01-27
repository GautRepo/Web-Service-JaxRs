package com.nt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nt.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles= new HashMap<>();
	
	public ProfileService() {
		profiles.put("Gautam", new Profile(1,"Gautam","Kumar"));
		
	}
	
	public List<Profile> getAllProf(){
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfById(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addMsg(Profile prof) {
		prof.setId(profiles.size()+1);
		profiles.put(prof.getFirstName(),prof);
		return prof;
	}
	
	public Profile updateMsg(Profile prof) {
		if(prof.getFirstName().isEmpty()) {
			return null;
		}
		profiles.put(prof.getFirstName(), prof);
		return prof;
	}
	
	public void deleteMsg(String profName) {
		profiles.remove(profName);
	}


}
