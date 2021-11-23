package iara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iara.service.CourseService;

@RestController
@RequestMapping("/course")
public class ClassController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping(value = {"", "/{classId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long classId) {
		return ResponseEntity.ok(service.findById(classId).get());
	}
}
