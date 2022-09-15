package com.digitalbooks.digitalbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.digitalbook.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
	@Query(value = "select book.book.title, book.book.author, book.book.price from book.book,book.purchase where book.purchase.book_id=book.book.id and book.purchase.reader_id=:emailId", nativeQuery = true)
	//@Query(value = "Select * from book.purchase where reader_id=?1", nativeQuery = true)
	List<Purchase> getAllPurchasedBooks(String emailId);
}
