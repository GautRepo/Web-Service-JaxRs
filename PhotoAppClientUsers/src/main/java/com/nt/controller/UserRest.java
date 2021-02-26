package com.nt.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.UserDto;
import com.nt.model.CreateUserRequestModel;
import com.nt.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRest {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/show")
	public String staus() {
		return "working";
	}
	
	/*@PostMapping
	public String postUser(@Valid @RequestBody CreateUserRequestModel usermodel) {
		
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(usermodel, dto);
		service.createUser(dto);
		
		return "post is called";
	}*/
	
	@PostMapping(
			
			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CreateUserRequestModel> postUser(@RequestBody CreateUserRequestModel usermodel) {
		
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(usermodel, dto);
		service.createUser(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usermodel);
	}

}
