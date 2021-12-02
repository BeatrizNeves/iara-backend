package iara.converter;

import iara.model.UserEntity;
import iara.model.UserSignupRequest;
import iara.model.UserValidationEntity;
import iara.model.UserValidationRequest;

public class UserValidationConverter {

	public static UserValidationEntity convertFromRequest(UserValidationRequest request) {
		UserValidationEntity entity = new UserValidationEntity();
		entity.setUsername(request.getUsername());
		entity.setPassword(request.getPassword());
		
		return entity;
	}

	public static UserValidationEntity convertFromSignUpRequest(UserSignupRequest request, UserEntity user) {
		UserValidationEntity entity = new UserValidationEntity();
		entity.setUsername(request.getUsername());
		entity.setPassword(request.getPassword());
		entity.setUser(user);
		
		return entity;
	}
	
}