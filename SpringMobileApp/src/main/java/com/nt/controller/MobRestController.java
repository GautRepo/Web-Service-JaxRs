package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.model.RequestModel;
import com.nt.model.UserServiceExcep;

@RestController
@RequestMapping("/users")
public class MobRestController {

	/*@GetMapping
	public String getUser(@RequestParam(value="page") int id, 
							@RequestParam(value="limit") int lt) {
		return "get is called "+id+" and "+lt;
	}*/

	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int id,
			@RequestParam(value = "limit", defaultValue = "150") int lt,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get is called " + id + " and " + lt + " " + sort;
	}

	/*@GetMapping(path="/{userId}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Employee getUser(@PathVariable String userId) {
		Employee emp = new Employee();
		emp.setFirstName("Gautam");
		emp.setLastName("Kumar");
		emp.setEmail("abc");
		emp.setUserId(10);
		return emp;
	}*/

	/*@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> getUser(@PathVariable String userId) {
		Employee emp = new Employee();
		emp.setFirstName("Gautam");
		emp.setLastName("Kumar");
		emp.setEmail("abc");
		emp.setUserId(10);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	*/
	
	
	/*@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
					produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> postUser(@RequestBody RequestModel model) {
		Employee emp = new Employee();
		emp.setFirstName(model.getFirstName());
		emp.setLastName(model.getLastName());
		emp.setEmail(model.getEmail());
		emp.setUserId(model.getUserId());
		return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}*/
	
	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> getUser(@PathVariable String userId) {
		
		if(true)
			throw new UserServiceExcep("Exception created");
		
		
		Employee emp = new Employee();
		emp.setFirstName("Gautam");
		emp.setLastName("Kumar");
		emp.setEmail("abc");
		emp.setUserId(10);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> postUser(@RequestBody RequestModel model) {
		Employee emp = new Employee();
		emp.setFirstName(model.getFirstName());
		emp.setLastName(model.getLastName());
		emp.setEmail(model.getEmail());
		emp.setUserId(model.getUserId());
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
	}

	@PutMapping
	public String updateUser() {
		return "put is called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete is called";
	}

}
