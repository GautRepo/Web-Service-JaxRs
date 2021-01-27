package com.nt.messages;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/demo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	
	@GET
	@Path("/annotation")
	public String getDemo(@MatrixParam("param") String mat,
							@HeaderParam("customeHeader")String head,
							@CookieParam("name") String name) {
		return "Matrix param::"+mat+" Header Param::"+head+" CookieParam::"+name;
	}
	
	@GET
	@Path("/test")
	public String getParam(@Context UriInfo uriInfo,@CookieParam("name") String cookie) {
		
		String path = uriInfo.getAbsolutePath().toString();
		return "Path::"+ path+ " Cookie Param::"+ cookie;
	}

}














