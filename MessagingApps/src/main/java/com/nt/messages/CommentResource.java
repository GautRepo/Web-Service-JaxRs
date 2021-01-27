package com.nt.messages;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")    //optional
public class CommentResource {

	@GET
	public String test() {
		return "This is comment Resource";
	}
	
	/*@GET
	@Path("/{commentId}")
	public String test2() {
		return "This is for comment Id";
	}*/
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") int id,
						@PathParam("messageId") int msgId) {
		return id+" This is for comment Id "+ msgId+" This is for msg Id";
	}
	
	
	
	
}
