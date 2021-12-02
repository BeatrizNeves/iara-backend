package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.UserValidationEntity;

public interface UserValidationRepository extends JpaRepository<UserValidationEntity, Long> {
	
	List<UserValidationEntity> findAll(Specification<UserValidationEntity> filter);
}