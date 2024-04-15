package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepo bookRepo;
	
	public Page<Author> getAllBook(Integer pageNumber, Integer pageSize, String sortBy){
		Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		return bookRepo.findAll(pageable);
	}
	
	public Author createBook(Author book) {
		return bookRepo.save(book);
	}
	
	public Author updateBook(Author book, Long id) throws Exception {
		Author boo = bookRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		boo.setName(book.getName());
		return bookRepo.save(boo);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
