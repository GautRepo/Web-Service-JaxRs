package com.nt.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeConsumer {
	
	@Autowired
	private DiscoveryClient client;
	
	@GetMapping("/consume")
	public String readProducerInfo() {
		String URL="";
		RestTemplate rt = new RestTemplate();
		
		List<ServiceInstance> siList= client.getInstances("EMPLOYEE-PRODUCER");
		ServiceInstance si =siList.get(0);
		URL=si.getUri()+"/show";
		
		String res=rt.getForObject(URL, String.class);
		
		return "From Consumer=>"+res;
	}

}
