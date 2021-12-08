package iara.model.entity;

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
@Table(name = "User_has_class")
public class UserHasClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserHasClass;

	@Column(nullable=false, name="user_id_user")
	private Long userId;

	@Column(nullable=false, name="Class_id_class")
	private Long classId;

	@Column(nullable=false, name="progress")
	private Long progress;

	@Column(nullable=false, name="completed")
	private Boolean completed;
}
