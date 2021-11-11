package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iara.model.ExampleEntity;
import iara.repository.ExampleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class ExampleService {
	
	private final ExampleRepository repository;
	
	public ExampleEntity save(ExampleEntity exampleEntity) {
		return repository.save(exampleEntity);
	}
	
	public List<ExampleEntity> findAll(ExampleEntity exampleEntity) {
		return repository.findAll();
	}
	
	public Optional<ExampleEntity> findById(Long id) {
		return repository.findById(id);
	}
}
