package com.company.Summative1AssessmentApekoJewel.controllers;

import com.company.Summative1AssessmentApekoJewel.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    //Testing POST /magic with question
    @Test
    public void shouldReturnRandomAnswerWithQuestion() throws Exception {
        //Arrange
        Answer inputAnswer = new Answer();
        inputAnswer.setQuestion("Will it rain tomorrow?");

        //Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);

        //Act
        mockMvc.perform(post("/magic")                         //Perform POST request
                        .content(inputJson)                             //Set request body
                        .contentType(MediaType.APPLICATION_JSON))       //Tell server it's JSON format
                .andDo(print())                                         //Print results to console
                .andExpect(status().isOk());                            //ASSERT (status code is 200)
    }

    //Testing POST /magic without question
    @Test
    public void shouldReturnRandomAnswerWithoutQuestion() throws Exception {
        //Arrange
        Answer inputAnswer = new Answer();
        inputAnswer.setQuestion("");

        //Convert Java object to JSON
        String inputJson = mapper.writeValueAsString(inputAnswer);

        //Act
        mockMvc.perform(post("/magic")                         //Perform POST request
                        .content(inputJson)                             //Set request body
                        .contentType(MediaType.APPLICATION_JSON))       //Tell server it's JSON format
                .andDo(print())                                         //Print results to console
                .andExpect(status().isOk());                            //ASSERT (status code is 200)
    }
}
