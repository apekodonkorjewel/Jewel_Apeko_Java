package com.company.bookstoreinventory.controller;

import com.company.bookstoreinventory.model.Author;
import com.company.bookstoreinventory.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    //Add a new author
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor (@RequestBody Author author){
        return authorRepository.save(author);
    }

    //Update an existing author
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author){
        authorRepository.save(author);
    }

    //Delete an existing author
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id){
        authorRepository.deleteById(id);
    }

    //Get author by id
    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id){
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }
        else{
            return null;
        }
    }

    //Get all authors
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}
