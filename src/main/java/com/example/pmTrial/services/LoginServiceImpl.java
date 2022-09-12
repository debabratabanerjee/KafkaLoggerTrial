package com.example.pmTrial.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.pmTrial.dao.UserRepository;
import com.example.pmTrial.entities.UserEntity;

@Service
public class LoginServiceImpl implements LoginService {
	Logger log = LogManager.getLogger(this.getClass());

	@Autowired

	private final UserRepository userRepository;

	public LoginServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserEntity addLogin(UserEntity params) {
		userRepository.save(params);
		return params;
	}

	@Override
	public List<UserEntity> getLogins() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getLogin(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public UserEntity updateLogin(UserEntity params, int id) {

		UserEntity user = userRepository.findById(id).get();
		user.setName(params.getName());
		user.setEmail(params.getEmail());

		return userRepository.save(user);

	}

	@Override
	public String deleteLogin(int id) {
		userRepository.deleteById(id);
		return "User(" + id + ")" + " has been deleted!";
	}
}