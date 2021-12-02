package iara.filter;

import java.util.List;

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
	
	private List<Long> classId;
	
	@Override
    public Specification<AlternativeEntity> get() {
        return (root, query, cb) -> {
            
            query.orderBy(cb.asc(root.get("id")));
            
            Predicate genericTextFilter = equal(cb, root.join("questionEntity").get("id"), classId.toString());
            
            return cb.and(genericTextFilter);
        };
    }
}
