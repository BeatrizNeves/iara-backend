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
@Table(name = "Class")

public class ClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_class;
	
	@Column(nullable=true)
	private String name;
	
	@Column(nullable=true)
	private String difficulty;
	
	@Column(nullable=true)
	private int index;
	
	@ManyToOne
	@MapsId("id_course")
	@JoinColumn(name="Course_id_course")
	private CourseEntity course;
}
