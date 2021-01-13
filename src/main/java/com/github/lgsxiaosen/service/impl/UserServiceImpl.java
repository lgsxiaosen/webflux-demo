package com.github.lgsxiaosen.service.impl;

import com.github.lgsxiaosen.po.User;
import com.github.lgsxiaosen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Mono<User> insertUser(User user) {
        return null;
    }

    @Override
    public Flux<User> selectUser(String name) {
        return null;
    }
}
