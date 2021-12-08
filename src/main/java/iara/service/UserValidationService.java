package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.entity.UserValidationEntity;
import iara.repository.UserValidationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserValidationService {
	
	private final UserValidationRepository repository;
	
	public UserValidationEntity save(UserValidationEntity exampleEntity) {
		return repository.save(exampleEntity);
	}
	
	public List<UserValidationEntity> findAll() {
		return repository.findAll();
	}
	
	public List<UserValidationEntity> findAll(Specification<UserValidationEntity> filter) {
		return repository.findAll(filter);
	}
	
	public Optional<UserValidationEntity> findById(Long id) {
		return repository.findById(id);
	}
}