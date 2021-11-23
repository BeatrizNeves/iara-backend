package iara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
