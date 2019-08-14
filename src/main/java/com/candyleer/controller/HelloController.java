package com.candyleer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

    @RequestMapping("http")
    @ResponseBody
    public String http() throws Exception {
        URL obj = new URL("http://www.baidu.com");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

}