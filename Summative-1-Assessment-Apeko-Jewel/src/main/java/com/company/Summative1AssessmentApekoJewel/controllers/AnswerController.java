package com.company.Summative1AssessmentApekoJewel.controllers;

import com.company.Summative1AssessmentApekoJewel.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class AnswerController {
    private List<Answer> answerList;
    private static int idCounter = 1;

    public AnswerController(){
        answerList = new ArrayList<>();

        answerList.add(new Answer(idCounter++, "Don't count on it"));
        answerList.add(new Answer(idCounter++, "Without a doubt!"));
        answerList.add(new Answer(idCounter++, "Yes, definitely"));
        answerList.add(new Answer(idCounter++, "Better not tell you now"));
        answerList.add(new Answer(idCounter++,  "Cannot predict now"));
        answerList.add(new Answer(idCounter++,  "Most likely"));
        answerList.add(new Answer(idCounter++, "As I see it, yes"));
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public Answer getRandomResponse(@RequestBody Answer answer){
        //pick id and answer an answer at random
        int randomNum = ThreadLocalRandom.current().nextInt(0,answerList.size());
        answer.setId(randomNum);
        answer.setAnswer(answerList.get(randomNum).getAnswer());
        return answer;
    }
}
