package com.example.springwebmvc.request;

import com.example.springwebmvc.urlpattern.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RequestController {

    /**
     * 핸들러 메소드 2부 URL 패턴
     */
    @GetMapping("/uriPattern/{id}")
    @ResponseBody
    public Event uriPattern(@PathVariable Integer id, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

    @GetMapping("/uriPattern2/{id}")
    @ResponseBody
    public Event uriPattern2(@PathVariable("id") Integer idValue, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(idValue);
        event.setName(name);
        return event;
    }


    /**
     * 핸들러 메소드 3부 URL 요청 매개변수 (단순 타입)
     * @RequestParam
     * 요청 매개변수에 들어있는 단순 타입 데이터를 메소드 아규먼트로 받아올 수 있다.
     * 값이 반드시 있어야 한다.
     *   - required=false 또는 Optional 을 사용해서 부가적인 값으로 설정할 수도 있다.
     *   - Map<String, String> 또는 MultiValueMap<String, String> 에 사용해서 모든 요청 매개
     *   변수를 받아올 수도 있다.
     *   - 이 애노테이션은 생략 할 수 있다.
     */
    @PostMapping("/requests")
    @ResponseBody
    public Event getReq(@RequestParam String name,
                        @RequestParam Integer limit) {
        Event event = new Event();
        event.setName(name);
        event.setLimit(20);
        return event;
    }


//    @PostMapping("/events")
//    @ResponseBody
//    public Event getEvent(@RequestBody Map<String, String> params) {
//        Event event = new Event();
//        event.setName(params.get("name"));
//        return event;
//    }

    /**
     * 폼 서브밋
     * 폼을 보여줄 요청 처리
     * - GET /events/frm
     * - 뷰 : events/form.html
     * - 모델 : "event", new Event()
     *
     * 타임리프
     *  - @{} : URL 표현식
     *  - ${} : variable 표현식
     *  - *{} : selection 표현식
     */
    @GetMapping("/eventForm/form")
    public String eventsForm1(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent);
        return "events/form";
    }

    @GetMapping("/eventForm")
    @ResponseBody
    public Event eventsForm2(@RequestParam String name,
                              @RequestParam Integer limit) {

        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }
}
