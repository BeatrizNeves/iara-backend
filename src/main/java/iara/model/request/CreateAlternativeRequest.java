package iara.model.request;


import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateAlternativeRequest {

	@NotBlank	
	private String text;

	@NotBlank
	private Boolean correct;
}
