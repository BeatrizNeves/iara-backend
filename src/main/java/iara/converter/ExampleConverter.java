package iara.converter;

import iara.model.ExampleEntity;
import iara.model.ExampleRequest;

public class ExampleConverter {

	public static ExampleEntity convertFromRequest(ExampleRequest request) {
		ExampleEntity entity = new ExampleEntity();
		entity.setName(request.getName());
		
		return entity;
	}
	
}
