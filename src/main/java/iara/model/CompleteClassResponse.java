package iara.model;

import java.util.*;
import lombok.Data;

@Data
public class CompleteClassResponse {
	
	private List<QuestionEntity> questions;
	private List<ClassTextEntity> texts;
	private List<AlternativeEntity> alternatives;
	
	public CompleteClassResponse(List<QuestionEntity> questionsInput, List<ClassTextEntity> textsInput, List<AlternativeEntity> alternativesInput) {
		questions = questionsInput;
		texts = textsInput;
		alternatives = alternativesInput;

	}

	
}
