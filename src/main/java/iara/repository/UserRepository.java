package iara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
