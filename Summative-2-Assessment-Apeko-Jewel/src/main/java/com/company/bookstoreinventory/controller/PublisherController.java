package com.company.bookstoreinventory.controller;

import com.company.bookstoreinventory.model.Publisher;
import com.company.bookstoreinventory.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository publisherRepository;

    //Add a new publisher
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher (@RequestBody Publisher publisher){
        return publisherRepository.save(publisher);
    }

    //Update an existing publisher
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher){
        publisherRepository.save(publisher);
    }

    //Delete an existing publisher
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id){
        publisherRepository.deleteById(id);
    }

    //Get publisher by id
    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisher(@PathVariable int id){
        Optional<Publisher> publisher = publisherRepository.findById(id);
        if(publisher.isPresent()){
            return publisher.get();
        }
        else{
            return null;
        }
    }

    //Get all publishers
    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }
}
