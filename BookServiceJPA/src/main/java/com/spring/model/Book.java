package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="book")
@EntityListeners(AuditingEntityListener.class)
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message="Id should not be null")
	private long id;
	
	private String category;
	
	@Min(value=0, message="Price should not be Negative")
	private int price;
	
	
	public Book() {
		super();
	}

	public Book(int id, String category, int price) {
		super();
		this.id = id;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
