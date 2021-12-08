package iara.model.request;

import lombok.Data;

@Data
public class SearchCourseRequest {
	
	private String name;
	
	private Boolean difficultyIsEasy = false;
	
	private Boolean difficultyIsMedium = false;
	
	private Boolean difficultyIsHard = false;
	
	private Boolean durationIsShort = false;
	
	private Boolean durationIsMedium = false;
	
	private Boolean durationIsLong = false;

}
