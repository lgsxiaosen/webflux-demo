package com.github.lgsxiaosen.service;

import com.github.lgsxiaosen.po.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
public interface UserService {

    Mono<User> insertUser(User user);

    Flux<User> selectUser(String name);

}
