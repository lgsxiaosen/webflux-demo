package com.github.lgsxiaosen.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author lgs
 * @date 2021/1/13
 **/
@Component
public class TimeHandler {
    private static final Logger logger = LoggerFactory.getLogger(TimeHandler.class);

    public Mono<ServerResponse> getTime(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("now time is " + getNowTime()), String.class);
    }

    public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1)).
                        map(l -> "now time is " + getNowTime()), String.class);
    }

    public Mono<ServerResponse> getTimeName(ServerRequest request){
        logger.info("获取参数");
        String name = request.queryParams().getFirst("name");
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just(name + " time is " + getNowTime()), String.class);
    }

    private String getNowTime(){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(ftf);
    }


}
