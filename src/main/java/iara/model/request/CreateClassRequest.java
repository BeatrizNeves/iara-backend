package iara.model.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateClassRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String difficulty;
	
	@NotNull
	private int index;
	
	@NotNull
	private int courseId;
	
	private List<CreateQuestionRequest> questions;

}
