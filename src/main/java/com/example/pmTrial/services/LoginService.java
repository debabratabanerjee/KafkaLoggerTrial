package com.example.pmTrial.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.pmTrial.entities.UserEntity;

@Component
public interface LoginService {

	// following convention of loose coupling
	// Using interfaces, we achieve the loose coupling by injecting the dependency.

	// all methods

	List<UserEntity> getLogins();

	UserEntity getLogin(int loginId);

	UserEntity addLogin(UserEntity login);

	UserEntity updateLogin(UserEntity login, int id);

	String deleteLogin(int id);
	// ResponseEntity<Login> updateLogin(long loginId);
//	Login updateLogin(Login login, long loginId);
}
