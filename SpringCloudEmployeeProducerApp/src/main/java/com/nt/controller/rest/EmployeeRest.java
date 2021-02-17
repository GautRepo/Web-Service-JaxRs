package com.nt.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRest {

	@GetMapping("/show")
	public String showMsg() {
		return "From Producer";
	}

}
