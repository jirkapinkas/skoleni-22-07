package com.example.demoeshopweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@Slf4j
@RestController
public class EmailController {

    @GetMapping("/sendEmails") // toto by melo byt @PostMapping
    public void sendEmails() {
        IntStream.range(0, 100)
                .forEach(this::sendEmail);
    }

    @Async
    public void sendEmail(int i) {
        log.info("sending email {}", i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
