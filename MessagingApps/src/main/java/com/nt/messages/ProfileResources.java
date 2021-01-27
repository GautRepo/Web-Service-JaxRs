package com.nt.messages;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nt.model.Profile;
import com.nt.service.ProfileService;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {
	
	ProfileService service = new ProfileService();

	@GET
	public List<Profile> getAll(){
		
		return service.getAllProf();
	}
	
	@GET
	@Path("/{name}")
	public Profile getProfById(@PathParam("name")String firstName) {
		
		return service.getProfById(firstName);
	}
	
	@POST
	public Profile postProf(Profile profile) {
		return service.addMsg(profile);
	}
	
	@PUT
	@Path("/{name}")
	public Profile updateProf(@PathParam("name") String name,Profile prof) {
		prof.setFirstName(name);
		return service.updateMsg(prof);
	}
	
	@DELETE
	@Path("/{name}")
	public void deletProf(@PathParam("name")String firstName) {
		service.deleteMsg(firstName);
	}
}
