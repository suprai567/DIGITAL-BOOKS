package com.digitalbooks.digitalbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbooks.digitalbook.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	@Query("select author from Author author where author.id =?1")
	Author findById(int autherId);

}
