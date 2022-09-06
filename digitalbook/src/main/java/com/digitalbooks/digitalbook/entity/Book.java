package com.digitalbooks.digitalbook.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Title cannot be blank #######")
	private String title;
	@ManyToMany
	List<Author> authors;
	private String author;
	private String logo;
	@NotBlank(message = "Publisher cannot be blank #######")
	private String publisher;
	private String publisedDate;
	private String category;
	private float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisedDate() {
		return publisedDate;
	}

	public void setPublisedDate(String publisedDate) {
		this.publisedDate = publisedDate;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", category=" + category + ", author=" + author + ", price=" + price + ", logo="
				+ logo + ", title=" + title + ", publisher=" + publisher + ", publisedDate=" + publisedDate + "]";
	}

}
