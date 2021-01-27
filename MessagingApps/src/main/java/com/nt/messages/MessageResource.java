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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.nt.model.Message;
import com.nt.service.MsgService;

@Path("/msg")
public class MessageResource {
	
	MsgService service = new MsgService(); 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMsg() {
		
		return service.getAllMsg(); 
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMsg(@QueryParam("year") int year) {
		if(year>0)
			return service.getAllMsgForYear(year);
		return service.getAllMsg(); 
	}*/
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMsg(@QueryParam("year") int year,
								@QueryParam("start") int start,
								@QueryParam("end") int end) {
		if(year>0)
			return service.getAllMsgForYear(year);
		if(start>=0 && end>=0) {
			System.out.println(service.getMsgByInter(start, end));
			return service.getMsgByInter(start, end);
		}
		return service.getAllMsg(); 
	}*/
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMsg(@BeanParam MessageFilterBean filterBean) {
		if(filterBean.getYear()>0)
			return service.getAllMsgForYear(filterBean.getYear());
		
		if(filterBean.getStart()>=0 && filterBean.getEnd()>=0) {
			System.out.println(service.getMsgByInter(filterBean.getStart(), filterBean.getEnd()));
			return service.getMsgByInter(filterBean.getStart(), filterBean.getEnd());
		}
		return service.getAllMsg(); 
	}*/
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMsgById(@PathParam("messageId")long id) {
		return service.getMsgById(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postMsg(Message msg) {
		
		Message nMsg = service.addMsg(msg);
		
		return Response.status(Status.CREATED)
				.entity(nMsg).build();
		
		
	}
	
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMsg(@PathParam("messageId")long id,Message msg) {
		msg.setId(id);
		return service.updateMsg(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMsg(@PathParam("messageId")long id) {
		service.deleteMsg(id);
	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
}














