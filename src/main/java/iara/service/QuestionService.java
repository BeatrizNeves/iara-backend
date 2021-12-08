package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.entity.QuestionEntity;
import iara.repository.QuestionRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class QuestionService {
	
private final QuestionRepository repository;
	
	public QuestionEntity save(QuestionEntity questionEntity) {
		return repository.save(questionEntity);
	}
	
	public List<QuestionEntity> findAll() {
		return repository.findAll();
	}
	
	public List<QuestionEntity> findAll(Specification<QuestionEntity> filter) {
		return repository.findAll(filter);
	}
	
	public Optional<QuestionEntity> findById(Long id) {
		return repository.findById(id);
	}
}