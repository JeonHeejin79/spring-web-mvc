package com.example.springwebmvc.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
// @RequestMapping(method = RequestMethod.GET)
public class SampleController {

    // @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/helloGet")
    @ResponseBody
    public String hello2() {
        return "hello";
    }

    @PostMapping("/helloPost")
    @ResponseBody
    public String hello3() {
        return "hello";
    }

    @GetMapping({"/hi1" , "hi2"})
    @ResponseBody
    public String hello4() {
        return "hello";
    }

    @GetMapping("/hi3/?")
    @RequestMapping
    public String hello5() {
        return "hello";
    }

    @RequestMapping("hello/{name:[a-z]+}")
    @ResponseBody
    public String hello6(@PathVariable String name) {
        return "hello " + name;
    }

    // request path 가 중복되는경우 가장 구체적인 request mapping 을 맵핑한다.
    @RequestMapping("hello/**")
    @ResponseBody
    public String hello7() {
        return "hello";
    }

    // 확장자 맵핑
    @RequestMapping({"/keesun.*", "/keesun"})
    @ResponseBody
    public String hello8() {
        return "hello keesun";
    }

    // 컨텐츠 타입 매핑
    @RequestMapping(value = "/helloContentHeader",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String hello9() {
        return "hello";
    }

    // 헤더와 파라미터 맵핑
    @GetMapping(value = "helloHeaderParamTest", headers = HttpHeaders.ACCEPT)
    @ResponseBody
    public String hello10() {
        return "hello";
    }

    @GetMapping(value="/headerMapping", headers = HttpHeaders.AUTHORIZATION + "=" + "111")
    @ResponseBody
    public String hello11() { return "hello"; }

    @GetMapping(value = "/paramMapping", params = "name=spring")
    @ResponseBody
    public String hello12() {
        return "hello";
    }

    // head options
    @GetMapping(value="/headOptions1", headers = HttpHeaders.ACCEPT)
    @ResponseBody
    public String headOptions1() {
        return "hello";
    }

    @PostMapping("/headOptions2")
    @ResponseBody
    public String headOptions2() {
        return "hello";
    }
}
