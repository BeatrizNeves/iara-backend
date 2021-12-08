package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
	
	List<CourseEntity> findAll(Specification<CourseEntity> filter);

}
