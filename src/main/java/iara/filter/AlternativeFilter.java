package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.AlternativeEntity;
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
public class AlternativeFilter extends RepositoryFilter<AlternativeEntity> {
	
	private Long questionId;
	
	@Override
    public Specification<AlternativeEntity> get() {
        return (root, query, cb) -> {
        	Set<Long> questionIdList = new HashSet<>(); 
        	questionIdList.add(questionId);
            
            query.orderBy(cb.asc(root.get("id")));
            
            Predicate genericTextFilter = in(cb, root.join("questionEntity").get("id"), questionIdList);
            
            return cb.and(genericTextFilter);
        };
    }
}
