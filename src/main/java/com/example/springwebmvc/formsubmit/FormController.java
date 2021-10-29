package com.example.springwebmvc.formsubmit;

import com.example.springwebmvc.servlet.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *   44. 폼 서브밋 (에러처리)
 *    바인딩 에러 발생시 Model 에 담기는 정보
 *    - Event
 *    - BindingResult event
 *
 *   타임리프 사용시 바인딩 에러 보여주기
 *   <p th:if="${#fields.hasErrors('liit'}" th:errors="*{limit}"></p>
 *
 *   Post / Redirect Get 패턴
 *   - Post 이후에 브라우저를 리프래시 하더라도 폼ㄴ 서브밋이 발생하지 않도록 하는 패턴
 *
 *   45. @SessionAttributes
 *
 *   모델 정보를 HTTP 세션에 저장하는 애노테이션
 *   - HttpSession 을 직접 상용할 수도 있지만
 *   - 이 애노테이션에 설정한 이름에 해당하는 모델 정보를 자동으로 세션에 넣어준다.
 *   - @ModelAttribute는 세션에 있는 데이터도 바인딩한다.
 *   - 여러 화면(또는 요청)에서 사용해야 하는 객체를 공유할 때 사용한다.
 *
 *   SessionStatus를 사용해서 세션 처리 완료를 알려줄 수 있다.
 *   - 폼 처리 끝나고 세션을 비울 때 사용한다.
 *
 *   46. 멀티 폼 서브밋
 *   세션을 사용해서 폼에 걸처 데이터를 나눠 입력 받고 저장하기
 *   - 이벤트 이름 입력받고
 *   - 이벤트 제한 인원 입력받고
 *   - 서브밋 -> 이벤트 목록으로
 *
 *   완료된 경우에 세션에서 모델 객체 체거하기
 *   - SessionStatus
 */

@Controller
@SessionAttributes("event")
public class FormController {

    @GetMapping("/forms/form")
    public String eventsForm(Model model, HttpSession httpSession) {

        FormEvent newEvent = new FormEvent();

        newEvent.setLimit(50);

        model.addAttribute("event", newEvent);
        /**
         * @SessionAttributes("event")
         * event 이름으로 세션에 애트리뷰트에 넣어준다.
         * */
        // httpSession.setAttribute("event", newEvent);

        return "/forms/form";
    }

    @PostMapping("/getEventsForm")
    public String createEvent(@Validated @ModelAttribute("event") FormEvent event
                            , BindingResult bindingResult
                            , SessionStatus sessionStatus) {

        if (bindingResult.hasErrors()) {
            return "/forms/form";
        }

        /**
         * 폼 처리가 끝났을때 세션을 비운다. : 세션정리
         *  : sessionStatus.setComplete();
         */
        sessionStatus.setComplete();
//        List<FormEvent> eventList = new ArrayList<>();
//        eventList.add(event);
//        model.addAttribute("eventList", eventList);

        return "redirect:/forms/list";
    }

    @GetMapping("/forms/list")
    public String getEvents(Model model) {

        FormEvent event = new FormEvent();
        event.setName("spring");
        event.setLimit(10);

        List<FormEvent> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);

        return "/forms/list";
    }

    @GetMapping("/forms/form/name")
    public String eventForm2(Model model) {
        FormEvent newEvent = new FormEvent();
        newEvent.setLimit(50);

        model.addAttribute("event", newEvent);

        return "/forms/form-name";
    }

    @PostMapping("/forms/form/name")
    public String eventFormNameSubmit(@Validated @ModelAttribute("event") FormEvent event,
                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/forms/form-name";
        }
        return "redirect:/forms/form/limit";
    }

    @GetMapping("/forms/form/limit")
    public String eventFormLimit(@ModelAttribute("event") FormEvent event,
                                 Model model) {

        model.addAttribute("event", event);

        return "/forms/form/form-limit";
    }

    @PostMapping("/forms/form/formname")
    public String formname (@Validated @ModelAttribute Event event,
                            BindingResult bindingResult,
                            SessionStatus sessionStatus) {

        if (bindingResult.hasErrors()) {
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        return "redirect:/events/list";
    }


}
