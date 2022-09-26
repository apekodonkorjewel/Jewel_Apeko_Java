package com.company.Summative1AssessmentApekoJewel.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    //Testing GET /quote with question
    @Test
    public void shouldReturnRandomQuote() throws Exception {
        // Act
        mockMvc.perform(get("/quote"))                   // Perform the GET request
                .andDo(print())                                 // Print results to console
                .andExpect(status().isOk());                    // ASSERT (status code is 200)
    }

}
