package iara.converter;

import iara.model.entity.AlternativeEntity;
import iara.model.entity.ClassEntity;
import iara.model.entity.CourseEntity;
import iara.model.entity.QuestionEntity;
import iara.model.request.CreateAlternativeRequest;
import iara.model.request.CreateClassRequest;
import iara.model.request.CreateQuestionRequest;

public class ClassConverter {
	public static ClassEntity convertClassFromCreateRequest(CreateClassRequest request, CourseEntity course) {
		ClassEntity entity = new ClassEntity();
		
		entity.setCourse(course);
		entity.setDifficulty(request.getDifficulty());
		entity.setName(request.getName());
		entity.setIndeex(request.getIndex());
		entity.setName(request.getName());
		
		return entity;
	}
	
	public static QuestionEntity convertQuestionFromCreateRequest(CreateQuestionRequest request, ClassEntity classEntity) {
		QuestionEntity question = new QuestionEntity();
		
		question.setClassEntity(classEntity);
		question.setContent(request.getContent());
		question.setImage(request.getImage());
		question.setTitle(request.getTitle());
		question.setIndeex(request.getIndex());
		
		return question;
	}
	
	public static AlternativeEntity convertAlternativeFromCreateRequest(CreateAlternativeRequest request, QuestionEntity question) {
		AlternativeEntity alternative = new AlternativeEntity();
		
		alternative.setCorrect(request.getCorrect());
		alternative.setQuestionEntity(question);
		alternative.setText(request.getText());
		
		return alternative;
	}
}
