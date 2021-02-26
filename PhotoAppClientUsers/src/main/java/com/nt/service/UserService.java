package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.dto.UserDto;

public interface UserService extends UserDetailsService{
	
	public UserDto createUser(UserDto dto);

}
