package com.digitalbooks.digitalbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
import com.digitalbooks.digitalbook.repository.AuthorRepository;
import com.digitalbooks.digitalbook.repository.BookSearchRepository;
import com.digitalbooks.digitalbook.repository.BookSpecification;

@Service
public class BookSearchService {

	@Autowired
	BookSearchRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;

	public Book save(Book book) {
		bookRepository.save(book);
		return book;
	}

	public Iterable<Book> getBook() {
		return bookRepository.findAll();
	}

	public List<Book> searchBooks(Optional<String> author, Optional<String> category, Optional<Float> price,
			Optional<String> publisher) {
		List<Book> book = bookRepository.findAll(Specification.where(BookSpecification.withAuthor(author)));
		System.out.println(book);
		return book;
	}

	public List<Author> getAuthor() {
		return authorRepository.findAll();
	}

	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

}
