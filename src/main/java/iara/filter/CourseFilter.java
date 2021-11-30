package iara.filter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import iara.model.CourseEntity;
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
public class CourseFilter extends RepositoryFilter<CourseEntity> {
	
	private String genericText;
	
	private Boolean difficultyIsEasy;
	
	private Boolean difficultyIsMedium;
	
	private Boolean difficultyIsHard;
	
	private Boolean durationIsShort;
	
	private Boolean durationIsMedium;
	
	private Boolean durationIsLong;
	
	@Override
    public Specification<CourseEntity> get() {
        return (root, query, cb) -> {
        	
        	Set<String> difficulties = new HashSet<String>();
        	Set<String> duration = new HashSet<String>();
        	Boolean shouldFilterByDifficulty = false;
        	Boolean shouldFilterByDuration = false;
            
            query.orderBy(cb.asc(root.get("id_course")));
            
            Predicate genericTextFilter = like(cb, root.get("name"), genericText);
            Predicate difficultyFilter = null;
            Predicate durationFilter = null;
            
            if(difficultyIsEasy || difficultyIsMedium || difficultyIsHard) {
            	shouldFilterByDifficulty = true;
            	if(difficultyIsEasy) difficulties.add("Fácil");
            	
            	if(difficultyIsMedium) difficulties.add("Médio");
            	
            	if(difficultyIsHard) difficulties.add("Difícil");
            	
            	difficultyFilter = in(cb, root.get("difficulty"), difficulties);
            }
            
            if(durationIsShort || durationIsMedium || durationIsLong) {
            	shouldFilterByDuration = true;
            	if(durationIsShort) duration.add("Curto");
            	
            	if(durationIsMedium) duration.add("Médio");
            	
            	if(durationIsLong) duration.add("Longo");
            	
            	durationFilter = in(cb, root.get("duration"), duration);
            }
            
            if(shouldFilterByDifficulty) {
            	if(shouldFilterByDuration) {
            		return cb.and(genericTextFilter, difficultyFilter, durationFilter);
            	}else {
            		return cb.and(genericTextFilter, difficultyFilter);
            	}
            } else {
            	if(shouldFilterByDuration) {
            		return cb.and(genericTextFilter, durationFilter);
            	}
            }
          
            return cb.and(genericTextFilter);         
        };
    }
}
