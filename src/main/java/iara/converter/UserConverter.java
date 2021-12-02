package iara.converter;

import iara.model.UserEntity;
import iara.model.UserSignupRequest;

public class UserConverter {

	public static UserEntity convertFromSignUpRequest(UserSignupRequest request) {
		UserEntity entity = new UserEntity();
		entity.setName(request.getName());
		entity.setBio(request.getBio());
		entity.setLogo(request.getLogo());
		entity.setRole(request.getRole());
		
		return entity;
	}
}
