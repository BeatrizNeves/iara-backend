package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.UserHasAnsweredEntity;
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
public class UserHasAnsweredFilter extends RepositoryFilter<UserHasAnsweredEntity> {
	
	private Long userId;
	private Long questionId;
	
	@Override
    public Specification<UserHasAnsweredEntity> get() {
        return (root, query, cb) -> {
            
        	Set<String> userIdList = new HashSet<String>();
        	Set<String> questionList = new HashSet<String>();
        	userIdList.add(userId.toString());
        	questionList.add(questionId.toString());
        	
            Predicate userFilter = in(cb, root.get("userId"), userIdList);
            
            Predicate questionFilter = in(cb, root.get("questionId"), questionList);
            
            return cb.and(userFilter, questionFilter);
        };
    }
}