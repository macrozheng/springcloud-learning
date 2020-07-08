package com.macro.cloud.component;

import cn.hutool.json.JSONUtil;
import com.macro.cloud.api.CommonResult;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

/**
 * 自定义返回结果：没有登录或token过期时
 * Created by macro on 2020/6/18.
 */
@Component
public class RestAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {
    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        String body= JSONUtil.toJsonStr(CommonResult.unauthorized(e.getMessage()));
        DataBuffer buffer =  response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
        return response.writeWith(Mono.just(buffer));
    }
}
