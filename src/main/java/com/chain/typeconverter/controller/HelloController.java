package com.chain.typeconverter.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data); // HTTP 요청 파라미터는 String으로 처리되기 때문에 변환해줘야함
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) { // @RequestParam, @ModelAttribute, @PathVariable 을 사용하면 스프링이 중간에서 타입을 변환해줌
        System.out.println("data = " + data);
        return "ok";
    }
}
