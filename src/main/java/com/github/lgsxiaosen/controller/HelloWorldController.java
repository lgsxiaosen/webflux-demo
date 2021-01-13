package com.github.lgsxiaosen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/{name}")
    public String hello(@PathVariable("name") String name){
        logger.info("请求普通方法");
        return "hello " + name;
    }

    @GetMapping("/mo/{name}")
    public Mono<String> helloMono(@PathVariable("name") String name) {
        logger.info("请求mono方法");
        return Mono.just("hello " + name);
    }

}
