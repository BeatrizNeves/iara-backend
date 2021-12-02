package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.ClassEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long>{

	List<ClassEntity> findAll(Specification<ClassEntity> filter);
}
