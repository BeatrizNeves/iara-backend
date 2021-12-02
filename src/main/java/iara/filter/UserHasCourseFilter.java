package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.UserHasCourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
public class UserHasCourseFilter extends RepositoryFilter<UserHasCourseEntity> {
	
	private Long userId;
	private Long courseId;
	
	@Override
    public Specification<UserHasCourseEntity> get() {
        return (root, query, cb) -> {
            
        	Set<String> userIdList = new HashSet<String>();
        	Set<String> courseIdList = new HashSet<String>();
        	userIdList.add(userId.toString());
        	courseIdList.add(courseId.toString());
        	
            Predicate userFilter = in(cb, root.get("userId"), userIdList);
            
            Predicate courseFilter = in(cb, root.get("courseId"), courseIdList);
            
            return cb.and(userFilter, courseFilter);
        };
    }
}