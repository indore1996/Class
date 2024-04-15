package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String expertise;
	private String department;
	
	
	
	@ManyToMany(mappedBy="teachers")
	private Set<Course> courses = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Teacher(String name, String expertise, String department, Set<Course> courses) {
	
		this.name = name;
		this.expertise = expertise;
		this.department = department;
		this.courses = courses;
	}

	public Teacher() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	
}
