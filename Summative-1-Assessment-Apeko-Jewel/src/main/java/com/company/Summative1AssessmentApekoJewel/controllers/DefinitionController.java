package com.company.Summative1AssessmentApekoJewel.controllers;

import com.company.Summative1AssessmentApekoJewel.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class DefinitionController {
    private List<Definition> definitionList;
    private static int idCounter = 1;

    public DefinitionController(){
        definitionList = new ArrayList<>();

        definitionList.add(new Definition(idCounter++, "ACID", "ACID is a programming mnemonic acronym that stands for Atomic, Consistent, Isolated, and Durable, and is used to define transactions"));
        definitionList.add(new Definition(idCounter++, "AWS", "Short for Amazon Web Services, AWS is a cloud services platform operated by Amazon that began operation in 2006"));
        definitionList.add(new Definition(idCounter++, "Big Data", "Big data is a term that describes handling and analyzing evolving data that is in the petabyte and exabyte range."));
        definitionList.add(new Definition(idCounter++, "Cloud Computing", "Cloud computing is a term used to describe services provided over a network by a collection of remote servers."));
        definitionList.add(new Definition(idCounter++, "Concurrency", "Concurrency is the occurrence of multiple events within overlapping time frames, but not simultaneously."));
        definitionList.add(new Definition(idCounter++, "Deadlock", "When two programs are waiting for the same signal from each other, they are said to be at a deadlock."));
        definitionList.add(new Definition(idCounter++, "Encrypt", "The term encrypt describes making data unreadable to other humans or computers that should not be seeing the contents."));
        definitionList.add(new Definition(idCounter++, "JDBC", "JDBC, also known as Java Database Connectivity, is an API that allows a Java application to access a database."));
        definitionList.add(new Definition(idCounter++, "MariaDB", "MariaDB is a community-developed RDBMS (relational database management system). It is a fork of MySQL, designed to be a drop-in replacement for MySQL in most applications."));
        definitionList.add(new Definition(idCounter++, "OpenStack", "OpenStack is open-source cloud computing service that started in 2010 when NASA and Rackspace Hosting joined together."));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getRandomWord() {
        Definition definition;
        //Return a word and its definition at random
        int randomNum = ThreadLocalRandom.current().nextInt(0,definitionList.size());
        definition = definitionList.get(randomNum);

        return definition;
    }
}
