package iara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.entity.UserHasCourseEntity;
import iara.repository.UserHasCourseRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserHasCourseService {
	
	private final UserHasCourseRepository repository;
	
	public List<UserHasCourseEntity> findAll(Specification<UserHasCourseEntity> filter) {
		return repository.findAll(filter);
	}
}
