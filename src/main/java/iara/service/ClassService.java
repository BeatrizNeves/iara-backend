package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.filter.UserHasCourseFilter;
import iara.model.entity.ClassEntity;
import iara.model.entity.UserHasClassEntity;
import iara.model.entity.UserHasCourseEntity;
import iara.repository.ClassRepository;
import iara.repository.UserHasClassRepository;
import iara.repository.UserHasCourseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ClassService {
	
private final ClassRepository repository;

private final UserHasClassRepository userHasClassRepository;

private final UserHasCourseRepository userHasCourseRepository;
	
	public ClassEntity save(ClassEntity classEntity) {
		return repository.save(classEntity);
	}
	
	public List<ClassEntity> findAll() {
		return repository.findAll();
	}

	
	public List<ClassEntity> findAll(Specification<ClassEntity> filter) {
		return repository.findAll(filter);
	}
	
	
	public Optional<ClassEntity> findById(Long id) {
		return repository.findById(id);
	}
	
	public UserHasClassEntity registerUser(Long userId, Long classId) {
		UserHasClassEntity userHasClassEntity = new UserHasClassEntity();
		userHasClassEntity.setUserId(userId);
		userHasClassEntity.setClassId(classId);
		
		Optional<ClassEntity> classEntity = this.findById(classId);
		UserHasCourseFilter filter = UserHasCourseFilter.builder().courseId(classEntity.get().getCourse().getId_course()).userId(userId).build();
		
		List<UserHasCourseEntity> userHasCourse = userHasCourseRepository.findAll(filter.get());
		
		if(userHasCourse.isEmpty()) {
			return null;
		}
		
		return userHasClassRepository.save(userHasClassEntity);
		
	}
}
