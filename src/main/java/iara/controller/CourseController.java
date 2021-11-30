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
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@GetMapping(value = {"", "/{courseId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long courseId) {
		return ResponseEntity.ok(service.findById(courseId).get());
	}
	
	@GetMapping("/popular")
	public ResponseEntity<?> getPopularCourses() {
		return ResponseEntity.ok(service.getPopularCourses());
	}
}
