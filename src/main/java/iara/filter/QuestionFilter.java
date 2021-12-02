package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.QuestionEntity;
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
public class QuestionFilter extends RepositoryFilter<QuestionEntity> {
	
	private Long classId;
	
	@Override
    public Specification<QuestionEntity> get() {
        return (root, query, cb) -> {
            query.orderBy(cb.asc(root.get("id")));
            Set<Long> classIdList = new HashSet<Long>();
            classIdList.add(classId);
            
            Predicate genericTextFilter = in(cb, root.join("classEntity").get("id_class"), classIdList);
            
            return cb.and(genericTextFilter);
        };
    }
}
