package br.com.challenge.service;

import java.util.List;

import br.com.challenge.model.UserEntity;
import br.com.challenge.request.ChangeUserRequest;

public interface UserService {

	List<UserEntity> getAllUsers();

	UserEntity getAllUsersById(Integer id);
	
	void deleteUserById(Integer id);
	
	UserEntity changeUser(Integer id, ChangeUserRequest request);
	
	UserEntity addUser(String body);
}
