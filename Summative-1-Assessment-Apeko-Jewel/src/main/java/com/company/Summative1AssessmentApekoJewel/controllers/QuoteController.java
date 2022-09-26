package com.company.Summative1AssessmentApekoJewel.controllers;

import com.company.Summative1AssessmentApekoJewel.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
@RestController
public class QuoteController {
    private List<Quote> quoteList;
    private static int idCounter = 1;

    public QuoteController(){
        quoteList = new ArrayList<>();

        quoteList.add(new Quote(idCounter++, "Nelson Mandela", "The greatest glory in living lies not in never falling, but in rising every time we fall."));
        quoteList.add(new Quote(idCounter++, "Walt Disney", "The way to get started is to quit talking and begin doing."));
        quoteList.add(new Quote(idCounter++, "James Cameron", "If you set your goals ridiculously high and it's a failure, you will fail above everyone else's success."));
        quoteList.add(new Quote(idCounter++, "John Lennon", "Life is what happens when you're busy making other plans."));
        quoteList.add(new Quote(idCounter++, "Mother Teresa", "Spread love everywhere you go. Let no one ever come to you without leaving happier."));
        quoteList.add(new Quote(idCounter++, "Franklin D. Roosevelt", "When you reach the end of your rope, tie a knot in it and hang on."));
        quoteList.add(new Quote(idCounter++, "Margaret Mead", "Always remember that you are absolutely unique. Just like everyone else."));
        quoteList.add(new Quote(idCounter++, "Benjamin Franklin", "Tell me and I forget. Teach me and I remember. Involve me and I learn."));
        quoteList.add(new Quote(idCounter++, "Abraham Lincoln", "In the end, it's not the years in your life that count. It's the life in your years."));
        quoteList.add(new Quote(idCounter++, "Helen Keller", "Life is either a daring adventure or nothing at all."));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getRandomQuote() {
        Quote randomQuote;
        //Return a word and its definition at random
        int randomNum = ThreadLocalRandom.current().nextInt(0,quoteList.size());
        randomQuote = quoteList.get(randomNum);

        return randomQuote;
    }
}

