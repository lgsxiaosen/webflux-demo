package com.github.lgsxiaosen.controller;

import com.github.lgsxiaosen.po.User;
import com.github.lgsxiaosen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@RestController
@RequestMapping("/u")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Flux<User> addUser(@RequestBody Flux<User> user){
        return userService.addUsers(user);
    }

    @GetMapping("/name")
    public Flux<User> getUserByName(@RequestParam("name") String name){
        return userService.selectUser(name);
    }

    @GetMapping("/all")
    public Flux<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/id")
    public Mono<User> getById(@RequestParam("id") Integer id){
        return userService.getById(id);
    }

}
