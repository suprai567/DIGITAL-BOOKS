package com.digitalbooks.digitalbook.repository;

import org.springframework.data.jpa.domain.Specification;

import com.digitalbooks.digitalbook.entity.Book;

public class BookSpecification {
	// public static Specification<Book> withAuthor(Optional<String> author) {
	public static Specification<Book> withAuthor(String author) {

		// Specification using Java 8 lambdas
		return (root, query, cb) -> {
			if (author == null)
				return cb.conjunction();
			return cb.equal(root.get("author"), author.toString());
		};
	}

	public static Specification<Book> withCategory(String category) {
		return (root, query, cb) -> {
			if (category == null)
				return cb.conjunction();
			return cb.equal(root.get("category"), category);
		};
	}

	public static Specification<Book> withPrice(Float price) {
		if (price == null) {
			return null;
		} else {
			// Specification using Java 8 lambdas
			return (root, query, cb) -> cb.equal(root.get("price"), price);
		}
	}

	public static Specification<Book> withPublisher(String publisher) {
		if (publisher == null) {
			return null;
		} else {
			// Specification using Java 8 lambdas
			return (root, query, cb) -> cb.equal(root.get("publisher"), publisher);
		}
	}

}
