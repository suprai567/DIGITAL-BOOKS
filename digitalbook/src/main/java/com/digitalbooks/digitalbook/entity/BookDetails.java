package com.digitalbooks.digitalbook.entity;

public class BookDetails {

	private int bookId;
	private Reader reader;

	public BookDetails(int bookId, Reader reader) {
		super();
		this.bookId = bookId;
		this.reader = reader;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", reader=" + reader + "]";
	}

}
