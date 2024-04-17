package br.com.alura.entity;

import java.time.LocalDateTime;

import br.com.alura.entity.enums.CourseStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true, length = 10)
	private String code;
	
	@ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
	private User instructor;
	
	@Column(nullable = false)
	private String nameCourse;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private CourseStatus status;
	
	@Column(nullable = false)
	private LocalDateTime creationDate;
	
	private LocalDateTime inactivationDate;
}
