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
@Table(name = "Course")

public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_course;
	
	@Column(nullable=true)
	private int id_user_author;
	
	@Column(nullable=true)
	private String name;
	
	@Column(nullable=true)
	private String duration;
	
	@Column(nullable=true)
	private String difficulty;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=true)
	private String icon;
}
