package br.com.challenge.service.impl;

import static br.com.challenge.consts.ChallengeConstants.*;
import static java.util.Objects.isNull;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.challenge.exception.DuplicateException;
import br.com.challenge.exception.JsonValidationException;
import br.com.challenge.exception.ObjectNotFoundException;
import br.com.challenge.model.UserEntity;
import br.com.challenge.repository.UserRepository;
import br.com.challenge.request.ChangeUserRequest;
import br.com.challenge.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity getAllUsersById(Integer id) {
		return userRepository.getById(id);
	}

	@Override
	public void deleteUserById(Integer id) {
		UserEntity entity = userRepository.getById(id);
		if (isNull(entity)) {
			throw new ObjectNotFoundException("User not found: " + id);
		}
		userRepository.deleteById(id);
	}

	@Transactional
	public UserEntity changeUser(Integer id, ChangeUserRequest request) {
		UserEntity entity = userRepository.getById(id);
		if (isNull(entity)) {
			return null;
		}

		if (request.getName() != null)
			entity.setName(request.getName());

		if (request.getEmail() != null)
			entity.setEmail(request.getEmail());

		return userRepository.save(entity);
	}

	@Override
	public UserEntity addUser(String body) {
		JSONObject jsonObject = parseStringToJsonObject(body);
		UserEntity userEntity = parseJsonObjectToEntity(jsonObject);

		if (existsItem(userEntity.getId())) {
			throw new DuplicateException("User already exists: " + userEntity.getId());
		}
		return userRepository.save(userEntity);
	}

	private JSONObject parseStringToJsonObject(String payload) {
		String[] splitPayload = payload.split(SPLIT_DELIMITER);

		try {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put(JSON_OBJECT_ID, splitPayload[JSON_OBJECT_INDEX_ID]);
			jsonObject.put(JSON_OBJECT_NAME, splitPayload[JSON_OBJECT_INDEX_NAME]);
			jsonObject.put(JSON_OBJECT_EMAIL, splitPayload[JSON_OBJECT_INDEX_EMAIL]);

			return jsonObject;
		} catch (Exception e) {
			throw new JsonValidationException(e.getMessage());
		}
	}

	private UserEntity parseJsonObjectToEntity(JSONObject jsonObject) {
		return new Gson().fromJson(jsonObject.toString(), UserEntity.class);
	}
	
	public boolean existsItem(Integer id) {
		return userRepository.findById(id).isPresent();
	}

}
