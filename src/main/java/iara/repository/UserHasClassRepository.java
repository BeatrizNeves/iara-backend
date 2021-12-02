package iara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.UserHasClassEntity;

public interface UserHasClassRepository extends JpaRepository<UserHasClassEntity, Long> {
	
}
