package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private BookService bookRepo;
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/book")
	public Page<Book> getAllBook(@RequestBody Integer pageNumber,@RequestBody Integer pageSize,@RequestParam(defaultValue = "id") String sortBy){
		return bookRepo.getAllBook(pageNumber, pageSize, sortBy);
	}
	
	@GetMapping("/author")
	public Page<Author> getAllauthor(@RequestBody Integer pageNumber,@RequestBody Integer pageSize,@RequestParam(defaultValue = "id") String sortBy){
		return authorService.getAllBook(pageNumber, pageSize, sortBy);
	}
	
	
	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		return bookRepo.createBook(book);
	}
	
	@PostMapping("/author")
	public Author createAuthor(@RequestBody Author book) {
		return authorService.createBook(book);
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book,@PathVariable Long id) throws Exception {		
		return bookRepo.updateBook(book, id);
	}
	
	@PutMapping("/author/{id}")
	public Author updateAuthor(@RequestBody Author book,@PathVariable Long id) throws Exception {		
		return authorService.updateBook(book, id);
	}
	
	@DeleteMapping("/book/{id}")
	public void delete(Long id) {
		bookRepo.delete(id);
	}
	
	@DeleteMapping("/autor/{id}")
	public void del(Long id) {
		authorService.delete(id);
	}
}
