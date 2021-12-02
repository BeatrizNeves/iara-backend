package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.ClassTextEntity;
import iara.repository.ClassTextRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ClassTextService {
	
private final ClassTextRepository repository;
	
	public ClassTextEntity save(ClassTextEntity classTextEntity) {
		return repository.save(classTextEntity);
	}
	
	public List<ClassTextEntity> findAll() {
		return repository.findAll();
	}
	
	public List<ClassTextEntity> findAll(Specification<ClassTextEntity> filter) {
		return repository.findAll(filter);
	}
	
	public Optional<ClassTextEntity> findById(Long id) {
		return repository.findById(id);
	}
}