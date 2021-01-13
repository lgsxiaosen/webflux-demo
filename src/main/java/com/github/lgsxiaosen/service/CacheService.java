package com.github.lgsxiaosen.service;

import com.github.lgsxiaosen.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@Component
public class CacheService {
    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    private static final Map<Integer, User> map = new ConcurrentHashMap<>();

    public Mono<User> getUserById(Integer id){
        logger.info("大小：{}", map.size());
        return Mono.just(map.get(id));
    }

    public Mono<User> addUser(Mono<User> user){
        user.log("添加用户").subscribe(u -> map.put(u.getId(), u));
        logger.info("大小：{}", map.size());
        return Mono.empty();
    }

    public Flux<User> getByName(String name){
        logger.info("大小：{}", map.size());
        return Flux.fromIterable(map.values()).filter(u -> Objects.equals(u.getName(), name));
    }

    public Flux<User> addUsers(Flux<User> users){
        users.log("添加用户").subscribe(u -> map.put(u.getId(), u));
        logger.info("大小：{}", map.size());
        return Flux.fromIterable(map.values());
    }

    public Flux<User> getAll(){
        logger.info("大小：{}", map.size());
        return Flux.fromIterable(map.values());
    }

}
