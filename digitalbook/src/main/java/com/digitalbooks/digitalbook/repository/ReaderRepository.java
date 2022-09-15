package com.digitalbooks.digitalbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digitalbooks.digitalbook.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String>{
	
	@Query(value="select * from book.reader where emailId=?1",nativeQuery = true)
	Reader findByEmail(String emailId);

}
