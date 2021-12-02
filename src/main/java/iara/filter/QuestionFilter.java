package iara.filter;

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
            
            Predicate genericTextFilter = equal(cb, root.join("classEntity").get("id_class"), classId.toString());
            
            return cb.and(genericTextFilter);
        };
    }
}
