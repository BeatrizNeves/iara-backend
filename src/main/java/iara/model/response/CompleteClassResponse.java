package iara.model.response;

import java.util.*;

import iara.model.entity.AlternativeEntity;
import iara.model.entity.ClassEntity;
import iara.model.entity.ClassTextEntity;
import iara.model.entity.QuestionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CompleteClassResponse {
	
	private ClassEntity classInfo;
	
	private List<ClassTextEntity> texts;

	private List<QuestionResponse> questions;
	
	public CompleteClassResponse() {
		questions = new ArrayList<>();
		texts = new ArrayList<>();
	}
	
	public void addQuestion(QuestionEntity question, List<AlternativeEntity> alternatives, Long answeredAlternative) {
		QuestionResponse questionResponse = new QuestionResponse(question, alternatives, answeredAlternative);
		questions.add(questionResponse);
	}
	
}
