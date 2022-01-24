package com.secure.PrettySecureApp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHello {

    @GetMapping("/hello")
    public String hello() {
        return "Hello User you are not yet authenticated";
    }

}
