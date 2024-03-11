package com.springboot.BankGatewayServer.filters;

import com.springboot.BankGatewayServer.constant.BankConstants;
import com.springboot.BankGatewayServer.utility.FilterUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {
    @Autowired
    private FilterUtility filterUtility;

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeader = exchange.getRequest().getHeaders();

        if(filterUtility.isCorrelationIdPresent(httpHeader)) {
            logger.debug("CorrelationId Found in Request Header Status ["+ BankConstants.CORRELATION_ID+" = "+filterUtility.getHeader(httpHeader, BankConstants.CORRELATION_ID)+"]" );
        }
        else {
            String correlationId = filterUtility.generateCorrelationId();
            exchange = filterUtility.setRequestHeader(exchange,BankConstants.CORRELATION_ID,correlationId);
            logger.debug("RequestTraceFilter CorrelationId RequestHeader CorrelationId ["+ correlationId +"]" );
        }
        return chain.filter(exchange);
    }
}
