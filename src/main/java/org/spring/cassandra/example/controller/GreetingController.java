package org.spring.cassandra.example.controller;

/**
 * Created by bfitouri on 26/10/16.
 */
import java.util.concurrent.atomic.AtomicLong;

import org.spring.cassandra.example.dto.Person;
import org.spring.cassandra.example.service.MyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s! Your age is %s";
    private final AtomicLong counter = new AtomicLong();

    private final MyService myService;

    public GreetingController(final MyService myService){
        this.myService = myService;
    }

    @RequestMapping("/call")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {

        Person p = myService.getPersonByName(name);

        return String.format(template, p.getName(), p.getAge());
    }
}