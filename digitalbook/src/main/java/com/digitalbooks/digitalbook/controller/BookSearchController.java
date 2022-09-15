package com.digitalbooks.digitalbook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
import com.digitalbooks.digitalbook.service.BookSearchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // spring bean
@RequestMapping("/digitalbooks")
public class BookSearchController {

	@Autowired
	BookSearchService bookSearchService;

	/*
	 * @GetMapping() Iterable<Book> getBook() { return bookSearchService.getBook();
	 * }
	 */

	@GetMapping("/books/search")
	Iterable<Book> getBookByAuthorCategoryPrice(@RequestParam Optional<String> author,
			@RequestParam Optional<String> category, @RequestParam Optional<Float> price,
			@RequestParam Optional<String> publisher) {
		if (author.isEmpty() && category.isEmpty() && price.isEmpty() && publisher.isEmpty()) {
			return bookSearchService.getBook();
		}
		return bookSearchService.searchBooks(author, category, price, publisher);
	}

	/*
	 * @PostMapping Integer saveBook(@RequestBody Book book) {
	 * bookSearchService.save(book); return book.getId(); }
	 */

	@GetMapping("/author")
	public Iterable<Author> getAuthor() {
		return bookSearchService.getAuthor();
	}

	@PostMapping("/author")
	public Integer saveAuthor(@RequestBody Author author) {
		bookSearchService.saveAuthor(author);
		return author.getId();
	}

}