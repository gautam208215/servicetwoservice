package com.example.service.two.service.two.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("/second")
public class serviceTwoController {

    @GetMapping("/two")
    public String serviceone(){


        return "service two response";
    }


    @GetMapping("/intercall")
    public String intercall(@RequestHeader Map<String,String> headers){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        headers.forEach((key,value) ->{
            System.out.println("Header Name: "+key+" Header Value: "+value);
        });
        return "called from service one and service two responded " + principal;
    }

//    @GetMapping("/print-all-headers")
//    public String getAllheaders(@RequestHeader Map<String,String> headers){
//        headers.forEach((key,value) ->{
//            System.out.println("Header Name: "+key+" Header Value: "+value);
//        });
//        return "successfully printed headers";
//    }

}
