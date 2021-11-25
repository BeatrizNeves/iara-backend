package iara.model;

import java.util.*;
import lombok.Data;

@Data
public class CompleteClassResponse {
	
	private List<QuestionEntity> questions;
	private List<ClassTextEntity> texts;
	
	public CompleteClassResponse(List<QuestionEntity> questionsInput, List<ClassTextEntity> textsInput) {
		questions = questionsInput;
		texts = textsInput;
	}

	
}
