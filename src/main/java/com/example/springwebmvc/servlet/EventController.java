package com.example.springwebmvc.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * [DispatcherServlet]
 * [doService]
 *  > handlerMappings
 *  0 = SimpleUrlHandlerMapping
 *  1 = RequestMappingHandlerMapping - annotation 기반 mvc 처리하는 핸들러매핑
 *  2 = BeanNameUrlHandlerMapping
 *  3 = SimpleUrlHandlerMapping -
 *     resources > static 이하 리소스를 캐시정보 리소스 효율적으로 제공
 *                         리소스 변경 아닐때 304 로 응답을 보내고 캐시를사용용
 *  4 = WelcomePageHandlerMapping
 * handlerAdapter
 *
 * [viewResolver]
 *  0 - ContentNegotiatingView : 다른뷰리졸러블에게 위임한다. 가장 적절한 뷰리졸버로 보내준다.
 *  1 = BeanNameViewResolver
 *  2 = ThymeleafViewResolver
 *  3 = ViewResolverComposite
 *  4 = InternalResourceViewResolver
 *
 *  [Spring Boot Application Type]
 *  1. Servlet, 2. WebFlux, 3. NonWeb
 *
 *  Spring Application
 *   > Spring Ioc Container
 *   > EmbeddedTomcat > DispatcherServlet
 *
 *  [스프링 MVC CUSTOMIZING]
 *  - application.properties
 *  - @Configuration + implements WebMvcConfigurer : 스프링 부트의 스프링 MVC 자동설정 + 추가설정
 *  - @Configuration + @EnableWebMvc : 스프링 부트의 스프링 MVC 자동설정을 사용하지 않는 경우
 *  - @Configuration + @EnableWebMvc + implementWebConfigurer : 스프링 부트의 스프링 MVC 자동설정을 사용하지 않는 경우 + 커스터마이징해서 구현해서 직접 설정하는 경우
 */
// @Controller
public class EventController {

//    @Autowired
//    EventService eventService;

    // @RequestMapping(value="/events", method= RequestMethod.GET)
//    @GetMapping("/events")
//    public String events(Model model) {
//        model.addAttribute("events", eventService.getEvents());
//        return "events/list";
//     }
}
