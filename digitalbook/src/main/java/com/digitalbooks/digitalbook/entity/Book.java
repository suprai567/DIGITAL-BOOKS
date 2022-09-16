package com.digitalbooks.digitalbook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Title cannot be blank #######")
	private String title;
	/*
	 * @ManyToOne private Author authors;
	 */
	private String author;
	private String logo;
	@NotBlank(message = "Publisher cannot be blank #######")
	private String publisher;
	@Column(name = "published_date")
	private Date publishedDate;

	private boolean active;
	/*
	 * @Enumerated(EnumType.STRING) private Category category;
	 */
	private String category;
	private float price;

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

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

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", category=" + category + ", author=" + author + ", price=" + price + ", logo="
				+ logo + ", title=" + title + ", publisher=" + publisher + ", publishedDate=" + publishedDate + "]";
	}

}
