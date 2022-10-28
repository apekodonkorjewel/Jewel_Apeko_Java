package com.company.bookstoreinventory.controller;

import com.company.bookstoreinventory.model.Book;
import com.company.bookstoreinventory.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    //Add a new book
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook (@RequestBody Book book){
        return bookRepository.save(book);
    }

    //Update an existing book
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    //Delete an existing book
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
    }

    //Get book by id
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable int id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        else{
            return null;
        }
    }

    //Get all books
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //Get book by author
    @GetMapping("/books/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable int id){
        return bookRepository.findByAuthorId(id);
    }
}
