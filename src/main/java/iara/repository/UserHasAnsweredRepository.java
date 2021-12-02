package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.UserHasAnsweredEntity;

public interface UserHasAnsweredRepository extends JpaRepository<UserHasAnsweredEntity, Long> {

	List<UserHasAnsweredEntity> findAll(Specification<UserHasAnsweredEntity> filter);
}
