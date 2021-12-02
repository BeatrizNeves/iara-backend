package iara.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "User_has_answered")
public class UserHasAnsweredEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserHasAnswered;

	@Column(nullable=false, name="user_id_user")
	private Long userId;

	@Column(nullable=false, name="question_id_question")
	private Long questionId;

	@Column(nullable=false, name="alternative_id_alternative")
	private Long alternativeId;

}
