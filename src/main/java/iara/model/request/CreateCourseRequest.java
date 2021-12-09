package iara.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateCourseRequest {
	
	@NotNull
	private int idAuthor;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String duration;
	
	@NotBlank
	private String difficulty;
	
	@NotBlank
	private String description;
	
	private String icon;
}
