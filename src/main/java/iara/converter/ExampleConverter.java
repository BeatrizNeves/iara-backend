package iara.converter;

import iara.model.entity.ExampleEntity;
import iara.model.request.ExampleRequest;

public class ExampleConverter {

	public static ExampleEntity convertFromRequest(ExampleRequest request) {
		ExampleEntity entity = new ExampleEntity();
		entity.setName(request.getName());
		
		return entity;
	}
	
}
