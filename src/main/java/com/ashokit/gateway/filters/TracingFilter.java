package com.ashokit.gateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.ashokit.gateway.utility.FilterUtility;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TracingFilter implements GlobalFilter {
	
	@Autowired
	FilterUtility filterUtility;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		if(filterUtility.getTracingId(exchange.getRequest().getHeaders()) != null) {
			log.info("myapp-tracing-id is found in trafing filter {} ", filterUtility.getTracingId(exchange.getRequest().getHeaders()));
		}else {
			String tracingId = generateTracingId();
			exchange = exchange.mutate().request(exchange.getRequest().mutate().header(FilterUtility.TRACING_ID, tracingId).build()).build();
			log.info("myapp-tracing-id is generated in trafing filter {} ", tracingId);
		}
			
			
			
		return chain.filter(exchange);
	}
	
	private String generateTracingId() {
		return java.util.UUID.randomUUID().toString();
	}

}
