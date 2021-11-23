package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.ExampleEntity;

public interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
	
	List<ExampleEntity> findAll(Specification<ExampleEntity> filter);

}
