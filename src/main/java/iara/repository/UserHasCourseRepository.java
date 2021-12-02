package iara.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iara.model.UserHasCourseEntity;

public interface UserHasCourseRepository extends JpaRepository<UserHasCourseEntity, Long> {
	
	@Query("SELECT courseId, COUNT(courseId) AS usersCount FROM UserHasCourseEntity GROUP BY courseId ORDER BY usersCount DESC")
    public List<Object[]> getPopularCourses();
    
	List<UserHasCourseEntity> findAll(Specification<UserHasCourseEntity> filter);
}
