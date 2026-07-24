package com.example.api_gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter {

    private static final Logger logger =
            LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        logger.info(
                "Request URL {}",
                exchange.getRequest().getURI()
        );

        return chain.filter(exchange);
    }
}