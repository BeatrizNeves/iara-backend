package iara.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
	
	private QuestionEntity question;
	
	private List<AlternativeEntity> alternatives;
	
	private Long answeredAlternative;

}
