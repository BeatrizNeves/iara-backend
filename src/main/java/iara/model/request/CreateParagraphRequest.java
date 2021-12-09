package iara.model.request;

import lombok.Data;

@Data
public class CreateParagraphRequest {

	private String image;
	
	private String content;
	
	private String index;
}
