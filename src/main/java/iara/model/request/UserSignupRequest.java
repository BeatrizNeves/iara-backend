package iara.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserSignupRequest {
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

	@NotBlank
	private String name;
	
	private String role;
	
	private String logo;
	
	private String bio;

}
