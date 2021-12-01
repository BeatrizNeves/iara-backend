package iara.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iara.model.UserEntity;
import iara.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {
	
	private final UserRepository repository;
		
	public Optional<UserEntity> findById(Long id) {
		return repository.findById(id);
	}

}
