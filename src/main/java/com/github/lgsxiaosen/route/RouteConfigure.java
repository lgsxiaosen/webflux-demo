package com.github.lgsxiaosen.route;

import com.github.lgsxiaosen.hander.TimeHandler;
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

    @Bean
    public RouterFunction<ServerResponse> timeRouter(){
        return RouterFunctions
                .route(RequestPredicates.GET("/time"), timeHandler::getTime)
                .andRoute(RequestPredicates.GET("/times"), timeHandler::sendTimePerSec);
    }
}
