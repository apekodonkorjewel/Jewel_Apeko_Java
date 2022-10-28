package com.company.bookstoreinventory.repository;

import com.company.bookstoreinventory.model.Author;
import com.company.bookstoreinventory.model.Book;
import com.company.bookstoreinventory.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception{
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void addGetDeleteBook(){
        //Create an author and a publisher record before creating a book record
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

        //Create a publisher record
        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        //Create a book record
        Book book = new Book();
        book.setIsbn("1235614324324");
        book.setPrice(new BigDecimal("44.61"));
        book.setTitle("The Gods Are Not To Blame");
        book.setPublishDate(LocalDate.of(2010,1,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        //Test find by ID
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);

        //Test delete by ID
        bookRepository.deleteById(book.getBookId());

        //Test get by ID
        book1 = bookRepository.findById(book.getBookId());
        assertFalse(book1.isPresent());
    }

    @Test
    public void updateBook(){
        //Create an author and a publisher record before creating a book record
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

        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("1235614324324");
        book.setPrice(new BigDecimal("44.61"));
        book.setTitle("The Gods Are Not To Blame");
        book.setPublishDate(LocalDate.of(2010,1,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        //Update some fields in the record
        book.setPrice(new BigDecimal("55.63"));
        book.setTitle("In the Chest of a Woman");
        bookRepository.save(book);

        //Load updated data from DB and compare with local variable book
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);
    }

    @Test
    public void getAllBooks(){
        //Create an author and a publisher record before creating a book record
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

        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        //Create two book records
        Book book = new Book();
        book.setIsbn("1235614324324");
        book.setPrice(new BigDecimal("44.61"));
        book.setTitle("The Gods Are Not To Blame");
        book.setPublishDate(LocalDate.of(2010,1,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        book = new Book();
        book.setIsbn("898768753514");
        book.setPrice(new BigDecimal("88.61"));
        book.setTitle("In the Chest of a Woman");
        book.setPublishDate(LocalDate.of(2010,1,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        //Test the findAll() method
        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.size(), 2);

        //Create another book (with the same author) and save it
        book = new Book();
        book.setIsbn("3567578522564");
        book.setPrice(new BigDecimal("41.99"));
        book.setTitle("The Golden Trophy");
        book.setPublishDate(LocalDate.of(2020,3,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        //Test the findAll() method
        bookList = bookRepository.findAll();
        assertEquals(bookList.size(), 3);
    }

    @Test
    public void getBooksByAuthor(){
        //Create an author and a publisher record before creating a book record
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

        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        //Create two books with the same author
        Book book = new Book();
        book.setIsbn("1235614324324");
        book.setPrice(new BigDecimal("44.61"));
        book.setTitle("The Gods Are Not To Blame");
        book.setPublishDate(LocalDate.of(2010,1,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        book = new Book();
        book.setIsbn("243589768456");
        book.setPrice(new BigDecimal("66.77"));
        book.setTitle("In the Chest of a Woman");
        book.setPublishDate(LocalDate.of(2010,1,2));
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());
        book = bookRepository.save(book);

        //Test find by author ID
        List<Book> bookList = bookRepository.findByAuthorId(author.getAuthorId());
        assertNotEquals(bookList.size(), 3);
        assertEquals(bookList.size(), 2);
    }
}
