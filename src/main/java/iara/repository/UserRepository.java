package iara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
