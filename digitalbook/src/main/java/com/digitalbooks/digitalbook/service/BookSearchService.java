package com.digitalbooks.digitalbook.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
import com.digitalbooks.digitalbook.entity.BookDetails;
import com.digitalbooks.digitalbook.entity.Purchase;
import com.digitalbooks.digitalbook.entity.Reader;
import com.digitalbooks.digitalbook.repository.AuthorRepository;
import com.digitalbooks.digitalbook.repository.BookSearchRepository;
import com.digitalbooks.digitalbook.repository.BookSpecification;
import com.digitalbooks.digitalbook.repository.PurchaseRepository;
import com.digitalbooks.digitalbook.repository.RandomString;
import com.digitalbooks.digitalbook.repository.ReaderRepository;

@Service
public class BookSearchService {

	@Autowired
	BookSearchRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	ReaderRepository readerRepository;
	@Autowired
	PurchaseRepository purchaseRepository;

	public Book save(Book book) {
		bookRepository.save(book);
		return book;
	}

	public Iterable<Book> getBook() {
		return bookRepository.findAll();
	}

	public List<Book> searchBooks(String author, String category, Float price, String publisher) {
		List<Book> book = bookRepository.findAll(
				Specification.where(BookSpecification.withAuthor(author).and(BookSpecification.withCategory(category)))
						.and(BookSpecification.withPrice(price)).and(BookSpecification.withPublisher(publisher)));
		return book;
	}

	public Book getBooks(Integer bookId) {
		return bookRepository.findById(bookId).get();
	}

	public List<Purchase> getAllPurchasedBooks(String emailId) {
		return purchaseRepository.getAllPurchasedBooks(emailId);
	}

	public Purchase getBooksByPurchseId(String purchaseId) {
		return purchaseRepository.findById(purchaseId).get();
	}

	public List<Author> getAuthor() {
		return authorRepository.findAll();
	}

	/**
	 * This method will find author by id and will return author object
	 * 
	 * @param authId
	 * @return Author
	 */
	public Author getAuthorById(int id) {
		return authorRepository.findById(id);
	}

	public String buyBook(BookDetails bookDetails) {
		Reader reader = bookDetails.getReader();
		String emailId = reader.getEmailId();
		Reader readerFromTable = readerRepository.findByEmail(emailId);
		if (readerFromTable == null) {
			readerRepository.save(reader);
		}
		String purchaseId = RandomString.getAlphaNumericString(10);
		int bookId = bookDetails.getBookId();
		String readerId = bookDetails.getReader().getEmailId();
		Date purchaseDate = new Date();
		Purchase purchase = new Purchase(purchaseId, bookId, readerId, purchaseDate);
		Purchase result = purchaseRepository.save(purchase);
		return result.getPurchaseId();

	}

}
