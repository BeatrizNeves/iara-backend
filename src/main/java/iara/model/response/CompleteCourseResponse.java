package iara.model.response;

import java.util.List;

import iara.model.entity.ClassEntity;
import iara.model.entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompleteCourseResponse {
	
	private CourseEntity courseInfo;
	
	private List<ClassEntity> classes;

}
