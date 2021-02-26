package com.nt.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.dto.UserDto;
import com.nt.entity.UserEntity;
import com.nt.repositery.UserRepositery;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositery repo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto dto) {
		UserEntity entity = new UserEntity();
		
		dto.setUserId(UUID.randomUUID().toString());
		
		BeanUtils.copyProperties(dto, entity);
		entity.setEncryPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		repo.save(entity);
		
		return dto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity entity =repo.findByEmail(username);
		if(entity==null) 
			throw new UsernameNotFoundException(username);
		
		
		return new User(entity.getEmail(),entity.getEncryPassword(),true,true,true,true,new ArrayList<>());
	}

	
}
