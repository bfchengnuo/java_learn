package com.bfchengnuo.sbdemo.config;

import com.bfchengnuo.sbdemo.domain.User;
import com.bfchengnuo.sbdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * Created by 冰封承諾Andy on 2018/1/16.
 * 路由器函数配置
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * servlet :
     * 请求接口： ServletRequest 或者 HttpServletRequest
     * 响应接口： ServletResponse 或者 HttpServletResponse
     * <p>
     * 在 Spring 5.0 + 重新定义了服务请求和响应接口
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 既可以支持 Servlet 规范，又可以可定义，比如 Netty（Web Server）
     *
     * Flux 是 0 - N 个对象集合
     * Mono 是 0 - 1 个对象集合
     * Reactive 中的 Flux 或者 Mono 都是异步处理 （非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {

        // Web Flux 方式
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request ->{
                    // Mono<ServerResponse> response = null;
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);

                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }
}
