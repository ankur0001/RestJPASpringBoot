package com.spring.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.spring.exception.BookNotFoundException;
import com.spring.model.Book;
import com.spring.repository.BookService;



@RequestMapping("/jpa" )
@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable long id) {	
		return bookService.findById(id)
							.orElseThrow(() -> new BookNotFoundException("id- "+ id));
	}
	
	@PostMapping("/books")
	public void addBook(@Valid @RequestBody Book book) {
		bookService.save(book);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable long id) {
		Book book = bookService.findById(id)
				.orElseThrow(() -> new BookNotFoundException("id- "+ id));
		bookService.delete(book);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/books")
	public Book updateBook(@Valid @RequestBody Book book) {
		Book oldBook = bookService.findById((long)book.getId())
				.orElseThrow(() -> new BookNotFoundException("id- "+ book.getId()));
		oldBook.setPrice(book.getPrice());
		oldBook.setCategory(book.getCategory());
		
		Book updatedBook = bookService.save(oldBook);
		return updatedBook;
	}
}
