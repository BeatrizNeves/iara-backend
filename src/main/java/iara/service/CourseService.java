package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iara.model.CourseEntity;
import iara.repository.CourseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class CourseService {
	
private final CourseRepository repository;
	
	public CourseEntity save(CourseEntity courseEntity) {
		return repository.save(courseEntity);
	}
	
	public List<CourseEntity> findAll(CourseEntity courseEntity) {
		return repository.findAll();
	}
	
	public Optional<CourseEntity> findById(Long id) {
		return repository.findById(id);
	}
}
