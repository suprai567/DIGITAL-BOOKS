package com.digitalbooks.digitalbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.digitalbooks.digitalbook.entity.Book;

public class BookSpecification {
	public static Specification<Book> withAuthor(Optional<String> author) {
        if (author.isEmpty()) {
            return null;
        } else {
        	System.out.println("Hello");
            // Specification using Java 8 lambdas
            return (root, query, cb) -> cb.equal(root.get("author"), author.toString());
        }
    }
	public static Specification<Book> withCategory(Optional<String> category) {
        if (category.isEmpty()) {
            return null;
        } else {
            // Specification using Java 8 lambdas
            return (root, query, cb) -> cb.equal(root.get("category"), category);
        }
    }
	public static Specification<Book> withPrice(Optional<Float> price) {
        if (price.isEmpty()) {
            return null;
        } else {
            // Specification using Java 8 lambdas
            return (root, query, cb) -> cb.equal(root.get("price"), price);
        }
    }
	public static Specification<Book> withPublisher(Optional<String> publisher) {
        if (publisher.isEmpty()) {
            return null;
        } else {
            // Specification using Java 8 lambdas
            return (root, query, cb) -> cb.equal(root.get("publisher"), publisher);
        }
    }

}
