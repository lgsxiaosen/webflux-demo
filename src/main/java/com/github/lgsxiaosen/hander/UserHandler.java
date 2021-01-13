package com.github.lgsxiaosen.hander;

import com.github.lgsxiaosen.po.User;
import com.github.lgsxiaosen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> addUser(ServerRequest request){
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.insertUser(userMono), User.class);
    }

    public Mono<ServerResponse> selectByName(ServerRequest request){
        String name = request.queryParam("name").get();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.selectUser(name), User.class);
    }

    public Mono<ServerResponse> addUsers(ServerRequest request){
        Flux<User> userMono = request.bodyToFlux(User.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.addUsers(userMono), User.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.getAll(), User.class);
    }

    public Mono<ServerResponse> addUserById(ServerRequest request){
        Integer id = Integer.valueOf(request.queryParam("id").get());
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.getById(id), User.class);
    }

    public Mono<ServerResponse> testUser(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(userService.testUser(), User.class);
    }

    public Mono<ServerResponse> testString(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(userService.testString(), String.class);
    }
}
