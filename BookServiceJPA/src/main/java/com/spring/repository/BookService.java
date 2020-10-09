package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Book;


@Repository
public interface BookService extends JpaRepository<Book,Long>{

	/*
	 * public List<Book> getAllBook(); public Book getBookById(int id); public Book
	 * save(Book book); public Book deleteBookById(int id); public Book update(Book
	 * book);
	 */
}
