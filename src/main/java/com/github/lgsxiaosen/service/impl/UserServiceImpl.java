package com.github.lgsxiaosen.service.impl;

import com.github.lgsxiaosen.po.User;
import com.github.lgsxiaosen.service.CacheService;
import com.github.lgsxiaosen.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CacheService cacheService;

    @Override
    public Mono<User> insertUser(Mono<User> user) {
        return cacheService.addUser(user);
    }

    @Override
    public Flux<User> selectUser(String name) {
        return cacheService.getByName(name);
    }

    @Override
    public Mono<User> getById(Integer id) {
        return cacheService.getUserById(id);
    }

    @Override
    public Flux<User> addUsers(Flux<User> users) {
        return cacheService.addUsers(users);
    }

    @Override
    public Flux<User> getAll() {
        return cacheService.getAll();
    }

    @Override
    public Mono<User> testUser() {
        return Mono.just(new User());
    }

    @Override
    public Mono<String> testString() {
        return Mono.just("test");
    }
}
