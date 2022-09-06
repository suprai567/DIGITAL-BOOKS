package com.digitalbooks.digitalbook.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.digitalbooks.digitalbook.entity.Author;
import com.digitalbooks.digitalbook.entity.Book;
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

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testGetBooks() throws Exception {
		List<Book> book = new ArrayList<>();
		Book books = new Book();
		Optional<String> author = Optional.of("Chetan");
		Optional<String> category = Optional.of("comic");
		Optional<Float> price = Optional.of(134.0f);
		Optional<String> publisher = Optional.of("Rupa Publication");
		book.add(books);
		Mockito.when(bookSearchService.getBook()).thenReturn(book);
		mockMvc.perform(get("/digitalbooks/books/search")).andExpect(status().isOk());
		Iterable<Book> getbooks = bookController.getBookByAuthorCategoryPrice(author, category, price, publisher);
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
		Mockito.when(bookSearchService.getAuthor()).thenReturn(author);
		mockMvc.perform(get("/digitalbooks/author")).andExpect(status().isOk());
		Iterable<Author> getAuthor = bookController.getAuthor();
		assertEquals(author, getAuthor);

	}

	@Test
	void testSaveAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setName("Ramu");
		author.setEmail("abc@gmail.com");
		author.setAge(30);
		Mockito.when(bookSearchService.saveAuthor(author)).thenReturn(author);// mocking
		Integer savedauthorId = bookController.saveAuthor(author);
		assertEquals(1, savedauthorId);
	}
}