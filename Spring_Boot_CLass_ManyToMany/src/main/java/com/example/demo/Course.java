package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String credits;
	
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="course_teacher", joinColumns = @JoinColumn(name="course_id"),inverseJoinColumns=@JoinColumn(name="teacher_id"))
	private Set<Teacher> teachers = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Course(String name, String desc, String credits, Set<Teacher> teachers) {
		
		this.name = name;
		this.description = desc;
		this.credits = credits;
		this.teachers = teachers;
	}

	public Course() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}
