package com.digitalbooks.digitalbook.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {
	@Id
	private String purchaseId;
	private int bookId;
	private String readerId;
	private Date purchaseDate;
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getReaderId() {
		return readerId;
	}
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Purchase(String purchaseId, int bookId, String readerId, Date purchaseDate) {
		super();
		this.purchaseId = purchaseId;
		this.bookId = bookId;
		this.readerId = readerId;
		this.purchaseDate = purchaseDate;
	}
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Purchase [purchaseId=" + purchaseId + ", bookId=" + bookId + ", readerId=" + readerId
				+ ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}
