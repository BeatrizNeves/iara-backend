package iara.model.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateQuestionRequest {

	@NotBlank
	private String title;

	private String image;

	private String content;

	private int index;
	
	private List<CreateAlternativeRequest> alternatives;

}
