package com.candyleer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lican
 */
@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("json")
    @ResponseBody
    public String json(HttpServletRequest request, HttpServletResponse response) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request1 = requestAttributes.getRequest();

        System.out.println(request1);
        System.out.println(request);
        System.out.println(response);
        return "json";
    }

}