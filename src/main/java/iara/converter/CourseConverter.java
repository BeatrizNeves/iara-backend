package iara.converter;

import iara.model.entity.CourseEntity;
import iara.model.request.CreateCourseRequest;

public class CourseConverter {
	public static CourseEntity convertFromCreateRequest(CreateCourseRequest request) {
		CourseEntity entity = new CourseEntity();

		entity.setDescription(request.getDescription());
		entity.setDifficulty(request.getDifficulty());
		entity.setDuration(request.getDuration());
		entity.setIcon(request.getIcon());
		entity.setId_user_author(request.getIdAuthor());
		entity.setName(request.getName());
		
		return entity;
	}
}
