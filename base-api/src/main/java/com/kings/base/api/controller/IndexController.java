package com.kings.base.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/11/18.
 */
@RestController
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "Welcome to xxxx!";
    }
}
