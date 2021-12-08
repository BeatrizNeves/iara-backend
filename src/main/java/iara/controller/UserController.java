package iara.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iara.converter.UserConverter;
import iara.converter.UserValidationConverter;
import iara.model.entity.UserEntity;
import iara.model.entity.UserValidationEntity;
import iara.model.request.UserSignupRequest;
import iara.service.UserService;
import iara.service.UserValidationService;

@CrossOrigin(origins = {"http://localhost:3000/", "https://iara-delta.vercel.app/"})
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidationService userValidationService;
	
	@GetMapping(value = {"", "/{userId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long userId) {
		return ResponseEntity.ok(userService.findById(userId).get());
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody UserSignupRequest request) {
		
		UserEntity userEntity = UserConverter.convertFromSignUpRequest(request);
		
		userEntity = userService.save(userEntity);
		
		UserValidationEntity userValidationEntity = UserValidationConverter.convertFromSignUpRequest(request, userEntity);
		userValidationService.save(userValidationEntity);
		
		return ResponseEntity.ok(userEntity);
	}
	
}
