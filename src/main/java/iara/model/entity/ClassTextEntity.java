package iara.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Paragraph")

public class ClassTextEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paragraph")
	private Long id;
	
	@Column(nullable=true)
	private String image;
	
	@Column(nullable=true)
	private String content;
	
	@Column(nullable=true)
	private String indeex;
	
	@ManyToOne
	@JoinColumn(name="Class_id_class", referencedColumnName = "id_class")
	private ClassEntity classEntity;
	
}
