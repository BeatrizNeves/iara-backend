package iara.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private int indeex;
	
	@ManyToOne
	@JoinColumn(name="Course_id_course", referencedColumnName="id_course")
	@JsonIgnore
	private CourseEntity course;
	
}
