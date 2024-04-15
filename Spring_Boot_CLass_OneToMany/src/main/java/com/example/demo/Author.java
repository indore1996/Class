package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	 @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	 private List<Book> books = new ArrayList<>();

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Author() {
	
		// TODO Auto-generated constructor stub
	}

	public Author(String name, List<Book> books) {
	
		this.name = name;
		this.books = books;
	}
	
	
}
