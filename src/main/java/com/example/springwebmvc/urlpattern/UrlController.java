package com.example.springwebmvc.urlpattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class UrlController {

    /**
     * URI 패턴
     */
    @GetMapping("/events/{id}")
    @ResponseBody
    // public Event getEvent(@PathVariable Optional<Integer> id) {
    // public Event getEvent(@PathVariable(required = false) Integer id) {
    // public Event getEvent(@PathVariable("id") Integer idValue) {
    public Event getEvent(@PathVariable Integer id) {
        Event event = new Event();
        event.setId(id);
        return event;
    }

    /**
     * 요청 매개변수 (단순타입)
     */
    @GetMapping("/events2/{id}")
    @ResponseBody
    // public Event getEvent2(@RequestParam String name) {
    // public Event getEvent2(@RequestParam(value="name", required = false, defaultValue = "keesun") String nameValue) {
    public Event getEvent2(@RequestParam(required = false, defaultValue = "keesun") String name) {
        Event event = new Event();
        // event.setId(id);
        event.setName(name);
        return event;
    }
}
