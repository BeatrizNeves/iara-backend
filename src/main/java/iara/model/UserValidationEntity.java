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
@Table(name = "UserValidation")
public class UserValidationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user_validation;
	
	@Column(nullable=true)
	private String username;
	
	@Column(nullable=true)
	private String password;
	
	@ManyToOne
	@MapsId("id_user")
	@JoinColumn(name="User_id_user")
	private UserEntity user;
	
}
