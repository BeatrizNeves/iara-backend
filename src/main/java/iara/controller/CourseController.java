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

import iara.converter.CourseConverter;
import iara.filter.ClassFilter;
import iara.filter.CourseFilter;
import iara.filter.UserHasCourseFilter;
import iara.model.entity.ClassEntity;
import iara.model.entity.CourseEntity;
import iara.model.entity.UserHasCourseEntity;
import iara.model.request.CreateCourseRequest;
import iara.model.request.SearchCourseRequest;
import iara.model.response.CompleteCourseResponse;
import iara.service.ClassService;
import iara.service.CourseService;
import iara.service.UserHasCourseService;

@CrossOrigin(origins = {"http://localhost:3000/", "https://iara-delta.vercel.app/"})
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService service;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private UserHasCourseService userHasCourseService;
	
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
	
	@GetMapping("/registerUser/userId={userId}&courseId={courseId}")
	public ResponseEntity<?> registerUser(@PathVariable(required = true) Long userId, @PathVariable(required = true) Long courseId) {
		return ResponseEntity.ok(service.registerUser(userId, courseId));
	}
	
	@GetMapping("/getCompleteCourseInfo/courseId={courseId}")
	public ResponseEntity<?> getCompleteCourseInfo(@PathVariable(required = true) Long courseId) {
		CompleteCourseResponse completeCourse = new CompleteCourseResponse();
		
		ClassFilter classFilter = ClassFilter.builder().courseId(courseId).build();
		List<ClassEntity> classes = classService.findAll(classFilter.get());
		
		completeCourse.setClasses(classes);
		completeCourse.setCourseInfo(service.findById(courseId).get());
		
		return ResponseEntity.ok(completeCourse);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCourse(@Valid @RequestBody CreateCourseRequest request) {

		CourseEntity course = CourseConverter.convertFromCreateRequest(request);
		
		return ResponseEntity.ok(service.save(course));
	}
	
	@GetMapping("/getUserCourses/userId={userId}")
	public ResponseEntity<?> getUserCourses(@PathVariable(required = true) Long userId) {

		CourseFilter filter = CourseFilter.builder()
				.genericText("")
				.difficultyIsEasy(false)
				.difficultyIsMedium(false)
				.difficultyIsHard(false)
				.durationIsShort(false)
				.durationIsMedium(false)
				.durationIsLong(false)
				.userId(userId).build();
		
		List<CourseEntity> courses = service.findAll(filter.get());
		
		UserHasCourseFilter userHasCourseFilter = UserHasCourseFilter.builder()
				.courseId(null)
				.userId(userId)
				.build();
		
		List<UserHasCourseEntity> userHasCourseEntities = userHasCourseService.findAll(userHasCourseFilter.get());

		
		var wrapper = new Object(){ Boolean isInList = false; };
		userHasCourseEntities.forEach(userCourse -> {
			wrapper.isInList = false;
			
			courses.forEach(courseAlreadyInList -> {
				if(courseAlreadyInList.getId_course() == userCourse.getCourseId()) {
					wrapper.isInList = true;
				}
			});
			
			if(!wrapper.isInList) {
				CourseEntity course = service.findById(userCourse.getCourseId()).get();
				courses.add(course);
			}
		});

		return ResponseEntity.ok(courses);
	}
	
	
}
