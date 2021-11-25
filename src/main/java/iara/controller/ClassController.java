package iara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iara.model.CompleteClassResponse;
import iara.filter.QuestionFilter;
import iara.filter.ClassTextFilter;
import iara.service.CourseService;
import iara.service.QuestionService;
import iara.service.ClassTextService;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ClassTextService classTextService;
	
	@GetMapping(value = {"", "/{classId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long classId) {
		return ResponseEntity.ok(courseService.findById(classId).get());
	}
	
	@GetMapping("/getCompleteClass/{classId}")
	public ResponseEntity<?> getQuestionsByClassId(@PathVariable(required = true) Long classId) {
		QuestionFilter questionFilter = QuestionFilter.builder().classId(classId).build();
		ClassTextFilter classTextFilter = ClassTextFilter.builder().classId(classId).build();
		
		CompleteClassResponse completeClass = new CompleteClassResponse(
				questionService.findAll(questionFilter.get()),
				classTextService.findAll(classTextFilter.get())
		);
		
		return ResponseEntity.ok(completeClass);
	}
}
