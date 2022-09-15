package com.digitalbooks.digitalbook.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.web.servlet.MockMvc;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
import com.digitalbooks.digitalbook.repository.AuthorRepository;
import com.digitalbooks.digitalbook.repository.BookSearchRepository;
import com.digitalbooks.digitalbook.repository.BookSpecification;
import com.digitalbooks.digitalbook.service.BookSearchService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
public class TestAuthorController {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	BookSearchService bookSearchService;
	@InjectMocks
	BookSearchController bookController;
	@InjectMocks
	BookSpecification bookSpecification;
	@InjectMocks
	BookSearchRepository bookSearchRepository;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetBookByAuthorCategoryPrice() throws Exception {
		List<Book> book = new ArrayList<>();

		Book books = new Book();
		books.setTitle("Bhagat");
		books.setAuthor("Chetan");
		books.setLogo("2 States");
		books.setCategory("comic");
		books.setPrice(134);
		books.setPublisher("Rupa Publication");
		books.setPublisedDate("2022-09-08");

		/*
		 * Optional<String> author = Optional.of("Chetan"); Optional<String> category =
		 * Optional.of("comic"); Optional<Float> price = Optional.of(134.0f);
		 * Optional<String> publisher = Optional.of("Rupa Publication");
		 */
		book.add(books);
		Mockito.when(bookSearchService.getBook()).thenReturn(book);
		mockMvc.perform(get("/digitalbooks/books/search?author=Ruskin&price=400&publisher=Press&category=horror"))
				.andExpect(status().isOk());
		Iterable<Book> getbooks = bookController.getBookByAuthorCategoryPrice("Chetan", "comic", 134.0f,
				"Rupa Publication");
		assertEquals(book, getbooks);

	}

	@Test
	void testSaveBook() {
		Book books = new Book();
		books.setId(1);
		books.setTitle("Bhagat");
		books.setAuthor("Chetan");
		books.setLogo("2 States");
		books.setCategory("comic");
		books.setPrice(134.0f);
		books.setPublisher("Rupa Publication");
		books.setPublisedDate("2022-09-08");
		Mockito.when(bookSearchService.save(books)).thenReturn(books);
		Integer savedbookId = bookController.saveBook(books);
		assertEquals(1, savedbookId);
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
		Mockito.when(bookSearchService.getAuthor()).thenReturn(author);
		mockMvc.perform(get("/digitalbooks/author")).andExpect(status().isOk());
		Iterable<Author> getAuthor = bookController.getAuthor();
		assertEquals(author, getAuthor);

	}

	@Test
	void testSaveAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setAge(40);
		author.setEmail("book123@gmail.com");
		author.setName("Prince");
		Mockito.when(bookSearchService.saveAuthor(author)).thenReturn(author);// mocking
		Integer savedauthorId = bookController.saveAuthor(author);
		assertEquals(1, savedauthorId);
	}
}