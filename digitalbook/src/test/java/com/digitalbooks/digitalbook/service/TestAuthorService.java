package com.digitalbooks.digitalbook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
import com.digitalbooks.digitalbook.repository.AuthorRepository;
import com.digitalbooks.digitalbook.repository.BookSearchRepository;

@ExtendWith(MockitoExtension.class)
class TestAuthorService {
	@InjectMocks
	BookSearchService bookSearchService;

	@Mock
	BookSearchRepository bookRepository;
	@Mock
	AuthorRepository authorRepository;

	@Test
	void testSave() {
		Book books = new Book();
		books.setId(1);
		books.setTitle("Bhagat");
		books.setAuthor("Chetan");
		books.setLogo("2 States");
		books.setCategory("comic");
		books.setPrice(134);
		books.setPublisher("Rupa Publication");
		books.setPublisedDate("2022-09-08");
		when(bookSearchService.save(books)).thenReturn(books);// mock
		bookSearchService.save(books);
		assertEquals(1, books.getId());
	}

	@Test
	public void testGetBook() throws Exception {
		List<Book> book = new ArrayList<>();
		Book books = new Book();
		books.setId(1);
		books.setTitle("Bhagat");
		books.setAuthor("Chetan");
		books.setLogo("2 States");
		books.setCategory("comic");
		books.setPrice(134);
		books.setPublisher("Rupa Publication");
		books.setPublisedDate("2022-09-08");
		book.add(books);
		when(bookRepository.findAll()).thenReturn(book);
		Iterable<Book> getbooks = bookSearchService.getBook();
		assertEquals(book, getbooks);

	}

	@Test
	public void testGetAuthor() throws Exception {
		List<Author> author = new ArrayList<>();
		Author authors = new Author();
		authors.setId(1);
		authors.setAge(40);
		authors.setEmail("book123@gmail.com");
		authors.setName("Prince");
		author.add(authors);
		when(authorRepository.findAll()).thenReturn(author);
		Iterable<Author> getAuthor = bookSearchService.getAuthor();
		assertEquals(author, getAuthor);
	}

	@Test
	void testSaveAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setAge(40);
		author.setEmail("book123@gmail.com");
		author.setName("Prince");
		when(authorRepository.save(author)).thenReturn(author);// mock
		bookSearchService.saveAuthor(author);
		assertEquals(1, author.getId());
	}
}