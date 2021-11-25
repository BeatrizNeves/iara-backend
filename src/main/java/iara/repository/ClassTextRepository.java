package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.ClassTextEntity;

public interface ClassTextRepository extends JpaRepository<ClassTextEntity, Long> {
	
	List<ClassTextEntity> findAll(Specification<ClassTextEntity> filter);
}
