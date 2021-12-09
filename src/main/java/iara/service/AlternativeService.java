package iara.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.entity.AlternativeEntity;
import iara.repository.AlternativeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AlternativeService {
	
	private final AlternativeRepository repository;
	
	public AlternativeEntity save(AlternativeEntity alternativeEntity) {
		return repository.save(alternativeEntity);
	}
	
	public List<AlternativeEntity> findAll(Specification<AlternativeEntity> filter) {
		return repository.findAll(filter);
	}
	
	public Optional<AlternativeEntity> findById(Long id) {
		return repository.findById(id);
	}
}
