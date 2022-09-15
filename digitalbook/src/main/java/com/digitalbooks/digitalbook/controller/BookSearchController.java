package com.digitalbooks.digitalbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
import com.digitalbooks.digitalbook.entity.BookDetails;
import com.digitalbooks.digitalbook.entity.Purchase;
import com.digitalbooks.digitalbook.entity.Reader;
import com.digitalbooks.digitalbook.service.BookSearchService;
import com.digitalbooks.digitalbook.service.PurchaseResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author supra
 * 
 *         This is BookSearchController which run methods for book api
 *         getBookByAuthorCategoryPrice method is used for fetching book details
 *         for book id searchBooks method is used for fetching all books which
 *         match conditions for category, author, price and publisher saveBook
 *         method is used for saving book with author id saveAuthor method is
 *         used for saving author details
 *
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/digitalbooks")
public class BookSearchController {

	@Autowired
	BookSearchService bookSearchService;

	/**
	 * 
	 * This method always returns the searched book based on author category price
	 * and publisher if these fields are null it will return whole book
	 *
	 * @param author    author of book
	 * @param category  category of book
	 * @param price     price of book
	 * @param publisher publisher of book
	 * @return returns the searched book based on author category price and
	 *         publisher if these fields are null it will return whole book
	 */
	@GetMapping("/books/search")
	Iterable<Book> getBookByAuthorCategoryPrice(@RequestParam(required = false) String author,
			@RequestParam(required = false) String category, @RequestParam(required = false) Float price,
			@RequestParam(required = false) String publisher) {
		if (author == null && category == null && price == null && publisher == null) {
			return bookSearchService.getBook();
		}
		return bookSearchService.searchBooks(author, category, price, publisher);
	}

	/**
	 * 
	 * This method always returns the purchased book by giving purchaseId
	 *
	 * @param bookDetails contains details of book
	 * @return returns the purchased book by giving purchaseId
	 */
	@PostMapping(value = "/books/buy", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PurchaseResponse buyBook(@RequestBody BookDetails bookDetails) {
		String purchaseId = bookSearchService.buyBook(bookDetails);
		return new PurchaseResponse(purchaseId);

	}

	// GetMapping reader can find all purchased books
	@GetMapping("/readers/{emailId}/books")
	List<Purchase> getAllPurchaseBooks(@PathVariable String emailId) {
		return bookSearchService.getAllPurchasedBooks(emailId);
	}

	@GetMapping("/readers/{emailId}/books/{bookId}")
	Book getUser(@PathVariable String emailId, @PathVariable Integer bookId) {
		return bookSearchService.getBooks(bookId);
	}

	@PostMapping("/readers/{emailId}/books")
	Purchase getUserByPurchaseId(@PathVariable String emailId, @RequestParam String purchaseId) {
		return bookSearchService.getBooksByPurchseId(purchaseId);
	}

	/**
	 * 
	 * This method always returns the purchased book by giving purchaseId
	 *
	 * @param emailId contains emailId of the reader
	 * @param bookId  contains id of book
	 * @return returns the response based on emailId and bookId and if book is not
	 *         present it will return response as not found
	 */
	/*
	 * @GetMapping("/readers/{emailId}/books/{bookId}") public ResponseEntity<Book>
	 * getBook(@PathVariable String emailId, @PathVariable Integer bookId) {
	 * ResponseEntity<Book> response; Book book =
	 * bookSearchService.getBooks(bookId); if (book == null) { response = new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } else { response = new
	 * ResponseEntity<>(book, HttpStatus.OK); } return response; }
	 */

	@PostMapping
	public Integer saveBook(@RequestBody Book books) {
		bookSearchService.save(books);
		return books.getId();
	}

	@GetMapping("/author")
	public Iterable<Author> getAuthor() {
		return bookSearchService.getAuthor();
	}

	/*
	 * @PostMapping("/author/{authorId}/books") Integer saveBooks(@RequestBody Book
	 * book, @PathVariable("authorId") int authorId) { Author author =
	 * bookSearchService.getAuthorById(authorId); if (null != author) {
	 * book.setAuthor(author); bookSearchService.save(book); return book.getId(); }
	 * return authorId; }
	 */

}