package com.github.lgsxiaosen.service;

import com.github.lgsxiaosen.po.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
public interface UserService {

    Mono<User> insertUser(Mono<User> user);

    Flux<User> selectUser(String name);

    Mono<User> getById(Integer id);

    Flux<User> addUsers(Flux<User> users);

    Flux<User> getAll();

    Mono<User> testUser();

    Mono<String> testString();

}
