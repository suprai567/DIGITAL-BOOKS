package com.digitalbooks.digitalbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.digitalbooks.digitalbook.entity.Book;

@Repository
public interface BookSearchRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

	// @Query(value="select * from book.book where author=?1 and category=?2 and
	// price=?3 and publisher=?4",nativeQuery = true)
	// List<Book> findBooks(Optional<String> author, Optional<String> category,
	// Optional<Float> price, Optional<String> publisher);
}
