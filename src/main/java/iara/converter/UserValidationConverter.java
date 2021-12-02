package iara.converter;

import iara.model.UserValidationEntity;
import iara.model.UserValidationRequest;

public class UserValidationConverter {

	public static UserValidationEntity convertFromRequest(UserValidationRequest request) {
		UserValidationEntity entity = new UserValidationEntity();
		entity.setUsername(request.getUsername());
		entity.setPassword(request.getPassword());
		
		return entity;
	}
	
}