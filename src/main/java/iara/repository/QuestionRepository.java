package iara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import iara.model.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

}
