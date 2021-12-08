package iara.filter;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.entity.ExampleEntity;
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
public class ExampleFilter extends RepositoryFilter<ExampleEntity> {
	
	private String name;
	
	@Override
    public Specification<ExampleEntity> get() {
        return (root, query, cb) -> {
            
            query.orderBy(cb.asc(root.get("id")));
            
            Predicate genericTextFilter = like(cb, root.get("name"), name);
            
            return cb.and(genericTextFilter);
        };
    }
}
