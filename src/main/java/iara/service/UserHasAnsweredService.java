package iara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import iara.model.entity.UserHasAnsweredEntity;
import iara.repository.UserHasAnsweredRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserHasAnsweredService {

	private final UserHasAnsweredRepository userHasAnsweredRepository;

	public UserHasAnsweredEntity save(UserHasAnsweredEntity userHasAnsweredEntity) {
		return userHasAnsweredRepository.save(userHasAnsweredEntity);
	}
	
	public List<UserHasAnsweredEntity> findAll(Specification<UserHasAnsweredEntity> filter){
		return userHasAnsweredRepository.findAll(filter);
	}

}
