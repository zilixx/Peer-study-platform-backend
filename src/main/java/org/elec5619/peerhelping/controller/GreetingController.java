package org.elec5619.peerhelping.controller;

import org.elec5619.peerhelping.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController // Returns a JSON object
// This code uses Spring @RestController annotation,
// which marks the class as a controller where every method returns a domain object instead of a view.
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    // or @RequestMapping(method=GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "The WORLD") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/hello")
    // The @GetMapping("/hello") annotation maps the sayHello() method to GET requests for /hello.
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World !") String name){
        // The @RequestParam annotation maps the name method parameter to the myName web request parameter.
        // If you don't provide the myName parameter in your web request, it will default to World.
        return String.format("Hello %s", name);
    }
}
