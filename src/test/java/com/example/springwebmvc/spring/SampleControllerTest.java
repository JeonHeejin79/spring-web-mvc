package com.example.springwebmvc.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello")) // get, post, delete, put
                .andDo(print())
                .andExpect(status().isOk());
                // .andExpect(status().isMethodNotAllowed());
                // .andExpect(content().string("hello"));

        mockMvc.perform(post("/hello"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/hi1"))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(get("/hi2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void helloTest2() throws Exception {
        mockMvc.perform(get("/hello/keesun"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello keesun"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("hello6"));
    }

    @Test
    public void helloContentHeaderTest() throws Exception {
        // helloContentHeader
        mockMvc.perform(get("/helloContentHeader")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // 헤더와 파라미터 맵핑
    @Test
    public void helloHeaderParamTest() throws Exception {

        mockMvc.perform(get("/helloHeaderParamTest"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void headerParam() throws Exception {
        mockMvc.perform(get("/paramMapping")
                .param("name", "spring"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // head options
    @Test
    public void headOptions() throws  Exception {
        mockMvc.perform(options("/headOptions1"))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(header().exists(HttpHeaders.ACCEPT))
                //.andExpect(header().stringValues(HttpHeaders.ALLOW, "GET",  "HEAD", "POST", "OPTIONS"));
                .andExpect(header().stringValues(HttpHeaders.ALLOW,
                        hasItems(containsString("GET"),
                                containsString("POST"),
                                containsString("HEAD"),
                                containsString("OPTIONS"))));
    }
}
