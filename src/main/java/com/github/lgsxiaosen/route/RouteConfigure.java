package com.github.lgsxiaosen.route;

import com.github.lgsxiaosen.hander.TimeHandler;
import com.github.lgsxiaosen.hander.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@Configuration
public class RouteConfigure {

    @Autowired
    private TimeHandler timeHandler;
    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRouter(){
        return RouterFunctions
                .route(RequestPredicates.GET("/time"), timeHandler::getTime)
                .andRoute(RequestPredicates.GET("/times"), timeHandler::sendTimePerSec)
                .andRoute(RequestPredicates.GET("/timeName"), timeHandler::getTimeName)
                .andRoute(RequestPredicates.POST("/add/user"), userHandler::addUser)
                .andRoute(RequestPredicates.POST("/add/users"), userHandler::addUsers)
                .andRoute(RequestPredicates.GET("/user"), userHandler::selectByName)
                .andRoute(RequestPredicates.GET("/user/all"), userHandler::getAll)
                .andRoute(RequestPredicates.GET("/user/id"), userHandler::addUserById)
                .andRoute(RequestPredicates.GET("/user/test"), userHandler::testUser)
                .andRoute(RequestPredicates.GET("/user/string"), userHandler::testString);
    }
}
