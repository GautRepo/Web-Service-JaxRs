package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acc")
public class AcoountRest {
	
	@Autowired
	private Environment env ;
	
	@GetMapping("/page")
	public String getAcc() {
		return "working... "+env.getProperty("local.server.port");
	}

}
