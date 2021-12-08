package iara.converter;

import iara.model.entity.UserEntity;
import iara.model.entity.UserValidationEntity;
import iara.model.request.UserSignupRequest;
import iara.model.request.UserValidationRequest;

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