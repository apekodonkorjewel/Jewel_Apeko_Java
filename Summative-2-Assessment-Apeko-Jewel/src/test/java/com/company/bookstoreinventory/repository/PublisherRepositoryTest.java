package com.company.bookstoreinventory.repository;

import com.company.bookstoreinventory.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception{
        publisherRepository.deleteAll();
        authorRepository.deleteAll();
        bookRepository.deleteAll();
    }

    @Test
    public void addGetDeletePublisher(){
        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());
        assertEquals(publisher1.get(), publisher);

        publisherRepository.deleteById(publisher.getPublisherId());
        publisher1 = publisherRepository.findById(publisher.getPublisherId());
        assertFalse(publisher1.isPresent());
    }

    @Test
    public void updatePublisher(){
        //Create and save an publisher record
        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        //Update some fields in the record
        publisher.setCity("Portsmouth");
        publisher.setEmail("pubb@example.com");
        publisherRepository.save(publisher);

        //Load updated data from DB and compare with local variable author
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void getAllPublishers(){
        //Create and save two publisher records
        Publisher publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        //Test the findAll() method
        List<Publisher> publisherList = publisherRepository.findAll();
        assertEquals(publisherList.size(), 2);

        //Create another publisher and save it
        publisher = new Publisher();
        publisher.setCity("Norton");
        publisher.setEmail("publisher@example.com");
        publisher.setPhone("221-222 2222");
        publisher.setState("MA");
        publisher.setName("Golden Publishers");
        publisher.setPostalCode("55502");
        publisher.setStreet("Englewood");
        publisher = publisherRepository.save(publisher);

        //Test the findAll() method
        publisherList = publisherRepository.findAll();
        assertEquals(publisherList.size(), 3);
    }
}
