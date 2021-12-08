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

import iara.filter.UserValidationFilter;
import iara.model.UserValidationRequest;
import iara.service.UserValidationService;

@CrossOrigin(origins = {"http://localhost:3000/", "https://iara-delta.vercel.app/"})
@RestController
@RequestMapping("/login")
public class UserValidationController {
	
	@Autowired
	private UserValidationService service;
	
	@PostMapping("")
	public ResponseEntity<?> insert(@Valid @RequestBody UserValidationRequest request) {

		UserValidationFilter filter = UserValidationFilter.builder().username(request.getUsername()).password(request.getPassword()).build();
		
		return ResponseEntity.ok(service.findAll(filter.get()));
	}

	@GetMapping("")
	public ResponseEntity<?> getById(@PathVariable(required = true) Long courseId) {
		return ResponseEntity.ok(service.findById(courseId).get());
	}
	


}