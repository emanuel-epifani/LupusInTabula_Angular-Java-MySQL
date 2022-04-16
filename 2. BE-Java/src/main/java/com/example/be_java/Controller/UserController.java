package com.example.be_java.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong idGiocatore = new AtomicLong();

    @PostMapping("/StartP")
    public long Starting(@RequestParam(value = "nome") String name) {
       // return new Saluto(counter.incrementAndGet(), String.format(template, name));

        return idGiocatore.incrementAndGet();

    }

}
