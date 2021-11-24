package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iara.model.ClassEntity;
import iara.repository.ClassRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ClassService {
	
private final ClassRepository repository;
	
	public ClassEntity save(ClassEntity classEntity) {
		return repository.save(classEntity);
	}
	
	public List<ClassEntity> findAll(ClassEntity classEntity) {
		return repository.findAll();
	}
	
	public Optional<ClassEntity> findById(Long id) {
		return repository.findById(id);
	}
}
