package iara.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserValidationRequest {
	
	@NotNull
	@Size(max = 30)
	private String username;
	
	@NotNull
	@Size(max = 30)
	private String password;
	

}
