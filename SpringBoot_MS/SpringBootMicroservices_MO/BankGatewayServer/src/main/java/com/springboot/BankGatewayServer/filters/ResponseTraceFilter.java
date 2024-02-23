package com.springboot.BankGatewayServer.filters;

import com.springboot.BankGatewayServer.constant.BankConstants;
import com.springboot.BankGatewayServer.utility.FilterUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter {
    private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);
    @Autowired
    FilterUtility filterUtility;

    @Bean
    public GlobalFilter globalFilter(){
        return (exchange, chain) -> {
            return chain.filter(exchange).then( Mono.fromRunnable(
                    () -> {
                        HttpHeaders requestHeaders =  exchange.getRequest().getHeaders();
                        String correlationId = filterUtility.getHeader(requestHeaders, BankConstants.CORRELATION_ID);
                        logger.debug("Updating CorrelationId in Response Header ["+ correlationId +"]" );
                        exchange.getResponse().getHeaders().add(BankConstants.CORRELATION_ID,correlationId);
                    }
                )
            );
        };
    }
}
