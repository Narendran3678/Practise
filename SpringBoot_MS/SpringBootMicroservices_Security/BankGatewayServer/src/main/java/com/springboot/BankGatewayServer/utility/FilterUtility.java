package com.springboot.BankGatewayServer.utility;

import com.springboot.BankGatewayServer.constant.BankConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class FilterUtility {

    public Boolean isCorrelationIdPresent(HttpHeaders httpHeader){
        String headerValue = this.getHeader(httpHeader, BankConstants.CORRELATION_ID);
        return headerValue != null;
    }
    public String getHeader(HttpHeaders httpHeader,String headerKey) {
        if(httpHeader.get(headerKey) !=null)
            return String.valueOf(httpHeader.get(headerKey));
        else
            return null;
    }
    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String headerKey,String headerValue){
        return exchange.mutate().request(exchange.getRequest().mutate().header(headerKey,headerValue).build()).build();
    }

    public String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
