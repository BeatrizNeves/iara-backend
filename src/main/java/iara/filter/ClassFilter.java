package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.ClassEntity;
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
public class ClassFilter extends RepositoryFilter<ClassEntity> {
	
	private Long courseId;
	
	@Override
    public Specification<ClassEntity> get() {
        return (root, query, cb) -> {
            query.orderBy(cb.asc(root.get("id_class")));
            Set<Long> courseIdList = new HashSet<Long>();
            courseIdList.add(courseId);
            
            //Predicate genericTextFilter = in(cb, root.get("id_class"), classIdList);
            Predicate genericTextFilter = in(cb, root.join("course").get("id_course"), courseIdList);
            
            return cb.and(genericTextFilter);
        };
    }
}
