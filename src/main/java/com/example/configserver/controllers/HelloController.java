package com.example.configserver.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RefreshScope
public class HelloController {

    @Value("${greeting.message}")
    private String message;

    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public ResponseEntity<String> greeting(){
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @RequestMapping("/")
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<String >("Welcome to PCF config server demo via spring-cloud-config-client with no repos!!",HttpStatus.OK);
    }
}
