package com.example.springwebmvc.formsubmit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class FormControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventFormTest() throws Exception {
        mockMvc.perform(get("/forms/form"))
                .andDo(print())
                .andExpect(view().name("/forms/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()));
    }

    @Test
    public void getEventFormTest() throws Exception {
        ResultActions result = mockMvc.perform(post("/getEventsForm")
                .param("name", "spring")
                .param("limit", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("spring"));

        ModelAndView mav = result.andReturn().getModelAndView();

        Map<String, Object> model = mav.getModel();

        System.out.println(model.size());
    }

    @Test
    public void getEventFromSession() throws Exception {
        MockHttpServletRequest request = mockMvc.perform(get("/forms/form"))
                .andDo(print())
                .andExpect(view().name("/forms/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()))
                .andReturn().getRequest();
        Object event = request.getSession().getAttribute("event");
        System.out.println(event);
    }
}
