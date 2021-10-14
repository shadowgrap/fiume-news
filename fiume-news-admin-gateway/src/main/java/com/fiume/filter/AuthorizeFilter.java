package com.fiume.filter;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.fiume.util.AppJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Fiume
 * @since : 2021/10/13 18:52
 */
@Component
@Log4j2
@Order(0)
public class AuthorizeFilter implements GlobalFilter {

    List<String> passList = Arrays.asList(
            "/v2/api-docs",
            "/login/in"
    );

    /**
     * Process the Web request and (optionally) delegate to the next {@code WebFilter}
     * through the given {@link GatewayFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String path = request.getURI().getPath();

        for (String pathurl : passList) {
            if (pathurl.contains(path)) {
                return chain.filter(exchange);
            }
        }
        //其他路径需要获取请求头token
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst("token");
        if (StringUtils.isEmpty(token)) {
            //不存在token 向前端返回错误信息,要求登录
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        //解析token,判断jwt令牌是否合法
        try {
            Claims claims = AppJwtUtil.getClaimsBody(token);
            int result = AppJwtUtil.verifyToken(claims);
            if (result == 0 || result == -1) {
                Integer id = (int) claims.get("id");
                log.info("Admin Gateway-->userid:{}, from URI:{}", id, request.getURI());
                //将token填充到header中,放行后由具体服务器取到后设置到threadlocal
                ServerHttpRequest serverHttpRequest = request.mutate().headers(httpHeaders -> httpHeaders.add("userId", String.valueOf(id))).build();
                exchange = exchange.mutate().request(serverHttpRequest).build();
                return chain.filter(exchange);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //放行

        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }
}
