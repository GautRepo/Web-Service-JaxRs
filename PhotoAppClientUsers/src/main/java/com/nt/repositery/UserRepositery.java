package com.nt.repositery;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.UserEntity;

public interface UserRepositery extends CrudRepository<UserEntity, Long> {

	
	UserEntity findByEmail(String email);
}
