package com.example.springwebmvc.urlpattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UrlControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void deleteEvent() throws Exception {
        mockMvc.perform(get("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
