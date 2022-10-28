package com.company.bookstoreinventory.repository;

import com.company.bookstoreinventory.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception{
        authorRepository.deleteAll();
    }

    @Test
    public void addGetDeleteAuthor(){
        Author author = new Author();
        author.setCity("Boston");
        author.setEmail("djohnson@example.com");
        author.setPhone("222-222 2222");
        author.setFirstName("Dwayne");
        author.setLastName("Johnson");
        author.setPostalCode("55022");
        author.setState("MA");
        author.setStreet("Englewood");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getAuthorId());
        author1 = authorRepository.findById(author.getAuthorId());
        assertFalse(author1.isPresent());
    }

    @Test
    public void updateAuthor(){
        //Create and save an author record
        Author author = new Author();
        author.setCity("Boston");
        author.setEmail("djohnson@example.com");
        author.setPhone("222-222 2222");
        author.setFirstName("Dwayne");
        author.setLastName("Johnson");
        author.setPostalCode("55022");
        author.setState("MA");
        author.setStreet("Englewood");
        author = authorRepository.save(author);

        //Update some fields in the record
        author.setCity("Norwey");
        author.setStreet("Portsmouth");
        authorRepository.save(author);

        //Load updated data from DB and compare with local variable author
        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void getAllAuthors(){
        //Create and save an author record
        Author author = new Author();
        author.setCity("Boston");
        author.setEmail("djohnson@example.com");
        author.setPhone("222-222 2222");
        author.setFirstName("Dwayne");
        author.setLastName("Johnson");
        author.setPostalCode("55022");
        author.setState("MA");
        author.setStreet("Englewood");
        author = authorRepository.save(author);

        //Create another author and save it
        author = new Author();
        author.setCity("Norfolk");
        author.setEmail("djohnson@example.com");
        author.setPhone("444-222 2222");
        author.setFirstName("Abu");
        author.setLastName("Ramadan");
        author.setPostalCode("55022");
        author.setState("MA");
        author.setStreet("Englewood");
        author = authorRepository.save(author);

        //Test the findAll() method
        List<Author> authorList = authorRepository.findAll();
        assertEquals(authorList.size(), 2);

        //Create another author and save it
        author = new Author();
        author.setCity("Hampton");
        author.setEmail("ampons@example.com");
        author.setPhone("555-222 2222");
        author.setFirstName("Abu");
        author.setLastName("Ramadan");
        author.setPostalCode("55022");
        author.setState("MA");
        author.setStreet("Englewood");
        author = authorRepository.save(author);

        //Test the findAll() method
        authorList = authorRepository.findAll();
        assertEquals(authorList.size(), 3);
    }
}
