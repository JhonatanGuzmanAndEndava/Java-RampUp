package com.endava.bod.challenge.api.controllers;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class GreetingsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHello() {
        try {
            mvc.perform(get("/greetings")).andExpect(status().isOk());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
