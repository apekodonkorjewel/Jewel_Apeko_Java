package com.company.bookstoreinventory.repository;

import com.company.bookstoreinventory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //Query to search books by author
    List<Book> findByAuthorId(Integer authorId);
}
