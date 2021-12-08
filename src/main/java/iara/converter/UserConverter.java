package iara.converter;

import iara.model.entity.UserEntity;
import iara.model.request.UserSignupRequest;

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
