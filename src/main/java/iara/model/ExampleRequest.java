package iara.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ExampleRequest {
	
	@NotNull
	@Size(max = 30)
	private String name;

}
