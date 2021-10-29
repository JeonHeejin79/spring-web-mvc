package com.example.springwebmvc.request;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class RequestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void requestTest1() throws Exception {
        mockMvc.perform(post("/request?name=keesun"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("keesun"));

    }

    @Test
    public void requestTest2() throws Exception {
        mockMvc.perform(post("/request")
                    .param("name", "keesun")
                    .param("limit", "20"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("keesun"));

    }
}
