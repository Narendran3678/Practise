package com.springboot.BankGatewayServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @RequestMapping("/contactsupport")
    public Mono<String> fallbackMethod() {
        return Mono.just("Error Account Contact narendran3678@gmaill.com");
    }
}
