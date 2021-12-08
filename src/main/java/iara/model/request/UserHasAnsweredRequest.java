package iara.model.request;

import lombok.Data;

@Data
public class UserHasAnsweredRequest {
	
	private Long userId;
	
	private Long questionId;
	
	private Long alternativeId;

}
