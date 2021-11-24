package iara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iara.filter.QuestionFilter;
import iara.service.CourseService;
import iara.service.QuestionService;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private CourseService couseService;
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping(value = {"", "/{classId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long classId) {
		return ResponseEntity.ok(couseService.findById(classId).get());
	}
	
	@GetMapping("/getCompleteClass/{classId}")
	public ResponseEntity<?> getQuestionsByClassId(@PathVariable(required = true) Long classId) {
		QuestionFilter filter = QuestionFilter.builder().classId(classId).build();
		
		return ResponseEntity.ok(questionService.findAll(filter.get()));
	}
}
