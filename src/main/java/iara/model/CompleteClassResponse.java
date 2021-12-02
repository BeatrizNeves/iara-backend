package iara.model;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CompleteClassResponse {
	
	private List<ClassTextEntity> texts;

	private List<QuestionResponse> questions;
	
	public CompleteClassResponse() {
		questions = new ArrayList<>();
		texts = new ArrayList<>();
	}
	
	public void addQuestion(QuestionEntity question, List<AlternativeEntity> alternatives) {
		QuestionResponse questionResponse = new QuestionResponse(question, alternatives);
		questions.add(questionResponse);
	}
	
}
