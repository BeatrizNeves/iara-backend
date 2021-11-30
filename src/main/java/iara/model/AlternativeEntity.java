package iara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Alternative")

public class AlternativeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_alternative;
	
	@Column(nullable=true)
	private String text;
	
	@Column(nullable=true)
	private Boolean correct;
	
	@ManyToOne
	@MapsId("id_question")
	@JoinColumn(name="Question_id_question")
	private QuestionEntity question;
	
}