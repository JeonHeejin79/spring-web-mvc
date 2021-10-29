package com.example.springwebmvc.annotation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

/**
 java 에서해당 애노테이션을 언제까지 유지할 것이냐 지징할 수 있다.
 @Retention(RetentionPolicy.CLASS) 는 컨트롤러를 로딩하는순간 이 애노테이션 정보는 사라진다
 하지만 스프링은 이 애노테이션정보를 런타임시에 참고해야한다.
 디스패처 서블릿이 동작할때 이 애노테이션 정보를 알아야한다 참고해야한다.
 따라서 @Retention(RetentionPolicy.RUNTIME) 으로
 설정해서 런타임시 알게하게 한다.
 */
@Documented // 우리가 사용하는 애노테이션 javadoc 을 만들때 퍼블릭한 명세에 포함되게끔 하는 것이다.
@Target(ElementType.METHOD) // 이 애노테이션을 어디에 사용할 수 있는가 알려주는 것이다.
@Retention(RetentionPolicy.RUNTIME) // 언제까지 이 애노테이션을 유지할 것이냐
@RequestMapping(method = RequestMethod.GET, value="/getHelloMapping")
public @interface GetHelloMapping {
}
