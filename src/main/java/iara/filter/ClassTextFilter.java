package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.entity.ClassTextEntity;
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
public class ClassTextFilter extends RepositoryFilter<ClassTextEntity> {
	
	private Long classId;
	
	@Override
    public Specification<ClassTextEntity> get() {
        return (root, query, cb) -> {
            query.orderBy(cb.asc(root.get("id")));
            Set<Long> classIdList = new HashSet<Long>();
            classIdList.add(classId);
            
            Predicate genericTextFilter = in(cb, root.join("classEntity").get("id_class"), classIdList);
            
            return cb.and(genericTextFilter);
        };
    }
}
