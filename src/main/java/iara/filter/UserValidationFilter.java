package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.entity.UserValidationEntity;
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
public class UserValidationFilter extends RepositoryFilter<UserValidationEntity> {
	
	private String username;
	private String password;
	
	@Override
    public Specification<UserValidationEntity> get() {
        return (root, query, cb) -> {
            
        	Set<String> usernameList = new HashSet<String>();
        	Set<String> passwordList = new HashSet<String>();
        	usernameList.add(username);
        	passwordList.add(password);
        	
            Predicate usernameFilter = in(cb, root.get("username"), usernameList);
            
            Predicate passwordFilter = in(cb, root.get("password"), passwordList);
            
            return cb.and(usernameFilter, passwordFilter);
        };
    }
}