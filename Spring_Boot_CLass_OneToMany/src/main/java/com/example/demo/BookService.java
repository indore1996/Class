package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;
	
	public Page<Book> getAllBook(Integer pageNumber, Integer pageSize, String sortBy){
		Pageable pageable = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy));
		return bookRepo.findAll(pageable);
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book, Long id) throws Exception {
		Book boo = bookRepo.findById(id).orElseThrow(()-> new Exception("no"+id));
		
		boo.setTitle(book.getTitle());
		return bookRepo.save(boo);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
