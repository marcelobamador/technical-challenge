package br.com.challenge.api;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.model.UserEntity;
import br.com.challenge.request.ChangeUserRequest;
import br.com.challenge.service.UserService;

@RestController
@RequestMapping("v1/user")
public class UserApiController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<UserEntity> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserEntity getAllUsersById(@PathVariable Integer id) {
		return userService.getAllUsersById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
	}
	
	@PatchMapping("/{id}")
	public UserEntity changeUser(@PathVariable Integer id,
			@Valid @RequestBody ChangeUserRequest changeUser) {
		return userService.changeUser(id, changeUser);
	}
	
	@PostMapping(value = "", consumes = MediaType.TEXT_HTML_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@Produces(MediaType.TEXT_HTML_VALUE)
	public UserEntity addUser(@RequestBody String body) {
		return userService.addUser(body);
	}
}
