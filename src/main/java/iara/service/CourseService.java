package iara.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.entity.CourseEntity;
import iara.model.entity.UserHasCourseEntity;
import iara.repository.CourseRepository;
import iara.repository.UserHasCourseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class CourseService {
	
	private final CourseRepository repository;
	private final UserHasCourseRepository userHasCourseRepository;
	
	public CourseEntity save(CourseEntity courseEntity) {
		return repository.save(courseEntity);
	}
	
	public List<CourseEntity> findAll() {
		return repository.findAll();
	}
	
	public List<CourseEntity> findAll(Specification<CourseEntity> filter) {
		return repository.findAll(filter);
	}
	
	public Optional<CourseEntity> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<CourseEntity> getPopularCourses(){
		List<Object[]> popularCoursesId = userHasCourseRepository.getPopularCourses();
		
		List<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		for (int i = 0; i < popularCoursesId.size() && i < 3; i++) {
			 Optional<CourseEntity> course = findById(Long.valueOf(popularCoursesId.get(i)[0].toString()));
			 courses.add(course.get());
		}
		
		return courses;
	}
	
	public UserHasCourseEntity registerUser(Long userId, Long courseId) {
		UserHasCourseEntity userHasCourseEntity = new UserHasCourseEntity();
		userHasCourseEntity.setUserId(userId);
		userHasCourseEntity.setCourseId(courseId);
		
		return userHasCourseRepository.save(userHasCourseEntity);
		
	}
}