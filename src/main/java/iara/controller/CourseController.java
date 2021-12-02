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

import iara.filter.CourseFilter;
import iara.model.SearchCourseRequest;
import iara.service.CourseService;

@CrossOrigin(origins = "http://localhost:3000/")
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
	
	@PostMapping("/search")
	public ResponseEntity<?> searchCourse(@Valid @RequestBody SearchCourseRequest request) {

		
		CourseFilter filter = CourseFilter.builder()
				.genericText(request.getName())
				.difficultyIsEasy(request.getDifficultyIsEasy())
				.difficultyIsMedium(request.getDifficultyIsMedium())
				.difficultyIsHard(request.getDifficultyIsHard())
				.durationIsShort(request.getDurationIsShort())
				.durationIsMedium(request.getDurationIsMedium())
				.durationIsLong(request.getDurationIsLong())
				.build();
		
		return ResponseEntity.ok(service.findAll(filter.get()));
	}
}
