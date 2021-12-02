package iara.controller;

import java.util.List;

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

import iara.model.CompleteClassResponse;
import iara.filter.QuestionFilter;
import iara.filter.UserHasAnsweredFilter;
import iara.filter.ClassTextFilter;
import iara.service.CourseService;
import iara.service.QuestionService;
import iara.service.UserHasAnsweredService;
import iara.model.AlternativeEntity;
import iara.model.ClassEntity;
import iara.model.QuestionEntity;
import iara.model.UserHasAnsweredEntity;
import iara.model.UserHasAnsweredRequest;
import iara.model.UserHasClassEntity;
import iara.filter.AlternativeFilter;
import iara.service.AlternativeService;
import iara.service.ClassService;
import iara.service.ClassTextService;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ClassTextService classTextService;
	
	@Autowired
	private AlternativeService alternativeService;

	@Autowired
	private UserHasAnsweredService userHasAnsweredService;
	
	@GetMapping(value = {"", "/{classId}"})
	public ResponseEntity<?> getById(@PathVariable(required = true) Long classId) {
		return ResponseEntity.ok(courseService.findById(classId).get());
	}
	
	@GetMapping("/getCompleteClass/{classId}&{userId}")
	public ResponseEntity<?> getQuestionsByClassId(@PathVariable(required = true) Long classId, @PathVariable(required = true) Long userId) {
		CompleteClassResponse completeClass = new CompleteClassResponse();
		
		ClassEntity classInfo = classService.findById(classId).get();
		completeClass.setClassInfo(classInfo);
		
		QuestionFilter questionFilter = QuestionFilter.builder().classId(classId).build();
		ClassTextFilter classTextFilter = ClassTextFilter.builder().classId(classId).build();
		
		List<QuestionEntity> questions = questionService.findAll(questionFilter.get());
		
		questions.forEach(question -> {
			AlternativeFilter alternativeFilter = AlternativeFilter.builder().questionId(question.getId()).build();
			List<AlternativeEntity> alternatives = alternativeService.findAll(alternativeFilter.get());
			
			UserHasAnsweredFilter userHasAnsweredFilter = UserHasAnsweredFilter.builder().questionId(question.getId()).userId(userId).build();
			List<UserHasAnsweredEntity> userHasAnsweredList = userHasAnsweredService.findAll(userHasAnsweredFilter.get());
			
			if(!userHasAnsweredList.isEmpty()) {
				completeClass.addQuestion(question, alternatives, userHasAnsweredList.get(0).getAlternativeId());
			} else {
				completeClass.addQuestion(question, alternatives, null);
			}
			
		});
		
		completeClass.setTexts(classTextService.findAll(classTextFilter.get()));
		
		return ResponseEntity.ok(completeClass);
	}
	
	@GetMapping("/registerUser/userId={userId}&classId={classId}")
	public ResponseEntity<?> registerUser(@PathVariable(required = true) Long userId, @PathVariable(required = true) Long classId) {
		UserHasClassEntity response = classService.registerUser(userId, classId);
		
		if(response == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/registerUserProgress")
	public ResponseEntity<?> registerUserProgress(@Valid @RequestBody UserHasAnsweredRequest request) {
		
		UserHasAnsweredEntity userHasAnsweredEntity = new UserHasAnsweredEntity();
		userHasAnsweredEntity.setUserId(request.getUserId());
		userHasAnsweredEntity.setAlternativeId(request.getAlternativeId());
		userHasAnsweredEntity.setQuestionId(request.getQuestionId());
		
		userHasAnsweredEntity = userHasAnsweredService.save(userHasAnsweredEntity);
		
		return ResponseEntity.ok(userHasAnsweredEntity);
	}
}
