package com.example.springwebmvc.servlet;

import java.time.LocalDateTime;
import java.util.List;

// @Service
public class EventService {
    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("스프링 웹 MVC 스터디")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2021, 9, 1, 10, 0, 0))
                .endDateTime(LocalDateTime.of(2021, 10, 1, 12, 0, 0))
                .build();

        Event event2 = Event.builder()
                .name("스프링 웹 MVC 스터디")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2021, 9, 1, 10, 0, 0))
                .endDateTime(LocalDateTime.of(2021, 10, 1, 12, 0, 0))
                .build();
        return List.of(event1, event2);
    }
}
